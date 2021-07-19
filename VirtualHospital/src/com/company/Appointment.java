package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class Appointment implements ActionListener {
    private String department;
    private String doctorName;
    private int patientID;
    private String timeslot;
    private String feedback;
    private boolean taken;

    JFrame frame5 = new JFrame();
    JLabel background;
    JComboBox selectDepartment, selectDoctor = new JComboBox();
    JTextField dateSlot, meetLink;
    JButton submit;
    JTextArea textArea, textArea1;
    Appointment appointment;

    Appointment() {
        ImageIcon image = new ImageIcon("vh.jpg");
        ImageIcon bg = new ImageIcon("bg3.jpg");

        background = new JLabel(bg);
        background.setSize(1000,600);
        background.setHorizontalAlignment(JLabel.LEFT);
        background.setVerticalAlignment(JLabel.BOTTOM);

        frame5.add(background);
        frame5.setTitle("SAHA");
        frame5.setResizable(false);
        frame5.setSize(1000,600);
        frame5.setLayout(null);
        frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame5.setIconImage(image.getImage());
        frame5.setLocationRelativeTo(null);

        String[] department = {"Select Department","Dermatologists","Immunologists","Anesthesiologists","Cardiologists","Endocrinologists","Gastroenterologists","Hematologists","Neurologists","Gynecologists","Internists"};

        selectDepartment = new JComboBox(department);
        selectDepartment.addActionListener(this);
        selectDepartment.setBounds(390, 60, 200, 50);
        selectDepartment.setBorder(BorderFactory.createBevelBorder(1));
        selectDepartment.setVisible(true);

        textArea = new JTextArea();
        textArea.setBounds(650, 0, 250,325);
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);

        selectDoctor.addItem("Select Doctor");
        selectDoctor.addActionListener(this);
        selectDoctor.setBounds(390, 155, 200, 50);
        selectDoctor.setBorder(BorderFactory.createBevelBorder(1));

        textArea1 = new JTextArea();
        textArea1.setBounds(75, 130, 250,195);
        textArea1.setBorder(BorderFactory.createBevelBorder(1));
        textArea1.setEditable(false);

        dateSlot = new JTextField();
        dateSlot.setBounds(390, 250, 200,50);
        dateSlot.setText("Date-Slot (e.g. 14-3)");
        dateSlot.setBorder(BorderFactory.createBevelBorder(1));

        meetLink = new JTextField();
        meetLink.setBounds(300, 370, 400,50);
        meetLink.setText("__________Meet Link__________");
        meetLink.setHorizontalAlignment(0);
        meetLink.setEditable(false);
        meetLink.setBorder(BorderFactory.createBevelBorder(1));

        submit = new JButton();
        submit.setBounds(390, 490, 200,50);
        submit.addActionListener(this);
        submit.setText("submit");
        submit.setFocusable(false);
        submit.setBorder(BorderFactory.createBevelBorder(1));

        background.add(selectDepartment);
        background.add(textArea);
        background.add(selectDoctor);
        background.add(textArea1);
        background.add(dateSlot);
        background.add(meetLink);
        background.add(submit);

        frame5.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selectDepartment) {
            if (selectDepartment.getSelectedItem().equals("Select Department")) {
            } else {
                appointment = new Appointment((String) selectDepartment.getSelectedItem());
                String txt = "                      Available Doctors";
                txt = txt + appointment.displayDoctors();
                textArea.setText(txt);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);

                background.add(textArea);

                for(int i=1; i<selectDoctor.getItemCount(); i++)
                    selectDoctor.removeItemAt(i);
                addComboItems((String) selectDepartment.getSelectedItem());
            }
        }

        if (e.getSource() == selectDoctor) {
            if (selectDepartment.getSelectedItem().equals("Select Doctor")) {}
            else {}
        }

        if(e.getSource() == submit) {
            frame5.dispose();
            new HomePage();
        }
    }

    public Appointment(String Department) {
            department = Department;
        }

//        public Appointment(int ID, String doctor, String department, String timeslot){
//            patientID = ID;
//            doctorName = doctor;
//            department = department;
//            timeslot = timeslot;
//        }

        public String displayDoctors () {
            String finalStr = "";
            File file = new File("DoctorDetails.txt");
            Scanner scanner = null;
            try {
                scanner = new Scanner(file);
            } catch (Exception e) {
            }

            while (scanner.hasNextLine()) {
                String[] arr = scanner.nextLine().split("\\|");
                if (!arr[1].equals(department))
                    continue;

                String name = arr[0];
                String experience = String.valueOf(arr[2]);
                String ratings = String.valueOf(arr[3]);

                finalStr += "\nName         : " + name + "\nExperience : " + experience + "\nRatings      : " + ratings + "\n";
            }
            return finalStr;
        }

        public void setDoctor (String doctorName)
        {        //take (doctor name) as input & append field in patient notepad

            this.doctorName = doctorName;

            try (FileWriter f = new FileWriter("PatientDetails.txt", true);
                 BufferedWriter b = new BufferedWriter(f);
                 PrintWriter p = new PrintWriter(b)) {

                p.print(doctorName);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void displayDatesSlots (String date){    //display available dates with their slots

            try {
                Scanner scanner = new Scanner(new File("DoctorDetails.txt"));
                while (scanner.hasNextLine()) {
                    String[] arr = scanner.nextLine().split("\\|");
                    if (!arr[0].equals(doctorName))
                        continue;

                    Time time = new Time(arr[5]);
                    System.out.println(time.toString());
                }

            } catch (Exception e) {
            }
        }

        public void setDateSlot (String Date,int SlotNumber){           //edit date and slot number in patient notepad

            try (FileWriter f = new FileWriter("PatientDetails.txt", true);
                 BufferedWriter b = new BufferedWriter(f);
                 PrintWriter p = new PrintWriter(b)) {

                p.print(Date + "|" + SlotNumber);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void addComboItems(String str) {
            if(selectDoctor.getItemCount() != 1) {
                selectDoctor.removeAllItems();
                selectDoctor.addItem("Select Doctor");
            }

            File file = new File("DoctorDetails.txt");
            Scanner scanner = null;
            try {
                scanner = new Scanner(file);
            } catch (Exception e) {
            }

            while (scanner.hasNextLine()) {
                String[] arr = scanner.nextLine().split("\\|");
                if (!arr[1].equals(str))
                    continue;
                selectDoctor.addItem(arr[0]);
            }
    }

//    public static void main(String[] args) throws FileNotFoundException {
//        Appointment a = new Appointment("Immunologists");
//        System.out.println(a.displayDoctors());
//    }


}

