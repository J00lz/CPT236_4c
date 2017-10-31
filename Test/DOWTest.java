// Scott G. Edwards, 10/2/2017
// Assignment 4c
// CPT 236 Fall 2017

// Shawn Ramsey
// Assignment 04d

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by sedward3 on 10/15/2017.
 */
public class DOWTest
{

    private static final int        DOW_MIN     =   DOW.DOW_MIN;        // Sunday
    private static final int        DOW_MAX     =   DOW.DOW_MAX;        // Saturday
    private static final int        DOW_BASE     =  DOW.DOW_BASE;        // 7: #days in week
    private static final int        DOW_Default =   DOW_MIN;
    private static final int        DOW_Invalid =   DOW_MAX+1;  // Index to get "Invalid Entries"

    private static final int        DOW_LT      =   DOW.DOW_LT;
    private static final int        DOW_EQ      =   DOW.DOW_EQ;
    private static final int        DOW_GT      =   DOW.DOW_GT;

    private static final String[]   dowStrShort =   DOW.dowStrShort;
    private static final String[]   dowStrLong  =   DOW.dowStrLong;

    private static final int        DOW_SUN     =   DOW_MIN;
    private static final int        DOW_WED     =   DOW_SUN+3;
    private static final int        DOW_SAT     =   DOW_MAX;

    public DOWTest()
    {;}


    // Method to use in all "setters" to validate value w.r.t. min & max (inclusive)
    private boolean validateRange(int value, int min, int max)
    {
        if ( (value >= min) && (value <= max) )
            return true;
        else
            return false;

    }   //  end validateRange()

    // Method to use in all "setters" to validate value w.r.t. min & max (inclusive)
    private boolean validateRange(int value)
    {
        return ( validateRange(value, DOW_MIN, DOW_MAX) );
    }   //  end validateRange()



    //  Test the default oonstructor
    @Test
    public void constructorDefaultTest()
    {
        DOW dow =   new DOW();
        assertEquals(DOW_MIN, dow.getValue() );

    }   //  end constructorDefaultTest()


    //  Test the overloaded oonstructor
    @Test
    public void copyConstructorTest()
    {
        DOW dow =   new DOW(DOW_WED);   //  valid
        assertEquals(DOW_WED, dow.getValue() );

        dow     =   new DOW(DOW_BASE);   // invalid ==> DOW_MIN
        assertEquals(DOW_MIN, dow.getValue() );

    }   //  end copyConstructorTest()


    // Test the add days to dow function
    @Test
    public void addDaysTest()
    {
        DOW dow     =   new DOW(DOW_WED);
        assertEquals(DOW_WED, dow.getValue() );

        int ckVal   =   dow.addDays(1);
        assertEquals(ckVal, (DOW_WED+1) );

        ckVal       =   dow.addDays(DOW_BASE);   // Add 7 days ==> same day-of-week (next week)
        assertEquals(ckVal, (DOW_WED+1) );

        ckVal       =   dow.addDays(-DOW_BASE);   // sub 7 days ==> same day-of-week (prev week)
        assertEquals(ckVal, (DOW_WED+1) );

    }   //  end addDaysTest()


    // Test the comparing function
    @Test
    public void compareToTest()
    {
        DOW dow     =   new DOW(DOW_WED);
        assertEquals(DOW_WED, dow.getValue() );

        DOW dowEQ    =   new DOW(DOW_WED);          // (dow == dowEQ) --> DOW_EQ
        assertEquals(DOW_WED, dowEQ.getValue() );

        DOW dowLT    =   new DOW(DOW_WED+1);        // (dow < dowLT) --> DOW_LT
        assertEquals((DOW_WED+1), dowLT.getValue() );

        DOW dowGT    =   new DOW(DOW_WED-1);        // (dow > dowLT) --> DOW_GT
        assertEquals((DOW_WED-1), dowGT.getValue() );

    }   //  end compareToTest()


    // Test getValue() and setValue()
    private void getSetValueTest()
    {
        int work    =   DOW_WED;

        DOW dow     =   new DOW(work);
        assertEquals(work, dow.getValue() );

        work        =   DOW_MIN;
        assertTrue( dow.setValue( work ) );
        assertEquals(work, dow.getValue() );

        work        =   DOW_MAX;
        assertTrue( dow.setValue( work ) );
        assertEquals(work, dow.getValue() );

        assertFalse( dow.setValue( DOW_BASE ) );  // Invalid
        assertEquals(work, dow.getValue() );    //  ==> don't change value

        assertFalse( dow.setValue( DOW_MIN-1 ) );  // Invalid
        assertEquals(work, dow.getValue() );    //  ==> don't change value

        work        =   DOW_WED;
        assertTrue( dow.setValue( work ) );
        assertEquals(work, dow.getValue() );

    }   //  end getSetValueTest()


    // Test getValue()
    @Test
    public void getValueTest()
    {
        getSetValueTest();
    }   //  end getValueTest()


    // Test setValue()
    @Test
    public void setValueTest()
    {
        getSetValueTest();
    }   //  end setValueTest()


    // Function to directly extrace expected string, and then compare to parameter (str)
    private void checkXXXString(int dowIdx, boolean trueForLong, String str )
    {
        assertTrue( validateRange(dowIdx, DOW_MIN, DOW_BASE) );      // Handle extra for "DOW_Invalid"

        String ckStr    =   trueForLong ? dowStrLong[dowIdx] : dowStrShort[dowIdx];

        assertEquals(ckStr, str);

    }   //  end checkXXXString()


    // Test getShortStr() and getLongStr()
    private void getXXXStrTest()
    {
        int     work    =   DOW_MIN;

        DOW dow     =   new DOW(work);
        assertEquals(work, dow.getValue() );
        checkXXXString(work, true, dow.getLongStr() );
        checkXXXString(work, false, dow.getShortStr() );

        work        =   DOW_WED;
        dow         =   new DOW(work);
        assertEquals(work, dow.getValue() );
        checkXXXString(work, true, dow.getLongStr() );
        checkXXXString(work, false, dow.getShortStr() );

        work        =   DOW_MAX;
        dow         =   new DOW(work);
        assertEquals(work, dow.getValue() );
        checkXXXString(work, true, dow.getLongStr() );
        checkXXXString(work, false, dow.getShortStr() );

        // Check return for invalid parameters
        checkXXXString(DOW_Invalid, true, dow.getLongStr(DOW_MIN-1) );
        checkXXXString(DOW_Invalid, false, dow.getShortStr(DOW_MIN-1) );
        checkXXXString(DOW_Invalid, true, dow.getLongStr(DOW_BASE) );
        checkXXXString(DOW_Invalid, false, dow.getShortStr(DOW_BASE) );

    }   //  end getXXXStrTest(()


    // Test getShortStr()
    @Test
    public void getShortStr()
    {
        getXXXStrTest();
    }   //  end getShortStr()


    // Test getLongStr()
    @Test
    public void getLongStr()
    {
        getXXXStrTest();
    }   //  end getLongStr()

}   //  end class DOWTest
