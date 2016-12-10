package com.hemant.parkinglot.service.state;

import com.hemant.parkinglot.model.Car;

/**
 * Both insertion and Deletion are possible
 * 
 * @author hemant
 *
 */
public class NormalState extends ParkingState {

	public NormalState(ParkingLotManager manager) {
		super(manager);
	}

	@Override
	String parkCar(Car car) {
		return null;
	}

	@Override
	String clearSlot(final int slotNo) {
		return null;
	}

}
