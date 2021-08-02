package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class UpdateDetails implements ActionListener {

    JFrame frame4 = new JFrame();
    JLabel background;
    JButton home, submit;
    JTextField ID, Name, Age, Aadhar, Password, Height, Weight, PhoneNumber;
    JComboBox Gender, BloodGroup;

//    Lists lists = new Lists();

    UpdateDetails()  {
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
        frame4.setUndecorated(true);
        frame4.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame4.setIconImage(image.getImage());
        frame4.setLocationRelativeTo(null);

//        home = new JButton();
//        home.setBounds(10, 10, 35,35);
//        home.addActionListener(this);
//        home.setIcon(hp);
//        home.setFocusable(false);
//        home.setBorder(BorderFactory.createBevelBorder(1));

        ID = new JTextField();
        ID.setBounds(300, 60, 200,50);
        ID.setText(String.valueOf(Signup.saveID()));
        ID.setEditable(false);
        ID.setHorizontalAlignment(JTextField.CENTER);
        ID.setBorder(BorderFactory.createBevelBorder(1));

        Name = new JTextField();
        Name.setBounds(50, 155, 200,50);
        Name.setText(Main.patientsList[Signup.saveID()-1001].getName());
        Name.setBorder(BorderFactory.createBevelBorder(1));
        Name.setEditable(false);

        Age = new JTextField();
        Age.setBounds(300, 155, 200,50);
        Age.setText(String.valueOf(Main.patientsList[Signup.saveID()-1001].getAge()));
        Age.setBorder(BorderFactory.createBevelBorder(1));
        Age.setEditable(false);

        Aadhar = new JTextField();
        Aadhar.setBounds(550, 155, 200,50);
        Aadhar.setText(Main.patientsList[Signup.saveID()-1001].getAadhar());
        Aadhar.setBorder(BorderFactory.createBevelBorder(1));
        Aadhar.setEditable(false);


        Password = new JTextField();
        Password.setBounds(50, 250, 200,50);
        Password.setText(Main.patientsList[Signup.saveID()-1001].getPassword());
        Aadhar.setBorder(BorderFactory.createBevelBorder(1));
        Aadhar.setEditable(false);

        Password = new JTextField();
        Password.setBounds(50, 250, 200,50);
        Password.setText(Main.patientsList[Signup.saveID()-1001].getPassword());
        Password.setBorder(BorderFactory.createBevelBorder(1));
        Password.setEditable(false);

        String[] gender = {"Gender", "Male", "Female"};
        Gender = new JComboBox(gender);
        Gender.setBounds(300, 250, 200,50);
        Gender.setBorder(BorderFactory.createBevelBorder(1));

        String[] bloodGroup = {"BloodGroup", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        BloodGroup = new JComboBox(bloodGroup);
        BloodGroup.setBounds(550, 250, 200,50);
        BloodGroup.setBorder(BorderFactory.createBevelBorder(1));

        Height = new JTextField();
        Height.setBounds(50, 345, 200,50);
        Height.setText("Height(in cm)");
        Height.setBorder(BorderFactory.createBevelBorder(1));

        Weight = new JTextField();
        Weight.setBounds(300, 345, 200,50);
        Weight.setText("Weight(in kg)");
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
//        background.add(home);
        frame4.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit) {
            if(check()==1) {
                saveDetails();
                saveInArray();
                frame4.dispose();
                new LoginSignup();
            }
            else {
                JOptionPane.showMessageDialog(null, "Check the details entered", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

//        if(e.getSource() == home) {
//            frame4.dispose();
//            new HomePage();
//        }
    }

    private int check(){
        if(String.valueOf(Gender.getSelectedItem()).equals("Gender"))
            return 0;
        if(String.valueOf(BloodGroup.getSelectedItem()).equals("BloodGroup"))
            return 0;
        if(String.valueOf(Height.getText()).equals("Height(in cm)"))
            return 0;
        if(String.valueOf(Weight.getText()).equals("Weight(in kg)"))
            return 0;
        if(String.valueOf(PhoneNumber.getText()).equals("Phone Number"))
            return 0;
        String s1 = Height.getText();
        if(s1.equals(""))
            return 0;
        int i=0;
        for(i=0;i<s1.length();i++){
            if((s1.charAt(i)<'0'&&s1.charAt(i)>'9')&&(s1.charAt(i)!='.'))
                return 0;
        }
        String s2 = Weight.getText();
        if(s2.equals(""))
            return 0;
        for(i=0;i<s2.length();i++){
            if((s2.charAt(i)<'0'&&s2.charAt(i)>'9')&&(s2.charAt(i)!='.'))
                return 0;
        }
        String s3 = PhoneNumber.getText();
        if(s3.equals(""))
            return 0;
        for(i=0;i<s3.length();i++){
            if(s3.charAt(i)<'0'&&s3.charAt(i)>'9')
                return 0;
        }

        return 1;
    }

    private void saveDetails() {
        Patient p = new Patient();
        p.setUserID2(ID.getText());
        p.setGender(String.valueOf(Gender.getSelectedItem()));
        p.setBloodGroup(String.valueOf(BloodGroup.getSelectedItem()));
        p.setHeight(Height.getText());
        p.setWeight(Weight.getText());
        p.setPhoneNumber(PhoneNumber.getText());
    }

    private void saveInArray(){
        int id = Signup.saveID();
        Main.patientsList[id-1001].setterGender(String.valueOf(Gender.getSelectedItem()));
        Main.patientsList[id-1001].setterBloodGroup(String.valueOf(BloodGroup.getSelectedItem()));
        Main.patientsList[id-1001].setterHeight(Float.parseFloat(Height.getText()));
        Main.patientsList[id-1001].setterWeight(Float.parseFloat(Weight.getText()));
        Main.patientsList[id-1001].setterPhoneNumber(PhoneNumber.getText());
    }
}
