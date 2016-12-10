package com.hemant.parkinglot.model;

/**
 * Car class signifying each car which is parked
 * Registration number is unique to a car, so that becomes 
 * the property for equals and hashcode
 * 
 * @author hemant
 *
 */
public class Car {

	private String regNumber;
	private String colour;

	public Car(String regNumber, String colour) {
		super();
		this.regNumber = regNumber;
		this.colour = colour;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	/**
	 * Reg Number is unique, so equals and hashCode depends on it
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((regNumber == null) ? 0 : regNumber.hashCode());
		return result;
	}

	/**
	 * Reg Number is unique, so equals and hashCode depends on it
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (regNumber == null) {
			if (other.regNumber != null)
				return false;
		} else if (!regNumber.equals(other.regNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [regNumber=" + regNumber + ", colour=" + colour + "]";
	}

}
