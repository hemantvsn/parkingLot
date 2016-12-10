package com.hemant.parkinglot.service.state;

import com.hemant.parkinglot.Constants;
import com.hemant.parkinglot.model.Car;
import com.hemant.parkinglot.model.exception.ParkingException;

/**
 * Insertion will always be in slot#1
 * Deletion is not possible
 * @author hemant
 *
 */
public class EmptyState extends ParkingState{

	private static final int FIRST_SLOT = 1;
	public EmptyState(ParkingLotManager manager) {
		super(manager);
	}

	/**
	 * If its empty parking, then car will always be parked in first slot
	 * @param car
	 * @return
	 */
	@Override
	String parkCar(Car car) {
		manager.slots[FIRST_SLOT] = car;
		manager.occupiedSlots ++;
		if (isFull()) {
			manager.setCurrentState(manager.fullState);
		} else {
			manager.setCurrentState(manager.normalState);
		}
		
		return String.format(Constants.ALLOCATED_SLOT_NO, FIRST_SLOT);
	}

	@Override
	String clearSlot(int slotNo) {
		throw new ParkingException(Constants.SLOT_ALREADY_EMPTY);
	}

}
