package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpcomingAppointment implements ActionListener {
    JFrame frame6 = new JFrame();
    JLabel background;
    JButton home;

    UpcomingAppointment() {
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

        frame6.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == home) {
            frame6.dispose();
            new HomePage();
        }
    }
}
