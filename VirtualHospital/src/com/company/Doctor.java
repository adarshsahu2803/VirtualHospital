package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Doctor {

	private String name;
	private String department;
	private int experience;
	private double rating;
	private int doctorID;
//	private time[] timeslots;
//	private String meetingLink;



	public Doctor(String name, String department, int experience, double rating, int doctorID){

		this.name = name;
		this.department = department;
		this.experience = experience;
		this.rating = rating;
		this.doctorID = doctorID;


	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public int getExperience() {
		return experience;
	}

	public double getRating() {
		return rating;
	}

	public int getDoctorID() {
		return doctorID;
	}

//	public time[] getTimeslots() {
//		return timeslots;
//	}

//	public String getMeetingLink() {
//		return meetingLink;
//	}


	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

//	public void setTimeslots(time[] timeslots) {
//		this.timeslots = timeslots;
//	}

//	public void setMeetingLink(String meetingLink) {
//		this.meetingLink = meetingLink;
//	}

	public String toString() {
		return this.name + "\n" + "Experience : " + this.experience + "\nRating : " + this.rating;
	}

	public static String getDepartment(Doctor[] list, int ID){
		for(int i=0; i<list.length; i++){
			if(list[i].doctorID == ID)
				return list[i].department;
		}
		return "null";
	}


	// all doctor functions
	public void updateFeedbackArray(String date,int slot,String feedback,AppointmentObject[] doctorAppointmentsList){
		for(int i=0;i<100;i++){
			if(doctorAppointmentsList[i].getDate().equals(date)&&doctorAppointmentsList[i].getTimeslot()==slot)
			doctorAppointmentsList[i].saveFeedback(feedback);
		}
	}
	

public void updateFeedbacktxt(int time,String date,String feedback){

        ArrayList<String> tempArray = new ArrayList<>();

        try {
            try (FileReader fr = new FileReader("AppointmentDetails.txt")) {
                Scanner reader = new Scanner(fr);
                String line;
                String[] lineArr;

                while ((line = reader.nextLine()) != null) {
                    lineArr = line.split("[|]");
                    if (lineArr[3].equals(String.valueOf(time))&&lineArr[4].equals(date)) {
                        tempArray.add(lineArr[0] + "|" + lineArr[1] + "|" + lineArr[2] + "|" + lineArr[3] + "|" + lineArr[4] + "|" + lineArr[5] + "|"+feedback);
                    } else
                        tempArray.add(line);
                }
				reader.close();
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }

        try {
            try (PrintWriter pr = new PrintWriter("AppointmentDetails.txt")) {
                for (String str : tempArray) {
                    pr.println(str);
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }

    }





	public String getAdditionalDetails(AppointmentObject[] doctorAppointmentsList,int time,String date){
		int ID=0;
		for(int i=0;i<100;i++)
		if(doctorAppointmentsList[i].getDate().equals(date) && doctorAppointmentsList[i].getTimeslot()==time){
        ID=doctorAppointmentsList[i].getID();
        break;}
	
		String details = "";
		File file = new File("AdditionalDetails.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (Exception e) {
		}
	
		while (scanner.hasNextLine()) {
			String[] arr = scanner.nextLine().split("\\|");
			if (ID==Integer.parseInt(arr[0])){
			String gender = arr[0];
			String bloodGroup = (arr[1]);
			int height=Integer.parseInt(arr[2]);
			int weight=Integer.parseInt(arr[3]);
			String phoneNumber=arr[4];
			
	
			details += "\nGender: " + gender + "\nBlood Group : " + bloodGroup + "\nHeight: " + height + "\nWeight: "+weight+"\nPhone Number: "+phoneNumber;
		}}
		scanner.close();


		
         int size=0;

        String filename = "AppointmentDetails.txt";
        File AppointmentsFile = new File(filename);
	Scanner scanner1=null;
	try {
		scanner1 = new Scanner(AppointmentsFile);
	} catch (Exception e) {
	}
       
        scanner1.nextLine();
     details=details+"\n\n Consultation History";
        while(scanner1.hasNextLine()) {
            String[] appointments = scanner1.nextLine().split("[|]");    
            if(Integer.parseInt(appointments[0])==ID &&Boolean.parseBoolean(appointments[5])==true ){
				String doctor=appointments[1];
				String dept=appointments[2];
				String feedback=appointments[6];
           
			details=details+"\nDepartment: " +dept+"\nDoctor: "+doctor+"\nFeedback: "+feedback;
		
            size++;}
			if(size==0)
			details+= "\nNo previous consultations";
        }
        scanner1.close();
		

		return details;

		
	
	
	}
	
}