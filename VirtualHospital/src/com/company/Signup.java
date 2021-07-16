package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup  implements ActionListener {
    JFrame frame2 = new JFrame();
    JLabel background, ID;
    JTextField name, age, aadharNumber, Password;
    JButton submit;
    int index = 1000;

    Signup() {
        ImageIcon image = new ImageIcon("vh.jpg");
        ImageIcon bg = new ImageIcon("bg3.jpg");

//        name.getName()

        background = new JLabel(bg);
        background.setSize(800,600);

        frame2.add(background);
        frame2.setTitle("Login");
        frame2.setResizable(false);
        frame2.setSize(800,600);
        frame2.setLayout(null);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setIconImage(image.getImage());
        frame2.setLocationRelativeTo(null);

        name = new JTextField();
        name.setBounds(150, 200, 200,50);
        name.setText("Name");

        age = new JTextField();
        age.setBounds(450, 200, 200,50);
        age.setText("Age");

        aadharNumber = new JTextField();
        aadharNumber.setBounds(150, 275, 200,50);
        aadharNumber.setText("Aadhar Number");

        Password = new JTextField();
        Password.setBounds(450, 275, 200,50);
        Password.setText("Password");
        
        submit = new JButton();
        submit.setBounds(300, 425, 200,50);
        submit.addActionListener(this);
        submit.setText("submit");
        submit.setFocusable(false);

        ID = new JLabel();
        ID.setHorizontalTextPosition(JLabel.CENTER);
        ID.setText("User ID : " + setID());
        ID.setBounds(300, 100, 200,50);
        ID.setBackground(Color.lightGray);
        ID.setOpaque(true);

        background.add(ID);

        background.add(name);
        background.add(age);
        background.add(aadharNumber);
        background.add(Password);
        background.add(submit);
        frame2.setVisible(true);
    }

    private String setID() {
        index += Main.counter;
        return String.valueOf(index);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit) {
            frame2.dispose();
            new LoginSignup();
            System.out.println("save details");
        }
    }
}
