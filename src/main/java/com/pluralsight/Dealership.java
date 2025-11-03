package com.pluralsight;

import java.util.ArrayList;

public class Dealership {

    //creating the properties for the dealership
    private String name;
    private String address;
    private String phone;

    //array list that holds the dealership inventory
    private ArrayList<Vehicle>inventory;

    //constructor
    public Dealership(String name, String address, String phone) {

        //this.* refers to the property on this class directly and name whatever is what is passed in
        this.name = name;
        this.address = address;
        this.phone = phone;

        //instantiating the array list/actually creating the empty list that will be the inventory
        this.inventory = new ArrayList<Vehicle>();

    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //our search vehicle methods
    public ArrayList<Vehicle> getVehiclePrice(double min, double max) {

        //list to hold the results
        ArrayList<Vehicle> results = new ArrayList<Vehicle>();

        //add any vehicles from our inventory that matches the passed in price to the results
        for(Vehicle currentVehicle : this.inventory){

            // check if the vehicle's price is within the desired range
            // first: is the price greater than or equal to the minimum
            // second: is the price less than or equal to the maximum
            if(currentVehicle.getPrice() >= min && currentVehicle.getPrice() <= max){

                //if both conditions are true, we add it to the list of results
                results.add(currentVehicle);
            }
        }
        return results;
    }
    public ArrayList<Vehicle> getVehicleMakeModel(String carMake, String carModel) {

        //list to hold the results
        ArrayList<Vehicle>results = new ArrayList<Vehicle>();

        //add any vehicles from our inventory thst match the passed in make model to the results list
        for(Vehicle currentVehicle : this.inventory) {

            //only add to results if the make and model of the car matches the make and model passed into this method
            if (currentVehicle.getMake().equalsIgnoreCase(carMake) && currentVehicle.getModel().equalsIgnoreCase(carModel)) {
                results.add(currentVehicle);
            }
        }
        return results;


    }
    public ArrayList<Vehicle> getVehicleYear(int min, int max) {

        //list to hold the results
        ArrayList<Vehicle>results = new ArrayList<Vehicle>();

        //add any vehicles from our inventory thst match the passed in make model to the results list
        for(Vehicle currentVehicle : this.inventory) {

            // check if the vehicle's year is within the desired range
            // first: is the year greater than or equal to the minimum
            // second: is the year less than or equal to the maximum
            if(currentVehicle.getYear() >= min && currentVehicle.getYear() <= max){

                //if both conditions are true, we add it to the list of results
                results.add(currentVehicle);
            }
        }
        return results;
    }

    //should return a list of vehicles from the inventory that are of the colors passed in
    public ArrayList<Vehicle> getVehicleColor(String colorWeAreLookingFor) {

        //list to hold the results
        ArrayList<Vehicle>results = new ArrayList<Vehicle>();

        //add any vehicles from our inventory thst match the passed in color to the results list
        for(Vehicle currentVehicle : this.inventory){

            //only add to results if the color of the car matches the color passed into this method
            if(currentVehicle.getColor().equalsIgnoreCase(colorWeAreLookingFor)){
                results.add(currentVehicle);
            }
        }

        return results;
    }
    public ArrayList<Vehicle> getVehicleMileage(int min, int max) {

        //list to hold the results
        ArrayList<Vehicle>results = new ArrayList<Vehicle>();

        //add any vehicles from our inventory thst match the passed in make model to the results list
        for(Vehicle currentVehicle : this.inventory) {

            // check if the vehicle's mileage is within the desired range
            // first: is the mileage greater than or equal to the minimum
            // second: is the mileage less than or equal to the maximum
            if (currentVehicle.getOdometer() >= min && currentVehicle.getOdometer() <= max) {

                //if both conditions are true, we add it to the list of results
                results.add(currentVehicle);
            }
        }
        return results;
    }
    public ArrayList<Vehicle> getVehicleType(String vehicleType) {

        //list to hold the results
        ArrayList<Vehicle>results = new ArrayList<Vehicle>();

        //add any vehicles from our inventory thst match the passed in vehicleType to the results list
        for(Vehicle currentVehicle : this.inventory){

            //only add to results if the vehicleType of the car matches the vehicleType passed into this method
            if(currentVehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                results.add(currentVehicle);
            }
        }
        return results;
    }

    //hands back
    public ArrayList<Vehicle> getAllVehicles(){
        return this.inventory;
    }

    //method to add a vehicle
    public void addVehicle( Vehicle theVehicle) {
        this.inventory.add(theVehicle);
    }

    //method to remove a vehicle
    public void removeVehicle(Vehicle theVehicle){
        this.inventory.remove(theVehicle);
    }
}
