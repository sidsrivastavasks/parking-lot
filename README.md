# ParkingLot

We'll be focussing on Command Query Separation and Custom Exceptions along with Clean Code practices 

Sanvi parked her car in the parking lot so that she can catch her flight.

We have Sanvi's code for parking the car in this repository.

```
    public void park(Parkable parkable) throws ParkingSlotNotAvailableException, AlreadyParkedException {
        if (!isSlotAvailable())
            throw new ParkingSlotNotAvailableException();
        if(isParked(parkable))
            throw new AlreadyParkedException();
        parkedVehicles.add(parkable);
    }

    private boolean isSlotAvailable() {
        return parkedVehicles.size() < capacity;
    }

    public boolean isParked(Parkable parkable) {
        return parkedVehicles.contains(parkable);
    }
```

Now it's time for her to go home.
Can you help her unpark the car?

You can Fork and Clone this repository to get started .
