package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateDetails implements ActionListener {

    JFrame frame4 = new JFrame();
    JLabel background;
    JButton home, submit;
    JTextField ID, Name, Age, Aadhar, Password, Gender, BloodGroup, Height, Weight, PhoneNumber;

    UpdateDetails() {
        ImageIcon image = new ImageIcon("vh.jpg");
        ImageIcon bg = new ImageIcon("bg3.jpg");
        ImageIcon hp = new ImageIcon("bg4.jpg");

        background = new JLabel(bg);
        background.setSize(800, 600);
        background.setHorizontalAlignment(JLabel.LEFT);
        background.setVerticalAlignment(JLabel.BOTTOM);

        frame4.add(background);
        frame4.setTitle("SAHA");
        frame4.setResizable(false);
        frame4.setSize(800, 600);
        frame4.setLayout(null);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setIconImage(image.getImage());
        frame4.setLocationRelativeTo(null);

        home = new JButton();
        home.setBounds(10, 10, 35,35);
        home.addActionListener(this);
        home.setIcon(hp);
        home.setFocusable(false);
        home.setBorder(BorderFactory.createBevelBorder(1));

        ID = new JTextField();
        ID.setBounds(300, 60, 200,50);
        ID.setText("ID");
        ID.setEditable(false);
        ID.setHorizontalAlignment(JTextField.CENTER);
        ID.setBorder(BorderFactory.createBevelBorder(1));

        Name = new JTextField();
        Name.setBounds(50, 155, 200,50);
        Name.setText("Name");
        Name.setBorder(BorderFactory.createBevelBorder(1));

        Age = new JTextField();
        Age.setBounds(300, 155, 200,50);
        Age.setText("Age");
        Age.setBorder(BorderFactory.createBevelBorder(1));

        Aadhar = new JTextField();
        Aadhar.setBounds(550, 155, 200,50);
        Aadhar.setText("Aadhar Number");
        Aadhar.setBorder(BorderFactory.createBevelBorder(1));

        Password = new JTextField();
        Password.setBounds(50, 250, 200,50);
        Password.setText("Password");
        Password.setBorder(BorderFactory.createBevelBorder(1));

        Gender = new JTextField();
        Gender.setBounds(300, 250, 200,50);
        Gender.setText("Gender");
        Gender.setBorder(BorderFactory.createBevelBorder(1));

        BloodGroup = new JTextField();
        BloodGroup.setBounds(550, 250, 200,50);
        BloodGroup.setText("Blood Group");
        BloodGroup.setBorder(BorderFactory.createBevelBorder(1));

        Height = new JTextField();
        Height.setBounds(50, 345, 200,50);
        Height.setText("Height");
        Height.setBorder(BorderFactory.createBevelBorder(1));

        Weight = new JTextField();
        Weight.setBounds(300, 345, 200,50);
        Weight.setText("Weight");
        Weight.setBorder(BorderFactory.createBevelBorder(1));

        PhoneNumber = new JTextField();
        PhoneNumber.setBounds(550, 345, 200,50);
        PhoneNumber.setText("Phone Number");
        PhoneNumber.setBorder(BorderFactory.createBevelBorder(1));

        submit = new JButton();
        submit.setBounds(300, 490, 200,50);
        submit.addActionListener(this);
        submit.setText("Submit");
        submit.setFocusable(false);
        submit.setBorder(BorderFactory.createBevelBorder(1));

        background.add(ID);
        background.add(Name);
        background.add(Age);
        background.add(Aadhar);
        background.add(Password);
        background.add(Gender);
        background.add(BloodGroup);
        background.add(Height);
        background.add(Weight);
        background.add(PhoneNumber);
        background.add(submit);
        background.add(home);
        frame4.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit) {}

        if(e.getSource() == home) {
            frame4.dispose();
            new HomePage();
        }
    }
}
