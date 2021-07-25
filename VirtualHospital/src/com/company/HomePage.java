package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class HomePage implements ActionListener {

    JFrame frame3 = new JFrame();
    JLabel background;
    JButton updateDetails, newAppointment, upcomingAppointments, previousAppointments, logout;

    HomePage() {
        ImageIcon image = new ImageIcon("vh.jpg");
        ImageIcon bg = new ImageIcon("bg3.jpg");

        background = new JLabel(bg);
        background.setSize(800,600);
        background.setHorizontalAlignment(JLabel.LEFT);
        background.setVerticalAlignment(JLabel.BOTTOM);

        frame3.add(background);
        frame3.setTitle("SAHA");
        frame3.setResizable(false);
        frame3.setSize(800,600);
        frame3.setLayout(null);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setIconImage(image.getImage());
        frame3.setLocationRelativeTo(null);

        updateDetails = new JButton();
        updateDetails.setBounds(250, 60, 300,50);
        updateDetails.addActionListener(this);
        updateDetails.setText("Update Details");
        updateDetails.setFocusable(false);
        updateDetails.setBorder(BorderFactory.createBevelBorder(1));

        newAppointment = new JButton();
        newAppointment.setBounds(250, 155, 300,50);
        newAppointment.addActionListener(this);
        newAppointment.setText("New Appointment");
        newAppointment.setFocusable(false);
        newAppointment.setBorder(BorderFactory.createBevelBorder(1));

        upcomingAppointments = new JButton();
        upcomingAppointments.setBounds(250, 250, 300,50);
        upcomingAppointments.addActionListener(this);
        upcomingAppointments.setText("Upcoming Appointments");
        upcomingAppointments.setFocusable(false);
        upcomingAppointments.setBorder(BorderFactory.createBevelBorder(1));

        previousAppointments = new JButton();
        previousAppointments.setBounds(250, 345, 300,50);
        previousAppointments.addActionListener(this);
        previousAppointments.setText("Previous Appointments");
        previousAppointments.setFocusable(false);
        previousAppointments.setBorder(BorderFactory.createBevelBorder(1));

        logout = new JButton();
        logout.setBounds(300, 490, 200,50);
        logout.addActionListener(this);
        logout.setText("Logout");
        logout.setFocusable(false);
        logout.setBorder(BorderFactory.createBevelBorder(1));

        background.add(updateDetails);
        background.add(newAppointment);
        background.add(upcomingAppointments);
        background.add(previousAppointments);
        background.add(logout);
        frame3.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == updateDetails) {
            frame3.dispose();
            try {
                new UpdateDetails();
            } catch (Exception ex) {}
        }

        if(e.getSource() == newAppointment) {
            frame3.dispose();
            new Appointment();
        }

        if(e.getSource() == upcomingAppointments) {}

        if(e.getSource() == previousAppointments) {}

        if(e.getSource() == logout) {
            frame3.dispose();
            new LoginSignup();
        }
    }
}
