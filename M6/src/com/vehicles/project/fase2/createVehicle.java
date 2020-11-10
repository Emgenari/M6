package com.vehicles.project.fase2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class createVehicle {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Car newCar;
		String plate=null;
		String brand=null;
		String color=null;
		boolean correctPlate = false;
					
		System.out.println("Creating a new car.");
		
		//car parameters		
		newCar=new Car(plate, brand, color);
		
		//check plate
		do {
			System.out.println("Type car plate:");
			plate=sc.next().toUpperCase();	
			
			Matcher m = Pattern.compile("^[0-9]{4}[A-Z]{2,3}$").matcher(plate); 
			
			if (m.find()) {
				System.out.println(plate + " is a valid plate number.");
				newCar.plate = plate;
				correctPlate=true;
			} 
			else {
				System.out.println(plate + " is not a valid plate number. Type 4 numbers + 2-3 letters.");
				correctPlate=false;
			}
		} while(correctPlate==false);
		
			
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
			
		boolean diameterEntry=false;
		double diameter = 0.0;
		System.out.println("Type wheel brand:");
		String brandW = sc.next();
		
		//check diameter
		do {
		System.out.println("Type wheel diameter:");
		double setDiameter=sc.nextDouble();
			if(setDiameter<0.4 || setDiameter>4){
				System.out.println("Type a valid diameter between 0.4 and 4.");	
			}else{
				diameter=setDiameter;
				diameterEntry=true;
			}
		}while(diameterEntry==false);
		
		Wheel wheel = new Wheel (brandW, diameter);
		
		return wheel;
	}
}