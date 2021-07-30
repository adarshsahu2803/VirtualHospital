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

//        updateDetails = new JButton();
//        updateDetails.setBounds(250, 60, 300,50);
//        updateDetails.addActionListener(this);
//        updateDetails.setText("Update Details");
//        updateDetails.setFocusable(false);
//        updateDetails.setBorder(BorderFactory.createBevelBorder(1));

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

//        background.add(updateDetails);
        background.add(newAppointment);
        background.add(upcomingAppointments);
        background.add(previousAppointments);
        background.add(logout);
        frame3.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if(e.getSource() == updateDetails) {
//            frame3.dispose();
//            try {
//                new UpdateDetails();
//            } catch (Exception ex) {}
//        }

        if(e.getSource() == newAppointment) {
            frame3.dispose();
            new Appointment();
        }

        if(e.getSource() == upcomingAppointments) {
            frame3.dispose();
            JFrame frame6 = new JFrame();
            JLabel background;
            JButton home;
            JTextField details;

            ImageIcon image = new ImageIcon("vh.jpg");
            ImageIcon bg = new ImageIcon("bg3.jpg");
            ImageIcon hp = new ImageIcon("bg4.jpg");

            background = new JLabel(bg);
            background.setSize(800, 600);
            background.setHorizontalAlignment(JLabel.LEFT);
            background.setVerticalAlignment(JLabel.BOTTOM);

            frame6.add(background);
            frame6.setTitle("SAHA");
            frame6.setResizable(false);
            frame6.setSize(800, 600);
            frame6.setLayout(null);
            frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame6.setIconImage(image.getImage());
            frame6.setLocationRelativeTo(null);

            home = new JButton();
            home.setBounds(10, 10, 35,35);
            home.addActionListener(this);
            home.setIcon(hp);
            home.setFocusable(false);
            home.setBorder(BorderFactory.createBevelBorder(1));
            background.add(home);

            details = new JTextField();
            details.setBounds(50,50,690,460);
            details.setText(Main.patientsList[Login.getID()-1001].upcomingAppointments());
            details.setBorder(BorderFactory.createBevelBorder(1));
            details.setEditable(false);
            background.add(details);

            home.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame6.dispose();
                    new HomePage();
                }
            });

            frame6.setVisible(true);

        }

        if(e.getSource() == previousAppointments) {
            frame3.dispose();
            JFrame frame7 = new JFrame();
            JLabel background;
            JButton home;
            JTextField details;

            ImageIcon image = new ImageIcon("vh.jpg");
            ImageIcon bg = new ImageIcon("bg3.jpg");
            ImageIcon hp = new ImageIcon("bg4.jpg");

            background = new JLabel(bg);
            background.setSize(800, 600);
            background.setHorizontalAlignment(JLabel.LEFT);
            background.setVerticalAlignment(JLabel.BOTTOM);

            frame7.add(background);
            frame7.setTitle("SAHA");
            frame7.setResizable(false);
            frame7.setSize(800, 600);
            frame7.setLayout(null);
            frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame7.setIconImage(image.getImage());
            frame7.setLocationRelativeTo(null);

            home = new JButton();
            home.setBounds(10, 10, 35,35);
            home.addActionListener(this);
            home.setIcon(hp);
            home.setFocusable(false);
            home.setBorder(BorderFactory.createBevelBorder(1));
            background.add(home);

            details = new JTextField();
            details.setBounds(50,50,690,460);
            details.setText(Main.patientsList[Login.getID()-1001].previousAppointments());
            details.setBorder(BorderFactory.createBevelBorder(1));
            details.setEditable(false);
            background.add(details);

            home.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame7.dispose();
                    new HomePage();
                }
            });

            frame7.setVisible(true);

        }

        if(e.getSource() == logout) {
            frame3.dispose();
            new LoginSignup();
        }
    }
}
