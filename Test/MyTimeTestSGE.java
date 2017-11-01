// Scott G. Edwards, 10/25/2017
// Assignment 4c
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

    // Use these definitions if MyTime has setup as "public static int XXX"
    private static final int  HOURS_MIN       =   MyTime.HOURS_MIN;
    private static final int  HOURS_MAX       =   MyTime.HOURS_MAX;
    private static final int  MINUTES_MIN     =   MyTime.MINUTES_MIN;
    private static final int  MINUTES_MAX     =   MyTime.MINUTES_MAX;
    private static final int  SECONDS_MIN     =   MyTime.SECONDS_MIN;
    private static final int  SECONDS_MAX     =   MyTime.SECONDS_MAX;


    // "HOURS_NOON" is based on either of the above variable definitions
    private static final int  HOURS_NOON      =   HOURS_MIN + 12;


    // Internal Test function for getHours() and setHours()
    private boolean getSetHoursTest()
    {
        MyTime myTime = new MyTime();

        assertEquals(HOURS_MIN, myTime.getHours());

        assertTrue(myTime.setHours(HOURS_MIN+1));
        assertEquals( (HOURS_MIN+1), myTime.getHours());

        assertFalse(myTime.setHours(HOURS_MIN-1));   //  invalid number ==> no change
        assertEquals( (HOURS_MIN+1), myTime.getHours());

        assertTrue(myTime.setHours(HOURS_MAX));
        assertEquals(HOURS_MAX, myTime.getHours());

        assertFalse(myTime.setHours(HOURS_MAX + 1));   //  invalid number ==> no change
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

        assertTrue(myTime.setMinutes(MINUTES_MIN+1));
        assertEquals( (MINUTES_MIN+1), myTime.getMinutes());

        assertFalse( myTime.setMinutes(MINUTES_MIN-1));   //  invalid number ==> no change
        assertEquals( (MINUTES_MIN+1), myTime.getMinutes());

        assertTrue(myTime.setMinutes(MINUTES_MAX));
        assertEquals(MINUTES_MAX, myTime.getMinutes());

        assertFalse(myTime.setMinutes(MINUTES_MAX + 1));   //  invalid number ==> no change
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

        assertTrue(myTime.setSeconds(SECONDS_MIN+1));
        assertEquals( (SECONDS_MIN+1), myTime.getSeconds());

        assertFalse(myTime.setSeconds(SECONDS_MIN-1));   //  invalid number ==> no change
        assertEquals( (SECONDS_MIN+1), myTime.getSeconds());

        assertTrue(myTime.setSeconds(SECONDS_MAX));
        assertEquals(SECONDS_MAX, myTime.getSeconds());

        assertFalse(myTime.setSeconds(SECONDS_MAX + 1));   //  invalid number ==> no change
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
        assertTrue(myTime.setTime(exHr,exMn,exSc));
        assertEquals(exHr, myTime.getHours());
        assertEquals(exMn, myTime.getMinutes());
        assertEquals(exSc, myTime.getSeconds());

        // Set w/ invalid Hours ==> no change
        assertFalse(myTime.setTime((HOURS_MIN-1),exMn,exSc));
        assertEquals(exHr, myTime.getHours());
        assertEquals(exMn, myTime.getMinutes());
        assertEquals(exSc, myTime.getSeconds());

        // Set w/ invalid Minutess ==> no change
        assertFalse(myTime.setTime(exHr, (MINUTES_MIN-1),exSc));
        assertEquals(exHr, myTime.getHours());
        assertEquals(exMn, myTime.getMinutes());
        assertEquals(exSc, myTime.getSeconds());

        // Set w/ invalid Seconds ==> no change
        assertFalse(myTime.setTime(exHr, exMn,(SECONDS_MIN-1) ));
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
        assertTrue("strings don't match", str.equals( getExpectedStrUniversalTime(0, 0, 0) ) );

        assertTrue(myTime.setTime(exHr, exMn, exSc));
        str = myTime.printUniversal();
        assertNotNull(str);
        assertTrue("strings don't match", str.equals( getExpectedStrUniversalTime(exHr, exMn, exSc) ) );

        exHr += 12;
        assertTrue(myTime.setTime(exHr, exMn, exSc));
        str = myTime.printUniversal();
        assertNotNull(str);
        assertTrue("strings don't match", str.equals( getExpectedStrUniversalTime(exHr, exMn, exSc) ) );

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
        assertEquals(str, getExpectedStrStandardTime(0, 0, 0));
        assertTrue("strings don't match", str.equals( getExpectedStrStandardTime(0, 0, 0) ) );

        assertTrue(myTime.setTime(exHr, exMn, exSc));
        str = myTime.printStandard();
        assertNotNull(str);
        assertTrue("strings don't match", str.equals( getExpectedStrStandardTime(exHr, exMn, exSc) ) );

        exHr += 12;
        assertTrue(myTime.setTime(exHr, exMn, exSc));
        str = myTime.printStandard();
        assertNotNull(str);
        assertTrue("strings don't match", str.equals( getExpectedStrStandardTime(exHr, exMn, exSc) ) );

    }   //  end printStandardTest()


    @Test
    public void constructorDefaultTest()
    {
        // New instance ==> All values set to default value
        MyTime myTime   =   new MyTime();
        assertEquals(HOURS_MIN, myTime.getHours());
        assertEquals(MINUTES_MIN, myTime.getMinutes());
        assertEquals(SECONDS_MIN, myTime.getSeconds());

    }   //  end constructorDefaultTest()


    @Test
    public void constructorExplicitTest()
    {
        int exHr    =   (HOURS_MAX - HOURS_MIN)/2;
        int exMn    =   (MINUTES_MAX - MINUTES_MIN)/2;
        int exSc    =   (SECONDS_MAX - SECONDS_MIN)/2;

        MyTime myTime   =   new MyTime(exHr, exMn, exSc);
        assertEquals(exHr, myTime.getHours());
        assertEquals(exMn, myTime.getMinutes());
        assertEquals(exSc, myTime.getSeconds());

        exHr        =   HOURS_MAX+1;
        exMn        =   MINUTES_MAX+1;
        exSc        =   SECONDS_MAX+1;
        MyTime myTime2  =   new MyTime(exHr, exMn, exSc);
        assertEquals(HOURS_MIN, myTime2.getHours());
        assertEquals(MINUTES_MIN, myTime2.getMinutes());
        assertEquals(SECONDS_MIN, myTime2.getSeconds());

    }   //  end constructorExplicitTest()()


    @Test
    public void constructorCopyTest()
    {
        int exHr    =   (HOURS_MAX - HOURS_MIN)/2;
        int exMn    =   (MINUTES_MAX - MINUTES_MIN)/2;
        int exSc    =   (SECONDS_MAX - SECONDS_MIN)/2;

        MyTime myTime   =   new MyTime(exHr, exMn, exSc);
        assertEquals(exHr, myTime.getHours());
        assertEquals(exMn, myTime.getMinutes());
        assertEquals(exSc, myTime.getSeconds());

        MyTime myTime2  =   new MyTime(myTime);
        assertEquals(exHr, myTime2.getHours());
        assertEquals(exMn, myTime2.getMinutes());
        assertEquals(exSc, myTime2.getSeconds());
        assertEquals(0, myTime.compareTo(myTime2));

        // Invaliddate  ==> default values for class
        exHr        =   HOURS_MAX+1;
        exMn        =   MINUTES_MAX+1;
        exSc        =   SECONDS_MAX+1;
        MyTime myTime3  =   new MyTime(exHr, exMn, exSc);
        assertEquals(HOURS_MIN, myTime3.getHours());
        assertEquals(MINUTES_MIN, myTime3.getMinutes());
        assertEquals(SECONDS_MIN, myTime3.getSeconds());

    }   //  end constructorCopyTest()()


    @Test
    public void isValidTest()
    {
        MyTime myTime   =   new MyTime();
        assertTrue(myTime.isValid());       // Should always be true.... how to set and then check invalids time.

    }   //  end isValidTest()


    // Not may not be implemented since was not in MyTimeInterface upon 4c test
    @Test
    public void isValidTest1()
    {
        int exHr    =   (HOURS_MAX - HOURS_MIN)/2;
        int exMn    =   (MINUTES_MAX - MINUTES_MIN)/2;
        int exSc    =   (SECONDS_MAX - SECONDS_MIN)/2;

        MyTime myTime   =   new MyTime(exHr, exMn, exSc);
        assertEquals(exHr, myTime.getHours());
        assertEquals(exMn, myTime.getMinutes());
        assertEquals(exSc, myTime.getSeconds());

        assertTrue(myTime.isValid() );

        assertTrue( myTime.isValid(exHr, exMn, exSc) );

        assertFalse( myTime.isValid(HOURS_MIN-1, exMn, exSc) );
        assertFalse( myTime.isValid(exHr, MINUTES_MIN-1, exSc) );
        assertFalse( myTime.isValid(exHr, exMn, SECONDS_MIN-1) );

        assertFalse( myTime.isValid(HOURS_MAX+1, exMn, exSc) );
        assertFalse( myTime.isValid(exHr, MINUTES_MAX+1, exSc) );
        assertFalse( myTime.isValid(exHr, exMn, SECONDS_MAX+1) );

        assertTrue( myTime.isValid(HOURS_MIN, MINUTES_MIN, SECONDS_MIN) );

    }   //  isValidTest1()


    // Routine to test MyTime.compareTo()
    @Test
    public void compareToTest()
    {
        int exHr    =   (HOURS_MAX - HOURS_MIN)/2;
        int exMn    =   (MINUTES_MAX - MINUTES_MIN)/2;
        int exSc    =   (SECONDS_MAX - SECONDS_MIN)/2;

        MyTime myTime1  =   new MyTime();
        MyTime myTime2  =   new MyTime();
        assertEquals(0, myTime1.compareTo(myTime2) );

        assertTrue(myTime1.setSeconds( exSc ) );
        assertEquals(+1, myTime1.compareTo(myTime2) );
        assertEquals(-1, myTime2.compareTo(myTime1) );

        assertTrue(myTime2.setSeconds( exSc ) );
        assertTrue(myTime1.setMinutes( exMn ) );
        assertEquals(+1, myTime1.compareTo(myTime2) );
        assertEquals(-1, myTime2.compareTo(myTime1) );

        assertTrue(myTime2.setSeconds( exMn ) );
        assertTrue(myTime1.setMinutes( exHr ) );
        assertEquals(+1, myTime1.compareTo(myTime2) );
        assertEquals(-1, myTime2.compareTo(myTime1) );

    }   //  end compareToTest()


    // Internal function to fully report time span validation errors
    private boolean doesTimeSpanOverLapTestAssert(MyTime myTimeA, MyTime myTimeB, int duration, boolean expResult)
    {
        String str  =   "Time Span - Result: " + String.valueOf(expResult) +
                "  myTimeA: " + myTimeA.toString() + "  myTimeB: " + myTimeB.toString() +
                "  duration: " + String.valueOf(duration);
        boolean result  =   myTimeA.doesTimeSpanOverlap(myTimeB, duration) ;

        assertEquals(str, result, expResult);

        return (result);

    }   //  end doesTimeSpanOverLapTestAssert()


    // Routin to test doesTimeSpanOverlap()
    @Test
    public void doesTimeSpanOverlapTest()
    {
        int exHr    =   (HOURS_MAX - HOURS_MIN)/2;
        int exMn    =   (MINUTES_MAX - MINUTES_MIN)/2;
        int exSc    =   (SECONDS_MAX - SECONDS_MIN)/2;

        MyTime  myTime1 =   new MyTime(exHr, 0, 0);
        MyTime  myTime2 =   new MyTime(myTime1);

        assertEquals( MyTime.COMPARE_TO_EQ, myTime1.compareTo(myTime2) );

        assertTrue( doesTimeSpanOverLapTestAssert(myTime1, myTime2, 0, true) );
        assertTrue( myTime1.setSeconds(SECONDS_MIN+1) );
        assertFalse( doesTimeSpanOverLapTestAssert(myTime1, myTime2, 0, false) );
        assertTrue( doesTimeSpanOverLapTestAssert(myTime1, myTime2, 2, true) );

        // Case#1 - new time starts before myTime2, then increment duration on/past myTime1
        assertTrue( myTime2.setHours( exHr-1 ));
        assertTrue( myTime1.setSeconds( SECONDS_MIN ) );
        assertFalse( doesTimeSpanOverLapTestAssert(myTime1, myTime2, 59, false) );
        assertTrue( doesTimeSpanOverLapTestAssert(myTime1, myTime2, 60, true) );
        assertTrue( doesTimeSpanOverLapTestAssert(myTime1, myTime2, 61, true) );

        // Case#2 - new time is less than this time, then increment on/past myTime1
        assertTrue( myTime2.setHours( exHr ));
        assertTrue( doesTimeSpanOverLapTestAssert(myTime1, myTime2, 0, true) );
        assertTrue( doesTimeSpanOverLapTestAssert(myTime1, myTime2, 1, true) );
        assertTrue( doesTimeSpanOverLapTestAssert(myTime1, myTime2, 2, true) );

        // Case#3 - new time is greater than this time, then increment on/past myTime1
        assertTrue( myTime2.setMinutes( exMn+1 ));
        assertFalse( doesTimeSpanOverLapTestAssert(myTime1, myTime2, 0, false) );
        assertFalse( doesTimeSpanOverLapTestAssert(myTime1, myTime2, 1, false) );
        assertFalse( doesTimeSpanOverLapTestAssert(myTime1, myTime2, 2, false) );

    }   //  end doesTimeSpanOverlapTest()


    // Method to create an ordinal out of HH/MM/SS - create as decimal integer: HHMMSS
    //  this allows for easy comparison
    private int getTimeOrdinal(MyTime myTime)
    {
        return ( getTimeOrdinal(myTime.getHours(), myTime.getMinutes(), myTime.getSeconds()) );
    }   //  end getTimeOrdinal()

    private int getTimeOrdinal(int ckHours, int ckMins, int ckSecs)
    {
        int ord     =   ckSecs;
        ord         +=  (ckMins*100);
        ord         +=  (ckHours*10000);
        return (ord);
    }   //  end getTimeOrdinal()



    private boolean checkSameTimeByOrdinals(MyTime myTimeA, MyTime myTimeB)
    {
        int ord1    =   getTimeOrdinal(myTimeA);
        int ord2    =   getTimeOrdinal(myTimeB);

        String str  =   "Error - Times do not match:  myTimeA=" + myTimeA.toString() + "  myTimeB=" + myTimeB.toString();

        assertTrue( str, (ord1==ord2) );

        return ( ord1 == ord2 );        // Note - will never get here if "assertTrue()" fails,
                                        // but in case want to return to caller

    }   //  end checkSameTimeByOrdinals()


    // Method to test updateTime()
    @Test
    public void updateTimeTest()
    {
        MyTime myTime   =   new MyTime();       //  00:00:00
        MyTime expTime  =   new MyTime();

        assertTrue( checkSameTimeByOrdinals(myTime, expTime ) );

        // Ignore the return for #4d - basically should always be true (due to bad specification)

        myTime.updateTime(0, 0, -1);
        expTime.setTime( 23, 59, 59);
        assertTrue( checkSameTimeByOrdinals(myTime, expTime ) );
        assertEquals( MyTime.COMPARE_TO_EQ, myTime.compareTo(expTime) );

        myTime.updateTime(0, 0, +1);
        expTime.setTime( 0, 0, 0);
        assertTrue( checkSameTimeByOrdinals(myTime, expTime ) );
        assertEquals( MyTime.COMPARE_TO_EQ, myTime.compareTo(expTime) );

        myTime.updateTime(0, -1, 0);
        expTime.setTime( 23, 59, 00);
        assertTrue( checkSameTimeByOrdinals(myTime, expTime ) );
        assertEquals( MyTime.COMPARE_TO_EQ, myTime.compareTo(expTime) );

        myTime.updateTime(0, +1, 0);
        expTime.setTime( 0, 0, 0);
        assertTrue( checkSameTimeByOrdinals(myTime, expTime ) );
        assertEquals( MyTime.COMPARE_TO_EQ, myTime.compareTo(expTime) );

        myTime.updateTime(-1, 0, 0);
        expTime.setTime( 23, 0, 00);
        assertTrue( checkSameTimeByOrdinals(myTime, expTime ) );
        assertEquals( MyTime.COMPARE_TO_EQ, myTime.compareTo(expTime) );

        myTime.updateTime(+1, 0, 0);
        expTime.setTime( 0, 0, 0);
        assertTrue( checkSameTimeByOrdinals(myTime, expTime ) );
        assertEquals( MyTime.COMPARE_TO_EQ, myTime.compareTo(expTime) );

        myTime.updateTime(-1, -1, -1);
        expTime.setTime( 22, 58, 59);
        assertTrue( checkSameTimeByOrdinals(myTime, expTime ) );
        assertEquals( MyTime.COMPARE_TO_EQ, myTime.compareTo(expTime) );

        myTime.updateTime(+1, +1, +1);
        expTime.setTime( 0, 0, 0);
        assertTrue( checkSameTimeByOrdinals(myTime, expTime ) );
        assertEquals( MyTime.COMPARE_TO_EQ, myTime.compareTo(expTime) );

    }   //  end updateTimeTest()



}   //  end class MyTimeTestSGE
