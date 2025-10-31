package com.pluralsight;

import java.util.ArrayList;
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
                case 1: this.processGetByPriceRequest();break;
                case 2: this.processGetByMakeModelRequest();break;
                case 3: this.processGetByYearRequest();break;
                case 4: this.processGetByColorRequest();break;
                case 5: this.processGetByMileageRequest();break;
                case 6: this.processGetByVehicleTypeRequest();break;
                case 7: this.processGetAllVehiclesRequest();break;
                case 8: this.processAddVehicleRequest();break;
                case 9: this.processRemoveVehicleRequest();break;
                case 99:
                    System.out.println("Goodbye, come again!");
                    menuRunning = false;
                    break;

                default:
                    System.out.println("INVALID OPTION: TRY AGAIN!");
            }
        }
    }

    public void processGetByPriceRequest(){}

    public void processGetByMakeModelRequest(){}

    public void processGetByYearRequest(){}

    public void processGetByColorRequest(){}

    public void processGetByMileageRequest(){}

    public void processGetByVehicleTypeRequest(){}

    public void processGetAllVehiclesRequest(){
        this.displayAllVehicles(theDealership.getAllVehicles());
    }

    public void processAddVehicleRequest(){}

    public void processRemoveVehicleRequest(){}

    private void init(){
        //created the DFM
        DealershipFileManager theDealershipFM = new DealershipFileManager();

        //set the dealarship in the file (this.dealership) to the dealership created
        //amd returned by getDealership() on the file manager
        this.theDealership = theDealershipFM.getDealership();

    }

    //method to display all vehicles
    private void displayAllVehicles(ArrayList<Vehicle>theVehicles){

        //we need to loop over all those vehicles to display
        for(Vehicle currentVehicle : theVehicles){
            //Call the toString method to get a nice display of the vehicle data
            System.out.println(currentVehicle);
        }



    }


}
