package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateDetails implements ActionListener {

    JFrame frame4 = new JFrame();
    JLabel background;
    JButton submit, previousPage;

    UpdateDetails() {
        ImageIcon image = new ImageIcon("vh.jpg");
        ImageIcon bg = new ImageIcon("bg3.jpg");

        background = new JLabel(bg);
        background.setSize(800, 600);

        frame4.add(background);
        background.setIcon(bg);

        frame4.setTitle("SHAA");
        frame4.setResizable(false);
        frame4.setSize(800, 600);
        frame4.setLayout(null);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setIconImage(image.getImage());
        frame4.setLocationRelativeTo(null);

        submit = new JButton();
        submit.setBounds(250, 60, 300, 50);
        submit.addActionListener(this);
        submit.setText("Submit");
        submit.setFocusable(false);

        previousPage = new JButton();
        previousPage.setBounds(250, 60, 300, 50);
        previousPage.addActionListener(this);
        previousPage.setText("Previous Page");
        previousPage.setFocusable(false);

        background.add(submit);
        background.add(previousPage);
        frame4.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit) {}

        if(e.getSource() == previousPage) {
            frame4.dispose();
            new HomePage();
        }
    }
}
