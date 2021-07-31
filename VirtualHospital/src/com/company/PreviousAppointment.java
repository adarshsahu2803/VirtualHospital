//package com.company;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class PreviousAppointment implements ActionListener {
//    JFrame frame7 = new JFrame();
//    JLabel background;
//    JButton home;
//
//    PreviousAppointment() {
//        ImageIcon image = new ImageIcon("vh.jpg");
//        ImageIcon bg = new ImageIcon("bg3.jpg");
//        ImageIcon hp = new ImageIcon("bg4.jpg");
//
//        background = new JLabel(bg);
//        background.setSize(800, 600);
//        background.setHorizontalAlignment(JLabel.LEFT);
//        background.setVerticalAlignment(JLabel.BOTTOM);
//
//        frame7.add(background);
//        frame7.setTitle("SAHA");
//        frame7.setResizable(false);
//        frame7.setSize(800, 600);
//        frame7.setLayout(null);
//        frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame7.setIconImage(image.getImage());
//        frame7.setLocationRelativeTo(null);
//
//        home = new JButton();
//        home.setBounds(10, 10, 35,35);
//        home.addActionListener(this);
//        home.setIcon(hp);
//        home.setFocusable(false);
//        home.setBorder(BorderFactory.createBevelBorder(1));
//
//        background.add(home);
//
//        frame7.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource() == home) {
//            frame7.dispose();
//            new HomePage();
//        }
//    }
//}
