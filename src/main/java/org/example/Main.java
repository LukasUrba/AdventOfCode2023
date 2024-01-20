package org.example;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;

//TODO Split file into classes

public class Main {
    public static void main(String[] args) {
        System.out.println(getTotal());
    }
    static int getTotal() {
        int total = 0;
        try {
            File myFile = new File("src/main/java/org/example/numberList.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String myLine = myReader.nextLine();
                int forwardVal = isolateNumbers(myLine, 1);
                int backVal = isolateNumbers(myLine, -1);
                int fullVal = (forwardVal * 10) + backVal;
                System.out.println(fullVal);
                total += fullVal;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return total;
    }
    static int isolateNumbers(String singleLine, int forwardOrBackward) {
    int checkNum;
        if (forwardOrBackward < 0) {
            for (int i = singleLine.length()-1; i >= 0; i--) {
                try {
                    checkNum = Integer.parseInt(String.valueOf(singleLine.charAt(i)));
                    return checkNum;
                } catch (NumberFormatException ignored) {
                }
            }
        } else {

            for (int i = 0; i < singleLine.length(); i++) {
                try {
                    checkNum = Integer.parseInt(String.valueOf(singleLine.charAt(i)));
                    return checkNum;

                } catch (NumberFormatException ignored) {
                }
            }
        }
        return 0;
    }
}