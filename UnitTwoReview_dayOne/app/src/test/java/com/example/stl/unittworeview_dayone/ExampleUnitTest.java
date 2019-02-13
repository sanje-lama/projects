package com.example.stl.unittworeview_dayone;

import org.junit.Before;
import org.junit.Test;

import java.net.PortUnreachableException;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    PartyClass partyClass;
    Car car = new Car();
    Calculator calculator = new Calculator();

    //@Before
    //       object declaration.
    //       put in external resources.

    @Test
    public void calculatorTest() {
        //Given
        int a = 2;
        int b = 3;
        int correctAnswer = 5;

        //when
        int result = calculator.getSum(a,b);

        //Then
       assertEquals(result, correctAnswer);

    }


    @Test
    public void GivenCarClass() {
        //Given
        int correctYear = 2018;

        //When
        int result = car.getYear();

        //Then
        assertEquals(result, correctYear);
        assertTrue(car.isBlue());

    }
    //Given:

    @Test
    public void greaterThanTrue() {
        assertTrue(calculator.greaterThanFIve(10));
    }

    @Test
    public void greaterThanFalse() {
        assertFalse(calculator.greaterThanFIve(55));
    }

    @Before
    public void setUp() throws Exception {
        partyClass = new PartyClass();
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);

    }
    @Test
    public void test_plus_one_method() {
        String fellow = "stl";
        assertEquals(fellow + " plus 1",partyClass.plusOne(fellow));
    }
}
