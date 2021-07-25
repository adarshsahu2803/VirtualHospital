package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static Doctor[] doctorsList = new Doctor[50];

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

        new LoginSignup();
    }
}