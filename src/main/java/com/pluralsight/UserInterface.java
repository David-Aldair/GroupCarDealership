package com.pluralsight;

import java.util.Scanner;

public class UserInterface {

    //access modifier (protected, public, protected) data type variable name
    //private property to hold our dealership
    private Dealership theDealership;

    //empty constructor
    public UserInterface(){
    }

    public void display(){
        //calling the initialize method
        this.init();

        //creating a scanner
        Scanner theScanner = new Scanner(System.in);

        //create a variable that we can use to determine if our app menu should display
        //even after we chose the option
        boolean menuRunning = true;

        //this loop will run until menuRunning is set to false
        while(menuRunning){

            System.out.println("""
                    Welcome to the dealership, choose your options:
                    
                    1 - Find vehicles within a price range
                    2 - Find vehicles by make / model
                    3 - Find vehicles by year range
                    4 - Find vehicles by color
                    5 - Find vehicles by mileage range
                    6 - Find vehicles by type (car, truck, SUV, van)
                    7 - List ALL vehicles
                    8 - Add a vehicle
                    9 - Remove a vehicle
                    99 - Quit""");

            //store the menu option in a variable called menuChoice
            int menuChoice = theScanner.nextInt();

            switch(menuChoice){
                case 1: this.processGetByPriceRequest();
                case 2:
            }




        }



    }

    public void processGetByPriceRequest(){}

    public void processGetByMakeModelRequest(){}

    public void processGetByYearRequest(){}

    public void processGetByColorRequest(){}

    public void processGetByMileageRequest(){}

    public void processGetByVehicleTypeRequest(){}

    public void processGetAllVehiclesRequest(){}

    public void processAddVehicleRequest(){}

    public void processRemoveVehicleRequest(){}

    private void init(){
        //created the DFM
        DealershipFileManager theDealershipFM = new DealershipFileManager();

        //set the dealarship in the file (this.dealership) to the dealership created
        //amd returned by getDealership() on the file manager
        this.theDealership = theDealershipFM.getDealership();

    }

    private void displayAllVehicles(){}


}
