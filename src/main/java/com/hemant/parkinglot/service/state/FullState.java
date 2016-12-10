package com.hemant.parkinglot.service.state;

import com.hemant.parkinglot.model.Car;

/**
 * Insertion not possible, but deletion is possible
 * 
 * @author hemant
 *
 */
public class FullState extends ParkingState {

	public FullState(ParkingLotManager manager) {
		super(manager);
	}

	@Override
	String parkCar(Car car) {
		return null;
	}

	@Override
	String clearSlot(int slotNo) {
		return null;
	}

}
