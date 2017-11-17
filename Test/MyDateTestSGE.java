// Scott G. Edwards, 10/25/2017
// Assignment 4c
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

    public  static final    int MONTH_MIN   =   MyDate.MONTH_MIN;
    public  static final    int MONTH_MAX   =   MyDate.MONTH_MAX;
    public  static final    int DAY_MIN     =   MyDate.DAY_MIN;
    public  static final    int DAY_MAX     =   MyDate.DAY_MAX;     // Simplification - to be fixed later
    public  static final    int YEAR_MIN    =   MyDate.YEAR_MIN;
    public  static final    int YEAR_MAX    =   MyDate.YEAR_MAX;

    public  static final    boolean PRINT_LONG  =   MyDate.PRINT_LONG;
    public  static final    boolean PRINT_SHORT =   MyDate.PRINT_SHORT;

    private static final    int MONTH_FEB   =   2;

    private static final    int MONTH_MID   =   (MONTH_MIN + MONTH_MIN) / 2;
    private static final    int DAY_MID     =   (DAY_MIN + DAY_MIN) / 2;
    private static final    int YEAR_MID    =   (YEAR_MIN + YEAR_MIN) / 2;


    // Default constructor for MyDateTestSGE class
    public MyDateTestSGE()
    {
    } //  end constructor MyDateTestSGE()


    // Routine:  MyDate default Constructor Test
    @Test
    public void myDateConstructorDefaultTest()
    {
        MyDate myDate   =   new MyDate();
        assertEquals(MONTH_MIN,     myDate.getMonth() );
        assertEquals(DAY_MIN,       myDate.getDay() );
        assertEquals(YEAR_MIN,      myDate.getYear() );

    }   //  end myDateConstructorDefaultTest()


    // Routine:  MyDate Explicit Constructor Test
    @Test
    public void myDateConstructorExplicitTest()
    {
        MyDate myDate   =   new MyDate(MONTH_MID, DAY_MID, YEAR_MID);
        assertEquals(MONTH_MID,     myDate.getMonth() );
        assertEquals(DAY_MID,       myDate.getDay() );
        assertEquals(YEAR_MID,      myDate.getYear() );

    }   //  end myDateConstructorExplicitTest()


    // Routine:  MyDate Copy Constructor Test
    @Test
    public void myDateConstructorCopyTest()
    {
        MyDate myDate   =   new MyDate(MONTH_MID, DAY_MID, YEAR_MID);
        assertEquals(MONTH_MID,     myDate.getMonth() );
        assertEquals(DAY_MID,       myDate.getDay() );
        assertEquals(YEAR_MID,      myDate.getYear() );

        MyDate myDate1  =   new MyDate(myDate);
        assertEquals(MONTH_MID,     myDate1.getMonth() );
        assertEquals(DAY_MID,       myDate1.getDay() );
        assertEquals(YEAR_MID,      myDate1.getYear() );

    }   //  end myDateConstructorCopyTest()


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
        myDateConstructorDefaultTest();

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
        myDateConstructorDefaultTest();

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
        myDateConstructorDefaultTest();

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
        myDateConstructorDefaultTest();
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
        return (((yr % 4) == 0) && ((yr % 100) != 0)) || ((yr % 400) == 0);

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


    // This test validates the isValid() method (e.g., the currently set values of M/D/Y)
    @Test
    public void isValidTest()
    {
        MyDate myDate = new MyDate(MONTH_MID, DAY_MID, YEAR_MID);
        assertTrue(myDate.isValid());

     }   //  end isValidTest()


    // This test validates the isValid(M,D,Y) method (e.g., directly specifying date to be validated)
    @Test
    public void isValidTest1()
    {
        MyDate myDate = new MyDate(MONTH_MID, DAY_MID, YEAR_MID);
        assertTrue(myDate.isValid());

        assertTrue(myDate.isValid(MONTH_MIN, DAY_MIN, YEAR_MIN));

        assertTrue(myDate.isValid(MONTH_MAX, DAY_MAX, YEAR_MAX));

        assertFalse(myDate.isValid(MONTH_MIN-1, DAY_MIN, YEAR_MIN));
        assertFalse(myDate.isValid(MONTH_MIN, DAY_MIN-1, YEAR_MIN));
        assertFalse(myDate.isValid(MONTH_MIN, DAY_MIN, YEAR_MIN-1));

        assertFalse(myDate.isValid(MONTH_MAX+1, DAY_MAX, YEAR_MAX));
        assertFalse(myDate.isValid(MONTH_MAX, DAY_MAX+1, YEAR_MAX));
        assertFalse(myDate.isValid(MONTH_MAX, DAY_MAX, YEAR_MAX+1));

    }   //  end isValidTest1()


    // This test validates the compareToTest() method
    @Test
    public void compareToTest()
    {
        MyDate myDate1  =   new MyDate(MONTH_MID, DAY_MID, YEAR_MID);
        MyDate myDate2  =   new MyDate(myDate1);

        assertEquals(MyDate.COMPARE_TO_EQ,     myDate1.compareTo(myDate2) );

        assertTrue(myDate2.setDate(MONTH_MID, DAY_MID+1, YEAR_MID));
        assertEquals(MyDate.COMPARE_TO_LT,     myDate1.compareTo(myDate2) );
        assertEquals(MyDate.COMPARE_TO_GT,     myDate2.compareTo(myDate1) );

        assertTrue(myDate2.setDate(MONTH_MID+1, DAY_MID, YEAR_MID));
        assertEquals(MyDate.COMPARE_TO_LT,     myDate1.compareTo(myDate2) );
        assertEquals(MyDate.COMPARE_TO_GT,     myDate2.compareTo(myDate1) );

        assertTrue(myDate2.setDate(MONTH_MID, DAY_MID, YEAR_MID+1));
        assertEquals(MyDate.COMPARE_TO_LT,     myDate1.compareTo(myDate2) );
        assertEquals(MyDate.COMPARE_TO_GT,     myDate2.compareTo(myDate1) );

    }   //  end compareToTest()


    // Function to determine the day-of-week


    //  Reference:  https://stackoverflow.com/questions/478694/what-is-the-easiest-algorithm-to-find-the-day-of-week-of-day-zero-of-a-given-yea
    //
    //  Here's a simple one-liner. I've verified this for all the years 1901-2200 using Excel, and 1582-3000 using Python's datetime.
    //
    //      dayOfWeek = (year*365 + trunc((year-1) / 4) - trunc((year-1) / 100) +
    //          trunc((year-1) / 400)) % 7
    //
    //  This will give the day of the week as 0 = Sunday, 6 = Saturday. This result can easily be adjusted by adding a constant before or after the modulo 7. For example to match Python's convention of 0 = Monday, add 6 before the modulo.
    private int calcDayZeroOfYear(int yr)
    {
        int part1, part2, part3;
        //      dayOfWeek = (year*365 + trunc((year-1) / 4) - trunc((year-1) / 100) + trunc((year-1) / 400)) % 7

        part1   =   (yr-1)/4;           // truncation via integer math

        part2   =   (yr-1)/100;         // truncation via integer math

        part3   =   (yr-1)/400;         // truncation via integer math

        int dow =   ( (365 * yr) + part1 - part2 + part3 ) % 7;

        return (dow);


    }   //  end calcDayZeroOfYear()


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // METHOD:  isLeapYear(int testYear) checks to see if the year passed as a parameter is a leap year
    // INPUT:   1 integer being tested as valid "testYear"
    // OUTPUT:  a boolean of true or false
    public boolean isLeapYear(int testYear)
    {
        //  Method Credit: Created by Maria Kickligher
        return ((testYear % 4 == 0) && (testYear % 100 != 0) || (testYear % 400 == 0));
    }  // end isLeapYear(int testYear)

    // Calc DOW as function of specified dates
    //  (used as validator of methods)
    private int calcDayOfWeekMK(int mon, int dy, int yr)
    {
        //  Method Credit: Created by Maria Kickligher
        /*
        Https://blog.artofmemory.com/how-to-calculate-the-day-of-the-week-4203.html
        Year Code + Month Code + Century Code + Date Number – Leap Year Code) mod 7
        Year Code = (YY + (YY div 4)) mod 7
        Month Code is as follows:
            January = 0, February = 3, March = 3, April = 6, May = 1, June = 4
            July = 6, August = 2, September = 5, October = 0, November = 3, December = 5
        Century Code is as follows:
            1700s = 4, 1800s = 2, 1900s = 0, 2000s = 6, 2100s = 4, 2200s = 2, 2300s = 0
        Leap Year Code is :The other thing to take into account is whether you are dealing with a leap year.
                EDIT: If the date is in a January or February of a leap year, you have to
                subtract one from your total before the final step.
        */
        int centuryCode = 6;    // set value
        int yearCode = 0;       // calculated
        int monthCodeArr[] = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
        int leapYearCode = 0;

        // calcuate the year code
        String yearString = Integer.toString(yr).substring(2);  // make year a string
        int yearInt = Integer.parseInt(yearString);         // get only last two digits by using "substring"
        yearCode = (yearInt + (yearInt / 4)) % 7;

        // get month code from array based on parameter
        int currMonthCode = monthCodeArr[mon - 1];

        // get leap code based on year and if it is January or February
        if (isLeapYear(yr))
        {
            if (mon == 1 || mon == 2)       // January or February
            {
                leapYearCode = 1;
            }
        }

        // use formula with data from above to get day of week
        int myDayOfWeek = ((yearCode + currMonthCode + centuryCode + dy - leapYearCode) % 7);

        // return the integer representing the day of the week calculated here
        return (myDayOfWeek);

    }  // end calcDayOfWeekcalcDayOfWeekMK(parms)


    private int calcDayOfWeek(int mn, int dy, int yr)
    {
        int nDays   =   calcDayZeroOfYear(yr);
        MyDate myDate   =   new MyDate(1, 1, yr);
        for (int m=MONTH_MIN; m<mn; m++)
            nDays   +=  myDate.getNumOfDaysInMonth(m);
        nDays       +=  ( dy - 1 );
        nDays       %=  7;

        int mkDays  =   calcDayOfWeekMK(mn, dy, yr);
        String str  = "DOW Calculaion Mismatch:  SGE: " + String.valueOf(nDays) + "  MK: " + String.valueOf(mkDays) ;
        assertEquals( nDays, mkDays);

        return (nDays);

    }   //  end calcDayOfWeek()


/*
    // This test validates that getDOW(m,d,y) validates the date
    // *** Does not work currently because last-released DOW does not allow setting to DOW.DOW_Invalid ***
    //  (will be updated next assignment)
    @Test
    public void getDOWTestforValidDate()
    {
        DOW dow;
        MyDate myDate   =   new MyDate();

        dow = myDate.getDOW(MONTH_MIN-1, DAY_MIN, YEAR_MIN);
        assertEquals( DOW.DOW_Invalid, dow.getValue());

        dow = myDate.getDOW(MONTH_MAX+1, DAY_MIN, YEAR_MIN);
        assertEquals( DOW.DOW_Invalid, dow.getValue());

        dow = myDate.getDOW(MONTH_MIN, DAY_MIN-1, YEAR_MIN);
        assertEquals( DOW.DOW_Invalid, dow.getValue());

        dow = myDate.getDOW(MONTH_MIN, DAY_MAX+1, YEAR_MIN);
        assertEquals( DOW.DOW_Invalid, dow.getValue());

        dow = myDate.getDOW(MONTH_MIN, DAY_MIN, YEAR_MIN-1);
        assertEquals( DOW.DOW_Invalid, dow.getValue());

        dow = myDate.getDOW(MONTH_MIN, DAY_MIN, YEAR_MAX+1);
        assertEquals( DOW.DOW_Invalid, dow.getValue());

    }   //  getDOWTestforValidDate()
*/


    // This test validates the getDOW() method
    // Reference#2: https://www.timeanddate.com/date/weekday.html
    @Test
    public void getDOWTest()
    {
        MyDate myDate   =   new MyDate();

        int mStart  =   MONTH_MIN;
        int dStart  =   DAY_MIN;
        int yStart  =   MyDate.DOW_DEFAULT_YEAR;
        // Override - comment after
/*
        mStart  =   1;
        dStart  =   1;
        yStart  =   2004;
*/

        for (int y=yStart; y<=YEAR_MAX; y++)
        {
            for (int m=mStart; m<=MONTH_MAX; m++)
            {
                assertTrue( myDate.setDate(m,1, y) );
                int daysInMonth =   myDate.getNumOfDaysInMonth();

                for (int d=dStart; d<=daysInMonth; d++)
                {
                    assertTrue( myDate.setDate(m,d, y) );
                    DOW dow1    =   myDate.getDOW();
                    int dow2    =   calcDayOfWeek(m, d, y);
                    String str =  "Date: " + myDate.toString() + "  dow1=" + dow1.getValue() + "  dow2=" + dow2;
//--                    System.out.println( str );
                    assertEquals(str, dow1.getValue(), dow2);

                }   //  end for (d)

            }   //  end for (0)

        }   //  end for (y)

    }   //  end getDOWTest()


    @Test
    public void getDOWTest1()
    {
        MyDate myDate   =   new MyDate();

        int mStart  =   MONTH_MIN;
        int dStart  =   DAY_MIN;
        int yStart  =   MyDate.DOW_DEFAULT_YEAR;
        // Override - comment after
/*
        mStart  =   1;
        dStart  =   1;
        yStart  =   2004;
*/

        for (int y=yStart; y<=YEAR_MAX; y++)
        {
            assertTrue( myDate.setDate( MONTH_MIN, DAY_MIN, y));
            for (int m=mStart; m<=MONTH_MAX; m++)
            {
                assertTrue( myDate.setDate(m,1, y) );
                int daysInMonth =   myDate.getNumOfDaysInMonth(m);

                for (int d=dStart; d<=daysInMonth; d++)
                {
//--                    assertTrue( myDate.setDate(m,d, y) );
                    DOW dow1    =   myDate.getDOW(m, d, y);
                    int dow2    =   calcDayOfWeek(m, d, y);
                    String str =  "Date: " + myDate.toString() + "  dow1=" + dow1.getValue() + "  dow2=" + dow2;
                    System.out.println( str );
                    assertEquals(str, dow1.getValue(), dow2);

                }   //  end for (d)

            }   //  end for (0)

        }   //  end for (y)

    }   //  end getDOWTest1()


    @Test
    public void getMonth1stDOWTest()
    {
        MyDate myDate   =   new MyDate();

        int mStart  =   MONTH_MIN;
        int dStart  =   DAY_MIN;
        int yStart  =   MyDate.DOW_DEFAULT_YEAR;
        // Override - comment after
/*
        mStart  =   1;
        dStart  =   1;
        yStart  =   2004;
*/

        for (int y=yStart; y<=YEAR_MAX; y++)
        {
            assertTrue( myDate.setDate( MONTH_MIN, DAY_MIN, y));
            for (int m=mStart; m<=MONTH_MAX; m++)
            {
                assertTrue( myDate.setDate(m,1, y) );
                int daysInMonth =   myDate.getNumOfDaysInMonth(m);

                for (int d=dStart; d<=daysInMonth; d++)
                {
                    assertTrue( myDate.setDate(m, d, y) );
                    DOW dow1    =   myDate.getMonth1stDOW();
                    int dow2    =   calcDayOfWeek(m, DAY_MIN, y);
                    String str =  "Date: " + myDate.toString() + "   FirstDOW:  dow1=" + dow1.getValue() + "  dow2=" + dow2;
                    System.out.println( str );
                    assertEquals(str, dow1.getValue(), dow2);

                }   //  end for (d)

            }   //  end for (0)

        }   //  end for (y)


    }   //  end getMonth1stDOWTest()





}   //  end class MyDateTestSGE
