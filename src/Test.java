import com.sun.xml.internal.bind.v2.TODO;

public class Test {
   private double[] Accel;
   private double[] Gyro;
   private double[] Magneto;

   //private UI Form;

   Test(){
       Accel = new double[3];
       Gyro = new double[3];
       Magneto = new double[3];
       init();

   }

    public static void main(String[] args) {
        //double x = 10, y = 34, z = 97;

        Test A = new Test();
        StateMonitor TestForm = new StateMonitor();
        //This is only example, u may make it differently
        A.run(TestForm);
    }

    public void run(StateMonitor form) {
       int i=0;
       //I increase all coords in a cycle, wiht delay of 700 msecs
        while (true) {
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //TODO: update coords how u want
            if (i==200){
                init();
            }
            else{
                Accel[0] = 0.1;
                Accel[1] += 0.2;
                Accel[2] -= 0.3;
                Magneto[0] += 0.1;
                Magneto[1] += 0.2;
                Magneto[2] -= 0.24;
                Gyro[0] += 0.1;
                Gyro[1] += 0.24;
                Gyro[2] -= 0.8;
            }
            //TODO: place these methods in your program
            form.assign(Accel,Gyro,Magneto);//I assign new values to my form
            form.repaint(form.AccelCoords, form.GyroCoords, form.MagnetoCoords); //I repaint my form
            //example of getting delicacy
            int Delicacy=form.getDelicacy();

        i++;
        }
    }
    private void init(){
        Accel[0] = 1.0;
        Accel[1] = 0.0;
        Accel[2] = 1.0;
        Gyro[0] = 1.0;
        Gyro[1] = 0.0;
        Gyro[2] = 1.0;
        Magneto[0] = 1.0;
        Magneto[1] = 0.0;
        Magneto[2] = 1.0;
    }
}
