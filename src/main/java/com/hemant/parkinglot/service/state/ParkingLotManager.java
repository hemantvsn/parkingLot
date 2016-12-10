package com.hemant.parkinglot.service.state;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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
		validateIfCarAlreadyExists(car);
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
	
	public String getAllRegForColour(String colour) {
		List<String> regNos = new ArrayList<>();
		for(int i = 1; i < slots.length; i++) {
			Car car = slots[i];
			if(null != car && colour.equalsIgnoreCase(car.getColour())) {
				regNos.add(car.getRegNumber());
			}
		}
		return CollectionUtils.isEmpty(regNos) 
				? Constants.NOT_FOUND
				: StringUtils.collectionToCommaDelimitedString(regNos);
	}
	
	public String getAllSlotsForColour(String colour) {
		List<String> slotNos = new ArrayList<>();
		for(Integer i = 1; i < slots.length; i++) {
			Car car = slots[i];
			if(null != car && colour.equalsIgnoreCase(car.getColour())) {
				slotNos.add(i.toString());
			}
		}
		return CollectionUtils.isEmpty(slotNos)
				? Constants.NOT_FOUND
				: StringUtils.collectionToCommaDelimitedString(slotNos);
	}
	

	private void validateSlotNo(int slotNo) {
		if(!(slotNo > 0 && slotNo <= slots.length-1)) {
			throw new ParkingException(Constants.INVALID_SLOT_NO);
		}
	}
	
	private void validateIfCarAlreadyExists(final Car car) {
		for (int i = 1; i < slots.length; i++) {
			if(car.equals(slots[i])) {
				throw new ParkingException(Constants.CAR_ALREADY_PARKED);
			}
		}
	}

	public String getSlotForRegNo(String regNo) {
		Car car = new Car(regNo, null);
		for (Integer i = 1; i < slots.length; i++) {
			if(car.equals(slots[i])) {
				return i.toString();
			}
		}
		return Constants.NOT_FOUND;
	}
}