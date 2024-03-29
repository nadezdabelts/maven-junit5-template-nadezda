package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {

    public static String generateName(){

    int length = 10;
    boolean useLetters = true;
    boolean useNumbers = false;
    String generateCustomerName= RandomStringUtils.random(length, useLetters, useNumbers);

    return generateCustomerName;
}
//Homework 11, point 1
public static String generatePhone(){
        int lenght =10;
        boolean useLetters = false;
        boolean useNumbers = true;
        String generaCustomerPhone = RandomStringUtils.random(lenght, useLetters, useNumbers);

        return generaCustomerPhone;

}
    //Homework 11, point 1
    public static String generateComment(){
        int lenght =50;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generaCustomerComment = RandomStringUtils.random(lenght, useLetters, useNumbers);

        return generaCustomerComment;
}
    public static String generateValidApiKey() {

        int length = 16;
        boolean useLetters = false;
        boolean useNumbers = true;

        return RandomStringUtils.random(length, useLetters, useNumbers);

    }

}

