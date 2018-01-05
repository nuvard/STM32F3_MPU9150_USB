import Scope.*;
public class StateMonitor {
    double[] AccelCoords;
    double[] GyroCoords;
    double[] MagnetoCoords;
    private Angle accel;
    private Angle gyro;
    private Angle magneto;
    public FormFactor form;

    StateMonitor() {
        AccelCoords = new double[3];
        GyroCoords = new double[3];
        MagnetoCoords = new double[3];
        accel = new Angle();
        gyro = new Angle();
        magneto = new Angle();
                form = new FormFactor();
                form.CoordsAX.setText(" x="+Double.toString(AccelCoords[0])+"y="+Double.toString(AccelCoords[1])+" z="+Double.toString(AccelCoords[2]));
    }

   /* public void run() {

        while (true) {
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           //assign(Accel,Gyro,Magneto);
            repaint(AccelCoords, GyroCoords, MagnetoCoords);
        }
    }*/

    public void repaint(double[] accelCoordinates, double[] gyroCoordinates, double[] magnetoCoordinates) {
        accel.assign(accelCoordinates[0], accelCoordinates[1], accelCoordinates[2]);
        gyro.assign(gyroCoordinates[0], gyroCoordinates[1], gyroCoordinates[2]);
        magneto.assign(magnetoCoordinates[0], magnetoCoordinates[1], magnetoCoordinates[2]);
        form.AccelXY.angle = (accel.XYAngle);//0.47969653528;
        form.AccelXZ.angle = accel.XZAngle;
        form.AccelYZ.angle = accel.YZAngle;
        form.MagnetoXY.assign(magneto.XYAngle);
        form.MagnetoXZ.assign(magneto.XZAngle);
        form.MagnetoYZ.assign(magneto.YZAngle);
        form.GyroXY.assign(gyro.XYAngle);
        form.GyroXZ.assign(gyro.XZAngle);
        form.GyroYZ.assign(gyro.YZAngle);
        form.CoordsAX.setText(" x: "+Double.toString(Math.round(AccelCoords[0]*100)/100.0));
        form.CoordsAY.setText(" y: "+Double.toString(Math.round(AccelCoords[1]*100)/100.0));
        form.CoordsAZ.setText(" z: "+Double.toString(Math.round(AccelCoords[2]*100)/100.0));
        form.CoordsGX.setText(" x: "+Double.toString(Math.round(GyroCoords[0]*100)/100.0));
        form.CoordsGY.setText(" y: "+Double.toString(Math.round(GyroCoords[1]*100)/100.0));
        form.CoordsGZ.setText(" z: "+Double.toString(Math.round(GyroCoords[2]*100)/100.0));
        form.CoordsMX.setText(" x: "+Double.toString(Math.round(MagnetoCoords[0]*100)/100.0));
        form.CoordsMY.setText(" y: "+Double.toString(Math.round(MagnetoCoords[1]*100)/100.0));
        form.CoordsMZ.setText(" z: "+Double.toString(Math.round(MagnetoCoords[2]*100)/100.0));

        form.validate();
        form.repaint();

    }
    public void assign(double[]accelCoordinates, double []gyroCoordinates, double[]magnetoCoordinates){
       this.AccelCoords[0] = accelCoordinates[0];
        this.AccelCoords[1] = accelCoordinates[1];
        this.AccelCoords[2] = accelCoordinates[2];
        this.MagnetoCoords[0] = magnetoCoordinates[0];
        this.MagnetoCoords[1] = magnetoCoordinates[1];
        this.MagnetoCoords[2] = magnetoCoordinates[2];
        this.GyroCoords[0] = gyroCoordinates[0];
        this.GyroCoords[1] = gyroCoordinates[1];
        this.GyroCoords[2] = gyroCoordinates[2];
    }
    public int getDelicacy(){
        return this.form.DelicacyValue;
    }
}
