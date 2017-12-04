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


/* Private typedef -----------------------------------------------------------*/
/* Private define ------------------------------------------------------------*/
/* Private macro -------------------------------------------------------------*/
/* Private variables ---------------------------------------------------------*/
/* Extern variables ----------------------------------------------------------*/
/* Private function prototypes -----------------------------------------------*/
/* Private functions ---------------------------------------------------------*/

/*******************************************************************************
* Function Name  : Virtual_Com_Write_Buffer.
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
    while (GetEPTxStatus(ENDP1) == EP_TX_VALID); //0x30
	
    /* Write data to the virtual UART through USB port */
    //UserToPMABufferCopy(&(data_buffer[b_index]), ENDP1_TXADDR, actual_input_size);
    
    USB_SIL_Write(EP1_IN, &(data_buffer[b_index]), actual_input_size);
    SetEPTxCount(ENDP1, actual_input_size); 
    SetEPTxValid(ENDP1);
    
    b_size = b_size - actual_input_size;
    b_index= b_index + actual_input_size; 
  }  
}

enum packet_type_e {
    PACKET_TYPE_ACCEL,
    PACKET_TYPE_GYRO,
    PACKET_TYPE_COMPASS,
};

/* Send data to the (Python) client application.
 * Data is formatted as follows:
 * packet[0]    = $
 * packet[1]    = packet type (see packet_type_e)
 * packet[2+]   = data
 */
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
* Function Name  : main.
* Description    : Main routine.
* Input          : None.
* Output         : None.
* Return         : None.
*******************************************************************************/

extern uint8_t needToSend;

int main(void){
	Set_System();
	Set_USBClock();
	USB_Interrupts_Config();
	USB_Init();
  
	while (1) {
        if(needToSend) {
            // usb test
            Virtual_Com_Write_Buffer("Good", 4);
            
            uint16_t data[] = {4, 5, 6};
            send_packet(PACKET_TYPE_GYRO, data);
            
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
