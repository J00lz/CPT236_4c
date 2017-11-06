public class MyEvent implements MyEventInterface{

    private String   eventName = "";        // Name of the event                [ Valid:  should never be NULL AND (length > 0) ]
    private String   eventDesc = "";        // Long description of the event    [ Valid:  should never be NULL AND (length > 0) ]

    private MyDate   eventDate;             // Date of the event

    private MyTime   eventTimeStart;        // Start of the event
    private int      eventTimeDuration;     // Event durations in minutes       // *** Updated variable type ***

    public MyEvent()
    {

    }
    public MyEvent(String name, String desc, MyDate dateStart, MyTime timeStart, int duration)
    {
        if (name != null)
            eventName = name;
        if (name != null)
            eventDesc = desc;
        eventDate = dateStart;
        eventTimeStart = timeStart;
        eventTimeDuration = duration;
    }
    public MyEvent(MyEvent copyEvent)
    {
        eventName = copyEvent.getEventName();
        eventDesc = copyEvent.getEventDesc();
        eventDate = copyEvent.getEventDate();
        eventTimeStart = copyEvent.getEventTimeStart();
        eventTimeDuration = copyEvent.getEventTimeDuration();
    }

    // return the eventTimeDuration
    public int getEventTimeDuration()
    {
        return eventTimeDuration;
    }

    // sets the eventTimeDuration
    public void setEventTimeDuration(int setEventTimeDuration)
    {
        eventTimeDuration = setEventTimeDuration;
    }
    // return the eventDate object
    public MyDate getEventDate()
    {
        return eventDate;
    }

    // sets the eventDate object
    public void setEventDate(MyDate setEventDate)
    {
        eventDate = setEventDate;
    }

    // return the eventTimeStart object
    public MyTime getEventTimeStart()
    {
        return eventTimeStart;
    }

    // sets the eventTimeStart object
    public void setEventTimeStart(MyTime setEventTimeStart)
    {
        eventTimeStart = setEventTimeStart;
    }
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

    // Compare the event's to see if they occur before one another, at the same time, or after one another
    @Override
    public int compareTo(MyEvent otherMyEvent) {
        if(this.eventDate.compareTo(otherMyEvent.eventDate) == 0)
        {
            if (this.eventTimeStart.compareTo(otherMyEvent.eventTimeStart) == 0)
                return 0;
            else if (this.eventTimeStart.compareTo(otherMyEvent.eventTimeStart) == -1)
                return -1;
            else
                return 1;
        }
        else if(this.eventDate.compareTo(otherMyEvent.eventDate) == -1)
        {
            return -1;
        }
        else
            return 1;
        /*if(this.eventDate.getYear() == otherMyEvent.eventDate.getYear() &&
                this.eventDate.getMonth() == otherMyEvent.eventDate.getMonth() &&
                this.eventDate.getDay() == otherMyEvent.eventDate.getDay() &&
                this.eventTimeStart.getHours() == otherMyEvent.eventTimeStart.getHours() &&
                this.eventTimeStart.getMinutes() == otherMyEvent.eventTimeStart.getMinutes)
                */
    }

    // use MyTime's doesTimeSpanOverlap to check if there is an overlap using an object... then return the object
    @Override
    public boolean doesTimeSpanOverlap(MyTime ckTime, int durationMins) {
        return ckTime.doesTimeSpanOverlap(this.eventTimeStart, durationMins);
    }

    // check if the time span over laps or not using MyTime's doesTimeSpanOverlap using parameters
    @Override
    public boolean doesTimeSpanOverlap(int hr, int mn, int sec, int durationMins) {
        MyTime ckTime = new MyTime(hr, mn, sec);
        return ckTime.doesTimeSpanOverlap(ckTime, durationMins);
    }

    @Override
    public String toString()
    {
        String str = "";
        str = "Event Name: " + this.eventName + "\nEvent Description: " + this.eventDesc + "\nDate: " + eventDate.toString() + "\nBeginning at: " + eventTimeStart;
        return str;
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
        return eventInfo != null && eventInfo.length() > 0;
    }

    // check the validity of all of the event information
    @Override
    public boolean isValid(String name, String desc, MyDate dateStart, MyTime timeStart, int duration) {
        return isValid(name) &&
                isValid(desc) &&
                dateStart.isValid() &&
                timeStart.isValid();
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
        return eventTimeStart.doesTimeSpanOverlap(ckEvent.eventTimeStart, ckEvent.eventTimeDuration);
    }

    public int compareTo(MyTime o) {
        return o.compareTo(eventTimeStart);
        //return o.compareTo
    }
}
