package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginSignup implements ActionListener{
    JFrame frame = new JFrame();
    JButton login, signup;
    JLabel background;

    LoginSignup() {
        ImageIcon image = new ImageIcon("vh.jpg");
        ImageIcon bg = new ImageIcon("bg3.jpg");
        ImageIcon icon = new ImageIcon("icon.png");

        background = new JLabel(bg);
        background.setSize(800,600);

        frame.add(background);
        background.setIcon(icon);

        frame.setTitle("Connect&Care");
        frame.setResizable(false);
        frame.setSize(800,600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(image.getImage());
        frame.setLocationRelativeTo(null);

        login = new JButton();
        login.setBounds(150, 400, 200,50);
        login.addActionListener(this);
        login.setText("Login");
        login.setFocusable(false);
        login.setBorder(BorderFactory.createBevelBorder(1));

        signup = new JButton();
        signup.setBounds(450, 400, 200,50);
        signup.addActionListener(this);
        signup.setText("Signup");
        signup.setFocusable(false);
        signup.setBorder(BorderFactory.createBevelBorder(1));

        background.add(login);
        background.add(signup);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login) {
            frame.dispose();
            new Login();
        }

        if(e.getSource() == signup) {
            frame.dispose();
            new Signup();
        }
    }
}
