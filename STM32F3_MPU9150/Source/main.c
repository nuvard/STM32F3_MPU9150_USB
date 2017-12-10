/**
  ******************************************************************************
  * @file    main.c
  * @author  MCD Application Team
  * @version V4.0.0
  * @date    21-January-2013
  * @brief   Virtual Com Port Demo main file
  ******************************************************************************
  * @attention
  *
  * <h2><center>&copy; COPYRIGHT 2013 STMicroelectronics</center></h2>
  *
  * Licensed under MCD-ST Liberty SW License Agreement V2, (the "License");
  * You may not use this file except in compliance with the License.
  * You may obtain a copy of the License at:
  *
  *        http://www.st.com/software_license_agreement_liberty_v2
  *
  * Unless required by applicable law or agreed to in writing, software 
  * distributed under the License is distributed on an "AS IS" BASIS, 
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  *
  ******************************************************************************
  */


/* Includes ------------------------------------------------------------------*/
#include "hw_config.h"
#include "usb_lib.h"
#include "usb_desc.h"
#include "usb_pwr.h"

/* Private define ------------------------------------------------------------*/
#define MPU9150_ADDR        (0x68)<<1   // Default MPU9150 I2C address
#define MPU9150_WHO_AM_I    0x75        // must return 0x68
#define I2C_SPEED           400000
#define TIMING_CLEAR_MASK   ((uint32_t)0xF0FFFFFF)

/* Extern variables ----------------------------------------------------------*/
extern uint8_t needToSend;


/*******************************************************************************
* Function Name  : Virtual_Com_Write_Buffer
* Description    : Transmit through the virtual com tha data.
* Input          : the buffer that contains the bytes to transmit,
*                : the number of bytes to transmit
* Return         : none.
*******************************************************************************/
void Virtual_Com_Write_Buffer(uint8_t* data_buffer, uint8_t size) {
  /* The USB cable is plugged into the USB-Mini connector */
  uint8_t b_size = size;
  uint8_t b_index = 0;
  uint8_t actual_input_size;
  
  while (b_index < size) {
    if (b_size < VIRTUAL_COM_PORT_DATA_SIZE) {
      actual_input_size = b_size;
    } else {
      actual_input_size = VIRTUAL_COM_PORT_DATA_SIZE;
    }
    
    /* wait until the data transmission is finished */
    while (GetEPTxStatus(ENDP1) == EP_TX_VALID);
	
    /* Write data to the virtual UART through USB port */
    //UserToPMABufferCopy(&(data_buffer[b_index]), ENDP1_TXADDR, actual_input_size);
    
    USB_SIL_Write(EP1_IN, &(data_buffer[b_index]), actual_input_size);
    SetEPTxCount(ENDP1, actual_input_size); 
    SetEPTxValid(ENDP1);
    
    b_size = b_size - actual_input_size;
    b_index= b_index + actual_input_size; 
  }  
}

/*******************************************************************************
* Function Name  : send_packet
* Description    : Send data to the client application.
*
*                  Data is formatted as follows:
*                  packet[0]    = $
*                  packet[1]    = packet type (see packet_type_e)
*                  packet[2+]   = data
*
* Input          : packet type (see packet_type_e),
*                : the buffer that contains the bytes to transmit
* Return         : none.
*******************************************************************************/
enum packet_type_e {
    PACKET_TYPE_ACCEL,
    PACKET_TYPE_GYRO,
    PACKET_TYPE_COMPASS,
};

void send_packet(char packet_type, void *data) {
#define MAX_BUF_LENGTH  (18)
    char buf[MAX_BUF_LENGTH], length;

    memset(buf, 0, MAX_BUF_LENGTH);
    buf[0] = '$';
    buf[1] = packet_type;

    if (packet_type == PACKET_TYPE_ACCEL || packet_type == PACKET_TYPE_GYRO || packet_type == PACKET_TYPE_COMPASS) {
        short *sdata = (short*)data;
        buf[2] = (char)(sdata[0] >> 8);
        buf[3] = (char)sdata[0];
        buf[4] = (char)(sdata[1] >> 8);
        buf[5] = (char)sdata[1];
        buf[6] = (char)(sdata[2] >> 8);
        buf[7] = (char)sdata[2];
        length = 8;
    }
	
    Virtual_Com_Write_Buffer(buf, length);  
}

/*******************************************************************************
* Function Name  : I2C_Config
* Description    : I2C configuration with MPU-9150.
* Input          : none.
* Return         : none.
*******************************************************************************/
void I2C_Config() {
    // GPIOB, Pin 6 - SCL, Pin 7 - SDA
    RCC   -> AHBENR  |= RCC_AHBENR_GPIOBEN;
    GPIOB -> OSPEEDR &= ~GPIO_OSPEEDER_OSPEEDR6 | ~GPIO_OSPEEDER_OSPEEDR7;
    GPIOB -> MODER   |= GPIO_MODER_MODER6_1 | GPIO_MODER_MODER7_1;
    GPIOB -> OTYPER  |= GPIO_OTYPER_OT_6 | GPIO_OTYPER_OT_7;    
    GPIOB -> AFR[0]  |= (4 << 24) | (4 << 28);      // I2C1 functions - Alter functions 4

    RCC  -> APB1ENR  |= RCC_APB1ENR_I2C1EN ;
    I2C1 -> CR1      |= I2C_CR1_ANFOFF;      // Analog Noise Filter OFF on SDA and SCL
    I2C1 -> TIMINGR   = I2C_SPEED & TIMING_CLEAR_MASK; // 400 kHz
    I2C1 -> CR2      |= MPU9150_ADDR;
    
    I2C1 -> CR1      |= I2C_CR1_PE;
}

/*******************************************************************************
* Function Name  : I2C_write_byte
* Description    : sending byte to device
* Input          : I2C slave address, byte for writing
* Return         : none.
*******************************************************************************/
void I2C_write_byte(uint8_t addr, uint8_t data) {
    I2C1 -> CR2 &= ~(I2C_CR2_RD_WRN);
    I2C1 -> CR2 |= I2C_CR2_START |  (2 << 16);
    while(I2C1->CR2 & I2C_CR2_START);
    
    I2C1 -> TXDR = addr;
    while (!(I2C1->ISR & I2C_ISR_TXE));

    I2C1 -> TXDR = data;
    while (!(I2C1->ISR & I2C_ISR_TXE));
    
    I2C1 -> CR2 |= I2C_CR2_STOP;
    while(I2C1->CR2 & I2C_CR2_STOP);
}

/*******************************************************************************
* Function Name  : I2C_read_byte
* Description    : read byte from device
* Input          : I2C slave address (or device's register address)
* Return         : none.
*******************************************************************************/
uint8_t I2C_read_byte(uint8_t addr) {
    uint8_t data = 0;

    I2C1 -> CR2 &= ~(I2C_CR2_RD_WRN);
    I2C1 -> CR2 &= ~(0xff << 16);
    I2C1 -> CR2 |= I2C_CR2_START | (1 << 16);
    while(I2C1->CR2 & I2C_CR2_START);

    I2C1 -> TXDR = addr;
    while (!(I2C1->ISR & I2C_ISR_TXE));

    I2C1 -> CR2 |= I2C_CR2_RD_WRN;
    I2C1 -> CR2 |= I2C_CR2_START | (1 << 16);
    while(I2C1->CR2 & I2C_CR2_START);
    
    while(!(I2C1->ISR & I2C_ISR_RXNE));
    data = I2C1->RXDR;
    
    I2C1 -> CR2 |= I2C_CR2_STOP;
    while(I2C1->CR2 & I2C_CR2_STOP);
    
    return data;
}

/*******************************************************************************
* Function Name  : main.
* Description    : Main routine.
* Input          : None.
* Return         : None.
*******************************************************************************/
int main(void){
	Set_System();
	Set_USBClock();
	USB_Interrupts_Config();
	USB_Init();
    
    while(bDeviceState != CONFIGURED);  // wait until USB is configured
    
    I2C_Config();
    
	while (1) {
        if(needToSend) {
            Virtual_Com_Write_Buffer(">>>", 3);
            
            uint8_t whoAmI;
            
            I2C_write_byte(MPU9150_ADDR, MPU9150_WHO_AM_I);
            whoAmI = I2C_read_byte(MPU9150_WHO_AM_I);
            
            Virtual_Com_Write_Buffer(&whoAmI, 1);   // must send 0x68 (if everything OK)
            
            needToSend = 0;
        }
	}
}

#ifdef USE_FULL_ASSERT
/*******************************************************************************
* Function Name  : assert_failed
* Description    : Reports the name of the source file and the source line number
*                  where the assert_param error has occurred.
* Input          : - file: pointer to the source file name
*                  - line: assert_param error line source number
* Output         : None
* Return         : None
*******************************************************************************/
void assert_failed(uint8_t* file, uint32_t line) {
  /* User can add his own implementation to report the file name and line number,
     ex: printf("Wrong parameters value: file %s on line %d\r\n", file, line) */

  /* Infinite loop */
  while (1) {
  }
}
#endif

/************************ (C) COPYRIGHT STMicroelectronics *****END OF FILE****/
