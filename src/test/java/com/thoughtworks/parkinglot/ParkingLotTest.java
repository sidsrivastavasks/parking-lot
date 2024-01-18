package com.thoughtworks.parkinglot;

import com.thoughtworks.parkinglot.exceptions.AlreadyParkedException;
import com.thoughtworks.parkinglot.exceptions.ParkingLotFullException;
import com.thoughtworks.parkinglot.exceptions.ParkableIsNotInTheLotException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingLotTest {

    @Test
    void shouldParkACarWhenSpaceIsAvailable() throws ParkingLotFullException, AlreadyParkedException {
        ParkingLot parkingLot = new ParkingLot(2);
        Parkable car = new Car();

        parkingLot.park(car);

        assertThat(parkingLot.isParked(car), is(true));
    }

    @Test
    void shouldNotParkACarWhenSpaceIsNotAvailable() throws ParkingLotFullException, AlreadyParkedException {
        ParkingLot parkingLot = new ParkingLot(1);
        Parkable car1 = new Car();
        Parkable car2 = new Car();

        parkingLot.park(car1);

        assertThrows(ParkingLotFullException.class, () -> parkingLot.park(car2));
    }

    @Test
    void shouldNotParkACarWhenItIsAlreadyParked() throws ParkingLotFullException, AlreadyParkedException {
        ParkingLot parkingLot = new ParkingLot(2);
        Parkable car = new Car();

        parkingLot.park(car);

        assertThrows(AlreadyParkedException.class, () -> parkingLot.park(car));
    }

    @Test
    void shouldUnParkTheCarWhenCarIsPassed() throws ParkingLotFullException, AlreadyParkedException, ParkableIsNotInTheLotException{
        ParkingLot parkingLot = new ParkingLot(2);
        Parkable car = new Car();
        parkingLot.park(car);

        parkingLot.unpark(car);

        assertThat(parkingLot.isParked(car), is(false));
    }

    @Test
    void shouldThrowExceptionWhenNoCarIsPassed() throws ParkingLotFullException, AlreadyParkedException, ParkableIsNotInTheLotException{
        ParkingLot parkingLot = new ParkingLot(2);
        Car car = new Car();

        assertThrows(ParkableIsNotInTheLotException.class, () -> parkingLot.unpark(car));
    }
}
