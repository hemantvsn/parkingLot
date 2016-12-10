package com.hemant.parkinglot.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hemant.parkinglot.Constants;
import com.hemant.parkinglot.model.Car;
import com.hemant.parkinglot.model.exception.ParkingException;

public class ParkingServiceImplLeaveTest {
	ParkingService service = new ParkingServiceImpl();

	/**
	 * If leave request is made before initializing the manager,
	 * then it should throw exception
	 */
	@Test
	public void testLeave1() {
		try {
			service.clearSlot(1);
		} catch (ParkingException e) {
			assertEquals(Constants.PARKING_LOT_NOT_CREATED_YET, e.getMessage());
		}
	}
	
	/**
	 * If slotId supplied is negative, it should throw an exception that slot is invalid
	 */
	@Test
	public void testLeave2() {
		try {
			service.init(10);
			service.clearSlot(-1);
		} catch (ParkingException e) {
			assertEquals(Constants.INVALID_SLOT_NO, e.getMessage());
		}
	}
	
	/**
	 * If slotId supplied is 0, it should throw an exception that slot is invalid
	 */
	@Test
	public void testLeave3() {
		try {
			service.init(10);
			service.clearSlot(0);
		} catch (ParkingException e) {
			assertEquals(Constants.INVALID_SLOT_NO, e.getMessage());
		}
	}
	
	/**
	 * If slotId supplied is much greater than initSize,
	 * it should throw an exception that slot is invalid
	 */
	@Test
	public void testLeave4() {
		try {
			service.init(10);
			service.clearSlot(100);
		} catch (ParkingException e) {
			assertEquals(Constants.INVALID_SLOT_NO, e.getMessage());
		}
	}
	
	/**
	 * If nothing is parked at that valid index
	 * we should get an exception that slot is already empty
	 */
	@Test
	public void testLeave5() {
		try {
			service.init(10);
			service.clearSlot(5);
		} catch (ParkingException e) {
			assertEquals(Constants.SLOT_ALREADY_EMPTY, e.getMessage());
		}
	}

	/**
	 * If nothing is parked at that valid index
	 * we should get an exception that slot is already empty
	 */
	@Test
	public void testLeave6() {
		try {
			service.init(10);
			service.parkCar(new Car("xyz", "green"));
			service.clearSlot(5);
		} catch (ParkingException e) {
			assertEquals(Constants.SLOT_ALREADY_EMPTY, e.getMessage());
		}
	}
	

	/**
	 * Positive case
	 */
	@Test
	public void testLeave7() {
		try {
			service.init(10);
			assertEquals(String.format(Constants.ALLOCATED_SLOT_NO, 1), service.parkCar(new Car("abc", "white")));
			assertEquals(String.format(Constants.ALLOCATED_SLOT_NO, 2), service.parkCar(new Car("ijk", "white")));
			assertEquals(String.format(Constants.ALLOCATED_SLOT_NO, 3), service.parkCar(new Car("xyz", "white")));
			
			
			assertEquals(String.format(Constants.SLOT_FREED, 3), service.clearSlot(3));
			assertEquals(String.format(Constants.SLOT_FREED, 1), service.clearSlot(1));
		} catch (ParkingException e) {
			assertEquals(Constants.SLOT_ALREADY_EMPTY, e.getMessage());
		}
	}

}
