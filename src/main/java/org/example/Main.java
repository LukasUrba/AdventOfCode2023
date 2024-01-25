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
                    char character = singleLine.toLowerCase().charAt(i);
//                    checks for number starts and makes sure there's enough space left in the line
                    if((character=='o'||character=='t'||character=='f'||character=='s'||character=='e'||character=='n')&& singleLine.length()-i>=3){
                        checkNum=buildNumberWord(singleLine,i);
                        if (checkNum>0) return checkNum;
                    }
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
//    todo make separate numberchecker
//    Passes the line to check for the word starting at the line position
    static int buildNumberWord(String singleLine,int pos) {

        return 0;
    }
}