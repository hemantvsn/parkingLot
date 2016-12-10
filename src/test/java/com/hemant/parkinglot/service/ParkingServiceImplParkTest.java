package com.hemant.parkinglot.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hemant.parkinglot.Constants;
import com.hemant.parkinglot.model.Car;
import com.hemant.parkinglot.model.exception.ParkingException;

public class ParkingServiceImplParkTest {
	ParkingService service = new ParkingServiceImpl();

	/**
	 * If parking request is made before initializing the manager,
	 * then it should throw exception
	 */
	@Test
	public void testPark1() {
		try {
			service.parkCar(new Car("xyz", "white"));
		} catch (ParkingException e) {
			assertEquals(Constants.PARKING_LOT_NOT_CREATED_YET, e.getMessage());
		}
	}
	
	/**
	 * For a parking lot of size = 1, first car should be parked at slot 1
	 */
	@Test
	public void testPark2() {
		service.init(1);
		assertEquals(String.format(Constants.ALLOCATED_SLOT_NO, 1), service.parkCar(new Car("xyz", "white")));
	}
	
	/**
	 * For a parking lot of size = 1, first car should be parked at slot 1.
	 * Next park request should throw an exception as lot is full
	 */
	@Test
	public void testPark3() {
		service.init(1);
		assertEquals(String.format(Constants.ALLOCATED_SLOT_NO, 1), service.parkCar(new Car("xyz", "white")));
		try {
			service.parkCar(new Car("xyz", "white"));
		} catch (ParkingException e) {
			assertEquals(Constants.PARKING_IS_FULL, e.getMessage());
		}
	}

	/**
	 * Reg No is unique
	 * For a parking lot of size = 3, first car should be parked at slot 1.
	 * If next park request, has same regNo, it should smell fish and 
	 * return exception saying this car is already parked
	 */
	@Test
	public void testPark4() {
		service.init(1);
		assertEquals(String.format(Constants.ALLOCATED_SLOT_NO, 3), service.parkCar(new Car("xyz", "white")));
		try {
			service.parkCar(new Car("xyz", "white"));
		} catch (ParkingException e) {
			assertEquals(Constants.CAR_ALREADY_PARKED, e.getMessage());
		}
	}
	
	/**
	 * For a parking lot of size = 3, 
	 * first car should be parked at slot 1.
	 * second car at slot 2
	 * third at slot 3
	 * For next park request, except lot is full exception
	 * 
	 */
	@Test
	public void testPark5() {
		service.init(3);
		assertEquals(String.format(Constants.ALLOCATED_SLOT_NO, 1), service.parkCar(new Car("abc", "white")));
		assertEquals(String.format(Constants.ALLOCATED_SLOT_NO, 2), service.parkCar(new Car("ijk", "white")));
		assertEquals(String.format(Constants.ALLOCATED_SLOT_NO, 3), service.parkCar(new Car("xyz", "white")));
		try {
			service.parkCar(new Car("lmn", "white"));
		} catch (ParkingException e) {
			assertEquals(Constants.PARKING_IS_FULL, e.getMessage());
		}
	}
	
}
