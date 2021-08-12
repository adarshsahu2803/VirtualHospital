package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

import static com.company.Signup.getLinesCount;

public class Appointment implements ActionListener{
    private String department;
    public static String doctorName;
    private int patientID = Login.getID();
    public static String selectedDateSlot;
    //public static String availableDateSlot;
    public static String weekTime;
    private String feedback = "null";
    private boolean completed = false;

    JFrame frame5 = new JFrame();
    JLabel background;
    JComboBox selectDepartment, selectDoctor;
    JTextField dateSlot, meetLink;
    JButton submit, home,Confirm;
    JTextArea textArea, textArea1;
    Appointment appointment;

    Appointment() {
        ImageIcon image = new ImageIcon("vh.jpg");
        ImageIcon bg = new ImageIcon("bg3.jpg");
        ImageIcon hp = new ImageIcon("bg4.jpg");

        background = new JLabel(bg);
        background.setSize(1000,600);
        background.setHorizontalAlignment(JLabel.LEFT);
        background.setVerticalAlignment(JLabel.BOTTOM);

        frame5.add(background);
        frame5.setTitle("Connect&Care");
        frame5.setResizable(false);
        frame5.setSize(1000,600);
        frame5.setLayout(null);
        frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame5.setIconImage(image.getImage());
        frame5.setLocationRelativeTo(null);

        home = new JButton();
        home.setBounds(10, 10, 35,35);
        home.addActionListener(this);
        home.setIcon(hp);
        home.setFocusable(false);
        home.setBorder(BorderFactory.createBevelBorder(1));

        String[] department = {"Select Department","Dermatologists","Immunologists","Anesthesiologists","Cardiologists","Endocrinologists","Gastroenterologists","Hematologists","Neurologists","Gynecologists","Internists"};

        selectDepartment = new JComboBox(department);
        selectDepartment.addActionListener(this);
        selectDepartment.setBounds(390, 60, 200, 50);
        selectDepartment.setBorder(BorderFactory.createBevelBorder(1));
        selectDepartment.setVisible(true);

        textArea = new JTextArea();
        textArea.setBounds(650, 0, 250,325);
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);

        selectDoctor = new JComboBox();
        selectDoctor.addItem("Select Doctor");
        selectDoctor.addActionListener(this);
        selectDoctor.setBounds(390, 155, 200, 50);
        selectDoctor.setBorder(BorderFactory.createBevelBorder(1));

        textArea1 = new JTextArea();
        textArea1.setBounds(75, 80, 250,245);
        textArea1.setBorder(BorderFactory.createBevelBorder(1));
        textArea1.setEditable(false);

        dateSlot = new JTextField();
        dateSlot.setBounds(390, 250, 200,50);
        dateSlot.setText("Date-Slot (e.g.28/08/2021-3)");
        dateSlot.setBorder(BorderFactory.createBevelBorder(1));

        Confirm = new JButton();
        Confirm.setBounds(440, 310, 100,40);
        Confirm.addActionListener(this);
        Confirm.setText("save");
        Confirm.setFocusable(false);
        Confirm.setBorder(BorderFactory.createBevelBorder(1));

        meetLink = new JTextField();
        meetLink.setBounds(300, 395, 400,50);
        meetLink.setHorizontalAlignment(0);
        meetLink.setEditable(false);
        meetLink.setBorder(BorderFactory.createBevelBorder(1));

        submit = new JButton();
        submit.setBounds(390, 490, 200,50);
        submit.addActionListener(this);
        submit.setText("submit");
        submit.setFocusable(false);
        submit.setBorder(BorderFactory.createBevelBorder(1));

        background.add(home);
        background.add(selectDepartment);
        background.add(textArea);
        background.add(selectDoctor);
        background.add(textArea1);
        background.add(dateSlot);
        background.add(Confirm);
        background.add(meetLink);
        background.add(submit);

        frame5.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == home) {
            frame5.dispose();
            new HomePage();
        }

        if (e.getSource() == selectDepartment) {
            department = (String) selectDepartment.getSelectedItem();

            if (selectDepartment.getSelectedItem().equals("Select Department")) {
            } else {
                appointment = new Appointment((String) selectDepartment.getSelectedItem());
                String txt = "                      Available Doctors";
                txt = txt + appointment.displayDoctors();
                textArea.setText(txt);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);

                background.add(textArea);

                selectDoctor.removeAllItems();
                textArea1.setText("");
            }
        }

        if (e.getSource() == selectDoctor) {
            doctorName = (String) selectDoctor.getSelectedItem();

            if (selectDoctor.getSelectedItem() == null) {
                addComboItems((String) selectDepartment.getSelectedItem());
            }


            if (selectDoctor.getSelectedItem().equals("Select Doctor")) {}
            else {
                String txt = "                   Available Dates/Slots\n";
                txt = txt + appointment.displayDatesSlots((String) selectDoctor.getSelectedItem());
                //availableDateSlot = appointment.displayDatesSlots((String) selectDoctor.getSelectedItem());
                textArea1.setText(txt);
                textArea1.setLineWrap(true);
                textArea1.setWrapStyleWord(true);

                background.add(textArea1);

                meetLink.setText(generateMeetLink());
            }
        }

        if(e.getSource()==Confirm){
            selectedDateSlot = dateSlot.getText().trim();
        }

        if(e.getSource() == submit) {
            int status;
            if(department.equals("Select Department") || doctorName.equals("Select Doctor"))
                status = -4;
            else {
                try {
                    status = Time.validTimeslot();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                    status = 7;
                }
            }
            if(status<1) {
                if (status==0)
                    JOptionPane.showMessageDialog(null, "Invalid Date-Slot format Eg:28/8/2021-3", "ERROR", JOptionPane.ERROR_MESSAGE);
                if(status==-1)
                    JOptionPane.showMessageDialog(null, "Invalid Date or slot number entered", "ERROR", JOptionPane.ERROR_MESSAGE);
                if(status==-2)
                    JOptionPane.showMessageDialog(null, "This slot isn't available.Please book another slot", "ERROR", JOptionPane.ERROR_MESSAGE);
                if(status==-3)
                    JOptionPane.showMessageDialog(null, "Save the Dateslot before submitting", "ERROR", JOptionPane.ERROR_MESSAGE);
                if(status==-4)
                    JOptionPane.showMessageDialog(null, "Invalid Department/Doctor", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

            else {
                frame5.dispose();
                saveAppointmentDetails();
//                Main.patientsList[patientID-1001].setCurrentAppointments(Main.patientsList[patientID-1001].getCurrentAppointments()+1);
//                saveAppointmentInArray();
                Main.patientsList[patientID-1001].setAppointment(patientID,doctorName,department,dateSlot.getText().split("[-]")[0],Integer.parseInt(dateSlot.getText().split("[-]")[1]),false);
                new HomePage();
            }
        }
    }

    void saveAppointmentDetails() {
        AppointmentObject ao = new AppointmentObject();

        ao.setID(patientID);
        ao.setDepartment(department);
        ao.setDoctor(doctorName);
        String[] str = dateSlot.getText().trim().split("[-]");
        ao.setTimeSlot(str[0], Integer.parseInt(str[1]));
        ao.setStatus(completed);
        ao.setFeedback(feedback);
        ao.incrementAppointmentNum(patientID);

    }

//    void saveAppointmentInArray(){
//        AppointmentObject a1 = new AppointmentObject(patientID,doctorName,department,Integer.parseInt(dateSlot.getText().split("[-]")[0]),Integer.parseInt(dateSlot.getText().split("[-]")[1]),false,null);
//        Main.patientsList[patientID-1001].appointmentsList[Main.patientsList[patientID-1001].getCurrentAppointments()-1] = a1;
//    }

//    public int NumberOfAppointments(int userID) {
//        File file = new File("AppointmentDetails.txt");
//        Scanner scanner = null;
//        try {
//            scanner = new Scanner(file);
//        } catch (Exception e) {
//        }
//
//        while (scanner.hasNextLine()) {
//            String[] arr = scanner.nextLine().split("\\|");
//            if (!arr[0].equals(doctorName))
//                continue;
//            else {
//                str = str.concat(arr[2]);
//                break;
//            }
//        }
//        return str;
//    }

    public Appointment(String Department) {
        department = Department;
    }

//        public Appointment(int ID, String doctor, String department, String timeslot){
//            patientID = ID;
//            doctorName = doctor;
//            department = department;
//            timeslot = timeslot;
//        }

    public String displayDoctors () {
        String finalStr = "";
        File file = new File("DoctorDetails.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (Exception e) {
        }

        while (scanner.hasNextLine()) {
            String[] arr = scanner.nextLine().split("\\|");
            if (!arr[1].equals(department))
                continue;

            String name = arr[0];
            String experience = String.valueOf(arr[2]);
            String ratings = String.valueOf(arr[3]);

            finalStr += "\nName         : " + name + "\nExperience : " + experience + "\nRatings      : " + ratings + "\n";
        }
        return finalStr;
    }

    public void setDoctor (String doctorName)
    {

        this.doctorName = doctorName;

        try (FileWriter f = new FileWriter("PatientDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b)) {

            p.print(doctorName);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String displayDatesSlots (String doctorName){

        try {
            Scanner scanner = new Scanner(new File("DoctorDetails.txt"));
            while (scanner.hasNextLine()) {
                String[] arr = scanner.nextLine().split("\\|");
                if (arr[0].equals(doctorName)) {
                    Time time = new Time(arr[5]);
                    weekTime = arr[5];
                    return time.toString();
                }
            }

        } catch (Exception e) {}
        return "";
    }



    public void setDateSlot (String Date,int SlotNumber){

        try (FileWriter f = new FileWriter("PatientDetails.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b)) {

            p.print(Date + "|" + SlotNumber);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addComboItems(String str) {
        selectDoctor.addItem("Select Doctor");

        File file = new File("DoctorDetails.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (Exception e) {
        }

        while (scanner.hasNextLine()) {
            String[] arr = scanner.nextLine().split("\\|");
            if (!arr[1].equals(str))
                continue;
            selectDoctor.addItem(arr[0]);
        }
    }

    public String generateMeetLink() {
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
            if (!arr[0].equals(doctorName))
                continue;
            else {
                str = str.concat(arr[2]);
                break;
            }
        }
        return str;
    }
}

