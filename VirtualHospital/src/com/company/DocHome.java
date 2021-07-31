package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DocHome implements ActionListener {
    JFrame frame6 = new JFrame();
    JLabel background;
    JButton  upcomingAppointments, logout;

    DocHome(){
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

        upcomingAppointments = new JButton();
        upcomingAppointments.setBounds(250, 250, 300,50);
        upcomingAppointments.addActionListener(this);
        upcomingAppointments.setText("Upcoming Appointments");
        upcomingAppointments.setFocusable(false);
        upcomingAppointments.setBorder(BorderFactory.createBevelBorder(1));

        logout = new JButton();
        logout.setBounds(300, 490, 200,50);
        logout.addActionListener(this);
        logout.setText("Logout");
        logout.setFocusable(false);
        logout.setBorder(BorderFactory.createBevelBorder(1));

        background.add(upcomingAppointments);
        background.add(logout);
        frame6.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == upcomingAppointments) {}

        if(e.getSource() == logout) {
            frame6.dispose();
            new LoginSignup();
        }
    }

}
