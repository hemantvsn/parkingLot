package com.hemant.parkinglot.service.state;

import com.hemant.parkinglot.model.Car;

public class ParkingLotManager {
	Car[] slots;
	int occupiedSlots;

	final ParkingState emptyState;
	final ParkingState fullState;
	final ParkingState normalState;

	private ParkingState currentState;

	public ParkingLotManager(int size) {
		// size is +1 since we want to avoid 0 based indexing
		// thus 0th slot will always be free, but not exposed
		slots = new Car[size + 1];
		occupiedSlots = 0;
		emptyState = new EmptyState(this);
		fullState = new FullState(this);
		normalState = new NormalState(this);
		currentState = emptyState;
	}

	public void setCurrentState(ParkingState currentState) {
		this.currentState = currentState;
	}

	public String parkCar(Car car) {
		return currentState.parkCar(car);
	}

	public String clearSlot(final int slotNo) {
		return currentState.clearSlot(slotNo);
	}

	public String getStatus() {
		return null;
	}

}
