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
                    6 - Find vehicles by type (sedan, truck, SUV, van)
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

    public void processGetByPriceRequest(){
        //creating a scanner
        Scanner theScanner = new Scanner(System.in);

        //ask the user what price range they're looking for
        System.out.println("What price range are you looking for, pick the minimum: ");

        //storing the answer
        double minPrice = theScanner.nextDouble();

        //ask the user for the max price
        System.out.println("Pick the the maximum: ");

        //storing the answer
        double maxPrice = theScanner.nextDouble();

        this.displayAllVehicles(theDealership.getVehiclePrice(minPrice, maxPrice ));

        //pausing so that the menu doesn't just pop up again
        System.out.println();
        System.out.println("Press enter to return to the main menu:");
        theScanner.nextLine();
    }

    public void processGetByMakeModelRequest(){

        //creating a scanner
        Scanner theScanner = new Scanner(System.in);

        //ask the user what make they're looking for
        System.out.println("What make are you looking for : ");

        //storing the answer
        String carMake = theScanner.nextLine();

        //ask the user what model they are looking for
        System.out.println("What model are you looking for: ");

        //storing the answer
        String carModel = theScanner.nextLine();

        this.displayAllVehicles(theDealership.getVehicleMakeModel(carMake, carModel ));

        //pausing so that the menu doesn't just pop up again
        System.out.println();
        System.out.println("Press enter to return to the main menu:");
        theScanner.nextLine();
    }

    public void processGetByYearRequest(){

        //creating a scanner
        Scanner theScanner = new Scanner(System.in);

        //ask the user what make they're looking for
        System.out.println("What year are you looking for, Enter a minimum : ");

        //storing the answer
        int minYear = theScanner.nextInt();

        //ask the user what model they are looking for
        System.out.println("Enter a maximum : ");

        //storing the answer
        int maxYear = theScanner.nextInt();

        this.displayAllVehicles(theDealership.getVehicleYear(minYear, maxYear ));
        theScanner.nextLine();

        //pausing so that the menu doesn't just pop up again
        System.out.println();
        System.out.println("Press enter to return to the main menu:");
        theScanner.nextLine();
    }

    public void processGetByColorRequest(){

        //creating a scanner
        Scanner theScanner = new Scanner(System.in);

        //ask the user what color they're looking for
        System.out.println("What color are you looking for: ");

        //storing the answer
        String theColor = theScanner.nextLine();

        ArrayList<Vehicle>matches = theDealership.getVehicleColor(theColor);

        this.displayAllVehicles(theDealership.getVehicleColor(theColor));

        //pausing so that the menu doesn't just pop up again
        System.out.println();
        System.out.println("Press enter to return to the main menu:");
        theScanner.nextLine();


    }

    public void processGetByMileageRequest(){

        //creating a scanner
        Scanner theScanner = new Scanner(System.in);

        //asking the user for the minimum amount of mileage
        System.out.println("What amount of mileage are you looking for, Enter minimum : ");

        //storing the answer
        int minMileage = theScanner.nextInt();

        //asking the user for the max amount of mileage
        System.out.println("Enter the maximum: ");

        //storing the answer
        int maxMileage = theScanner.nextInt();

        ArrayList<Vehicle>matches = theDealership.getVehicleMileage(minMileage, maxMileage);

        this.displayAllVehicles(theDealership.getVehicleMileage(minMileage, maxMileage));
        theScanner.nextLine();

        //pausing so that the menu doesn't just pop up again
        System.out.println();
        System.out.println("Press enter to return to the main menu:");
        theScanner.nextLine();

    }

    public void processGetByVehicleTypeRequest(){

        //creating a scanner
        Scanner theScanner = new Scanner(System.in);

        //ask the user what color they're looking for
        System.out.println("What vehicle type(e.g. sedan, truck, SUV, van) are you looking for: ");

        //storing the answer
        String vehicleType = theScanner.nextLine();

        ArrayList<Vehicle>matches = theDealership.getVehicleType(vehicleType);

        this.displayAllVehicles(theDealership.getVehicleType(vehicleType));

        //pausing so that the menu doesn't just pop up again
        System.out.println();
        System.out.println("Press enter to return to the main menu:");
        theScanner.nextLine();
    }

    public void processGetAllVehiclesRequest(){
        this.displayAllVehicles(theDealership.getAllVehicles());
    }

    public void processAddVehicleRequest(){

        //creating a scanner
        Scanner theScanner = new Scanner(System.in);

        //asking the user for each piece of vehicle info that we need
        //we need a vin, year, make, model, vehicle type, color, odometer, and price
        System.out.println("Enter the vin number: ");
        int vinNum = Integer.parseInt(theScanner.nextLine());

        System.out.println("Enter the year: ");
        int year = Integer.parseInt(theScanner.nextLine());

        System.out.println("Enter the make: ");
        String make = theScanner.nextLine();

        System.out.println("Enter the model: ");
        String model = theScanner.nextLine();

        System.out.println("Enter the vehicle type(e.g. e.g. sedan, truck, SUV, van) : ");
        String vehicleType = theScanner.nextLine();

        System.out.println("Enter the color: ");
        String color = theScanner.nextLine();

        System.out.println("Enter the amount of mileage: ");
        int mileage = Integer.parseInt(theScanner.nextLine());

        System.out.println("Enter the price: ");
        double price = Double.parseDouble(theScanner.nextLine());

        //building a vehicle object that represents one complete vehicle to add to the dealership
        Vehicle addedVehicle = new Vehicle(vinNum, year, make, model, vehicleType, color, mileage, price);

        //add the new vehicle to the dealership
        this.theDealership.addVehicle(addedVehicle);

        //save the dealership to the csv
        DealershipFileManager dfm = new DealershipFileManager();
        dfm.saveDealership(theDealership);

        System.out.println("Vehicle Added Successfully");

        System.out.println();
        System.out.println("Press enter to return to the main menu");
        theScanner.nextLine();



    }

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
