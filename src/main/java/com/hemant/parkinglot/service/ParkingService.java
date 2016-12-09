package com.hemant.parkinglot.service;

import com.hemant.parkinglot.model.Car;

public interface ParkingService {

	String init(int size);

	String parkCar(Car car);

}
