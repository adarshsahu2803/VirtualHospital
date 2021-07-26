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
    boolean covid;
AppointmentObject[] appointmentsList=new AppointmentObject[50];
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

//when patient makes a new appointment,save the appointmnet details in text file(set functions) also call the saveAppointment function to add it to 
//the array of appointments of the current patient object


        int size=0;
        String filename = "AppointmentDetails.txt";

        File AppointmentsFile = new File(filename);
        Scanner scanner3 = new Scanner(AppointmentsFile);
        scanner3.nextLine();

        while(scanner3.hasNextLine()) {
            String[] appointments = scanner3.nextLine().split("[|]");     //size of this array=no.of currentAppoinments
            if(Integer.parseInt(appointments[0])==this.userID){
            appointmentsList[size] = new AppointmentObject(Integer.parseInt(appointments[0]),appointments[1],appointments[2],Integer.parseInt(appointments[3]),Boolean.parseBoolean(appointments[4]),appointments[5] );
            size++;}
        }

        scanner3.close();



    }


public void setAppointment(int id,String doctor,String dept,int time,boolean status){
    appointmentsList[currentAppointments].saveID(id);
    appointmentsList[currentAppointments].saveDepartment(dept);
    appointmentsList[currentAppointments].saveDoctor(doctor);
    appointmentsList[currentAppointments].saveStatus(status);
    appointmentsList[currentAppointments].saveTimeslot(time);
    appointmentsList[currentAppointments].saveFeedback("NULL");
    

    this.currentAppointments++;

}
    Patient() {}
public int getCurrentAppointments(){
    return currentAppointments;
}
public void setCurrentAppointments(int n){
   this.currentAppointments=n;
}
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

            p.print(pass+"|");

        } catch (Exception e) {}
    }
    public void setNoOfAppointments(int currentAppointments) {
        try (FileWriter f = new FileWriter("PatientDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);) {

            p.println(currentAppointments);

        } catch (Exception e) {}
    }
public int getNumberAppointments(){
    return currentAppointments;
}

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


    public String upcomingAppointments(){
        String upcomingAppts="";
        int flag=1;
        for(int i=0;i<currentAppointments;i++){
            if(appointmentsList[i].getStatus()==false){
            flag=0;
            upcomingAppts=upcomingAppts+appointmentsList[i].toStringUpcoming()+"\n";}
          
        } 
         if (flag==1)
         return "No upcoming appointments";
         else return upcomingAppts;
        
    }

public String previousAppointments(){
    String prevAppts="";
    int flag=1;
    for(int i=0;i<currentAppointments;i++){
        if(appointmentsList[i].getStatus()==false){
        flag=0;
        prevAppts=prevAppts+appointmentsList[i].toStringPrevious()+"\n";}
      
    } 
     if (flag==1)
     return "No previous appointments";
     else return prevAppts;
    

}
}