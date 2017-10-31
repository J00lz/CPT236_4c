// Shawn Ramsey
// Assignment 04d
// All functions working properly

//Usage:
// You MUST set year prior to attempting to set number of days, otherwise it will possibly set the wrong day
// Example: setDate(2, 29, 2016); will return true (due to all dates being valid since the month is february, the day is 29, and the year is 2016(a leap year)
// Example2: setDate(2, 29, 2017); will return false (due to 2017 not being a leap year and attempting to place 29 days in the month of february (out of bounds))

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.Locale;

public class MyDate implements MyDateInterface{

    public  static final    int MONTH_MIN   =   1;
    public  static final    int MONTH_MAX   =   12;
    public  static final    int DAY_MIN     =   1;
    //public  static final    int DAY_MAX     =   31;
    public  static final    int YEAR_MIN    =   2000;
    public  static final    int YEAR_MAX    =   2099;

    public                  int day_max;
    private                 int day;    // 1...31
    private                 int month;  // 1...12
    private                 int year;   // 2000... 2099
    private                 DOW dayOfWeek = new DOW();
    //private const int MAX_YEAR = 2099;
    public MyDate() {
        day = DAY_MIN;
        month = MONTH_MIN;
        year = YEAR_MIN;
    }

    public boolean isLeapYear()
    {
        // better method? (I had a dream about this for some reason)
        return isLeapYear(this.year);
//        if ((this.year % 4 == 0) && (this.year % 100 == 00) && (this.year % 400 == 0) )
//            return true;
//        else
//            return false;
    }

    public boolean isLeapYear(int yr)
    {
        if (( (yr % 4 == 0) && (yr % 100 != 0) ) || (yr % 400 == 0) )
            return true;
        else
            return false;
    }
    public int getNumOfDaysInMonth()
    {
        return checkMonthDays(this.month);
    }
    public int getNumOfDaysInMonth(int mn)
    {
        return checkMonthDays(mn);
    }



    private int checkMonthDays(int month)
    {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            return 31;
        else if (month == 2)
            if (isLeapYear() == true)
                return 29;
            else
                return 28;
        else
            return 30;
    }
    private boolean validateRange(int value, int min, int max)
    {
        // is it above or equal to the min? and below or equal to the max?
        if ( (value >= min) && (value <= max) )
            return true;
        else
            return false;
    }

    //Sets the date
    public boolean setDate(int newMonth, int newDay, int newYear)
    {
        if (setMonth(newMonth) && setYear(newYear) && setDay(newDay))
            return true;
        else
            return false;
    }

    // Sets the Months
    public boolean setMonth(int newMonth)
    {
        // is the range valid?
        if(validateRange(newMonth, MONTH_MIN, MONTH_MAX))
        {
            month = newMonth;
            return true;
        }
        else
        {
            return false;            //we finally do something!
        }
    }

    // Sets the Days
    public boolean setDay(int newDay)
    {
        day_max = getNumOfDaysInMonth();
        // is the range valid?
        if(validateRange(newDay, DAY_MIN, day_max))
        {
            day = newDay;
            return true;
        }
        else
        {
            return false;            //we finally do something!
        }
    }

    // Sets the Years
    public boolean setYear(int newYear)
    {
        if(validateRange(newYear, YEAR_MIN, YEAR_MAX))
        {
            year = newYear;
            return true;
        }
        else
        {
            return false;            //we finally do something!
        }
    }

    // Gets the Months
    public int getMonth() { return (month); }
    // Gets the Days
    public int getDay() { return (day); }
    // Gets the Year
    public int getYear() { return (year); }

    // Prints the date in format: MM/DD/YY
    // Still not properly working for some reason
    public String printShort() {
        int yr = year % 100;
        String str = String.format("%02d/%02d/%02d", month, day, year % 100);
        return str;
    }
    // Prints the date in format: MM/DD/YYYY
    public String printLong() {
        String str = String.format("%02d/%02d/%02d", month, day, year);
        return str;
    }

   //*********************************************************
   // Added methods
   //*********************************************************
    @Override
    public String toString()
    {
        return printShort();
    }
   // Working
   public boolean isValid() {
       return isValid(this.month, this.day, this.year);
   }
    // Working
    public boolean isValid(int newMonth, int newDay, int newYear) {
        if (validateRange(newMonth, MONTH_MIN, MONTH_MAX) && validateRange(newDay, DAY_MIN, checkMonthDays(newMonth)) && validateRange(newYear, YEAR_MIN, YEAR_MAX))
            return true;
        else
            return false;
    }

    @Override
    public int compareTo(MyDate otherMyDate) {
        if (this.year > otherMyDate.year)
            // greater than
            return 1;
        else if (this.year == otherMyDate.year)
            if(this.month > otherMyDate.year)
                // greater than
                return 1;
            else if (this.month == otherMyDate.month)
                if(this.day > otherMyDate.day)
                    // greater than
                    return 1;
                else if (this.day == otherMyDate.day)
                    // equal to
                    return 0;
                else
                    // less than
                    return -1;
            else
                // less than
                return -1;
        else
            // less than
            return -1;
    }

    // Working!
    public DOW getDOW()
    {
        //DOW.
        return getDOW(this.day, this.month, this.year);
        //this.DOW.getValue();
    }
    // Working!
    public DOW getDOW(int dy, int mon, int yr)
    {
        LocalDate date = LocalDate.of(yr, mon, dy);
        DayOfWeek theDayOfWeek = DayOfWeek.from(date);
        dayOfWeek.setValue(theDayOfWeek.getValue());
        return dayOfWeek;

    }
    // Working!
    public DOW getMonth1stDOW() {
        //StringBuilder sb = new StringBuilder();
        //Formatter formatter = new Formatter(sb, Locale.US);

        //formatter.format("%d-%d-%d", 01, this.month, this.year);
        //LocalDate date = LocalDate.of(1, this.month, this.year);
        //getDOW(this.)
        return getDOW(1, this.month, this.year);
        //return null;
    }
    // Working
    public int getNumOfDaysInYear() {
        return getNumOfDaysInYear(this.year);
    }
    // Working
    public int getNumOfDaysInYear(int yr) {
        if (isLeapYear(yr))
            return 366;
        else
            return 365;
    }
}   // end class MyDate
