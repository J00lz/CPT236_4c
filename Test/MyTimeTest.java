// Shawn Ramsey
// CPT 236
// Currently Working

import org.junit.Test;
import static org.junit.Assert.*;

public class MyTimeTest {

    public MyTimeTest()
    {
    }

    @Test
    public void setHoursTest()
    {
        MyTime myTime = new MyTime();

        assertEquals(0,     myTime.getHours() );

        myTime.setHours(1);
        assertEquals(1,     myTime.getHours() );

        myTime.setHours(-1);
        assertEquals(1,     myTime.getHours() );

        myTime.setHours(23);
        assertEquals(23,     myTime.getHours() );

        myTime.setHours(24);
        assertEquals(23,     myTime.getHours() );

    }

    @Test
    public void printUniversalTest()
    {
       MyTime myTime = new MyTime();
       myTime.setTime(9, 23, 14);

       assertEquals("09:23:14",     myTime.printUniversal());


    }
    @Test
    public void printStandardTest()
    {
        MyTime myTime = new MyTime();
        myTime.setTime(9, 23, 14);

        assertEquals("09:23:14 AM",     myTime.printStandard());
    }

    // 4d tests
    @Test
    public void isValidTest() {
        MyTime myTime = new MyTime();
        assertTrue(myTime.isValid(1, 1, 1));

        myTime.setTime(1, 1, 1);
        assertTrue(myTime.isValid());

        assertFalse(myTime.isValid(-1, -1, -1));
    }

    // FIXME
/*    @Test
    public void updateTimeTest()
    {
        MyTime myTime = new MyTime();
        assertTrue(myTime.updateTime(1, 1, 1));
        assertFalse(myTime.updateTime(-1,-1,-1));
    }
*/

}   // end class MyTimeTest
