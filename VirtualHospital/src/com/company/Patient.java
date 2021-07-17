package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Patient {
    private String name, password, aadharNum;
    private int age, userID;

    private int currentAppointments;
    float height,weight;
    boolean covid;

    Patient(int userID, String name, int age, String aadharNum, String password) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.aadharNum = aadharNum;
        this.password = password;
    }

    Patient() {}

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getAadhar() {
        return aadharNum;
    }
    public float getHeight() {
        return height;
    }
    public float getWeight() {
        return weight;
    }
    public boolean getCovid() {
        return covid;
    }
    public int getID() {
        return userID;
    }

    public void setUserID(String uid) {
        try (FileWriter f = new FileWriter("PatientDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);) {

            p.print(uid + "|");

        } catch (Exception e) {}
    }

    public void setName(String n) {
        try (FileWriter f = new FileWriter("PatientDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);) {

            p.print(n + "|");

        } catch (Exception e) {}
    }

    public void setAge(String a) {
        try (FileWriter f = new FileWriter("PatientDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);) {

            p.print(a + "|");

        } catch (Exception e) {}
    }

    public void setAadharNum(String aadhar) {
        try (FileWriter f = new FileWriter("PatientDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);) {

            p.print(aadhar + "|");

        } catch (Exception e) {}
    }

    public void setPassword(String pass) {
        try (FileWriter f = new FileWriter("PatientDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);) {

            p.println(pass);

        } catch (Exception e) {}
    }
}