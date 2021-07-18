package com.company;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Appointment {
    private String department;
    private String doctorName;

    JFrame frame5 = new JFrame();
    JLabel background;

    public Appointment(String Department) {
        department = Department;
    }

    Appointment() {
        ImageIcon image = new ImageIcon("vh.jpg");
        ImageIcon bg = new ImageIcon("bg3.jpg");

        background = new JLabel(bg);
        background.setSize(800,600);

        frame5.add(background);
        background.setIcon(bg);

        frame5.setTitle("SHAA");
        frame5.setResizable(false);
        frame5.setSize(800,600);
        frame5.setLayout(null);
        frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame5.setIconImage(image.getImage());
        frame5.setLocationRelativeTo(null);

        frame5.setVisible(true);

    }
    
    public String displayDoctors() throws FileNotFoundException {          //display doctors of particular department with their details
        String finalStr = "";
        File file = new File("DoctorDetails.txt");
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()) {
            String[] arr = scanner.nextLine().split("\\|");
            if(!arr[1].equals(department))
                continue;

            String name = arr[0];
            String experience = String.valueOf(arr[2]);
            String ratings = String.valueOf(arr[3]);

            finalStr += "\nName       : " + name + "\nExperience : " + experience + "\nRatings    : " + ratings + "\n";
        }
        return finalStr;
    }

    public void setDoctor(String doctorName) {        //take (doctor name) as input & append field in patient notepad

        this.doctorName = doctorName;

        try (FileWriter f = new FileWriter("PatientDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b)) {

            p.print(doctorName);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void displayDatesSlots(String date) {    //display available dates with their slots

        try {
            Scanner scanner = new Scanner(new File("DoctorDetails.txt"));
            while(scanner.hasNextLine()) {
                String[] arr = scanner.nextLine().split("\\|");
                if (!arr[0].equals(doctorName))
                    continue;

                Time time = new Time(arr[5]);
                System.out.println(time.toString());
            }

        }catch (Exception e) {}
    }

    public void setDateSlot(String Date, int SlotNumber) {           //edit date and slot number in patient notepad

        try (FileWriter f = new FileWriter("PatientDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b)) {

            p.print(Date + "|" + SlotNumber);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    public static void main(String[] args) throws FileNotFoundException {
//        Appointment a = new Appointment("Immunologists");
//        System.out.println(a.displayDoctors());
//    }


}
