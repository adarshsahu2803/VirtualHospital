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

    private String gender;
    private String bloodGroup;
    private String phoneNumber;


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
    public String getPassword(){
        return password;
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

    public void setUserID2(String uid) {
        try (FileWriter f = new FileWriter("AdditionalDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);) {

            p.print(uid + "|");

        } catch (Exception e) {}
    }

    public void setGender(String gender) {
        try (FileWriter f = new FileWriter("AdditionalDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);) {

            p.print(gender + "|");

        } catch (Exception e) {}
    }

    public void setBloodGroup(String bloodgroup) {
        try (FileWriter f = new FileWriter("AdditionalDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);) {

            p.print(bloodgroup + "|");

        } catch (Exception e) {}
    }

    public void setHeight(String height) {
        try (FileWriter f = new FileWriter("AdditionalDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);) {

            p.print(height + "|");

        } catch (Exception e) {}
    }

    public void setWeight(String weight) {
        try (FileWriter f = new FileWriter("AdditionalDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);) {

            p.print(weight + "|");

        } catch (Exception e) {}
    }

    public void setPhoneNumber(String phoneNumber) {
        try (FileWriter f = new FileWriter("AdditionalDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);) {

            p.println(phoneNumber);

        } catch (Exception e) {}
    }

    //Setters-II
    public void setterGender(String s){
        this.gender = s;
    }

    public void setterBloodGroup(String b){
        this.bloodGroup = b;
    }

    public void setterHeight(float height){
        this.height = height;
    }

    public void setterWeight(float weight){
        this.weight = weight;
    }

    public void setterPhoneNumber(String p){
        this.phoneNumber = p;
    }
    //Setters-II end

    public static boolean isIdValid( Patient[] list, int ID){
        for(int i=0; i<Signup.getLinesCount(); i++){
            if(list[i].userID == ID)
                return true;
        }
        return false;
    }

    public static boolean checkPassword(Patient[] list, int ID, String password){
        if(list[ID-1001].getPassword().equals(password))
            return true;
        else
            return false;
    }


}