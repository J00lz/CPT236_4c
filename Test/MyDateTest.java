import org.junit.Test;
import static org.junit.Assert.*;

// Shawn Ramsey
// Assignment 04d

public class MyDateTest {
    public MyDateTest()
    {;}

    @Test
    public void setDateTest()
    {
        MyDate myDate = new MyDate();
        assertEquals(true, myDate.setDate(1, 25, 2010));
        assertEquals(false, myDate.setDate(-1, 25, 2010));
    }

    @Test
    public void setDaysTest()
    {
        MyDate myDate = new MyDate();
        assertEquals(true, myDate.setDay(1));
        assertEquals(false, myDate.setDay(-1));

    }

    @Test
    public void setMonthsTest()
    {
        MyDate myDate = new MyDate();
        assertEquals(true, myDate.setMonth(5));
        assertEquals(false, myDate.setMonth(-1));
        //assertEquals(5, myDate.getMonth());

    }
    @Test
    public void setYearsTest()
    {
        MyDate myDate = new MyDate();
        assertEquals(true, myDate.setYear(2020));
        assertEquals(false, myDate.setYear(-1));

    }

    @Test
    public void printLongTest()
    {
        MyDate myDate = new MyDate();
        myDate.setDate(6, 18, 2017);

        assertEquals("06/18/2017", myDate.printLong());
    }

    @Test

    // still not properly working for some reason
    public void printShortTest()
    {
        MyDate myDate = new MyDate();

        myDate.setDate(6, 18, 2017);

        assertEquals("06/18/17", myDate.printShort());
    }

    @Test
    public void isLeapYearTest() {
        MyDate myDate = new MyDate();

        // Check the method with no parameter
        myDate.setYear(2000);
        assertEquals(true, myDate.isLeapYear());
        myDate.setYear(2001);
        assertEquals(false, myDate.isLeapYear());

        // Check the method requiring parameter
        assertEquals(true, myDate.isLeapYear(2000));
        assertEquals(false, myDate.isLeapYear(2001));

    }

    @Test
    public void getNumDaysTest() {
        MyDate myDate = new MyDate();

        // Check the method with no parameter
        myDate.setMonth(1);
        assertEquals(31, myDate.getNumOfDaysInMonth());
        myDate.setMonth(2);
        myDate.setYear(2016);
        assertEquals(29, myDate.getNumOfDaysInMonth());
        myDate.setYear(2015);
        assertEquals(28, myDate.getNumOfDaysInMonth());

        // Check the method requiring parameter
        assertEquals(31, myDate.getNumOfDaysInMonth(1));
        assertEquals(28, myDate.getNumOfDaysInMonth(2));

    }


    // added for 4d
    @Test
    public void getNumOfDaysInYearTest()
    {
        MyDate myDate = new MyDate();

        assertEquals(365, myDate.getNumOfDaysInYear(2017));
        assertEquals(366, myDate.getNumOfDaysInYear(2016));
    }

    @Test
    // not sure how to test with objects?
    public void getMonth1stDOWTest()
    {
        MyDate myDate = new MyDate();
        myDate.setMonth(10);
        myDate.setYear(2017);

        assertEquals(7, myDate.getMonth1stDOW());

    }
}
