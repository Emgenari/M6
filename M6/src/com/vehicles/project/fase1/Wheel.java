package com.vehicles.project.fase1;

public class Wheel {
	private String brandW;
	private double diameter;

	public Wheel(String brandW, double diameter) {
		this.brandW = brandW;
		this.diameter = diameter;
	}
	
	public String toString() {
		return "Wheel [brand=" +brandW+ ", diameter=" +diameter+ "]";
	}
}