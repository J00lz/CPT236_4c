// Scott G. Edwards, 9/07/2017
// Assignment 3a
// CPT 236 Fall 2017




import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by sedward3 on 8/28/2017.
 */
public class MyTimeTestSGE {

    public MyTimeTestSGE()
    { ;  }

    ////////////////////////////////////////////////////////////////////////////////
    //  Enable one of the below (1st one will always work, but 2nd is better)
    ////////////////////////////////////////////////////////////////////////////////

//  4a - Removed since 2nd set should work
    // Use these definitions if MyTime does NOT have "public static int XXX"
    private static final int  HOURS_MIN       =   0;
    private static final int  HOURS_MAX       =   23;
    private static final int  MINUTES_MIN     =   0;
    private static final int  MINUTES_MAX     =   59;
    private static final int  SECONDS_MIN     =   0;
    private static final int  SECONDS_MAX     =   59;


//  4a - enabled these variables (rather than repeating)
    // Use these definitions if MyTime has setup as "public static int XXX"
    //private static final int  HOURS_MIN       =   MyTime.HOURS_MIN;
    //private static final int  HOURS_MAX       =   MyTime.HOURS_MAX;
    //private static final int  MINUTES_MIN     =   MyTime.MINUTES_MIN;
    //private static final int  MINUTES_MAX     =   MyTime.MINUTES_MAX;
    //private static final int  SECONDS_MIN     =   MyTime.SECONDS_MIN;
    //private static final int  SECONDS_MAX     =   MyTime.SECONDS_MAX;


    // "HOURS_NOON" is based on either of the above variable definitions
    private static final int  HOURS_NOON      =   HOURS_MIN + 12;


    // Internal Test function for getHours() and setHours()
    private boolean getSetHoursTest()
    {
        MyTime myTime = new MyTime();

        assertEquals(HOURS_MIN, myTime.getHours());

        myTime.setHours(1);
        assertEquals( (HOURS_MIN+1), myTime.getHours());

        myTime.setHours(HOURS_MIN-1);   //  invalid number ==> no change
        assertEquals( (HOURS_MIN+1), myTime.getHours());

        myTime.setHours(HOURS_MAX);
        assertEquals(HOURS_MAX, myTime.getHours());

        myTime.setHours(HOURS_MAX + 1);   //  invalid number ==> no change
        assertEquals(HOURS_MAX,     myTime.getHours() );

        return (true);

    }   //  end getSetHoursTest()

    @Test
    // Test function for setHours()
    public void setHoursTest()
    {
        getSetHoursTest();

    }   //  end setHoursTest()


    @Test
    // Test function for setHours()
    public void getHoursTest()
    {
        getSetHoursTest();

    }   //  end getHoursTest()



    // Internal Test function for getHours() and setHours()
    private boolean getSetMinutesTest()
    {
        MyTime myTime = new MyTime();

        assertEquals(MINUTES_MIN, myTime.getMinutes());

        myTime.setMinutes(1);
        assertEquals( (MINUTES_MIN+1), myTime.getMinutes());

        myTime.setMinutes(MINUTES_MIN-1);   //  invalid number ==> no change
        assertEquals( (MINUTES_MIN+1), myTime.getMinutes());

        myTime.setMinutes(MINUTES_MAX);
        assertEquals(MINUTES_MAX, myTime.getMinutes());

        myTime.setMinutes(MINUTES_MAX + 1);   //  invalid number ==> no change
        assertEquals(MINUTES_MAX,     myTime.getMinutes() );

        return (true);

    }   //  end getSetMinutesTest()

    @Test
    // Test function for setHours()
    public void setMinutesTest()
    {
        getSetMinutesTest();

    }   //  end setMinutesTest()

    @Test
    // Test function for setHours()
    public void getMinutesTest()
    {
        getSetMinutesTest();

    }   //  end getMinutesTest()


    // Internal Test function for getHours() and setHours()
    private boolean getSetSecondsTest()
    {
        MyTime myTime = new MyTime();

        assertEquals(SECONDS_MIN, myTime.getSeconds());

        myTime.setSeconds(1);
        assertEquals( (SECONDS_MIN+1), myTime.getSeconds());

        myTime.setSeconds(SECONDS_MIN-1);   //  invalid number ==> no change
        assertEquals( (SECONDS_MIN+1), myTime.getSeconds());

        myTime.setSeconds(SECONDS_MAX);
        assertEquals(SECONDS_MAX, myTime.getSeconds());

        myTime.setSeconds(SECONDS_MAX + 1);   //  invalid number ==> no change
        assertEquals(SECONDS_MAX,     myTime.getSeconds() );

        return (true);

    }   //  end getSetSecondsTest()

    @Test
    // Test function for setHours()
    public void setSecondsTest()
    {
        getSetSecondsTest();

    }   //  end setSecondsTest()

    @Test
    // Test function for setHours()
    public void getSecondsTest()
    {
        getSetSecondsTest();

    }   //  end getSecondsTest()


    /***********************************************************************
     Need to add getSecondsTest() and setSecondsTest()
     **********************************************************************/


    @Test
    // Test function for getHours() and setHours()
    public void SetTimeTest()
    {
        // First, validate all three H/M/S "setters" (which also tests the "getters")
        setHoursTest();
        setMinutesTest();
//--        setSecondsTest();

        MyTime myTime = new MyTime();

        // New instance ==> All values set to default value
        assertEquals(HOURS_MIN, myTime.getHours());
        assertEquals(MINUTES_MIN, myTime.getMinutes());
        assertEquals(SECONDS_MIN, myTime.getSeconds());

        int exHr    =   1;
        int exMn    =   1;
        int exSc    =   1;

        // Set to a valid time
        myTime.setTime(exHr,exMn,exSc);
        assertEquals(exHr, myTime.getHours());
        assertEquals(exMn, myTime.getMinutes());
        assertEquals(exSc, myTime.getSeconds());

        // Set w/ invalid Hours ==> no change
        myTime.setTime((HOURS_MIN-1),exMn,exSc);
        assertEquals(exHr, myTime.getHours());
        assertEquals(exMn, myTime.getMinutes());
        assertEquals(exSc, myTime.getSeconds());

        // Set w/ invalid Minutess ==> no change
        myTime.setTime(exHr, (MINUTES_MIN-1),exSc);
        assertEquals(exHr, myTime.getHours());
        assertEquals(exMn, myTime.getMinutes());
        assertEquals(exSc, myTime.getSeconds());

        // Set w/ invalid Seconds ==> no change
        myTime.setTime(exHr, exMn,(SECONDS_MIN-1) );
        assertEquals(exHr, myTime.getHours());
        assertEquals(exMn, myTime.getMinutes());
        assertEquals(exSc, myTime.getSeconds());

        // Assumption - because the individual "Setters" are being check, should be OK with this set of tests
    }   //  end SetTimeTest()

    // Internal routine to generate string simulating what is expected return string from MyTime.printUniversal()
    private String getExpectedStrUniversalTime(int hr, int mn, int sc)
    {
        return ( String.format("%02d:%02d:%02d", hr, mn, sc) );
    }   //  end getExpectedStrUniversalTime()

    @Test
    // Test function for printUniversal()
    public void printUniversalTest()
    {
        int exHr    =   1;
        int exMn    =   2;
        int exSc    =   3;

        MyTime myTime = new MyTime();       // Time is "00:00:00"

        String str = myTime.printUniversal();
        assertNotNull(str);
        assertTrue("Unexpected MyTime.printUniversal() string", str.equals( getExpectedStrUniversalTime(0, 0, 0) ) );

        myTime.setTime(exHr, exMn, exSc);
        str = myTime.printUniversal();
        assertNotNull(str);
        assertTrue("Unexpected MyTime.printUniversal() string", str.equals( getExpectedStrUniversalTime(exHr, exMn, exSc) ) );

        exHr += 12;
        myTime.setTime(exHr, exMn, exSc);
        str = myTime.printUniversal();
        assertNotNull(str);
        assertTrue("Unexpected MyTime.printUniversal() string", str.equals( getExpectedStrUniversalTime(exHr, exMn, exSc) ) );

    }   //  end printUniversalTest()

    // Internal routine to generate string simulating what is expected return string from MyTime.printStandard()
    private String getExpectedStrStandardTime(int hr, int mn, int sc)
    {
        String suffix = (hr < HOURS_NOON) ? "AM" : "PM" ;
        hr = (hr < HOURS_NOON) ? hr : hr - HOURS_NOON ;

        return ( String.format("%02d:%02d:%02d %2s", hr, mn, sc, suffix) );
    }   //  end getExpectedStrStandardTime()

    @Test
    // Test function for printUniversal()
    public void printStandardTest()
    {
        int exHr    =   1;
        int exMn    =   2;
        int exSc    =   3;

        MyTime myTime = new MyTime();       // Time is "00:00:00"

        String str = myTime.printStandard();
        assertNotNull(str);
        assertTrue("Unexpected MyTime.printUniversal() string", str.equals( getExpectedStrStandardTime(0, 0, 0) ) );

        myTime.setTime(exHr, exMn, exSc);
        str = myTime.printStandard();
        assertNotNull(str);
        assertTrue("Unexpected MyTime.printUniversal() string", str.equals( getExpectedStrStandardTime(exHr, exMn, exSc) ) );

        exHr += 12;
        myTime.setTime(exHr, exMn, exSc);
        str = myTime.printStandard();
        assertNotNull(str);
        assertTrue("Unexpected MyTime.printUniversal() string", str.equals( getExpectedStrStandardTime(exHr, exMn, exSc) ) );

    }   //  end printStandardTest()

}   //  end class MyTimeTestSGE
