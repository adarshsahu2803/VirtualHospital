//package com.company;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class exp {
//    public static void main(String[] args) throws FileNotFoundException {
//        AppointmentObject[] docAppointments = new AppointmentObject[50];
//
//        String doctorName = Main.doctorsList[0].getName();
//        int n=0;
//        String filename = "AppointmentDetails.txt";
//        File file = new File(filename);
//        Scanner scanner = new Scanner(file);
//        scanner.nextLine();
//        while(scanner.hasNextLine()){
//            String[] strings = scanner.nextLine().split("[|]");
//            if(strings[2].equals(doctorName)){
//                docAppointments[n] = new AppointmentObject(Integer.parseInt(strings[0]),strings[1],strings[2],strings[3],Integer.parseInt(strings[4]),Boolean.parseBoolean(strings[5]),strings[6]);
//                n++;
//            }
//        }
//
//        System.out.println(Doctor.getAdditionalDetails(docAppointments, 9,"12/8/2021"));
//    }
//}
