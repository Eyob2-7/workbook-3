package com.pluralsight;

import java.util.Scanner;

public class FamousQuotes {
    public static void main(String[] args) {
        //Fire the scanner
        Scanner input = new Scanner(System.in);
        String[] quotes = new String[10];
        quotes[0] = "Believe you can and you're halfway there. – Theodore Roosevelt";
        quotes[1] = "Success is not final, failure is not fatal: It is the courage to continue that counts. – Winston Churchill";
        quotes[2] = "Don't watch the clock; do what it does. Keep going. – Sam Levenson";
        quotes[3] = "The future depends on what you do today. – Mahatma Gandhi";
        quotes[4] = "It always seems impossible until it's done. – Nelson Mandela";
        quotes[5] = "Start where you are. Use what you have. Do what you can. – Arthur Ashe";
        quotes[6] = "Dream big and dare to fail. – Norman Vaughan";
        quotes[7] = "Hardships often prepare ordinary people for an extraordinary destiny. – C.S. Lewis";
        quotes[8] = "Keep your face always toward the sunshine—and shadows will fall behind you. – Walt Whitman";
        quotes[9] = "Act as if what you do makes a difference. It does. – William James";


        boolean isRunning = true;
        while (isRunning) {
            //Ask the user to enter a number
            try {
                System.out.println("Select a number between 1-10");
                int choice = input.nextInt();

                if (choice >= 1 && choice <= 10) {
                    System.out.println("\n" + quotes[choice - 1]);
                    input.nextLine();
                    //Ask the user if they want more quotes
                    System.out.print("Would you like to see more quotes?(y/n)");
                    String moreQuotes = input.nextLine();
                    // Condition for more quotes
                    if (!moreQuotes.equalsIgnoreCase("y")) {
                        isRunning = false;
                        System.out.print("Good Bye.");
                    }

                } else {
                    System.out.println("invalid input");

                }
            } catch (Exception e) {
                System.out.println("please enter a valid number (1-10)");

            }
        }
    }
}
