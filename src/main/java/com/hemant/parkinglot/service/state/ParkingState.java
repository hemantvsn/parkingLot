package com.hemant.parkinglot.service.state;

import com.hemant.parkinglot.Constants;
import com.hemant.parkinglot.model.Car;
import com.hemant.parkinglot.model.exception.ParkingException;

public abstract class ParkingState {

	ParkingLotManager manager;

	public ParkingState(ParkingLotManager manager) {
		this.manager = manager;
	}

	abstract String parkCar(Car car);

	abstract String clearSlot(int slotNo);

	public boolean isEmpty() {
		return manager.occupiedSlots == 0;
	}

	public boolean isFull() {
		return manager.occupiedSlots == manager.slots.length-1;
	}
	
	int getNearestAvailableSlot() {
		Car[] slots = manager.slots;
		for (int i = 1; i < slots.length; i++) {
			if(null == slots[i]) {
				return i;
			}
		}
		throw new ParkingException(Constants.PARKING_IS_FULL);
	}
}
