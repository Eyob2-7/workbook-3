package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {

    //Fire up the scanner
    static Scanner  input =new Scanner(System.in);
    //create pattern/formatter we need for time stamp format
    static DateTimeFormatter timeStampFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
    //create a variable that will keep us looping the question for the user
        boolean isRunning = true;
        while(isRunning){
            String searchTerm = question("Enter a search term (x to Exit)");
            if (searchTerm.equalsIgnoreCase("x")){
                logActions("Exit");
                System.out.println("Good Bye");
                isRunning = false;
            }else{
                logActions("Search:"+searchTerm);
            }

        }

    }
    //Create a method that will create and maintain our log file
    public static void logActions(String theAction){
        try{
            //Create a file writer and set append to true so it adds to the file
            FileWriter outPutFile= new FileWriter("src/main/resources/logs.txt",true);

            //create the buffered writer to write to the log file
            BufferedWriter bufWriter = new BufferedWriter(outPutFile);

            //create a date and time
            LocalDateTime timeStamp = LocalDateTime.now();
            bufWriter.write(timeStamp.format(timeStampFormatter)+ " " + theAction);
            //make sure we have a new line in our file
            bufWriter.newLine();
            //close the buffer
            bufWriter.close();


        }catch(Exception e){
            //if we ran into an issue writing to the file, display this instead
            System.out.println("Error writing to the file:"+ e.getMessage());
        }

    }
    //
    public static String question(String message) {
        System.out.println(message);
        return input.nextLine();
    }
}
