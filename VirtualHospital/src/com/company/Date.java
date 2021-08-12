package com.company;

public class Date {
    private static final int[] DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    private final int month;   // month (between 1 and 12)
    private final int day;     // day   (between 1 and DAYS[month]
    private final int year;    // year

    // do bounds-checking to ensure object represents a valid date
    public Date(int d, int m, int y) {
        if (!isValid(d, m, y)) throw new RuntimeException("Invalid date");
        day   = d;
        month = m;
        year  = y;
    }
    public static Date toDate(String date){
        return new Date(Integer.parseInt(date.split("/")[0]),Integer.parseInt(date.split("/")[1]),Integer.parseInt(date.split("/")[2]));
    }

    // is the given date valid?
    public static boolean isValid(int d, int m, int y) {
        if (m < 1 || m > 12)      return false;
        if (d < 1 || d > DAYS[m]) return false;
        if (m == 2 && d == 29 && !isLeapYear(y)) return false;
        return true;
    }

    // is y a leap year?
    private static boolean isLeapYear(int y) {
        if (y % 400 == 0) return true;
        if (y % 100 == 0) return false;
        return (y % 4 == 0);
    }

    // return the next Date
    public Date next() {
        if (isValid(day + 1, month , year))    return new Date(day + 1, month, year);
        else if (isValid(1, month + 1, year)) return new Date(1, month + 1, year);
        else                                  return new Date(1, 1, year + 1);
    }


    // is this Date after b?
    public boolean isAfter(Date b) {
        return compareTo(b) > 0;
    }

    // is this Date a before b?
    public boolean isBefore(Date b) {
        return compareTo(b) < 0;
    }

    //returns day of week (1-7) for (Mon-Sun)
    public int getDay(){
        return Time.Day_of_week(this.toString());
    }

    // comparison function between two dates
    public int compareTo(Date b) {
        if  (year  != b.year)  return year  - b.year;
        if  (month != b.month) return month - b.month;
        return day - b.day;
    }

    // return a string representation of this date
    public String toString() {
        return day + "/" + month + "/" + year;
    }

}

