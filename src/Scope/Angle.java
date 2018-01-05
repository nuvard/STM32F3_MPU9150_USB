package Scope;

public class Angle {
    public double X;
    public double Y;
    public double Z;
    public double XYAngle;
    public double XZAngle;
    public double YZAngle;

    public Angle() {

     /* X=init_x;
      double init_x, double init_y, double init_z
      Y=init_y;
      Z=init_z;*/
    }

    public void assign(double x, double y, double z)
    {

        this.X=x;
        this.Y=y;
        this.Z=z;

        if (this.X==0 && this.Y==0){
            X=0.0000001;
        }
        else if (this.X==0 && this.Z==0){
            X=0.0000001;
        }
        else if (this.Y==0 && this.Y==0){
            Y=0.0000001;
        }
        this.XYAngle = Math.atan(y / x);
        this.XZAngle = Math.atan(z / x);
        this.YZAngle = Math.atan(z / y);

    }
}
