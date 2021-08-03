package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorHomePage implements ActionListener {
    JFrame frame6 = new JFrame();
    JLabel background;
    JButton logout;
    JTextField userDetails;
    JComboBox upcomingAppID, previousAppID;
    AppointmentObject[] docAppointments = new AppointmentObject[50];

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
                docAppointments[n] = new AppointmentObject(Integer.parseInt(strings[0]),strings[1],strings[2],Integer.parseInt(strings[3]),Integer.parseInt(strings[4]),Boolean.parseBoolean(strings[5]),strings[6]);
                n++;
            }
        }

        List<String> list1 = new ArrayList<String>();
        list1.add("Upcoming Appointment's Date-Slot");
        List<String> list2 = new ArrayList<String>();
        list2.add("Previous Appointment's Date-Slot");

        for(int i=0; i<n; i++){
            if(docAppointments[i].getStatus()==false)
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

        upcomingAppID = new JComboBox(list1.toArray());
        upcomingAppID.addActionListener(this);
        upcomingAppID.setBounds(275, 125, 250, 50);
//        upcomingAppID.addItem("Upcoming Appointment's Date-Slot");
        upcomingAppID.setBorder(BorderFactory.createBevelBorder(1));
        upcomingAppID.setVisible(true);

        previousAppID = new JComboBox(list2.toArray());
        previousAppID.addActionListener(this);
        previousAppID.setBounds(275, 225, 250, 50);
//        previousAppID.addItem("Previous Appointment's Date-Slot");
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

        if(e.getSource() == upcomingAppID){
            String str = (String)upcomingAppID.getSelectedItem();
            if(str.equals("Upcoming Appointment's Date-Slot") != true){
                for(int i=0; docAppointments[i]!=null; i++){
                    if(Integer.parseInt(str.split("[-]")[0]) == docAppointments[i].getDate() && Integer.parseInt(str.split("[-]")[1]) == docAppointments[i].getTimeslot()){
                        int id = docAppointments[i].getID();
                        //Code to show patient details
                    }
                }
            }
        }

        if(e.getSource() == previousAppID){
            String str = (String)previousAppID.getSelectedItem();
            if(str.equals("Previous Appointment's Date-Slot") != true){
                for(int i=0; docAppointments[i]!=null; i++){
                    if(Integer.parseInt(str.split("[-]")[0]) == docAppointments[i].getDate() && Integer.parseInt(str.split("[-]")[1]) == docAppointments[i].getTimeslot()){
                        int id = docAppointments[i].getID();
                        //Code to update feedback
                    }
                }
            }
        }
    }

}
