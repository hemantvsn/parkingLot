package com.hemant.parkinglot.service.state;

import com.hemant.parkinglot.model.Car;

public abstract class ParkingState {

	ParkingLotManager manager;

	public ParkingState(ParkingLotManager manager) {
		this.manager = manager;
	}

	abstract String parkCar(Car car);

	abstract String clearSlot(int slotNo);
}
