package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

    //variable that helps us know where the csv file is
    //UPPER CASE is best practice to et other programmers know it's a private final
    private final String FILE_PATH = "src/main/resources/inventory.csv";

    //reponsible for reading the csv and pulling the dealership data from the first line of the csv
    //splitting the | to get the different parts
    //then creating the dealership from those parts
    public Dealership getDealership() {

        //you need to be able to work with the dealership outside the try
        Dealership theDealership = null;

        //try all this stuff and if it fails, do the stuff in catch block
        try {
            //buffered readers job is to help us read its file
            BufferedReader inventoryReader = new BufferedReader(new FileReader(FILE_PATH));

            //this reads the first line of the csv "D & B Used Cars|111 Old Benbrook Rd|817-555-5555"
            String dealershipInfo = inventoryReader.readLine();


            //string array to split the dealership info
            //it stores the values in an array called dealershipParts
            //splitting this "D & B Used Cars|111 Old Benbrook Rd|817-555-5555"
            String[] dealershipParts = dealershipInfo.split("\\|");

            //creating a dealership out of parts
            theDealership = new Dealership(dealershipParts[0], dealershipParts[1], dealershipParts[2]);

            //looping over the rest of the lines in the file and create vehicles
            //and add them to the dealership inventory
            String vehicleInfo;
            while((vehicleInfo = inventoryReader.readLine()) != null){

                //processing each
                String[] vehicleParts = vehicleInfo.split("\\|");

                //dealing with different parts
                int vin = Integer.parseInt(vehicleParts[0]);
                int year =Integer.parseInt(vehicleParts[1]);
                String make = vehicleParts[2];
                String model = vehicleParts[3];
                String vehicleType = vehicleParts[4];
                String color = vehicleParts[5];
                int odometer = Integer.parseInt(vehicleParts[6]);
                double price = Double.parseDouble(vehicleParts[7]);

                //creating a vehicle
                Vehicle firstVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                //adding it to the inventory of the dealership
                theDealership.addVehicle(firstVehicle);
            }

            //closing the reader
            inventoryReader.close();



            //use this if the stuff in the try block fails
        } catch (IOException exception) {

            //do this if it fails
            System.out.println("Error: File " + exception.getMessage());



        }










        return theDealership;
    }




    //saves the dealership to csv file
    public void saveDealership(Dealership theDealership){

    }




}
