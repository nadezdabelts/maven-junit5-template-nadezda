package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //create object
        Calculator calculator =new Calculator();
        // call method
        System.out.println( "Run calculator" + calculator.calculateSumOfTwoIntegerValue(5, 0));
        System.out.println("Run calculator" + calculator.calculateSubtractionBetweenTwoIntegerValues(8, 2));
        System.out.println("Run calculator" + calculator.theFirstValueIsBiggerThanTheSecondValue(5, 2));
        System.out.println("Run calculator" + calculator.theFirstValueIsBiggerThanTheSecondValue(5, 7));

    }
}
