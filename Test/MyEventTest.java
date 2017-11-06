import org.junit.Test;
import static org.junit.Assert.*;

public class MyEventTest {
    public MyEventTest()
    {
    }

    @Test
    public void compareToTest()
    {
        //String name, String desc, MyDate dateStart, MyTime timeStart, int duration
        MyEvent myEvent = new MyEvent("Testing", "Test Desc", new MyDate(18,06,2000), new MyTime(5, 5, 5), 3600);
        MyEvent myEvent2 = new MyEvent("Testing2", "Test Desc2", new MyDate(18,07,2000), new MyTime(5, 5, 5), 3600);

        assertEquals(-1, myEvent.compareTo(myEvent2));
        assertEquals(0, myEvent2.compareTo(myEvent2));


    }

    @Test
    public void doesTimeSpanOverlapTest()
    {
        MyEvent myEvent = new MyEvent("Testing", "Test Desc", new MyDate(18,06,2000), new MyTime(5, 5, 5), 3600);
        MyEvent myEvent2 = new MyEvent("Testing2", "Test Desc2", new MyDate(18,06,2000), new MyTime(5, 55, 5), 3600);

        assertFalse(myEvent2.doesTimeSpanOverlap(myEvent.getEventTimeStart(), 3600));
        assertTrue(myEvent.doesTimeSpanOverlap(myEvent2.getEventTimeStart(), 3600));

    }

    @Test
    public void updateTimeTest()
    {
        MyEvent myEvent = new MyEvent();

        // hmmm how to test?
        //assertTrue(myEvent.updateTime(5, 5, 5);
        //assertFalse(myEvent.updateTime(-1,5,5);
        //assertFalse(myEvent.updateTime(5,-1,5);
        //assertFalse(myEvent.updateTime(5,5,-1);

    }

    @Test
    public void isValidTest()
    {
        MyEvent myEvent = new MyEvent("Testing", "Test Desc", new MyDate(18,06,2000), new MyTime(5, 5, 5), 3600);

        assertTrue(myEvent.isValid());
        assertTrue(myEvent.isValid("Testing"));
        assertFalse(myEvent.isValid(""));
        assertTrue(myEvent.isValid("Testing", "Test Desc", new MyDate(18,06,2000), new MyTime(5, 5, 5), 3600));
    }



}
