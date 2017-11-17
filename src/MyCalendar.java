import java.util.ArrayList;
import java.util.Collections;

public class MyCalendar implements MyCalendarInterface{
    private ArrayList<MyEvent> eventsList = new ArrayList<>();

    public MyCalendar() {
        eventsList = new ArrayList<>();
    }

    @Override
    public boolean addEvent(MyEvent event) {
        if (event.isValid()) {

            eventsList.add(event);
            Collections.sort(eventsList);
            return true;
        }
        else
            return false;

    }

    @Override
    public boolean removeEvent(MyEvent event) {
        return eventsList.remove(event);
    }

    @Override
    public ArrayList<MyEvent> getEvents() {
        return null;
    }

    @Override
    public ArrayList<MyEvent> getEvents(int mn, int dy, int yr) {
        return null;
    }

    @Override
    public int compareTo(MyCalendar o) {
        return 0;
    }

    public int findEventElement(MyEvent event) {
        //for(int i = 0; i < eventsList.size(); ++i)

        // if this return -1... the event was not found
        return eventsList.indexOf(event);
                //return i;
    }
}
