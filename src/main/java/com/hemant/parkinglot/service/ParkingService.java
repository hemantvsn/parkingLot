package com.hemant.parkinglot.service;

import com.hemant.parkinglot.model.Car;

public interface ParkingService {

	String init(int size);

	String parkCar(Car car);

	String clearSlot(int slotNo);

	String getStatus();

	String getAllRegForColour(String colour);

	String getAllSlotsForColour(String colour);

	String getSlotForRegNo(String regNo);

}
