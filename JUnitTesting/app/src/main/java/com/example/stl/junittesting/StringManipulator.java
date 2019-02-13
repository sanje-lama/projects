package com.example.stl.junittesting;

public class StringManipulator {

    private static StringManipulator instance;

    public static StringManipulator getInstance() {
        if (instance == null) {
            instance = new StringManipulator();
        }
        return instance;
    }

    public boolean isLessThan10(String input) {
        if (isLessThan10(input)) {
            return true;
        }
        return false;
    }

    public boolean isOddLength(String input) {
        if (isOddLength(input)) {
            return true;
        }
        return false;
    }

    public String zipperWords(String first, String second) {
        return String;
        if (first,second) {
            return true;
        }
        return false;
    }
}



//if the argument passed to the method is less than 10 characters in length, return true, otherwise return false
//Create at least two tests in the StringManipulatorUnitTest.java class to confirm that this method runs as expected.
//
//Create a method called isOddLength(String input) in StringManipulator.java (10 Minutes)
//
//This method should:
//
//return a boolean value
//if the argument passed to the method has an odd-numbered length, return true, otherwise return false
//Create at least two tests in the StringManipulatorUnitTest.java class to confirm that this method runs as expected.
//
//Create a method called zipperWords(String first, String second) in StringManipulator.java (10 Minutes)
//
//This method should:
//
//return a String value
//return a String that consists of the characters from both parameters "zippered" together, i.e. - the words apple and orange should be zippered into aoprpalngee
//add the remainder of the longest word to the end of the newly zippered word
//Create at least one test in the StringManipulatorUnitTest.java class to confirm that this method runs as expected.
//
//Create a method called deconstructedWord(String word) in StringManipulator.java (10 Minutes)
//
//This method should:
//
//return a String value
//return a String that consists of the characters from both parameters separated by whether they are either vowels or consonants, i.e. - the word goodbye should be separated into gdby ooe
//Create at least one test in the StringManipulatorUnitTest.java class to confirm that this method runs as expected.
//
//Create a method called wordSum(String first, String second) in StringManipulator.java (10 Minutes)
//
//This method should:
//
//return an int value
//return the sum of the lengths of both strings passed as arguments
//Create at least one test in the StringManipulatorUnitTest.java class to confirm that this method runs as expected.
//
//Create a method called longestWord(String[] words) in StringManipulator.java (10 Minutes)
//
//This method should:
//
//return a String value
//return the word with the longest number of characters in the String array
//Create at least one test in the StringManipulatorUnitTest.java class to confirm that this method runs as expected.
//
//Create a method called wordSort(String[] words) in StringManipulator.java (10 Minutes)
//
//This method should:
//
//return a String[] array
//return the contents of the original array, but sorted by length from smallest to largest
//Create at least one test in the StringManipulatorUnitTest.java class to confirm that this method runs as expected.