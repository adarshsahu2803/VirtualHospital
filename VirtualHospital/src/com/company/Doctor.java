package com.company;

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

}