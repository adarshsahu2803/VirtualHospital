package com.company;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Patient {
    private String name, password, aadharNum;
    private int age, userID;
    private int currentAppointments;
    float height,weight;

    public static AppointmentObject[] appointmentsList=new AppointmentObject[50];

    Patient(int userID, String name, int age, String aadharNum, String password) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.aadharNum = aadharNum;
        this.password = password;
        currentAppointments=0;
    }

    Patient(int userID, String name, int age, String aadharNum, String password,int appointment)  throws FileNotFoundException{
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.aadharNum = aadharNum;
        this.password = password;
        currentAppointments=appointment;

        int size=0;
        String filename = "AppointmentDetails.txt";

        File AppointmentsFile = new File(filename);
        Scanner scanner3 = new Scanner(AppointmentsFile);
        scanner3.nextLine();

        while(scanner3.hasNextLine()) {
            String[] appointments = scanner3.nextLine().split("[|]");     //size of this array=no.of currentAppointments
            if(Integer.parseInt(appointments[0])==this.userID){
                appointmentsList[size] = new AppointmentObject(Integer.parseInt(appointments[0]),appointments[1],appointments[2],appointments[3],Integer.parseInt(appointments[4]),Boolean.parseBoolean(appointments[5]),appointments[6] );
                size++;}
        }
        scanner3.close();
    }

    public void setAppointment(int id,String dept,String doctor,String date,int time,boolean completed){
        appointmentsList[currentAppointments] = new AppointmentObject();

        appointmentsList[currentAppointments].saveID(id);
        appointmentsList[currentAppointments].saveDepartment(dept);
        appointmentsList[currentAppointments].saveDoctor(doctor);
        appointmentsList[currentAppointments].saveStatus(completed);
        appointmentsList[currentAppointments].saveTimeslot(time);
        appointmentsList[currentAppointments].saveFeedback("NULL");
        appointmentsList[currentAppointments].saveDate(date);

        this.currentAppointments++;
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

    public int getID() {
        return userID;
    }

    public String getPassword(){
        return password;
    }

    public void setUserID(String uid) {
        try (FileWriter f = new FileWriter("PatientDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b)) {

            p.print(uid + "|");

        } catch (Exception e) {}
    }

    public void setName(String n) {
        try (FileWriter f = new FileWriter("PatientDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b)) {

            p.print(n + "|");

        } catch (Exception e) {}
    }

    public void setAge(String a) {
        try (FileWriter f = new FileWriter("PatientDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b)) {

            p.print(a + "|");

        } catch (Exception e) {}
    }

    public void setAadharNum(String aadhar) {
        try (FileWriter f = new FileWriter("PatientDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b)) {

            p.print(aadhar + "|");

        } catch (Exception e) {}
    }

    public void setPassword(String pass) {
        try (FileWriter f = new FileWriter("PatientDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b)) {

            p.print(pass+"|");

        } catch (Exception e) {}
    }

    public void setNoOfAppointments(int currentAppointments) {
        try (FileWriter f = new FileWriter("PatientDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b)) {

            p.println(currentAppointments);

        } catch (Exception e) {}
    }

    public void setUserID2(String uid) {
        try (FileWriter f = new FileWriter("AdditionalDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b)) {

             p.print(uid + "|");

        } catch (Exception e) {}
    }

    public void setGender(String gender) {
        try (FileWriter f = new FileWriter("AdditionalDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b)) {

            p.print(gender + "|");

        } catch (Exception e) {}
    }

    public void setBloodGroup(String bloodGroup) {
        try (FileWriter f = new FileWriter("AdditionalDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b)) {

            p.print(bloodGroup + "|");

        } catch (Exception e) {}
    }

    public void setHeight(String height) {
        try (FileWriter f = new FileWriter("AdditionalDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b)) {

            p.print(height + "|");

        } catch (Exception e) {}
    }

    public void setWeight(String weight) {
        try (FileWriter f = new FileWriter("AdditionalDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b)) {

            p.print(weight + "|");

        } catch (Exception e) {}
    }

    public void setPhoneNumber(String phoneNumber) {
        try (FileWriter f = new FileWriter("AdditionalDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b)) {

            p.println(phoneNumber);

        } catch (Exception e) {}
    }

    public void setterHeight(float height){
        this.height = height;
    }

    public void setterWeight(float weight){
        this.weight = weight;
    }

    public static boolean isIdValid( Patient[] list, int ID){
        for(int i=0; i<Signup.getLinesCount()-1; i++){
            if(list[i].userID == ID)
                return true;
        }
        return false;
    }

    public static boolean checkPassword(Patient[] list, int ID, String password){
        return list[ID - 1001].getPassword().equals(password);
    }

    public String upcomingAppointments(){
        StringBuilder upcomingApp= new StringBuilder();
        int flag=1;
        for(int i=0;i<currentAppointments;i++){
            if(!appointmentsList[i].getStatus()){
                flag=0;
                upcomingApp.append(appointmentsList[i].toStringUpcoming()).append("\n");
            }
        }
        if (flag==1)
            return "No upcoming appointments";
        else return upcomingApp.toString();
    }

    public String previousAppointments(){
        StringBuilder prevApp= new StringBuilder();
        int flag=1;
        for(int i=0;i<currentAppointments;i++){
            if(appointmentsList[i].getStatus()){
                flag=0;
                prevApp.append(appointmentsList[i].toStringPrevious()).append("\n");}
        }
        if (flag==1)
            return "No previous appointments";
        else return prevApp.toString();
    }
}