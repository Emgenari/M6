package com.vehicles.project.fase3;

import java.util.List;

public class Moto extends Vehicle {
	
	public Moto(String plate, String brand, String color) {
		super(plate, brand, color);
	}
	
	public void addTwoWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception();

		Wheel frontWheel = wheels.get(0);
		Wheel backWheel = wheels.get(1);

		this.wheels.add(frontWheel);
		this.wheels.add(backWheel);
	}

	public String toString() {
		return "Moto [plate=" +plate+ ", brand=" +brand+ ", color=" +color+ ", wheels=" +wheels+ "]";
	}
}