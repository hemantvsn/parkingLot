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

	@CliCommand(value = "create_parking_lot", help = "Creates a parking lot of desired size. This will reset the data")
	public String createParkingLot(
			@CliOption(key = { "" }, mandatory = true, help = "Size of parking lot") int size) {
		try {
			return parkingService.init(size);
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@CliCommand(value = "park", help = "Park your car")
	public String createParkingLot(
			@CliOption(key = { "" }, mandatory = true, help = "Registration number of CAR") String details) {
		String[] strings = details.split(" ");
		try {
			return parkingService.parkCar(new Car(strings[0], strings[1]));
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@CliCommand(value = "leave", help = "Creates a parking lot of desired size. This will reset the data")
	public String leaveSlot(
			@CliOption(key = { "" }, mandatory = true, help = "Slot number we want to free") int slotNo) {
		try {
			return parkingService.clearSlot(slotNo);
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@CliCommand(value = "status", help = "Get Status")
	public String getStatus() {
		try {
			return parkingService.getStatus();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	
	@CliCommand(value = "registration_numbers_for_cars_with_colour", 
			help = "Get all registration numbers for the given colour")
	public String getAllRegForColour(
			@CliOption(key = { "" }, mandatory = true, help = "Colour") String colour) {
		try {
			return parkingService.getAllRegForColour(colour);
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@CliCommand(value = "slot_numbers_for_cars_with_colour", 
			help = "Get all slot numbers for the given colour")
	public String getAllSlotsForColour(
			@CliOption(key = { "" }, mandatory = true, help = "Colour") String colour) {
		try {
			return parkingService.getAllSlotsForColour(colour);
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@CliCommand(value = "slot_number_for_registration_number", 
			help = "Get slot number for the given registration number")
	public String getSlotForRegNo(
			@CliOption(key = { "" }, mandatory = true, help = "Reg No") String regNo) {
		try {
			return parkingService.getSlotForRegNo(regNo);
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
}
