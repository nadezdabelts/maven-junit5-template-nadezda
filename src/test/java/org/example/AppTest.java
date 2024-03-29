package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */

public class AppTest {

    @Test
    public void checkTwoValuesEquals(){
        Calculator calculator = new Calculator();

        assertEquals( 4 , calculator.calculateSumOfTwoIntegerValue(2, 2));
       // assertEquals( 3 , 3);
    }

    @Test
    public void checkTwoValuesNotEquals(){
        Calculator calculator = new Calculator();

        assertNotEquals( 3 , calculator.calculateSumOfTwoIntegerValue(3, 4));
       // assertNotEquals( 3 , 4);
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        Calculator calculator = new Calculator();

        assertTrue( 3 == 3 );
        //assertTrue( 3 == 3 );
    }

    @Test
    public void shouldAnswerWithFalse()
    {

        assertFalse( 4 < 2 );
    }

    //Homework 5, point 3.3



}
