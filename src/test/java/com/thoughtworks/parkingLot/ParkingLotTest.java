package com.thoughtworks.parkingLot;

import com.thoughtworks.parkingLot.exceptions.AlreadyParkedException;
import com.thoughtworks.parkingLot.exceptions.ParkingSlotNotAvailableException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingLotTest {

    @Test
    void shouldParkACarWhenSpaceIsAvailable() throws ParkingSlotNotAvailableException, AlreadyParkedException {
        ParkingLot parkingLot = new ParkingLot(5);
        Parkable car = new Car();

        parkingLot.park(car);

        assertThat(parkingLot.isParked(car), is(true));
    }

    @Test
    void shouldNotParkACarWhenSpaceIsNotAvailable() throws ParkingSlotNotAvailableException, AlreadyParkedException {
        ParkingLot parkingLot = new ParkingLot(1);
        Parkable car1 = new Car();
        Parkable car2 = new Car();

        parkingLot.park(car1);

        assertThrows(ParkingSlotNotAvailableException.class, () -> parkingLot.park(car2));
    }

    @Test
    void shouldNotParkACarWhenItIsAlreadyParked() throws ParkingSlotNotAvailableException, AlreadyParkedException {
        ParkingLot parkingLot = new ParkingLot(5);
        Parkable car = new Car();

        parkingLot.park(car);

        assertThrows(AlreadyParkedException.class, () -> parkingLot.park(car));
    }
}
