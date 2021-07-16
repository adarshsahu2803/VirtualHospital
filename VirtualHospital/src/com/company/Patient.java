
public class Patient {
	private String name,phone,aadhar;
	private int age,ID,currentAppointments;
	float height,weight;
	boolean covid;
	String password;
public Patient(String name,int age,String aadhar,String phone,String password) {
	this.name=name;
	this.age=age;
	this.aadhar=aadhar;
	this.phone=phone;
	currentAppointments=0;
	this.password=password;
	
	
}
public void setHeight(float height) {
	this.height=height;
}
public void setWeight(float weight) {
	this.weight=weight;
}

public void setCovid(boolean covid) {
	this.covid= covid;
}

public String getName() {
	return this.name;
}
public int getAge() {
	return age;
}
public String getAadhar() {
	return this.aadhar;
}
public String getPhone() {
	return this.phone;
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
public void setId(int ID) {
	this.ID= ID;
}
public int getID() {
	return ID;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
