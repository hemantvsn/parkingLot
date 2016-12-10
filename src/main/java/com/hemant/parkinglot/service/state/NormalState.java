package com.hemant.parkinglot.service.state;

import com.hemant.parkinglot.Constants;
import com.hemant.parkinglot.model.Car;
import com.hemant.parkinglot.model.exception.ParkingException;

/**
 * Both insertion and Deletion are possible
 * @author hemant
 *
 */
public class NormalState extends ParkingState {

	public NormalState(ParkingLotManager manager) {
		super(manager);
	}

	@Override
	String parkCar(Car car) {
		final int slotID = getNearestAvailableSlot();
		manager.slots[slotID] = car;
		manager.occupiedSlots ++;
		if (isFull()) {
			manager.setCurrentState(manager.fullState);
		}
		return String.format(Constants.ALLOCATED_SLOT_NO, slotID);
	}

	@Override
	String clearSlot(final int slotNo) {
		if(manager.slots[slotNo] == null) {
			throw new ParkingException(Constants.SLOT_ALREADY_EMPTY);
		}
		manager.slots[slotNo] = null;
		manager.occupiedSlots --;
		if(isEmpty()) {
			manager.setCurrentState(manager.emptyState);
		}
		return String.format(Constants.SLOT_FREED, slotNo);
	}

}
