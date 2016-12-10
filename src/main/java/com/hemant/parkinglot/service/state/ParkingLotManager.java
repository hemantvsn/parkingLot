package com.hemant.parkinglot.service.state;

import com.hemant.parkinglot.Constants;
import com.hemant.parkinglot.model.Car;
import com.hemant.parkinglot.model.exception.ParkingException;

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
		validateSlotNo(slotNo);
		return currentState.clearSlot(slotNo);
	}

	public String getStatus() {
		StringBuilder builder = new StringBuilder();
		builder.append("===========================================\n");
		builder.append("SLOT NO\t REG NO\t COLOUR \n");
		for (int i = 1; i < slots.length; i++) {
			Car car = slots[i];
			if(null != car) {
				builder.append(String.format(Constants.STATUS_FORMAT, i, car.getRegNumber(), car.getColour()));
			}
		}
		builder.append("===========================================\n");
		builder.append(currentState.getClass().getName());
		return builder.toString();
	}
	

	private void validateSlotNo(int slotNo) {
		if(!(slotNo > 0 && slotNo <= slots.length-1)) {
			throw new ParkingException(Constants.INVALID_SLOT_NO);
		}
	}

}



