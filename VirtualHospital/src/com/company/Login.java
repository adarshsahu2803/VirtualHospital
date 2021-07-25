package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener{
    JFrame frame1 = new JFrame();
    JLabel background;
    static JTextField ID;
    JTextField Password;
    JButton submit;

    Login() {
        ImageIcon image = new ImageIcon("vh.jpg");
        ImageIcon bg = new ImageIcon("bg3.jpg");

        background = new JLabel(bg);
        background.setSize(800,600);
        background.setHorizontalAlignment(JLabel.LEFT);
        background.setVerticalAlignment(JLabel.BOTTOM);

        frame1.add(background);
        frame1.setTitle("SAHA");
        frame1.setResizable(false);
        frame1.setSize(800,600);
        frame1.setLayout(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setIconImage(image.getImage());
        frame1.setLocationRelativeTo(null);

        ID = new JTextField();
        ID.setBounds(300, 150, 200,50);
        ID.setText("ID");
        ID.setBorder(BorderFactory.createBevelBorder(1));

        Password = new JTextField();
        Password.setBounds(300, 225, 200,50);
        Password.setText("Password");
        Password.setBorder(BorderFactory.createBevelBorder(1));

        submit = new JButton();
        submit.setBounds(300, 375, 200,50);
        submit.addActionListener(this);
        submit.setText("submit");
        submit.setFocusable(false);
        submit.setBorder(BorderFactory.createBevelBorder(1));

        background.add(ID);
        background.add(Password);
        background.add(submit);
        frame1.setVisible(true);
    }

    public static int getID(){
        return Integer.parseInt(ID.getText());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            try {

            int id = Integer.parseInt(ID.getText());

                Lists lists = new Lists();
            try {
                lists.updatePatientList();
                lists.updateDoctorList();
            } catch (Exception ex) {}

            if(Patient.isIdValid(lists.patientsList, id)){

                if(Patient.checkPassword(lists.patientsList, id, Password.getText())){
                    frame1.dispose();
                    new HomePage();

                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid ID/password", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid ID/password", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid ID/password", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }

    }
}


