public class MyEvent implements MyEventInterface{

    private String   eventName = "";        // Name of the event                [ Valid:  should never be NULL AND (length > 0) ]
    private String   eventDesc = "";        // Long description of the event    [ Valid:  should never be NULL AND (length > 0) ]

    private MyDate   eventDate;             // Date of the event

    private MyTime   eventTimeStart;        // Start of the event
    private int      eventTimeDuration;     // Event durations in minutes       // *** Updated variable type ***

    // return the Event Name
    public String getEventName()
    {
        return eventName;
    }
    // validate the event name and if valid, update it
    public void setEventName(String evName)
    {
        if (isValid(evName))
            eventName = evName;
    }
    // return the Event Description
    public String getEventDesc()
    {
        return eventDesc;
    }
    // validate the Event Description and if valid, update it
    public void setEventDesc(String evDesc)
    {
        if (isValid(evDesc))
            eventDesc = evDesc;
    }
    @Override
    public int compareTo(MyEvent otherMyEvent) {
        return 0;
    }

    // use MyTime's doesTimeSpanOverlap to check if there is an overlap using an object... then return the object
    @Override
    public boolean doesTimeSpanOverlap(MyTime ckTime, int durationMins) {
        return ckTime.doesTimeSpanOverlap(ckTime, durationMins);
    }

    // check if the time span over laps or not using MyTime's doesTimeSpanOverlap using parameters
    @Override
    public boolean doesTimeSpanOverlap(int hr, int mn, int sec, int durationMins) {
        MyTime ckTime = new MyTime(hr, mn, sec);
        return ckTime.doesTimeSpanOverlap(ckTime, durationMins);
    }

    // use MyTime's update time to update the time of the object.
    @Override
    public MyTime updateTime(int deltaHours, int deltaMinutes, int deltaSeconds) {
        return eventTimeStart.updateTime(deltaHours, deltaMinutes, deltaSeconds);
            //return eventTimeStart;
    }

    // check the validity of all of the event information
    @Override
    public boolean isValid() {
        return isValid(this.eventName, this.eventDesc, this.eventDate, this.eventTimeStart, this.eventTimeDuration);
    }

    // check the validity of the Event Description or Event Name
    public boolean isValid(String eventInfo)
    {
        if (eventInfo != null && eventInfo.length() > 0)
            return true;
        else
            return false;
    }

    // check the validity of all of the event information
    @Override
    public boolean isValid(String name, String desc, MyDate dateStart, MyTime timeStart, int duration) {
        if (isValid(name) &&
                isValid(desc) &&
                dateStart.isValid() &&
                timeStart.isValid() )
            return true;
        else
            return false;
    }

    // wrap DOW class getDOW and return the object
    @Override
    public DOW getDOW() {
        return eventDate.getDOW();
    }

    // wrap DOW class and return the object with parameters
    @Override
    public DOW getDOW(int mn, int dy, int yr) {
        return eventDate.getDOW(mn, dy, yr);
    }

    // wrap DOW class and return the object
    @Override
    public DOW getMonth1stDOW() {
        return eventDate.getMonth1stDOW();
    }

    // wrap DOW class and return the number of days in a year
    @Override
    public int getNumOfDaysInYear() {
        return eventDate.getNumOfDaysInYear();
    }

    // wrap DOW class and return the number of days in a year using a parameter
    @Override
    public int getNumOfDaysInYear(int yr) {
        return eventDate.getNumOfDaysInYear(yr);
    }

    // verify if the events overlap and return true if they do... else false
    @Override
    public boolean doEventsOverlap(MyEvent ckEvent) {
        return false;
    }

    @Override
    public int compareTo(MyTime o) {
        return 0;
    }
}
