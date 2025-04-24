package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class PayRollCalculatorApp {
    
    // ================ Fire up the scanner =================
    static Scanner userPrompt = new Scanner(System.in);

    public static void main(String[] args) {

        // ================= ASk the user for input and output file names =================
        String inputFile = question("Enter the name of the input file\n");
        String outputFile = question("Enter the name of the out put file \n");

        try {
            // ================= Create a FileReader object connected to the File =================
            FileReader fileReader = new FileReader("src/main/resources/" + inputFile);
            // create a BufferedReader to manage input stream
            BufferedReader bufReader = new BufferedReader(fileReader);

            // ================= Create a FileWriter =================
            FileWriter fileWriter = new FileWriter("src/main/resources/" + outputFile);

            // ================= Create a BufferedWriter =================
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            // Create a header row on the csv file which is  a string
            bufWriter.write("id" + "|" + "name" + "|" + "gross pay" + "\n");


            // ================= Create a variable to hold the input =================
            String theLine;
            while ((theLine = bufReader.readLine()) != null) {

                String[] inputParts = theLine.split("\\|");

                // ================= Check to see if the first part of the line is equal to id =================
                if (inputParts[0].equals("id")) {
                    continue;
                }
                // ================= Create a variable to hold the parsed values =================
                int id = Integer.parseInt(inputParts[0]);
                String name = inputParts[1];
                double hours = Double.parseDouble(inputParts[2]);
                double rate = Double.parseDouble(inputParts[3]);

                bufWriter.write(id + "|" + name + "|" + Employee.getGrossPay(hours, rate) + "\n");


            }
            // ================= Close the buffer ================
            bufReader.close();
            bufWriter.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String question(String message) {
        System.out.print(message);
        return userPrompt.nextLine();
    }
}

