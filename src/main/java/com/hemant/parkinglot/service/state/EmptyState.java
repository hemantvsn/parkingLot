package com.hemant.parkinglot.service.state;

import com.hemant.parkinglot.model.Car;

/**
 * Insertion will always be in slot#1 Deletion is not possible
 * 
 * @author hemant
 *
 */
public class EmptyState extends ParkingState {

	public EmptyState(ParkingLotManager manager) {
		super(manager);
	}

	/**
	 * If its empty parking, then car will always be parked in first slot
	 * 
	 * @param car
	 * @return
	 */
	@Override
	String parkCar(Car car) {
		return null;
	}

	@Override
	String clearSlot(int slotNo) {
		return null;
	}

}
