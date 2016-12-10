package com.hemant.parkinglot.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hemant.parkinglot.Constants;
import com.hemant.parkinglot.model.Car;
import com.hemant.parkinglot.model.exception.ParkingException;
import com.hemant.parkinglot.service.state.ParkingLotManager;

@Service
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ParkingServiceImpl implements ParkingService {
	ParkingLotManager manager;
	
	@Override
	public String init(final int size) {
		if(0 >= size) {
			throw new ParkingException(Constants.PARKING_LOT_NEGATIVE_SIZE_EXC);
		}
		manager = new ParkingLotManager(size);
		return String.format(Constants.LOT_CREATED_WITH_SIZE, size);
	}

	@Override
	public String parkCar(Car car) {
		isManagerCreated();
		return manager.parkCar(car);
	}
	
	@Override
	public String clearSlot(int slotNo) {
		isManagerCreated();
		return manager.clearSlot(slotNo);
	}

	@Override
	public String getStatus() {
		isManagerCreated();
		return manager.getStatus();
	}
	
	private void isManagerCreated() {
		if(null == manager) {
			throw new ParkingException(Constants.PARKING_LOT_NOT_CREATED_YET);
		}
	}

	@Override
	public String getAllRegForColour(String colour) {
		isManagerCreated();
		return manager.getAllRegForColour(colour);
	}
	
	@Override
	public String getAllSlotsForColour(String colour) {
		isManagerCreated();
		return manager.getAllSlotsForColour(colour);
	}
	
	@Override
	public String getSlotForRegNo(String regNo) {
		isManagerCreated();
		return manager.getSlotForRegNo(regNo);
	}
}
