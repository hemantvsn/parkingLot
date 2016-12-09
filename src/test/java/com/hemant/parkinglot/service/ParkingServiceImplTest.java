package com.hemant.parkinglot.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.hemant.parkinglot.Constants;
import com.hemant.parkinglot.model.exception.ParkingException;

public class ParkingServiceImplTest {
	ParkingService service = new ParkingServiceImpl();

	@Test
	public void testInitNeg1() {
		try {
			service.init(-1);
		} catch (ParkingException e) {
			assertEquals(Constants.PARKING_LOT_NEGATIVE_SIZE_EXC, e.getMessage());
		}
	}

	@Test
	public void testInitNeg2() {
		try {
			service.init(0);
		} catch (ParkingException e) {
			assertEquals(Constants.PARKING_LOT_NEGATIVE_SIZE_EXC, e.getMessage());
		}
	}

	@Test
	public void testInitPos1() {
		int size = 3;
		assertEquals(String.format(Constants.LOT_CREATED_WITH_SIZE, size), service.init(size));
	}

	@Test
	public void testInitPos2() {
		int size = 5;
		assertEquals(String.format(Constants.LOT_CREATED_WITH_SIZE, size), service.init(size));
	}

	@Test
	public void testParkCar() {
		fail("Not yet implemented");
	}

}
