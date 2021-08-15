package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorHomePage implements ActionListener {
    JFrame frame8 = new JFrame();
    JLabel background;
    JButton logout;
    JTextField userDetails;
    JComboBox upcomingAppID, previousAppID;
    public static AppointmentObject[] docAppointments = new AppointmentObject[50];

    DoctorHomePage() throws FileNotFoundException {

        String doctorName = Main.doctorsList[Login.getID()-2343245].getName();

        int n=0;
        String filename = "AppointmentDetails.txt";
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        while(scanner.hasNextLine()){
            String[] strings = scanner.nextLine().split("[|]");
            if(strings[2].equals(doctorName)){
                docAppointments[n] = new AppointmentObject(Integer.parseInt(strings[0]),strings[1],strings[2],strings[3],Integer.parseInt(strings[4]),Boolean.parseBoolean(strings[5]),strings[6]);
                n++;
            }
        }
     scanner.close();
        List<String> list1 = new ArrayList<String>();
        list1.add("Upcoming Appointment's Date-Slot");
        List<String> list2 = new ArrayList<String>();
        list2.add("Previous Appointment's Date-Slot");

        for(int i=0; i<n; i++){
            if(!docAppointments[i].getStatus())
                list1.add(docAppointments[i].date + "-" + docAppointments[i].getTimeslot());
            else
                list2.add(docAppointments[i].date + "-" + docAppointments[i].getTimeslot());
        }


        ImageIcon image = new ImageIcon("vh.jpg");
        ImageIcon bg = new ImageIcon("bg3.jpg");

        background = new JLabel(bg);
        background.setSize(800,600);
        background.setHorizontalAlignment(JLabel.LEFT);
        background.setVerticalAlignment(JLabel.BOTTOM);

        frame8.add(background);
        frame8.setTitle("Connect&Care");
        frame8.setResizable(false);
        frame8.setSize(800,600);
        frame8.setLayout(null);
        frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame8.setIconImage(image.getImage());
        frame8.setLocationRelativeTo(null);

        userDetails = new JTextField();
        userDetails.setBounds(600, 25, 150,50);
        userDetails.setText("User ID : " + Login.getID());
        userDetails.setHorizontalAlignment(0);
        userDetails.setBorder(BorderFactory.createBevelBorder(1));
        userDetails.setEditable(false);

        upcomingAppID = new JComboBox(list1.toArray());
        upcomingAppID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged (ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if(!upcomingAppID.getSelectedItem().toString().equals("Upcoming Appointment's Date-Slot")) {

                        String selectedItem = (String) upcomingAppID.getSelectedItem();
                        frame8.dispose();

                        JFrame frame9 = new JFrame();
                        JLabel background;
                        JButton home;
                        JTextArea details;

                        ImageIcon image = new ImageIcon("vh.jpg");
                        ImageIcon bg = new ImageIcon("bg3.jpg");
                        ImageIcon hp = new ImageIcon("bg4.jpg");

                        background = new JLabel(bg);
                        background.setSize(800, 600);
                        background.setHorizontalAlignment(JLabel.LEFT);
                        background.setVerticalAlignment(JLabel.BOTTOM);

                        frame9.add(background);
                        frame9.setTitle("Connect&Care");
                        frame9.setResizable(false);
                        frame9.setSize(800, 600);
                        frame9.setLayout(null);
                        frame9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame9.setIconImage(image.getImage());
                        frame9.setLocationRelativeTo(null);

                        home = new JButton();
                        home.setBounds(10, 10, 35,35);
                        home.setIcon(hp);
                        home.setFocusable(false);
                        home.setBorder(BorderFactory.createBevelBorder(1));
                        background.add(home);

                        details = new JTextArea();
                        details.setBounds(50,50,690,460);
                        String[] ts = selectedItem.split("-");
                        details.setText(Doctor.displayAdditionalDetails(docAppointments, Integer.parseInt(ts[1]), ts[0], false));
                        details.setBorder(BorderFactory.createBevelBorder(1));
                        details.setEditable(false);
                        background.add(details);

                        home.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                frame9.dispose();
                                try {
                                    new DoctorHomePage();
                                } catch (Exception ex) {}
                            }
                        });

                        frame9.setVisible(true);
                    }
                }
            }
        });
        upcomingAppID.setBounds(275, 150, 250, 50);
        upcomingAppID.setBorder(BorderFactory.createBevelBorder(1));
        upcomingAppID.setVisible(true);

        previousAppID = new JComboBox(list2.toArray());
        previousAppID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged (ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if(!previousAppID.getSelectedItem().toString().equals("Previous Appointment's Date-Slot")) {

                        String selectedItem = (String) previousAppID.getSelectedItem();
                        frame8.dispose();

                        JFrame frame10 = new JFrame();
                        JLabel background;
                        JButton home, save;
                        JTextArea details;
                        JTextField feedback;

                        ImageIcon image = new ImageIcon("vh.jpg");
                        ImageIcon bg = new ImageIcon("bg3.jpg");
                        ImageIcon hp = new ImageIcon("bg4.jpg");

                        background = new JLabel(bg);
                        background.setSize(800, 600);
                        background.setHorizontalAlignment(JLabel.LEFT);
                        background.setVerticalAlignment(JLabel.BOTTOM);

                        frame10.add(background);
                        frame10.setTitle("Connect&Care");
                        frame10.setResizable(false);
                        frame10.setSize(800, 600);
                        frame10.setLayout(null);
                        frame10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame10.setIconImage(image.getImage());
                        frame10.setLocationRelativeTo(null);

                        home = new JButton();
                        home.setBounds(10, 10, 35,35);
                        home.setIcon(hp);
                        home.setFocusable(false);
                        home.setBorder(BorderFactory.createBevelBorder(1));
                        background.add(home);

                        details = new JTextArea();
                        details.setBounds(50,50,690,350);
                        String[] ts = selectedItem.split("-");
                        details.setText(Doctor.displayAdditionalDetails(docAppointments, Integer.parseInt(ts[1]), ts[0], true));
                        details.setBorder(BorderFactory.createBevelBorder(1));
                        details.setEditable(false);
                        background.add(details);

                        feedback = new JTextField();
                        feedback.setBounds(100, 425, 600,50);
                        feedback.setHorizontalAlignment(0);
                        feedback.setText("Update Feedback");
                        feedback.setBorder(BorderFactory.createBevelBorder(1));
                        background.add(feedback);

                        save = new JButton();
                        save.setBounds(350, 500, 100,40);
                        save.setText("save");
                        save.setFocusable(false);
                        save.setBorder(BorderFactory.createBevelBorder(1));
                        background.add(save);

                        home.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                frame10.dispose();
                                try {
                                    new DoctorHomePage();
                                } catch (Exception ex) {}
                            }
                        });

                        save.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Doctor.updateFeedbacktxt(Integer.parseInt(ts[1]), ts[0], feedback.getText());
                                Doctor.updateFeedbackArray(ts[0], Integer.parseInt(ts[1]), feedback.getText(), docAppointments);
                                details.setText(Doctor.displayAdditionalDetails(docAppointments, Integer.parseInt(ts[1]), ts[0], true));
                            }
                        });

                        frame10.setVisible(true);
                    }
                }
            }
        });
        previousAppID.setBounds(275, 250, 250, 50);
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
        frame8.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logout) {
            frame8.dispose();
            new LoginSignup();
        }
    }
}