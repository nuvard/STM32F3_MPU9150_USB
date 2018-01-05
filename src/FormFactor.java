import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Scope.*;

public class FormFactor extends JFrame {

    int DelicacyValue;
    private JButton Kotik;
    private JPanel area1;
    private JPanel rootPanel;
    private JButton Tale;
    private JLabel smth;
    private JLabel Name;
    private JSlider slider1;
    public JLabel CoordsAX;
    public JLabel CoordsMX;
    public JLabel CoordsGX;
    public JLabel Gyro;
    public JLabel CoordsMY;
    public JLabel CoordsMZ;
    public JLabel CoordsGY;
    public JLabel CoordsGZ;
    public JLabel CoordsAY;
    public JLabel CoordsAZ;
    public Scope AccelXY;
    public Scope AccelXZ;
    public Scope AccelYZ;
    public Scope GyroXY;
    public Scope GyroXZ;
    public Scope GyroYZ;
    public Scope MagnetoXY;
    public Scope MagnetoXZ;
    public Scope MagnetoYZ;
    public Angle AccelAngle;
    public Angle GyroAngle;
    public Angle MagnetoAngle;
    int i;

    public FormFactor() {

        AccelAngle = new Angle();
        MagnetoAngle = new Angle();
        GyroAngle = new Angle();
        $$$setupUI$$$();
        area1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 3, new Insets(0, 0, 0, 0), 2, 1));
        createUIComponents();
        setContentPane(rootPanel);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        i = 1;
        slider1.addChangeListener(new ChangeListener() {
            // @Override
            public void stateChanged(ChangeEvent e) {
                int temp = slider1.getValue();
                if (temp == 250 || temp == 500 || temp == 750 || temp == 1000) {
                    DelicacyValue = temp;
                }

            }
        });


        Kotik.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (i == 1) {
                    Tale.setVisible(true);
                    i = 0;
                } else {
                    Tale.setVisible(false);
                    i = 1;
                }
            }
        });
    }

    /*  public void run(double[] AAngle, double[] GAngle, double[] MAngle) {
          while (true) {
              AccelXY.angle = AAngle[0];
              AccelXZ.angle = AAngle[1];
              AccelYZ.angle = AAngle[2];
              MagnetoXY.angle = MAngle[0];
              MagnetoXZ.angle = MAngle[1];
              MagnetoYZ.angle = MAngle[2];
              GyroXY.angle = GAngle[0];
              GyroXZ.angle = GAngle[1];
              GyroYZ.angle = GAngle[2];
          }
      }
  */
    public static void main(String[] args) {
        //double A = Double.parseDouble(args[0]);
        new FormFactor();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here


        AccelXY = new Scope(AccelAngle.XYAngle);
        area1.add(AccelXY, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        AccelXY.setOpaque(true);
        GyroXY = new Scope(GyroAngle.XYAngle);
        GyroXY.setBackground(new Color(-12891098));
        area1.add(GyroXY, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        MagnetoXY = new Scope(MagnetoAngle.XYAngle);
        area1.add(MagnetoXY, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        AccelXZ = new Scope(AccelAngle.XZAngle);
        AccelXZ.setBackground(new Color(-12891045));
        area1.add(AccelXZ, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        GyroXZ = new Scope(GyroAngle.XZAngle);
        GyroXZ.setBackground(new Color(-12891013));
        area1.add(GyroXZ, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        MagnetoXZ = new Scope(MagnetoAngle.XZAngle);
        area1.add(MagnetoXZ, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        AccelYZ = new Scope(AccelAngle.YZAngle);
        AccelYZ.setBackground(new Color(-12891045));
        area1.add(AccelYZ, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        GyroYZ = new Scope(GyroAngle.YZAngle);
        GyroYZ.setBackground(new Color(-12891013));
        area1.add(GyroYZ, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        MagnetoYZ = new Scope(MagnetoAngle.YZAngle);
        area1.add(MagnetoYZ, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));


    }


    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rootPanel = new JPanel();
        rootPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(31, 14, new Insets(10, 10, 10, 0), -1, -1));
        rootPanel.setBackground(new Color(-10081498));
        rootPanel.setOpaque(true);
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        rootPanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 16, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, 1, new Dimension(15, 15), new Dimension(15, 15), new Dimension(15, 15), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        rootPanel.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(26, 13, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        rootPanel.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 12, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, new Dimension(100, 30), new Dimension(100, 30), new Dimension(-1, 30), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        rootPanel.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(28, 3, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        rootPanel.add(spacer5, new com.intellij.uiDesigner.core.GridConstraints(30, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-11327952));
        rootPanel.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(5, 4, 23, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setBackground(new Color(-11327952));
        Font label1Font = this.$$$getFont$$$("Moscow Sans Regular", -1, 16, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-9992654));
        label1.setHorizontalTextPosition(11);
        label1.setText("XY");
        panel1.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setBackground(new Color(-11327952));
        Font label2Font = this.$$$getFont$$$("Moscow Sans Regular", -1, 16, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setForeground(new Color(-9992654));
        label2.setText("XZ");
        panel1.add(label2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setBackground(new Color(-11327952));
        Font label3Font = this.$$$getFont$$$("Moscow Sans Regular", -1, 16, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setForeground(new Color(-9992654));
        label3.setText("YZ");
        panel1.add(label3, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        area1 = new JPanel();
        area1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), 2, 0));
        area1.setBackground(new Color(-12055012));
        area1.setEnabled(true);
        area1.setVisible(true);
        rootPanel.add(area1, new com.intellij.uiDesigner.core.GridConstraints(5, 5, 23, 8, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(600, 600), new Dimension(600, 600), new Dimension(600, 600), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer6 = new com.intellij.uiDesigner.core.Spacer();
        rootPanel.add(spacer6, new com.intellij.uiDesigner.core.GridConstraints(1, 9, 3, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer7 = new com.intellij.uiDesigner.core.Spacer();
        rootPanel.add(spacer7, new com.intellij.uiDesigner.core.GridConstraints(27, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel2.setBackground(new Color(-11327952));
        rootPanel.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(4, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 30), new Dimension(-1, 30), 0, false));
        final JLabel label4 = new JLabel();
        label4.setBackground(new Color(-10081498));
        Font label4Font = this.$$$getFont$$$("Moscow Sans Regular", -1, 16, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setForeground(new Color(-9992654));
        label4.setText("Accel");
        panel2.add(label4, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setBackground(new Color(-10081498));
        Font label5Font = this.$$$getFont$$$("Moscow Sans Regular", -1, 16, label5.getFont());
        if (label5Font != null) label5.setFont(label5Font);
        label5.setForeground(new Color(-9992654));
        label5.setText("Gyro");
        panel2.add(label5, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setBackground(new Color(-10081498));
        Font label6Font = this.$$$getFont$$$("Moscow Sans Regular", -1, 16, label6.getFont());
        if (label6Font != null) label6.setFont(label6Font);
        label6.setForeground(new Color(-9992654));
        label6.setText("Magneto");
        panel2.add(label6, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Name = new JLabel();
        Name.setBackground(new Color(-10081498));
        Font NameFont = this.$$$getFont$$$("Moscow Sans Regular", -1, 24, Name.getFont());
        if (NameFont != null) Name.setFont(NameFont);
        Name.setForeground(new Color(-6240895));
        Name.setHorizontalTextPosition(11);
        Name.setText("Scope");
        rootPanel.add(Name, new com.intellij.uiDesigner.core.GridConstraints(4, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHEAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer8 = new com.intellij.uiDesigner.core.Spacer();
        rootPanel.add(spacer8, new com.intellij.uiDesigner.core.GridConstraints(7, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 40), new Dimension(-1, 40), new Dimension(-1, 40), 0, false));
        smth = new JLabel();
        Font smthFont = this.$$$getFont$$$("Moscow Sans Regular", -1, 16, smth.getFont());
        if (smthFont != null) smth.setFont(smthFont);
        smth.setForeground(new Color(-6240895));
        smth.setText("Delicacy");
        smth.setVerticalAlignment(1);
        rootPanel.add(smth, new com.intellij.uiDesigner.core.GridConstraints(8, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHEAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        slider1 = new JSlider();
        slider1.setBackground(new Color(-10081498));
        slider1.setFocusable(true);
        Font slider1Font = this.$$$getFont$$$("Moscow Sans Regular", -1, 10, slider1.getFont());
        if (slider1Font != null) slider1.setFont(slider1Font);
        slider1.setForeground(new Color(-6240895));
        slider1.setMajorTickSpacing(500);
        slider1.setMaximum(1000);
        slider1.setMinimum(0);
        slider1.setMinorTickSpacing(250);
        slider1.setName("SensSlider");
        slider1.setPaintLabels(true);
        slider1.setPaintTicks(true);
        slider1.setPaintTrack(true);
        slider1.setSnapToTicks(true);
        rootPanel.add(slider1, new com.intellij.uiDesigner.core.GridConstraints(9, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(140, -1), new Dimension(140, -1), new Dimension(140, -1), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer9 = new com.intellij.uiDesigner.core.Spacer();
        rootPanel.add(spacer9, new com.intellij.uiDesigner.core.GridConstraints(10, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 40), new Dimension(-1, 40), new Dimension(-1, 40), 0, false));
        final JLabel label7 = new JLabel();
        Font label7Font = this.$$$getFont$$$("Moscow Sans Regular", -1, 14, label7.getFont());
        if (label7Font != null) label7.setFont(label7Font);
        label7.setForeground(new Color(-6240895));
        label7.setText("Values of Accel");
        label7.setVerticalAlignment(1);
        rootPanel.add(label7, new com.intellij.uiDesigner.core.GridConstraints(11, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHEAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        Font label8Font = this.$$$getFont$$$("Moscow Sans Regular", -1, 14, label8.getFont());
        if (label8Font != null) label8.setFont(label8Font);
        label8.setForeground(new Color(-6240895));
        label8.setText("Values of Magneto");
        label8.setVerticalAlignment(1);
        rootPanel.add(label8, new com.intellij.uiDesigner.core.GridConstraints(22, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHEAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Gyro = new JLabel();
        Font GyroFont = this.$$$getFont$$$("Moscow Sans Regular", -1, 14, Gyro.getFont());
        if (GyroFont != null) Gyro.setFont(GyroFont);
        Gyro.setForeground(new Color(-6240895));
        Gyro.setText("Values of Gyro");
        Gyro.setVerticalAlignment(1);
        rootPanel.add(Gyro, new com.intellij.uiDesigner.core.GridConstraints(16, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHEAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer10 = new com.intellij.uiDesigner.core.Spacer();
        rootPanel.add(spacer10, new com.intellij.uiDesigner.core.GridConstraints(15, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 15), new Dimension(-1, 15), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer11 = new com.intellij.uiDesigner.core.Spacer();
        rootPanel.add(spacer11, new com.intellij.uiDesigner.core.GridConstraints(21, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 15), new Dimension(-1, 15), new Dimension(-1, 15), 0, false));
        Kotik = new JButton();
        Kotik.setBackground(new Color(-10081498));
        Kotik.setBorderPainted(false);
        Kotik.setContentAreaFilled(true);
        Kotik.setEnabled(true);
        Font KotikFont = this.$$$getFont$$$("Magneto", -1, 14, Kotik.getFont());
        if (KotikFont != null) Kotik.setFont(KotikFont);
        Kotik.setForeground(new Color(-6240895));
        Kotik.setHideActionText(true);
        Kotik.setIcon(new ImageIcon(getClass().getResource("/Untitled-1.png")));
        Kotik.setMargin(new Insets(2, 0, 2, 0));
        Kotik.setOpaque(false);
        Kotik.setText("");
        Kotik.setVisible(true);
        rootPanel.add(Kotik, new com.intellij.uiDesigner.core.GridConstraints(6, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(140, 140), new Dimension(140, 140), new Dimension(140, 140), 0, false));
        CoordsAX = new JLabel();
        CoordsAX.setBackground(new Color(-12055012));
        Font CoordsAXFont = this.$$$getFont$$$("Moscow Sans Regular", -1, 12, CoordsAX.getFont());
        if (CoordsAXFont != null) CoordsAX.setFont(CoordsAXFont);
        CoordsAX.setForeground(new Color(-9992654));
        CoordsAX.setOpaque(true);
        CoordsAX.setText(" x=, y=,z= ");
        CoordsAX.setVerticalAlignment(1);
        rootPanel.add(CoordsAX, new com.intellij.uiDesigner.core.GridConstraints(12, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHEAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(140, -1), new Dimension(140, -1), new Dimension(140, -1), 0, false));
        CoordsGX = new JLabel();
        CoordsGX.setBackground(new Color(-12055012));
        Font CoordsGXFont = this.$$$getFont$$$("Moscow Sans Regular", -1, 12, CoordsGX.getFont());
        if (CoordsGXFont != null) CoordsGX.setFont(CoordsGXFont);
        CoordsGX.setForeground(new Color(-9992654));
        CoordsGX.setOpaque(true);
        CoordsGX.setText(" x=, y=,z= ");
        CoordsGX.setVerticalAlignment(1);
        rootPanel.add(CoordsGX, new com.intellij.uiDesigner.core.GridConstraints(17, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHEAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(140, -1), new Dimension(140, -1), new Dimension(140, -1), 0, false));
        CoordsMX = new JLabel();
        CoordsMX.setBackground(new Color(-12055012));
        Font CoordsMXFont = this.$$$getFont$$$("Moscow Sans Regular", -1, 12, CoordsMX.getFont());
        if (CoordsMXFont != null) CoordsMX.setFont(CoordsMXFont);
        CoordsMX.setForeground(new Color(-9992654));
        CoordsMX.setOpaque(true);
        CoordsMX.setText(" x=, y=,z= ");
        CoordsMX.setVerticalAlignment(1);
        rootPanel.add(CoordsMX, new com.intellij.uiDesigner.core.GridConstraints(23, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHEAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(140, -1), new Dimension(140, -1), new Dimension(140, -1), 0, false));
        Tale = new JButton();
        Tale.setBackground(new Color(-10081498));
        Tale.setBorderPainted(false);
        Tale.setEnabled(false);
        Tale.setFocusable(false);
        Tale.setIcon(new ImageIcon(getClass().getResource("/Untitled-4.png")));
        Tale.setLabel("");
        Tale.setOpaque(false);
        Tale.setRequestFocusEnabled(true);
        Tale.setText("");
        Tale.setVisible(false);
        rootPanel.add(Tale, new com.intellij.uiDesigner.core.GridConstraints(26, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        CoordsMY = new JLabel();
        CoordsMY.setBackground(new Color(-12055012));
        Font CoordsMYFont = this.$$$getFont$$$("Moscow Sans Regular", -1, 12, CoordsMY.getFont());
        if (CoordsMYFont != null) CoordsMY.setFont(CoordsMYFont);
        CoordsMY.setForeground(new Color(-9992654));
        CoordsMY.setOpaque(true);
        CoordsMY.setText(" x=, y=,z= ");
        CoordsMY.setVerticalAlignment(1);
        rootPanel.add(CoordsMY, new com.intellij.uiDesigner.core.GridConstraints(24, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHEAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(140, -1), new Dimension(140, -1), new Dimension(140, -1), 0, false));
        CoordsMZ = new JLabel();
        CoordsMZ.setBackground(new Color(-12055012));
        Font CoordsMZFont = this.$$$getFont$$$("Moscow Sans Regular", -1, 12, CoordsMZ.getFont());
        if (CoordsMZFont != null) CoordsMZ.setFont(CoordsMZFont);
        CoordsMZ.setForeground(new Color(-9992654));
        CoordsMZ.setOpaque(true);
        CoordsMZ.setText(" x=, y=,z= ");
        CoordsMZ.setVerticalAlignment(1);
        rootPanel.add(CoordsMZ, new com.intellij.uiDesigner.core.GridConstraints(25, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHEAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(140, -1), new Dimension(140, -1), new Dimension(140, -1), 0, false));
        CoordsGY = new JLabel();
        CoordsGY.setBackground(new Color(-12055012));
        Font CoordsGYFont = this.$$$getFont$$$("Moscow Sans Regular", -1, 12, CoordsGY.getFont());
        if (CoordsGYFont != null) CoordsGY.setFont(CoordsGYFont);
        CoordsGY.setForeground(new Color(-9992654));
        CoordsGY.setOpaque(true);
        CoordsGY.setText(" x=, y=,z= ");
        CoordsGY.setVerticalAlignment(1);
        rootPanel.add(CoordsGY, new com.intellij.uiDesigner.core.GridConstraints(18, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHEAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(140, -1), new Dimension(140, -1), new Dimension(140, -1), 0, false));
        CoordsGZ = new JLabel();
        CoordsGZ.setBackground(new Color(-12055012));
        Font CoordsGZFont = this.$$$getFont$$$("Moscow Sans Regular", -1, 12, CoordsGZ.getFont());
        if (CoordsGZFont != null) CoordsGZ.setFont(CoordsGZFont);
        CoordsGZ.setForeground(new Color(-9992654));
        CoordsGZ.setOpaque(true);
        CoordsGZ.setText(" x=, y=,z= ");
        CoordsGZ.setVerticalAlignment(1);
        rootPanel.add(CoordsGZ, new com.intellij.uiDesigner.core.GridConstraints(19, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHEAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(140, -1), new Dimension(140, -1), new Dimension(140, -1), 0, false));
        CoordsAY = new JLabel();
        CoordsAY.setBackground(new Color(-12055012));
        Font CoordsAYFont = this.$$$getFont$$$("Moscow Sans Regular", -1, 12, CoordsAY.getFont());
        if (CoordsAYFont != null) CoordsAY.setFont(CoordsAYFont);
        CoordsAY.setForeground(new Color(-9992654));
        CoordsAY.setOpaque(true);
        CoordsAY.setText(" x=, y=,z= ");
        CoordsAY.setVerticalAlignment(1);
        rootPanel.add(CoordsAY, new com.intellij.uiDesigner.core.GridConstraints(13, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHEAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(140, -1), new Dimension(140, -1), new Dimension(140, -1), 0, false));
        CoordsAZ = new JLabel();
        CoordsAZ.setBackground(new Color(-12055012));
        Font CoordsAZFont = this.$$$getFont$$$("Moscow Sans Regular", -1, 12, CoordsAZ.getFont());
        if (CoordsAZFont != null) CoordsAZ.setFont(CoordsAZFont);
        CoordsAZ.setForeground(new Color(-9992654));
        CoordsAZ.setOpaque(true);
        CoordsAZ.setText(" x=, y=,z= ");
        CoordsAZ.setVerticalAlignment(1);
        rootPanel.add(CoordsAZ, new com.intellij.uiDesigner.core.GridConstraints(14, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHEAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(140, -1), new Dimension(140, -1), new Dimension(140, -1), 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }
}

