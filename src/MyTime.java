// Shawn Ramsey
// CPT 236
// Assignment 04b
// Currently Working
public class MyTime implements MyTimeInterface{

    private int hours;      // 0 - 23
    private int minutes;    // 0 - 59
    private int seconds;    // 0 - 59

    public MyTime() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }

    // Lets check the range of time and make sure its valid
    private boolean validateRange(int value, int min, int max)
    {
        if ( (value >= min) && (value <= max) )
            return true;
        else
            return false;
    }

    //Sets the time
    public boolean setTime(int newHr, int newMin, int newSec) {
        setHours(newHr);
        setMinutes(newMin);
        setSeconds(newSec);

        return true;
    }

    // Prints the time in 24 hour format
    public String printUniversal() {
        String universalOutput = String.format("%02d:%02d:%02d", getHours(), getMinutes(), getSeconds());

        return universalOutput;
    }

    // Prints the time with AM or PM afterwards (on a 12 hour scale)
    public String printStandard() {
        String standardOutput = "";
        int standardHours = 0;

        if (getHours() > 12)
        {
            standardHours = getHours() % 12;
            standardOutput = String.format("%02d:%02d:%02d PM", standardHours, getMinutes(), getSeconds());
        }
        else
        {
            standardOutput = String.format("%02d:%02d:%02d AM", getHours(), getMinutes(), getSeconds());
        }
        return standardOutput;
    }

    // Sets the hours
    public boolean setHours(int newHours) {
        if (validateRange(newHours, 0, 23))
        {
            hours = newHours;
            return true;
        }
            else
        {
            // Not Valid
            return false;
        }
    }

    // Sets the minutes
    public boolean setMinutes(int newMinutes) {
        if (validateRange(newMinutes, 0, 59))
        {
            minutes = newMinutes;
            return true;
        }
        else
        {
            // Not Valid
            return false;
        }
    }

    // Sets the seconds
    public boolean setSeconds(int newSeconds) {
        if (validateRange(newSeconds, 0, 59))
        {
            seconds = newSeconds;
            return true;
        }
                else
        {
            // Not Valid
            return false;
        }
    }

    // Gets the hours
    public int getHours()
    {
        return (hours);
    }
    // Gets the minutes
    public int getMinutes()
    {
        return (minutes);
    }
    // Gets the seconds
    public int getSeconds()
    {
        return (seconds);
    }


    //*************************************************************
    // Added stuff for 4c
    //*************************************************************

    public MyTime(int hr, int min, int sec)
    {
        setHours(hr);
        setMinutes(min);
        setSeconds(sec);
    }

    public MyTime(MyTime copyFromMyTime)
    {
        setHours(copyFromMyTime.getHours());
        setMinutes(copyFromMyTime.getMinutes());
        setSeconds(copyFromMyTime.getSeconds());
    }
    // Convert time all into seconds then compare
    @Override
    public int compareTo(MyTime otherMyTime)
    {
        int currentTime = 0;
        int checkTime = 0;

        currentTime += (getHours() * 60) * 60;
        currentTime += getMinutes() * 60;
        currentTime += getSeconds();

        checkTime += (otherMyTime.getHours() * 60) * 60;
        checkTime += otherMyTime.getMinutes() * 60;
        checkTime += otherMyTime.getSeconds();

        if ( currentTime == checkTime )
            return  (0);        // Equals

        if ( currentTime > checkTime )
            return  (1);       // Greater Than

        //if ( dayOfWeek < otherDOW.getValue() )
        return  (-1);       // Less Than

    }

    public boolean doesTimeSpanOverlap(MyTime ckTime, int durationMins)
    {
        int checkTimeMin = 0;
        int checkTimeMax = 0;
        int compareTime = 0;

        compareTime += (getHours() * 60) * 60;
        compareTime += getMinutes() * 60;
        compareTime += getSeconds();

        checkTimeMin+= (ckTime.getHours() * 60) * 60;
        checkTimeMin += ckTime.getMinutes() * 60;
        checkTimeMin += ckTime.getSeconds();

        checkTimeMax = checkTimeMin + (durationMins * 60);

        if ((compareTime > checkTimeMin) && (compareTime < checkTimeMax))
            return true;
        else
            return false;
    }

    public boolean updateTime(int deltaHours, int deltaMinutes, int deltaSeconds)
    {
        return (setTime(deltaHours, deltaMinutes, deltaSeconds));
    }

    public boolean isValid()
    {
        if (validateRange(getHours(), 0, 23) && validateRange(getMinutes(), 0, 59) && validateRange(getSeconds(), 0, 59))
            return true;
        else
            return false;
    }
}   // end class MyTime
