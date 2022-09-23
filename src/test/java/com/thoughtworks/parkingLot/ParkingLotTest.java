package com.thoughtworks.parkingLot;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ParkingLotTest {

    @Test
    void shouldParkACarWhenSpaceIsAvailable() {
        ParkingLot parkingLot = new ParkingLot(5);
        Parkable car = new Car();

        parkingLot.park(car);

        assertThat(parkingLot.isParked(car), is(true));
    }
}
