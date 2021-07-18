package com.company;

public class Time {
    private String daySlot;
    public int[] timeSlots;

    public Time(String daySlot){
        this.daySlot = daySlot;
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


}
