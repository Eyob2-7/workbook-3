package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class PayRollCalculatorApp {
        static Scanner userPrompt = new Scanner(System.in);
    public static void main(String[] args) {
        try{

            // create a FileReader object connected to the File
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            // create a BufferedReader to manage input stream
            BufferedReader bufReader = new BufferedReader(fileReader);

            String token;
            while((token = bufReader.readLine()) != null) {

                String[] inputParts = token.split("\\|");
                if(inputParts[0].equals("id")){
                    continue;
                }
                // Create a variable to hold the parsed values
                int id = Integer.parseInt(inputParts[0]);
                String name= inputParts[1];
                double hours= Double.parseDouble(inputParts[2]);
                double rate=Double.parseDouble(inputParts[3]);

                System.out.printf("%d - %s - $%.2f\n", id, name, Employee.getGrossPay(hours,rate));

            }

            bufReader.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
