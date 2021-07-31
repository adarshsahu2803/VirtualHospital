package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AppointmentObject {
    private int patientID,timeslot;
    String doctor;
    String department;
    String MeetLink;
    String feedback;
    int date;
    private boolean completed; 

    public AppointmentObject(int ID,String doctor,String department,int date,int timeslot,Boolean status,String feedback ){
        patientID = ID;
         this.doctor = doctor;
         this.department = department;
         this.timeslot = timeslot;
         this.completed=status;
         this.feedback=feedback;
         this.date=date;
    }

    public AppointmentObject (){};

//    public AppointmentObject(int id, String appointment, String department, int date, int timeslot, boolean completed, String feedback){};

    public void saveDoctor(String doctor){
        this.doctor=doctor;
    }
    public void saveDepartment(String dept){
        this.department=dept;
    }
    public void saveDate(int date){
        this.date=date;
    }
    public void saveTimeslot(int slot){
        this.timeslot=slot;
    }
    public void saveID(int ID){
        this.patientID=ID;
    }
    public void saveStatus(boolean status){
        this.completed=status;
    }
    public void saveFeedback(String feedback){
        this.feedback=feedback;
    }

    public void setID(int userid){
        try (FileWriter f = new FileWriter("AppointmentDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);) {

            p.print(userid + "|");

        } catch (Exception e) {}
    }

    public void setDoctor(String doctorname){
    try (FileWriter f = new FileWriter("AppointmentDetails.txt", true);
    BufferedWriter b = new BufferedWriter(f);
    PrintWriter p = new PrintWriter(b);) {

   p.print(doctorname + "|");

} catch (Exception e) {}
}

public void setDepartment(String departmentname){
    try (FileWriter f = new FileWriter("AppointmentDetails.txt", true);
    BufferedWriter b = new BufferedWriter(f);
    PrintWriter p = new PrintWriter(b);) {

   p.print(departmentname + "|");

} catch (Exception e) {}
}

public void setTimeSlot(int Date,int SlotNumber){
        try (FileWriter f = new FileWriter("AppointmentDetails.txt", true);
        BufferedWriter b = new BufferedWriter(f);
        PrintWriter p = new PrintWriter(b);) {
    
       p.print(Date + "|" + SlotNumber + "|");
    
    } catch (Exception e) {}
}

public void setStatus(boolean status){
    try (FileWriter f = new FileWriter("AppointmentDetails.txt", true);
    BufferedWriter b = new BufferedWriter(f);
    PrintWriter p = new PrintWriter(b);) {

   p.print(status + "|");

} catch (Exception e) {}
}

public void setFeedback(String Feedback){
        try (FileWriter f = new FileWriter("AppointmentDetails.txt", true);
        BufferedWriter b = new BufferedWriter(f);
        PrintWriter p = new PrintWriter(b);) {
    
       p.println(Feedback );
    
    } catch (Exception e) {}
}

    public void incrementAppointmentNum(int userID){

        ArrayList<String> tempArray = new ArrayList<>();

        try {
            try (FileReader fr = new FileReader("PatientDetails.txt")) {
                Scanner reader = new Scanner(fr);
                String line;
                String[] lineArr;

                while ((line = reader.nextLine()) != null) {
                    lineArr = line.split("[|]");
                    if (lineArr[0].equals(String.valueOf(userID))) {
                        tempArray.add(lineArr[0] + "|" + lineArr[1] + "|" + lineArr[2] + "|" + lineArr[3] + "|" + lineArr[4] + "|" + (Integer.parseInt(lineArr[5]) + 1));
                    } else
                        tempArray.add(line);
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }

        try {
            try (PrintWriter pr = new PrintWriter("PatientDetails.txt")) {
                for (String str : tempArray) {
                    pr.println(str);
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }

    }

public int getID(){
    return this.patientID;
}

public String getDoctor(){
    return doctor;
}
public String getDepartment(){
    return department;
}
public int getTimeslot(){
    return timeslot;
}
public int getDate(){
    return date;
}

public boolean getStatus(){
    return completed;
}
public String getFeedback(){
    return feedback;
}
 public String MeetLink() {
            String str = "https://meet.google.com/";
            str = str.concat(department);

            File file = new File("DoctorDetails.txt");
            Scanner scanner = null;
            try {
                scanner = new Scanner(file);
            } catch (Exception e) {
            }

            while (scanner.hasNextLine()) {
                String[] arr = scanner.nextLine().split("\\|");
                if (!arr[0].equals(doctor))
                    continue;
                else {
                    str = str.concat(arr[2]);
                    break;
                }
            }
            return str;
        }

public String toStringUpcoming() {

    String timeSlot= timeslot-1+":00-"+timeslot+":00";

    String Appointments = "Department:"+ department+"\nDoctor: "+doctor+"\nTime Slot: "+timeSlot+"\nMeet Link:"+MeetLink();
    return Appointments;
}
public String toStringPrevious() {

    String timeSlot= timeslot-1+":00-"+timeslot+":00";

    String Appointments = "Department: "+ department+"\nDoctor: "+doctor+"\nTime Slot: "+timeSlot+"\nFeedback: \n"+feedback;
    return Appointments;
}
}
