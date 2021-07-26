package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {
    private String daySlot;
    public int[] timeSlots;

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
    public static int getDate(String date){
        String[] components = date.split("/");
        return Integer.parseInt(components[0]);
    }
    public static int getMonth(String date){
        String[] components = date.split("/");
        return Integer.parseInt(components[1]);
    }
    public static int getYear(String date){
        String[] components = date.split("/");
        return Integer.parseInt(components[2]);
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




}
