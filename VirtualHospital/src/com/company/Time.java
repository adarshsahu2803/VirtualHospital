package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import static com.company.Patient.appointmentsList;

public class Time {
    private String daySlot;

    public Time(String daySlot){
        this.daySlot = daySlot;
    }

    public String toString(){
        String time;
        String toDay = Time.today();
        Date today = new Date(Time.getDate(toDay),Time.getMonth(toDay),Time.getYear(toDay));
        int day = Time.Day_of_week(toDay);
        Date d1=today,d2=today,d3=today;
        int[] slots = setSlots();
        int day1,day2,day3;
        day1 = slots[0]/100;
        day2 = slots[3]/100;
        day3 = slots[6]/100;
        for(int i =0;i<9;i++){
            slots[i] %= 100;
        }
        while (true){
            Date t1 = d1;
            d1 = t1.next();
            if(d1.getDay()==day1)
                break;
        }
        while (true){
            Date t2 = d2;
            d2 = t2.next();
            if(d2.getDay()==day2)
                break;
        }
        while (true){
            Date t3 = d3;
            d3 = t3.next();
            if(d3.getDay()==day3)
                break;
        }
        Date D1,D2,D3;
        if(d1.isAfter(d2)){
            if(d1.isAfter(d3)){
                D1=d1;
                if(d2.isAfter(d3)) {
                    D2 = d2;D3 = d3;
                }
                else {
                    D2 = d3;D3 = d2;
                }
            }
            else {
                D1 = d3;D2 = d1;D3 = d2;
            }
        }
        else {
            if(d2.isAfter(d3)){
                D1 = d2;
                if(d1.isAfter(d3)){
                    D2 = d1;D3 = d3;
                }
                else{
                    D2 = d3;D3 = d1;
                }
            }
            else {
                D1 = d3;D2 = d2;D3 = d1;
            }
        }
        String[] weekDays = {"","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        time = D3+","+weekDays[D3.getDay()]+"\n"+"Slot "+slots[0]+":    "+(slots[0]-1)+":00 - "+slots[0]+":00\n"+"Slot "+slots[1]+":    "+(slots[1]-1)+":00 - "+slots[1]+":00\n"+"Slot "+slots[2]+":    "+(slots[2]-1)+":00 - "+slots[2]+":00\n\n"+D2+","+weekDays[D2.getDay()]+"\n"+"Slot "+slots[3]+":    "+(slots[3]-1)+":00 - "+slots[3]+":00\n"+"Slot "+slots[4]+":    "+(slots[4]-1)+":00 - "+slots[4]+":00\n"+"Slot "+slots[5]+":    "+(slots[5]-1)+":00 - "+slots[5]+":00\n\n"+D1+","+weekDays[D1.getDay()]+"\n"+"Slot "+slots[6]+":    "+(slots[6]-1)+":00 - "+slots[6]+":00\n"+"Slot "+slots[7]+":    "+(slots[7]-1)+":00 - "+slots[7]+":00\n"+"Slot "+slots[8]+":    "+(slots[8]-1)+":00 - "+slots[8]+":00\n";
        return time;
    }


    public static void updateCompleted() throws FileNotFoundException {

        ArrayList<String> tempArray = new ArrayList<>();
        boolean status;

        try {
            try (FileReader fr = new FileReader("AppointmentDetails.txt")) {
                Scanner reader = new Scanner(fr);
                String line;
                String[] lineArr;

                while ((line = reader.nextLine()) != null) {
                    lineArr = line.split("[|]");

                    if(lineArr[0].equals("ID")) {
                        tempArray.add(line);
                        continue;
                    }

                    Date d = new Date(Integer.parseInt(lineArr[3].split("/")[0]),Integer.parseInt(lineArr[3].split("/")[1]),Integer.parseInt(lineArr[3].split("/")[2]));
                    Date today = new Date(Time.getDate(Time.today()),Time.getMonth(Time.today()),Time.getYear(Time.today()));
                    if(today.isAfter(d)) status = true;
                    else if(d.getDay()==today.getDay() && (Integer.parseInt(lineArr[4]) <= getTime())) status = true;
                    else status = false;

                    tempArray.add(lineArr[0] + "|" + lineArr[1] + "|" + lineArr[2] + "|" + lineArr[3] + "|" + lineArr[4] + "|" + status + "|" + lineArr[6]);
                }
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

        //updating appointmentList.

        int size=0;
        String filename = "AppointmentDetails.txt";

        File AppointmentsFile = new File(filename);
        Scanner scanner3 = new Scanner(AppointmentsFile);
        scanner3.nextLine();

        while(scanner3.hasNextLine()) {
            String[] appointments = scanner3.nextLine().split("[|]");
            if(Integer.parseInt(appointments[0])==Login.getID()){

                appointmentsList[size] = new AppointmentObject(Integer.parseInt(appointments[0]),appointments[1],appointments[2],appointments[3],Integer.parseInt(appointments[4]),Boolean.parseBoolean(appointments[5]),appointments[6] );
                size++;
            }
        }
        scanner3.close();
    }

    public int[] setSlots(){
        int[] Slots = new int[9];
        String[] workDays = new String[3];
        workDays = daySlot.split(":");
        for(int i =0;i<3;i++){
            String[] day_time = workDays[i].split("-");
            String[] times = day_time[1].split(",");
            Slots[3*i] = Integer.parseInt(day_time[0])*100 + Integer.parseInt(times[0]);
            Slots[3*i+1] = Integer.parseInt(day_time[0])*100 + Integer.parseInt(times[1]);
            Slots[3*i+2] = Integer.parseInt(day_time[0])*100 + Integer.parseInt(times[2]);
        }
        return Slots;
    }

    public static String today(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/MM/uuuu");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    public static String now(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/MM/uuuu HH");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    public static int getTime(){
        return Integer.parseInt(now().split(" ")[1]);
    }
    public static int getDate(String date){
        return Integer.parseInt(date.split("/")[0]);
    }
    public static int getMonth(String date){
        return Integer.parseInt(date.split("/")[1]);
    }
    public static int getYear(String date){
        return Integer.parseInt(date.split("/")[2]);
    }
    public static int Day_of_week (String day){
        String[] dmy = day.split("/");
        int d = Integer.parseInt(dmy[0]);
        int m = Integer.parseInt(dmy[1]);
        int y = Integer.parseInt(dmy[2]);
        int y0,x,m0,d0;
        y0=y-(14-m)/12;
        x=y0+y0/4-y0/100+y0/400;
        m0=m+12*((14-m)/12)-2;
        d0=(d+x+31*m0/12)%7;
        if(d0==0) return 7;
        return d0;
    }
    public static int validTimeslot() throws FileNotFoundException {
        String s = Appointment.selectedDateSlot;
        if (s==null)
            return -3;
        String weekTime = Appointment.weekTime;
        Time t = new Time(weekTime);
        int[] slots = t.setSlots();
        for(int i=0;i<s.length();i++)
            if(!(s.charAt(i)==45||(s.charAt(i)>=47&&s.charAt(i)<=57))) return 0;

        String[] strings = s.split("-")[0].split("/");
        if(!(Date.isValid(Integer.parseInt(strings[0]),Integer.parseInt(strings[1]),Integer.parseInt(strings[2]))))
            return 0;
        Date selected = Date.toDate(s.split("-")[0]);

        Date today = Date.toDate(Time.today());
        Date d1=today,d2=today,d3=today;
        int day1,day2,day3;
        day1 = slots[0]/100;
        day2 = slots[3]/100;
        day3 = slots[6]/100;
        for(int i =0;i<9;i++){
            slots[i] %= 100;
        }
        while (true){
            Date t1 = d1;
            d1 = t1.next();
            if(d1.getDay()==day1)
                break;
        }
        while (true){
            Date t2 = d2;
            d2 = t2.next();
            if(d2.getDay()==day2)
                break;
        }
        while (true){
            Date t3 = d3;
            d3 = t3.next();
            if(d3.getDay()==day3)
                break;
        }
        if(!(selected.compareTo(d1)==0 || selected.compareTo(d2)==0||selected.compareTo(d3)==0)) return -1;
        int slot;
        if(selected.compareTo(d1)==0){
            slot = Integer.parseInt(s.split("-")[1]);
            if(!(slot==slots[0]||slot==slots[1]||slot==slots[2])) return -1;
        }
        if(selected.compareTo(d2)==0){
            slot = Integer.parseInt(s.split("-")[1]);
            if(!(slot==slots[3]|slot==slots[4]||slot==slots[5])) return -1;
        }
        if(selected.compareTo(d3)==0){
            slot = Integer.parseInt(s.split("-")[1]);
            if(!(slot==slots[6]||slot==slots[7]||slot==slots[8])) return -1;
        }
        if(isOccupied(Appointment.doctorName,Appointment.selectedDateSlot))
            return -2;
        return 1;
    }

    public static boolean isOccupied(String doctorName,String dateSlot) throws FileNotFoundException {
        boolean isOccupied = false;
        String str[] = dateSlot.split("[-]");
        Date date = Date.toDate(str[0]);

        String filename = "AppointmentDetails.txt";
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        while(scanner.hasNextLine()){
            String appointment[] = scanner.nextLine().split("[|]");
            Date date2 = Date.toDate(appointment[3]);
            if(appointment[2].equals(doctorName) && date.compareTo(date2)==0 && Integer.parseInt(appointment[4]) == Integer.parseInt(str[1])){
                isOccupied = true;
                break;
            }
        }

        return isOccupied;
    }




}