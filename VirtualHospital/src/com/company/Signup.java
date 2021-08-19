package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Signup extends Patient implements ActionListener {
    JFrame frame2 = new JFrame();
    JLabel background;
    static JLabel ID;
    JTextField name, age, aadharNumber, Password;
    JButton submit, back;
    int index = 1000;

    Signup() {
        ImageIcon image = new ImageIcon("vh.jpg");
        ImageIcon bg = new ImageIcon("bg3.jpg");
        ImageIcon backButton = new ImageIcon("back.png");

        back = new JButton();
        back.setBounds(10, 10, 40,40);
        back.addActionListener(this);
        back.setIcon(backButton);
        back.setFocusable(false);
        back.setBorder(BorderFactory.createBevelBorder(1));

        background = new JLabel(bg);
        background.setSize(800,600);
        background.setHorizontalAlignment(JLabel.LEFT);
        background.setVerticalAlignment(JLabel.BOTTOM);

        frame2.add(background);
        frame2.setTitle("Connect&Care");
        frame2.setResizable(false);
        frame2.setSize(800,600);
        frame2.setLayout(null);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setIconImage(image.getImage());
        frame2.setLocationRelativeTo(null);

        name = new JTextField();
        name.setBounds(150, 200, 200,50);
        name.setText("Name");
        name.setBorder(BorderFactory.createBevelBorder(1));

        age = new JTextField();
        age.setBounds(450, 200, 200,50);
        age.setText("Age");
        age.setBorder(BorderFactory.createBevelBorder(1));

        aadharNumber = new JTextField();
        aadharNumber.setBounds(150, 275, 200,50);
        aadharNumber.setText("Aadhar Number");
        aadharNumber.setBorder(BorderFactory.createBevelBorder(1));

        Password = new JTextField();
        Password.setBounds(450, 275, 200,50);
        Password.setText("Password");
        Password.setBorder(BorderFactory.createBevelBorder(1));

        submit = new JButton();
        submit.setBounds(300, 425, 200,50);
        submit.addActionListener(this);
        submit.setText("submit");
        submit.setFocusable(false);
        submit.setBorder(BorderFactory.createBevelBorder(1));

        ID = new JLabel();
        ID.setHorizontalTextPosition(JLabel.CENTER);
        ID.setText(setID());
        ID.setBounds(300, 100, 200,50);
        ID.setOpaque(true);
        ID.setBorder(BorderFactory.createBevelBorder(1));

        background.add(ID);
        background.add(back);
        background.add(name);
        background.add(age);
        background.add(aadharNumber);
        background.add(Password);
        background.add(submit);
        frame2.setVisible(true);
    }

    public static int getLinesCount() {
        int lines = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("PatientDetails.txt"))) {
            while (br.readLine() != null)
                lines++;
        } catch (Exception e) {}

        return lines;

    }

    private String setID() {
        return String.valueOf(index + getLinesCount());
    }

    public static int saveID(){
        return Integer.parseInt(ID.getText());
    }

    public void saveDetails() {
        Patient p = new Patient();

        p.setUserID(setID());
        p.setName(name.getText());
        p.setAge(age.getText());
        p.setAadharNum(aadharNumber.getText());
        p.setPassword(Password.getText());
        p.setNoOfAppointments(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back) {
            frame2.dispose();
            new LoginSignup();
        }

        if(e.getSource() == submit) {
            try {
                int validAge = Integer.parseInt(age.getText());
            }
            catch (Exception NumberFormatException) {
                JOptionPane.showMessageDialog(null, "Invalid Age", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            if(aadharNumber.getText().length() != 12) {
                JOptionPane.showMessageDialog(null, "Invalid Aadhar Number", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else {

                frame2.dispose();
                saveDetails();
                Patient newPatient = new Patient(Integer.parseInt(ID.getText()), name.getText(), Integer.parseInt(age.getText()), aadharNumber.getText(), Password.getText());
                Main.patientsList[getLinesCount()-2] = newPatient;

                new UpdateDetails();
            }
        }
    }
}