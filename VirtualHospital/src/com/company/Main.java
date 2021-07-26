package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static Doctor[] doctorsList = new Doctor[50];
    public static Patient[] patientsList=new Patient[100];

    public static void main(String[] args) throws FileNotFoundException {
        int n=0;
        String filename = "DoctorDetails.txt";

        File doctorsFile = new File(filename);
        Scanner scanner = new Scanner(doctorsFile);
        scanner.nextLine();
        while(scanner.hasNextLine()) {
            String[] doctor = scanner.nextLine().split("[|]");
            doctorsList[n] = new Doctor(doctor[0], doctor[1], Integer.parseInt(doctor[2]), Double.parseDouble(doctor[3]), Integer.parseInt(doctor[4]));
            n++;
        }
        scanner.close();



        n=0;
        String file = "PatientDetails.txt";

        File patientsFile = new File(file);
        Scanner scanner2 = new Scanner(patientsFile);
        scanner2.nextLine();


        while(scanner2.hasNextLine()) {
            try {
                   String[] patient = scanner2.nextLine().split("[|]");
            if(patient[0].equals("")) continue;
            patientsList[n] = new Patient(Integer.parseInt(patient[0]), patient[1], Integer.parseInt(patient[2]), patient[3], patient[4]);
            n++;
            } catch (Exception e) {
                String[] patient = scanner2.nextLine().split("[|]");
            if(patient[0].equals("")) continue;
            patientsList[n] = new Patient(Integer.parseInt(patient[0]), patient[1], Integer.parseInt(patient[2]), patient[3], patient[4],Integer.parseInt(patient[5]));
            n++;
            }
         
        }
        scanner2.close();


//        for(int i=0; i<patientsList.length; i++){
//            System.out.println(patientsList[i]);
//
//        }




        new LoginSignup();
    }
}