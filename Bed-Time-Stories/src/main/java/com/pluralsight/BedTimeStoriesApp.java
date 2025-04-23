package com.pluralsight;

import java.io.FileInputStream;
import java.util.Scanner;

public class BedTimeStoriesApp {
    // Fire up the scanner
    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Save the file path inside a variable
        String goldilocks = "src/main/resources/goldilocks.txt";
        String hansel = "src/main/resources/hansel_and_gretel.txt";
        String mary = "src/main/resources/mary_had_a_little_lamb.txt";

        boolean isRunning = true;
        while (isRunning) {
           int option = mainMenu();
            myScanner.nextLine();

            // Create an empty variable to set  the file path.
            String file = "";

            switch (option) {
                case 1:
                    file = goldilocks;
                    isRunning = false;
                    break;
                case 2:
                    file = hansel;
                    isRunning = false;
                    break;
                case 3:
                    file = mary;
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option, please enter a number from 1 to 3");
                    continue; // Go back to the main menu
            }

            try {
                // create a FileInputStream object pointing to
                // a specific file
                FileInputStream story = new FileInputStream(file);
                // create a Scanner to reference the file to be read
                Scanner scanner = new Scanner(story);
                String input;
                // read until there is no more data
                while (scanner.hasNextLine()) {
                    input = scanner.nextLine();
                    System.out.println(input);
                    Thread.sleep((1000)); //wait for 1 second
                }
                System.out.println("\n....The End. Sweet dreams!");
                // close the scanner and release the resources
                scanner.close();
            } catch (Exception e) {
                System.out.print("That file doesn't exist");

            }


        }

    }
    public static  int mainMenu(){
        int response = 0;
        //Display the Main Menu
        System.out.println("Welcome to Bed Time Stories");
        System.out.println("The Bed Time Stories for today");
        System.out.println("1.Goldilocks");
        System.out.println("2.hansel and gretel");
        System.out.println("3.mary had a little lamb");
        System.out.println("Enter a number from (1-3) to read a story:");

        //Save the input inside a variable
         response = myScanner.nextInt();
         return response;
    }
}

