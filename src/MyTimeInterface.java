// Scott G. Edwards, 10/2/2017
// Assignment 4c
// CPT 236 Fall 2017

// Note - this interface is based on Assignment #3a


/**
 * Created by sedward3 on 10/2/2017.
 */
public interface MyTimeInterface extends Comparable<MyTime>
{

    // Define the ranges for the variables (ranges shown on above variable declaration)
    public static final int  HOURS_MIN    =   0;
    public static final int  HOURS_MAX    =   23;
    public static final int  MINUTES_MIN  =   0;
    public static final int  MINUTES_MAX  =   59;
    public static final int  SECONDS_MIN  =   0;
    public static final int  SECONDS_MAX  =   59;

    public static final int   HOURS_NOON  =   12;

    // AM or PM?    -   future implementation

    // Constructors
    //public MyTime();
    //public MyTime(int hr, int min, int sec);
    // public MyTime(int hr, int min, int sec, boolean trueForPM);
    //public MyTime(MyTime copyTime);


    // Routine:  "setter" for "hours"
    public boolean setHours(int newHours);

    // Routine:  "getter" for "hours"
    public int getHours();

    // Routine:  "setter" for "minutes"
    public boolean setMinutes(int newMins);

    // Routine:  "getter" for "minutes"
    public int getMinutes();

    // Routine:  "setter" for "seconds"
    public boolean setSeconds(int newSecs);

    // Routine:  "setter" for "seconds"
    public int getSeconds();

    // Routine:  "setter" for "hours" and "minutes" and "seconds"
    public boolean setTime(int newHours, int newMins, int newSecs);

    // This functions returns a string indicating "Universal Time" (24 hour) format:  HH:MM:SS (zero fill integers)
    public String printUniversal();

    // This functions returns a string indicating "Standard Time" (12 hour) format:  HH:MM:SS xM (zero fill integers)
    public String printStandard();


    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // 4c New prototypes
    ///////////////////////////////////////////////////////////////////////////////////////////////////


    // Add new constructors
    // public MyTime(int hr, int min, int sec);
    // public MyTime(MyTime copyFromMyTime);

    // Routine to validate that the current time is valid
    public boolean isValid();
                                                            // Include "@Override" when populate in MyDate

    // Routine to compare current time to otherMyTime.
    @Override public int compareTo(MyTime otherMyTime);     //  (this - otherMyTime) : Neg:LessThan, 0:Equal, Pos:GreaterThan
                                                            // Do not include "@Override" when populate in MyTime

    // Routine to print information
    @Override public String toString();

    // Routine to determine if range of time ckTime..ckTime+durationMIns overlaps current time
    public boolean doesTimeSpanOverlap(MyTime ckTime, int durationMins);

    // routine to update current time
    public boolean updateTime( int deltaHours, int deltaMinutes, int deltaSeconds);


}   //  end interface MyTimeInterface
