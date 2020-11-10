package com.vehicles.project.fase1;

import java.util.Scanner;

public class createVehicle {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Car newCar;
		String plate=null;
		String brand=null;
		String color=null;
					
		System.out.println("Creating a new car.");
		
		//car parameters		
		newCar=new Car(plate, brand, color);
		System.out.println("Type car plate:");
		newCar.plate=sc.next().toUpperCase();	
		System.out.println("Type car brand:");
		newCar.brand=sc.next();
		System.out.println("Type car color:");
		newCar.color=sc.next();
			
		//wheels parameters
		System.out.println("Adding front wheels.");
		newCar.wheels.add(CreateWheel(sc));
		System.out.println("Adding back wheels.");
		newCar.wheels.add(CreateWheel(sc));
				
		//print
		System.out.println(newCar);
	}		

	public static Wheel CreateWheel(Scanner sc) {
			
		System.out.println("Type wheel brand:");
		String brandW = sc.next();
		System.out.println("Type wheel diameter:");
		double diameter=sc.nextDouble();
		
		Wheel wheel = new Wheel (brandW, diameter);
		
		return wheel;
	}
}