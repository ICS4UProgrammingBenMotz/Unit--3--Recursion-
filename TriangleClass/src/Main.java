/*
 * Created by: Ben Motz
 * Created on: April 21, 2020
 * Created for: ICS4U
 * Major Assignment #4, Triangle Class
 * This program tells the user info about triangles
 */
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private JPanel panel1;
    private JLabel lblsidelengths;
    private JSpinner spnSide1;
    private JSpinner spnSide2;
    private JSpinner spnSide3;
    private JButton btnGenerate;
    private JLabel lblArea;
    private JLabel lblType;
    private JLabel lblHeight;
    private JLabel lblInscCirc;
    private JLabel lblCircumArea;

    public Main() {
        //sets the spinners values
        spnSide1.setValue(1);
        spnSide2.setValue(1);
        spnSide3.setValue(1);

        //creates a new triangle class so it can be referenced
        Triangle triangle = new Triangle();

        panel1.setPreferredSize(new Dimension(800,250));


        //code for all the spinners so that the side lengths can not be less than 1
        spnSide1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                if ((int)spnSide1.getValue()<1){
                    spnSide1.setValue(1);
                }
            }
        });
        spnSide2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                if ((int)spnSide2.getValue()<1){
                    spnSide2.setValue(1);
                }
            }
        });
        spnSide3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                if ((int)spnSide3.getValue()<1){
                    spnSide3.setValue(1);
                }
            }
        });
        btnGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //passes the side lengths to the triangle class
                triangle.Triangle((int)spnSide1.getValue(), (int)spnSide2.getValue(), (int)spnSide3.getValue());
                //checks if triangle is valid
                boolean isTheTriValid=triangle.isTriValid();

                if (isTheTriValid==false){
                    //tells user that the lengths entered can not create a triangle
                    JOptionPane.showMessageDialog(null, "These values do not create a proper triangle. Please try again");
                }
                else {

                    //displays all the info
                    lblArea.setText("The area is: " + triangle.calcArea() + "m^2");

                    lblHeight.setText("The height is: " + triangle.calcHeight() + "m");

                    lblType.setText("This is a(n) " + triangle.TriangleType() + " triangle");

                    lblCircumArea.setText("The circumcircle's area is: " + triangle.AreaOfCircumcircle() + "m^2");

                    lblInscCirc.setText("The radius of the largest inscribed circle is:"+triangle.radOFInscCirc()+"m");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new Main().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
