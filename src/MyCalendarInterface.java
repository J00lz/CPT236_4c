import java.util.ArrayList;

public interface MyCalendarInterface extends Comparable<MyCalendar> {
    // return true if the event has been added
    boolean addEvent (MyEvent event);
    // return true if event is properly deleated
    boolean removeEvent(MyEvent event);
    // return events in chronological order
    ArrayList<MyEvent> getEvents();
    // return events for a specific date in chronological order;
    ArrayList<MyEvent> getEvents(int mn, int dy, int yr);
}
