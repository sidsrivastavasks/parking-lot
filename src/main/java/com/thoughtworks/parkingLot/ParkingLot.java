package com.thoughtworks.parkingLot;

import java.util.HashSet;

public class ParkingLot {
    private final int capacity;
    private final HashSet<Parkable> parkedVehicles;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        parkedVehicles = new HashSet<>(capacity);
    }

    public void park(Parkable parkable) {
        if (isSlotAvailable())
            parkedVehicles.add(parkable);
    }

    private boolean isSlotAvailable() {
        return parkedVehicles.size() < capacity;
    }

    public boolean isParked(Parkable parkable) {
        return parkedVehicles.contains(parkable);
    }
}
