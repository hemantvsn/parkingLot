package com.hemant.parkinglot.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hemant.parkinglot.model.Car;
import com.hemant.parkinglot.service.state.ParkingLotManager;

@Service
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ParkingServiceImpl implements ParkingService {

	ParkingLotManager manager;
	
	@Override
	public String init(final int size) {
		return null;
	}

	@Override
	public String parkCar(Car car) {
		return null;
	}

	@Override
	public String clearSlot(int slotNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

}
