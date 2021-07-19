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

        return "";
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
        return d0+1;
    }




}
