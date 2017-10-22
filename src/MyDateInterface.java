// Scott G. Edwards, 10/2/2017
// Assignment 4c
// CPT 236 Fall 2017

// Note - this interface is based on Assignment #3d



/**
 * Created by sedward3 on 10/2/2017.
 */


public interface MyDateInterface  extends Comparable<MyDate>
{

    public  static final    int MONTH_MIN   =   1;
    public  static final    int MONTH_MAX   =   12;
    public  static final    int DAY_MIN     =   1;
    public  static final    int DAY_MAX     =   31;     // Simplification - to be fixed later
    public  static final    int YEAR_MIN    =   2000;
    public  static final    int YEAR_MAX    =   2099;

    public  static final    int NUM_DAYS_IN_NORMAL_YEAR =   365;
    public  static final    int NUM_DAYS_IN_LEAP_YEAR   =   NUM_DAYS_IN_NORMAL_YEAR + 1;

    public  static final    int MONTH_FEB   =   2;

    public  static final    boolean PRINT_LONG  =   true;
    public  static final    boolean PRINT_SHORT =   false;

//  Removed - "interface" does not like private variables nor constructors
//        private                 int month;
//        private                 int day;
//        private                 int year;
//
//        Constructor
//        public MyDate();



    // Routine:     setMonth()
    // Purpose:     "Setter" for Month
    // Input:       newMonth    [MONTH_MIN..MONTH_MAX]
    // Output:      true --> valid "newMonth" parameter
    // Description: This function sets the value of the "month" variable.
    //              The input value is ranged checked for valid values, and
    //              if invalid, then the current/previous internal value
    //              is not updated.
    public boolean setMonth(int newMonth);

    // Routine: "Getter" for Month
    public int getMonth();

    // Routine:  "Setter" for Day
    public boolean setDay(int newDay);

    // Routine: "Getter" for Day
    public int getDay();

    // Routine:  "Setter" for Year
    public boolean setYear(int newYear);

    // Routine: "Getter" for Year
    public int getYear();

    // Routine: "Setter" for date - setDate()
    public boolean setDate(int newMonth, int newDay, int newYear);

    // Routine:  printShort() - get date in short format "MM/DD/YY"
    public String printShort();

    // Routine:  printLong() - get date in short format "MM/DD/YYYY"
    public String printLong();

    // Routine to check internal year to see if it is a leap year
    public boolean isLeapYear();

    // Routine to check specified year (parm "yr") to see if it is a leap year
    public boolean isLeapYear(int yr);

    // Routine to get the number of days in the month for the current month & year
    public int getNumOfDaysInMonth();

    // Routine to get the number of days in the month for the specified month & year
    public int getNumOfDaysInMonth(int mn);


    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // 4c New prototypes
    ///////////////////////////////////////////////////////////////////////////////////////////////////


    // Add new Constructors
    //public MyDate(int mon, int dy, int yr);
    //public MyDate(MyDate copyDate);

    // Routine to validate that the current time is valid
    public boolean isValid();
    public boolean isVaid(int newMonth, int newDay, int newYear);



    // Include "@Override" when populate in MyDate

    // Routine to compare current time to otherMyDate.
    @Override public int compareTo(MyDate otherMyDate);     //  (this - otherMyDate) : Neg:LessThan, 0:Equal, Pos:GreaterThan
                                                            // Do not include "@Override" when populate in MyDate

    // Routine to print information
    @Override public String toString();

    // Return the day of the week for the current Date
    public DOW getDOW();

    // Return the day of the week for the indicated Date
    public DOW getDOW(int dy, int min, int yr);

    // Return the day of the week for the current date's first day of the month
    public DOW getMonth1stDOW();


    // get # days in year so that Calendar can display properly

    // Return the number of days in the current year
    public int getNumOfDaysInYear();

    // Return the number of days in the s[ecofoed year
    public int getNumOfDaysInYear(int yr);



}   //  end interface MyDateInterface
