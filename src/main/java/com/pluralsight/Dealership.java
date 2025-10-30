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

    //our search vehicle methods
    public ArrayList<Vehicle> getVehiclePrice(double min, double max) {
        return null;
    }
    public ArrayList<Vehicle> getVehicleMakeModel(String make, String model) {
        return null;
    }
    public ArrayList<Vehicle> getVehicleYear(int min, int max) {
        return null;
    }
    public ArrayList<Vehicle> getVehicleColor(String color) {
        return null;
    }
    public ArrayList<Vehicle> getVehicleMileage(int min, int max) {
        return null;
    }
    public ArrayList<Vehicle> getVehicleType(String vehicleType) {
        return null;
    }

    //hands back
    public ArrayList<Vehicle> getAllVehicles(){
        return this.inventory;
    }

    //method to add a vehicle
    public void addVehicle( Vehicle theVehicle) {
        this.inventory.add(Vehicle);
    }

    //method to remove a vehicle
    public void removeVehicle(Vehicle theVehicle){}
}
