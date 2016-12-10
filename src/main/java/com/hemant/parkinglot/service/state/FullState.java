package com.hemant.parkinglot.service.state;

import com.hemant.parkinglot.Constants;
import com.hemant.parkinglot.model.Car;
import com.hemant.parkinglot.model.exception.ParkingException;

/**
 * Insertion not possible, but deletion is possible
 * @author hemant
 *
 */
public class FullState extends ParkingState {

	public FullState(ParkingLotManager manager) {
		super(manager);
	}

	@Override
	String parkCar(Car car) {
		throw new ParkingException(Constants.PARKING_IS_FULL);
	}

	@Override
	String clearSlot(int slotNo) {
		if(manager.slots[slotNo] == null) {
			throw new ParkingException(Constants.SLOT_ALREADY_EMPTY);
		}
		manager.slots[slotNo] = null;
		manager.occupiedSlots --;
		if(isEmpty()) {
			manager.setCurrentState(manager.emptyState);
		} else {
			manager.setCurrentState(manager.normalState);
		}
		return String.format(Constants.SLOT_FREED, slotNo);
	}

}
