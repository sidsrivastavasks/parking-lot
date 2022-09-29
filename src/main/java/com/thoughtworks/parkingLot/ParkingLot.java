package com.thoughtworks.parkingLot;

import com.thoughtworks.parkingLot.exceptions.AlreadyParkedException;
import com.thoughtworks.parkingLot.exceptions.ParkingLotFullException;

import java.util.HashSet;

public class ParkingLot {
    private final int capacity;
    private final HashSet<Parkable> parkedVehicles;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        parkedVehicles = new HashSet<>(capacity);
    }

    public void park(Parkable parkable) throws ParkingLotFullException, AlreadyParkedException {
        if (isFull())
            throw new ParkingLotFullException();
        if(isParked(parkable))
            throw new AlreadyParkedException();
        parkedVehicles.add(parkable);
    }

    private boolean isFull() {
        return parkedVehicles.size() >= capacity;
    }

    public boolean isParked(Parkable parkable) {
        return parkedVehicles.contains(parkable);
    }
}
