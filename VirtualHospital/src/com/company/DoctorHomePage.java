package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorHomePage implements ActionListener {
    JFrame frame6 = new JFrame();
    JLabel background;
    JButton logout;
    JTextField userDetails;
    JComboBox upcomingAppID, previousAppID;

    DoctorHomePage(){
        ImageIcon image = new ImageIcon("vh.jpg");
        ImageIcon bg = new ImageIcon("bg3.jpg");

        background = new JLabel(bg);
        background.setSize(800,600);
        background.setHorizontalAlignment(JLabel.LEFT);
        background.setVerticalAlignment(JLabel.BOTTOM);

        frame6.add(background);
        frame6.setTitle("SAHA");
        frame6.setResizable(false);
        frame6.setSize(800,600);
        frame6.setLayout(null);
        frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame6.setIconImage(image.getImage());
        frame6.setLocationRelativeTo(null);

        userDetails = new JTextField();
        userDetails.setBounds(600, 25, 150,50);
        userDetails.setText("User ID : " + Login.getID());
        userDetails.setHorizontalAlignment(0);
        userDetails.setBorder(BorderFactory.createBevelBorder(1));
        userDetails.setEditable(false);

        upcomingAppID = new JComboBox();
        upcomingAppID.addActionListener(this);
        upcomingAppID.setBounds(275, 125, 250, 50);
        upcomingAppID.addItem("Upcoming Appointment's Date-Slot");
        upcomingAppID.setBorder(BorderFactory.createBevelBorder(1));
        upcomingAppID.setVisible(true);

        previousAppID = new JComboBox();
        previousAppID.addActionListener(this);
        previousAppID.setBounds(275, 225, 250, 50);
        previousAppID.addItem("Previous Appointment's Date-Slot");
        previousAppID.setBorder(BorderFactory.createBevelBorder(1));
        previousAppID.setVisible(true);

        logout = new JButton();
        logout.setBounds(300, 400, 200,50);
        logout.addActionListener(this);
        logout.setText("Logout");
        logout.setFocusable(false);
        logout.setBorder(BorderFactory.createBevelBorder(1));

        background.add(userDetails);
        background.add(upcomingAppID);
        background.add(previousAppID);
        background.add(logout);
        frame6.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == logout) {
            frame6.dispose();
            new LoginSignup();
        }
    }

}
