package com.thoughtworks.parkingLot;

import com.thoughtworks.parkingLot.exceptions.ParkingSlotNotAvailableException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingLotTest {

    @Test
    void shouldParkACarWhenSpaceIsAvailable() throws ParkingSlotNotAvailableException {
        ParkingLot parkingLot = new ParkingLot(5);
        Parkable car = new Car();

        parkingLot.park(car);

        assertThat(parkingLot.isParked(car), is(true));
    }

    @Test
    void shouldNotParkACarWhenSpaceIsNotAvailable() throws ParkingSlotNotAvailableException{
        ParkingLot parkingLot = new ParkingLot(1);
        Parkable car1 = new Car();
        parkingLot.park(car1);
        Parkable car2 = new Car();

        assertThrows(ParkingSlotNotAvailableException.class, () -> parkingLot.park(car2));
    }
}
