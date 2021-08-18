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

	public static void updateFeedbackArray(String date,int slot,String feedback,AppointmentObject[] doctorAppointmentsList){
		for(int i=0;i<100;i++){
			if(doctorAppointmentsList[i].getDate().equals(date)&&doctorAppointmentsList[i].getTimeslot()==slot)
				doctorAppointmentsList[i].saveFeedback(feedback);
			break;
		}
	}

	public static void updateFeedbacktxt(int time,String date,String feedback){

		ArrayList<String> tempArray = new ArrayList<>();

		try {
			try (FileReader fr = new FileReader("AppointmentDetails.txt")) {
				Scanner reader = new Scanner(fr);
				String line;
				String[] lineArr;

				while ((line = reader.nextLine()) != null) {
					lineArr = line.split("[|]");
					if (lineArr[3].equals(date) && lineArr[4].equals(String.valueOf(time))) {
						tempArray.add(lineArr[0] + "|" + lineArr[1] + "|" + lineArr[2] + "|" + lineArr[3] + "|" + lineArr[4] + "|" + lineArr[5] + "|" + feedback);
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

	public static String displayAdditionalDetails(AppointmentObject[] doctorAppointmentsList,int time,String date, boolean status){
		String details = "\n\t\t\t\tAppointment Details";
		String timeF = time-1 + ":00 - " + time + ":00";
		details += "\nDate\t                  : " +date+ "\nTime\t                  : " + timeF;


		int ID=0;
		for(int i=0;i<100;i++)
			if(doctorAppointmentsList[i].getDate().equals(date) && doctorAppointmentsList[i].getTimeslot()==time){
				ID=doctorAppointmentsList[i].getID();
				break;}

		File file1 = new File("PatientDetails.txt");
		Scanner scanner0 = null;
		try {
			scanner0 = new Scanner(file1);
		} catch (Exception e) {
		}

		while (scanner0.hasNextLine()) {
			String[] arr = scanner0.nextLine().split("\\|");
			if(arr[0].equals("ID")) continue;
			if (ID==Integer.parseInt(arr[0])){
				String name = arr[1];
				String age = arr[2];
				String aadhar = arr[3];

				details += "\nName\t                  : " + name + "\nAge\t                  : " + age + "\nAadhar Number               : " + aadhar;
				break;
			}}
		scanner0.close();


		File file = new File("AdditionalDetails.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (Exception e) {
		}

		while (scanner.hasNextLine()) {
			String[] arr = scanner.nextLine().split("\\|");
			if(arr[0].equals("Patient ID")) continue;
			if (ID==Integer.parseInt(arr[0])){
				String gender = arr[1];
				String bloodGroup = (arr[2]);
				int height=Integer.parseInt(arr[3]);
				int weight=Integer.parseInt(arr[4]);
				String phoneNumber=arr[5];

				details += "\nGender\t                  : " + gender + "\nBlood Group\t                  : " + bloodGroup + "\nHeight\t                  : " + height + "\nWeight\t                  : "+weight+"\nPhone Number                : "+phoneNumber;
				break;
			}}
		scanner.close();

		if(status == false) {
			int size=0;
			String filename = "AppointmentDetails.txt";
			File AppointmentsFile = new File(filename);
			Scanner scanner1=null;
			try {
				scanner1 = new Scanner(AppointmentsFile);
			} catch (Exception e) {}

			scanner1.nextLine();

			while(scanner1.hasNextLine()) {
				String[] appointments = scanner1.nextLine().split("[|]");
				if(Integer.parseInt(appointments[0])==ID && Boolean.parseBoolean(appointments[5])){
					if(size==0) details=details+"\n\n\t\t\t\tConsultation History";

					String doctor=appointments[2];
					String dept=appointments[1];
					String feedback=appointments[6];

					details=details+"\nDate\t                  : " +appointments[3]+"\nDepartment\t                  : " +dept+"\nDoctor\t                  : "+doctor+"\nFeedback\t                  : "+feedback;
					size++;
				}
			}
			scanner1.close();
			if(size==0) details+= "\n\n\t\t\t\tNo previous consultations";
		}
		else {
			String filename = "AppointmentDetails.txt";
			File AppointmentsFile = new File(filename);
			Scanner scanner1=null;
			try {
				scanner1 = new Scanner(AppointmentsFile);
			} catch (Exception e) {}

			scanner1.nextLine();

			while(scanner1.hasNextLine()) {
				String[] appointments = scanner1.nextLine().split("[|]");
				if(Integer.parseInt(appointments[0])==ID && Boolean.parseBoolean(appointments[5])){
					details=details+"\n\nFeedback\t                  : "+appointments[6];
				}
			}
			scanner1.close();
		}
		return details;
	}
}