package com.hemant.parkinglot.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

import com.hemant.parkinglot.model.Car;
import com.hemant.parkinglot.service.ParkingService;

@Component
public class ParkingCommand implements CommandMarker {

	@Autowired
	ParkingService parkingService;

	@CliCommand(value = "create-parking-lot", help = "Creates a parking lot of desired size. This will reset the data")
	public String createParkingLot(
			@CliOption(key = { "" }, mandatory = true, help = "Size of parking lot") int size) {
		return parkingService.init(size);
	}

	@CliCommand(value = "park", help = "Park your car")
	public String createParkingLot(
			@CliOption(key = { "" }, mandatory = true, help = "Registration number of CAR") String regNo,
			@CliOption(key = { "" }, mandatory = true, help = "Colour of the CAR") String colour) {
		return parkingService.parkCar(new Car(regNo, colour));
	}
}
