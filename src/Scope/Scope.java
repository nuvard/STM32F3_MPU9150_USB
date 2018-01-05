package Scope;
import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormat.*;

public class Scope extends JPanel {
    public double angle;
    //double i=0;

    public Scope(double init_angle) {
        angle = init_angle;
        setOpaque(true);
        setVisible(true);

    }


    @Override
    protected void paintComponent(Graphics g) {
        //angle+=Math.toRadians(90);
        int littleX = (int) ((getWidth() / 2 - 10) + ((getWidth() - 50) / 2) * Math.sin(angle + Math.toRadians(90)));
        int littleY = (int) ((getHeight() / 2 - 10) + ((getHeight() - 50) / 2) * Math.cos(angle + Math.toRadians(90)));
        //super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //g2d.setClip(0,0, getWidth(), getHeight() * 2);
        //g2d.setClip(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // g2d.setColor(Color.blue);
        //g2d.fillOval(10, 10, getWidth() - 20, getHeight() * 2 - 20);
        g2d.setColor(new Color(72, 14, 28));
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setColor(new Color(90, 121, 76));
        g2d.fillOval(20, 20, getWidth() - 40, getHeight() - 40);
        g2d.setColor(new Color(72, 14, 28));
        g2d.fillOval(30, 30, getWidth() - 60, getHeight() - 60);
        g2d.setColor(new Color(151, 187, 120));
        g2d.fillOval(littleX, littleY, getWidth() / 8, getHeight() / 8);
        g2d.drawLine((getWidth() / 2), (getHeight() / 2) - (getHeight() / 2 - 15), (getWidth() / 2), (getHeight() / 2) + (getHeight() / 2 - 15));
        g2d.drawLine((getWidth() / 2) - (getWidth() / 2 - 15), (getHeight() / 2), (getWidth() / 2) + (getWidth() / 2 - 15), (getHeight() / 2));
        g2d.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        Font NameFont = new Font("Arial", Font.PLAIN, 12);
        if (NameFont != null) g2d.setFont(NameFont);
        DecimalFormat df = new DecimalFormat("#.#");
       // String Str = Double.toString(angle).format("%.1g%n"
        g2d.drawString(Double.toString(Math.round(angle*100)/100.0), getWidth() - 30, 30);
        // g2d.drawArc(getWidth()/4, getHeight()/4, getWidth()/2, getHeight()/2, 225, 90);
    }

    public void update(Graphics g) {
        paintComponent(g);
    }

    public void assign(double x) {
        angle = x;
    }

    public double GetAngle() {
        return angle;
    }


}