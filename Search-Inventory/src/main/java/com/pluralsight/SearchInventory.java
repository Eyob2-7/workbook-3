package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SearchInventory {

    public static void main(String[] args) {

        //========== call the inventory method to get our products =========
        ArrayList<Product> inventory = readInventory();

        //========= fire up the scanner =========
        Scanner scanner = new Scanner(System.in);
        System.out.println("We carry the following inventory: ");

        //========= loop over our products and display them =========
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
//            System.out.printf("id: %d %s - Price: $%.2f\n",p.getId(), p.getName(), p.getPrice());//out put for getInventory

            //========= Display ========
            System.out.printf("%d|%s|$%.2f\n",p.getId(), p.getName(), p.getPrice());
        }
    }
    //our getInventory method that create an array-list of products and returns it
    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        // this method loads product objects into inventory
        inventory.add(new Product(1, "product1", 27.99f));
        inventory.add(new Product(2, "chips", 5.99f));
        inventory.add(new Product(3, "rollerblades", 159.99f));
        inventory.add(new Product(4, "dog food", 15.99f));
        inventory.add(new Product(5, "cat food", 8.99f));
        return inventory;
    }

    public static ArrayList<Product> readInventory() {
        ArrayList<Product> inventory = new ArrayList<>();
        try {
            // ================= Connect to the inventory file =================
            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);

            String theLine;
            //================= Read each line of the line =================
            while ((theLine = bufReader.readLine()) != null) {
            //================= Split the line using the pipe symbol
                String[] inputParts = theLine.split("\\|");

            //================= Create a Product object from parts:id| Name | Price =================
                Product myProducts = new Product(
                        Integer.parseInt(inputParts[0]),
                        inputParts[1],
                        (Float.parseFloat(inputParts[2]))
                );
                //================= Add product to the inventory list =================

                inventory.add(myProducts);
            }

            bufReader.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return inventory;
    }
}