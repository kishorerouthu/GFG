package com.css.gfg;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kishore Routhu on 20/12/17 11:47 AM.
 */
public class ParkingLot {


}

enum VehicleSize {
    Motorcycle,
    Compact,
    Large
}

enum Level {
    L1,
    L2,
    L3
}

abstract class Vehicle {
    protected VehicleSize size;
    protected List<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
    protected int spotsNeeded;
    protected String licencePlate;

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleSize getSize() {
        return size;
    }

    /* park vehicle in this spot */
    public void parkinSpot(ParkingSpot s) {
        parkingSpots.add(s);
    }

    /** Remove vehicle from spot, and notify spot that it's gone */
    public void clearSpots() {

    }

    /*
    *  Checks if the spot
    * */
    public abstract boolean canFitInSpot(ParkingSpot spot);

}

class Bus extends Vehicle {

    public Bus() {
        spotsNeeded = 5;
        size = VehicleSize.Large;
    }


    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.canFitVehicle(this);
    }
}

class Car extends Vehicle {

    public Car() {
        spotsNeeded = 1;
        size = VehicleSize.Compact;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.canFitVehicle(this);
    }
}

class MotorCycle extends Vehicle {

    public MotorCycle() {
        spotsNeeded = 1;
        size = VehicleSize.Motorcycle;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.canFitVehicle(this);
    }
}

class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int row;
    private Level level;
    private int spotNumber;

    public ParkingSpot(VehicleSize spotSize, int row, Level level, int spotNumber) {
        this.spotSize = spotSize;
        this.row = row;
        this.level = level;
        this.spotNumber = spotNumber;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        boolean canFit = false;
        switch (spotSize) {
            case Compact:
                canFit = vehicle.getSize() == VehicleSize.Motorcycle || vehicle.getSize() == VehicleSize.Compact;
                break;
            case Motorcycle:
                canFit = vehicle.getSize() == VehicleSize.Motorcycle;
                break;
            case Large:
                canFit = true;
        }
        return canFit;
    }

    public boolean park(Vehicle vehicle) {
        if(!isAvailable()) {
            return false;
        }
        this.vehicle = vehicle;
        return true;
    }

    public int getRow() {
        return row;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    /**
     * Remove vehicle from spot, and notify level
     * that a new spot available
     */
    public void removeVehicle() {
        this.vehicle = null;
    }
}


