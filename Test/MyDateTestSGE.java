// Scott G. Edwards, 9/28/2017
// Assignment 3d
// CPT 236 Fall 2017


import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by sedward3 on 9/14/2017.
 */

public class MyDateTestSGE
{
    ////////////////////////////////////////////////////////////////////////////////
    //  Enable one of the below (1st one will always work, but 2nd is better)
    ////////////////////////////////////////////////////////////////////////////////
/*
    public  static final    int MONTH_MIN   =   MyDate.MONTH_MIN;
    public  static final    int MONTH_MAX   =   MyDate.MONTH_MAX;
    public  static final    int DAY_MIN     =   MyDate.DAY_MIN;
    public  static final    int DAY_MAX     =   MyDate.DAY_MAX;     // Simplification - to be fixed later
    public  static final    int YEAR_MIN    =   MyDate.YEAR_MIN;
    public  static final    int YEAR_MAX    =   MyDate.YEAR_MAX;

    public  static final    boolean PRINT_LONG  =   MyDate.PRINT_LONG;
    public  static final    boolean PRINT_SHORT =   MyDate.PRINT_SHORT;
*/
    public  static final    int MONTH_MIN   =   1;
    public  static final    int MONTH_MAX   =   12;
    public  static final    int DAY_MIN     =   1;
    public  static final    int DAY_MAX     =   31;     // Simplification - to be fixed later
    public  static final    int YEAR_MIN    =   2000;
    public  static final    int YEAR_MAX    =   2099;

    public  static final    boolean PRINT_LONG  =   true;
    public  static final    boolean PRINT_SHORT =   false;


    private static final    int MONTH_FEB   =   2;

    private static final    int MONTH_MID   =   (MONTH_MIN + MONTH_MIN) / 2;
    private static final    int DAY_MID     =   (DAY_MIN + DAY_MIN) / 2;
    private static final    int YEAR_MID    =   (YEAR_MIN + YEAR_MIN) / 2;


//--    public  static final    boolean USE_MYDATE_RANGEINT =   true;
//--    public  static final    boolean USE_MYDATE_ORIGINAL =   false;


    // Default constructor for MyDateTestSGE class
    public MyDateTestSGE()
    {;} //  end constructor MyDateTestSGE()



    @Test
    // Routine:  MyDate default Constructor Test
    public void myDateConstructorTest()
    {
        MyDate myDate   =   new MyDate();
        assertEquals(MONTH_MIN,     myDate.getMonth() );
        assertEquals(DAY_MIN,       myDate.getDay() );
        assertEquals(YEAR_MIN,      myDate.getYear() );

    }   //  end myDateConstructorTest()

    // Routine: Set & Test month value
    private boolean getSetMonthValueTest(MyDate myDate, int mon, int lastValid, boolean expectedRetState)
    {
        assertEquals( expectedRetState, myDate.setMonth(mon));        // Set to specified value (even though may be invalid;  caller specified)
        assertEquals(lastValid, myDate.getMonth() );
        return (true);
    }   //  end getSetMonthValueTest()

    // Routine:  Test function for setMonth() and getMonth()
    private boolean getSetMonthTest()
    {
        myDateConstructorTest();

        MyDate  myDate      =   new MyDate();
        int     lastValid   =   MONTH_MIN;                                  // Test at bottom of range (from constructor)
        assertEquals(lastValid, myDate.getMonth() );

        getSetMonthValueTest(myDate, MONTH_MIN-1, lastValid, false);     // Test out-of-range/low ==> ck against lastValid

        lastValid   =   MONTH_MID;                                      // Test at middle of valid range
        getSetMonthValueTest(myDate, lastValid, lastValid, true);

        lastValid   =   MONTH_MIN;                                      // Test at bottom of valid range (after moving away from MIN)
        getSetMonthValueTest(myDate, lastValid, lastValid, true);

        lastValid   =   MONTH_MAX;                                      // Test at top of valid range
        getSetMonthValueTest(myDate, lastValid, lastValid, true);

        getSetMonthValueTest(myDate, MONTH_MAX+1, lastValid, false);     // Test out-of-range/high ==> ck against lastValid

        return (true);

    }   //  end getSetMonthTest()

    @Test
    // Routine:  setMonth() test function
    public void setMonthTest()
    {
        getSetMonthTest();
    }   //  end setMonthTest()

    @Test
    // Routine:  getMonth() test function
    public void getMonthTest()
    {
        getSetMonthTest();
    }   //  end getMonthTest()

    // Routine: Set & Test month value
    private boolean getSetDayValueTest(MyDate myDate, int dy, int lastValid, boolean expectedRetState)
    {
        assertEquals( expectedRetState, myDate.setDay(dy));        // Set to specified value (even though may be invalid;  caller specified)
        assertEquals(lastValid, myDate.getDay() );
        return (true);
    }   //  end getSetDayValueTest()

    // Routine:  Test function for setDay() and getDay()
    private boolean getSetDayTest()
    {
        myDateConstructorTest();

        MyDate  myDate      =   new MyDate();
        int     lastValid   =   DAY_MIN;                            // Test at bottom of range (from constructor)
        assertEquals(lastValid, myDate.getDay() );

        getSetDayValueTest(myDate, DAY_MIN-1, lastValid, false);           // Test out-of-range/low ==> ck against lastValid

        lastValid   =   DAY_MID;                                    // Test at middle of valid range
        getSetDayValueTest(myDate, lastValid, lastValid, true);

        lastValid   =   DAY_MIN;                                    // Test at bottom of valid range (after moving away from MIN)
        getSetDayValueTest(myDate, lastValid, lastValid, true);

        lastValid   =   DAY_MAX;                                    // Test at top of valid range
        getSetDayValueTest(myDate, lastValid, lastValid, true);

        getSetDayValueTest(myDate, DAY_MAX+1, lastValid, false);           // Test out-of-range/high ==> ck against lastValid

        return (true);

    }   //  end getSetDayTest()

    @Test
    // Routine:  setDay() test function
    public void setDayTest()
    {
        getSetDayTest();
    }   //  end setDayTest()

    @Test
    // Routine:  getDay() test function
    public void getDayTest()
    {
        getSetDayTest();
    }   //  end getDayTest()

    // Routine: Set & Test month value
    private boolean getSetYearValueTest(MyDate myDate, int yr, int lastValid, boolean expectedRetState)
    {
        assertEquals( expectedRetState, myDate.setYear(yr));        // Set to specified value (even though may be invalid;  caller specified)
        assertEquals(lastValid, myDate.getYear() );
        return (true);
    }   //  end getSetYearValueTest()

    // Routine:  Test function for setYear() and getYear()
    private boolean getSetYearTest()
    {
        myDateConstructorTest();

        MyDate  myDate      =   new MyDate();
        int     lastValid   =   YEAR_MIN;                            // Test at bottom of range (from constructor)
        assertEquals(lastValid, myDate.getYear() );

        getSetYearValueTest(myDate, YEAR_MIN-1, lastValid, false);           // Test out-of-range/low ==> ck against lastValid

        lastValid   =   YEAR_MID;                                    // Test at middle of valid range
        getSetYearValueTest(myDate, lastValid, lastValid, true);

        lastValid   =   YEAR_MIN;                                    // Test at bottom of valid range (after moving away from MIN)
        getSetYearValueTest(myDate, lastValid, lastValid, true);

        lastValid   =   YEAR_MAX;                                    // Test at top of valid range
        getSetYearValueTest(myDate, lastValid, lastValid, true);

        getSetYearValueTest(myDate, YEAR_MAX+1, lastValid, false);           // Test out-of-range/high ==> ck against lastValid


        return (true);

    }   //  end getSetYearTest()

    @Test
    // Routine:  setYear() test function
    public void setYearTest()
    {
        getSetYearTest();
    }   //  end setYearTest()

    @Test
    // Routine:  getYear() test function
    public void getYearTest()
    {
        getSetYearTest();
    }   //  end getYearTest()

    // Routine:  function to set & validate setTime() values
    private boolean setTimeValuesTest(MyDate myDate, int mn, int dy, int yr, int exMn, int exDy, int exYr)
    {
        // Set to a valid time
        //??    myDate.setDate(exMn,exMn,exYr);
        myDate.setDate(mn,dy,yr);               // Don't check return - some values are wrong/invalid
        assertEquals(exMn, myDate.getMonth() ); // Check against what is expected.
        assertEquals(exDy, myDate.getDay() );
        assertEquals(exYr, myDate.getYear() );

        return (true);

    }   //  end setTimeValuesTest()

    @Test
    // Routine:  setDate() test function
    public void setDateTest()
    {
        // First - just to make sure that the foundation is working, repeat tests here
        myDateConstructorTest();
        setMonthTest();
        setDayTest();
        setYearTest();

        MyDate myDate = new MyDate();

        int exMn    =   MONTH_MID;
        int exDy    =   DAY_MID;
        int exYr    =   YEAR_MID;

        setTimeValuesTest(myDate, exMn, exDy, exYr, exMn++, exDy++, exYr++);            // Test valid values

        setTimeValuesTest(myDate, exMn, exDy, exYr, exMn, exDy, exYr);                  // Test valid values
        setTimeValuesTest(myDate, MONTH_MIN-1, exDy, exYr, exMn++, exDy++, exYr++);// Test invalid month

        setTimeValuesTest(myDate, exMn, exDy, exYr, exMn, exDy, exYr);                  // Test valid values
        setTimeValuesTest(myDate, exMn, DAY_MIN-1, exYr, exMn++, exDy++, exYr++);   // Test invalid day

        setTimeValuesTest(myDate, exMn, exDy, exYr, exMn, exDy, exYr);                  // Test valid values
        setTimeValuesTest(myDate, exMn, exDy, YEAR_MIN-1, exMn++, exDy++, exYr++);  // Test invalid year

    }   //  end setDateTest()

    // Routine: return expected string for printLong() and printShort()
    private String getExpectedDateString(int mn, int dy, int yr, boolean trueForLong)
    {
        yr  =   (trueForLong == PRINT_LONG) ? yr : (yr % 100);

        return ( String.format("%02d/%02d/%02d", mn, dy, yr) );     // Note - "%02d" for year expands to 4 digits as necessary

    }   //  end getExpectedDateString()

    @Test
    // Routine:  printLong() test function
    public void printLongTest()
    {
        MyDate myDate   =   new MyDate();

        assertEquals(getExpectedDateString(MONTH_MIN, DAY_MIN, YEAR_MIN, PRINT_LONG), myDate.printLong() );

        assertTrue( myDate.setDate(MONTH_MID, DAY_MID, YEAR_MID) );
        assertEquals(getExpectedDateString(MONTH_MID, DAY_MID, YEAR_MID, PRINT_LONG), myDate.printLong() );

    }   //  end printLongTest()

    @Test
    // Routine:  printShort() test function
    public void printShortTest()
    {
        MyDate myDate   =   new MyDate();

        assertEquals(getExpectedDateString(MONTH_MIN, DAY_MIN, YEAR_MIN, PRINT_SHORT), myDate.printShort() );

        assertTrue( myDate.setDate(MONTH_MID, DAY_MID, YEAR_MID) );
        assertEquals(getExpectedDateString(MONTH_MID, DAY_MID, YEAR_MID, PRINT_SHORT), myDate.printShort() );

    }   //  end printShortTest()


    @Test
    public void isLeapYearTest()
    {
        MyDate myDate = new MyDate();

        assertEquals( false,    myDate.isLeapYear(2010) );
        assertEquals( false,    myDate.isLeapYear(2010) );
        assertEquals( true,     myDate.isLeapYear(2012) );
        assertEquals( false,    myDate.isLeapYear(2013) );
        assertEquals( false,    myDate.isLeapYear(2014) );
        assertEquals( false,    myDate.isLeapYear(2015) );
        assertEquals( true,     myDate.isLeapYear(2016) );
        assertEquals( false,    myDate.isLeapYear(2017) );


        // Check dates per https://everipedia.org/wiki/Leap_year/
        assertEquals( true,     myDate.isLeapYear(1600) );
        assertEquals( false,    myDate.isLeapYear(1700) );
        assertEquals( false,    myDate.isLeapYear(1800) );
        assertEquals( false,    myDate.isLeapYear(1900) );
        assertEquals( true,     myDate.isLeapYear(2000) );
        assertEquals( false,    myDate.isLeapYear(2100) );
        assertEquals( false,    myDate.isLeapYear(2200) );
        assertEquals( false,    myDate.isLeapYear(2300) );
        assertEquals( true,     myDate.isLeapYear(2400) );

    }   //  end isLeapYearTest()

    // Routine to calculate number of days in month
    private int calcDaysInMonth(int mn, boolean trueForLeapYear)    //  http://www.codecodex.com/wiki/Calculate_the_number_of_days_in_a_month [C/C++]
    {
        int numberOfDays;
        if ( (mn == 4) || (mn == 6) || (mn == 9) || (mn == 11) )
            numberOfDays = 30;
        else if (mn == 2)
            numberOfDays = 28 + ( trueForLeapYear ? 1 : 0 );
        else
            numberOfDays = 31;
        return ( numberOfDays );

    }   //  end calcDaysInMonth()

    // Routine to calculate leap year for specified year
    private boolean calcLeapYear(int yr)
    {
        //  if ((year modulo 4 is 0) and (year modulo 100 is not 0))
        //  or (year modulo 400 is 0)
        //  then true
        if ( ( ( (yr%4) == 0 ) && ( (yr%100) != 0) ) || ( (yr%400) == 0) )
            return (true);
        else
            return (false);

    }   //  end calcLeapYear()


    private void ckDaysInMonth( int mn, int yr )
    {
        MyDate myDate = new MyDate();

        assertTrue( myDate.setMonth(mn) );
        assertTrue( myDate.setDay(DAY_MIN) );
        assertTrue( myDate.setYear(yr) );

//        int expectedNumDays =   calcDaysInMonth(mn, myDate.isLeapYear(yr) );
        int expectedNumDays =   calcDaysInMonth(mn, calcLeapYear(yr) );
        int calcNumDays     =   myDate.getNumOfDaysInMonth();
        assertEquals( expectedNumDays,  calcNumDays);

        // For specified mn & yr, check all expected day rangess in the month
        assertFalse( myDate.setDay(DAY_MIN-1));     // Invalid      //3d
        assertTrue( myDate.setDay(DAY_MIN));        // Valid        //3d
        assertTrue( myDate.setDay(DAY_MID));        // Valid        //3d
        assertTrue( myDate.setDay(expectedNumDays));        // Valid        //3d
        assertFalse( myDate.setDay(expectedNumDays+1));     // Invalid      //3d

    }   //  end ckDaysInMonth()

    @Test
    public void getNumDaysInMonthTest()
    {
        isLeapYearTest();       // Validate isLeapYear() first

        int mn;
        // Fist check base number of days in month for non-leap year (2017)
        for (mn=MONTH_MIN; mn<=MONTH_MAX; mn++)
            ckDaysInMonth(mn, 2017);

        ckDaysInMonth(MONTH_FEB,    2016);      // Leap year
        ckDaysInMonth(MONTH_FEB,    2017);      // not Leap
        ckDaysInMonth(MONTH_FEB,    2018);      // not Leap
        ckDaysInMonth(MONTH_FEB,    2019);      // not Leap
        ckDaysInMonth(MONTH_FEB,    2020);      // Leap Year

    }   //  end getNumDaysInMonthTest()


    // This test validates change values individually where when changed, the interim new date
    //  is not valid correct.
    @Test
    public void setDateTest_2()
    {
        MyDate myDate = new MyDate();

        assertFalse( myDate.setDate( MONTH_FEB, 29,2017 ) );    // Invalid - 2/29 in  non-leap year

        assertTrue( myDate.setDate( MONTH_FEB, 28,2017 ) );    // Valid

        assertTrue( myDate.setDate(MONTH_FEB, 29, 2016));       // Valid

        assertFalse( myDate.setDate(MONTH_FEB, 29, 2017));      // Invalid - 2/29 in  non-leap year

        assertTrue( myDate.setDate(MONTH_FEB, 29, 2016));       // Reset to be safe...
        assertFalse( myDate.setYear(2017) );                    //  "Should" fail...

        assertTrue( myDate.setDate(MONTH_FEB, 29, 2016));       // Reset to be safe...
        assertTrue( myDate.setMonth(MONTH_MIN) );               // Valid
        assertTrue( myDate.setYear(2017) );                     // Valid
        assertFalse( myDate.setMonth(MONTH_FEB) );              // Invalid - Day=29 with non-leap year 


        assertTrue( myDate.setDate(MONTH_FEB, 29, 2016));       // Reset to be safe...
        assertTrue( myDate.setDay(28) );                        // Valid
        assertTrue( myDate.setDay(29) );                        // Valid

    }   //  end setDateTest_2()

}   //  end class MyDateTestSGE
