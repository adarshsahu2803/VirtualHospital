//package com.company;
//
//import java.io.*;
//import java.util.Scanner;
//
//public class Appointment {
//    private final String department;
//    private String doctorName;
//
//
//    public Appointment(String Department) {
//        department = Department;
//    }
//
//    public String displayDoctors() throws FileNotFoundException {          //display doctors of particular department with their details
//        String finalStr = "";
//        File file = new File("DoctorDetails.txt");
//        Scanner scanner = new Scanner(file);
//
//        while(scanner.hasNextLine()) {
//            String[] arr = scanner.nextLine().split("\\|");
//            if(!arr[1].equals(department))
//                continue;
//
//            String name = arr[0];
//            String experience = String.valueOf(arr[2]);
//            String ratings = String.valueOf(arr[3]);
//
//            finalStr += "\nName       : " + name + "\nExperience : " + experience + "\nRatings    : " + ratings + "\n";
//        }
//        return finalStr;
//    }
//
//    public void setDoctor(String doctorName) {        //take (doctor name) as input & append field in patient notepad
//
//        this.doctorName = doctorName;
//
//        try (FileWriter f = new FileWriter("PatientDetails.txt", true);
//             BufferedWriter b = new BufferedWriter(f);
//             PrintWriter p = new PrintWriter(b)) {
//
//            p.print(doctorName);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public void displayDatesSlots(String date) {    //display available dates with their slots
//
//        try {
//            Scanner scanner = new Scanner(new File("DoctorDetails.txt"));
//            while(scanner.hasNextLine()) {
//                String[] arr = scanner.nextLine().split("\\|");
//                if (!arr[0].equals(doctorName))
//                    continue;
//
//                Time time = new Time(arr[5]);
//                System.out.println(time.toString());
//            }
//
//        }catch (Exception e) {}
//    }
//
//    public void setDateSlot(String Date, int SlotNumber) {           //edit date and slot number in patient notepad
//
//        try (FileWriter f = new FileWriter("PatientDetails.txt", true);
//             BufferedWriter b = new BufferedWriter(f);
//             PrintWriter p = new PrintWriter(b)) {
//
//            p.print(Date + "|" + SlotNumber);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
////    public static void main(String[] args) throws FileNotFoundException {
////        Appointment a = new Appointment("Immunologists");
////        System.out.println(a.displayDoctors());
////    }
//
//
//}
