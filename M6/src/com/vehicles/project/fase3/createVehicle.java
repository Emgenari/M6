package com.vehicles.project.fase3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class createVehicle {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean chooseVehicle=false;
		boolean isaCar=false;
		boolean isaMoto=false;
		Car newCar;
		Moto newMoto;
		String plate=null;
		String brand=null;
		String color=null;
		boolean correctPlate=false;
		
		//ask for car or moto
		do{
			System.out.println("Creating a new vehicle. Choose car or moto:");
			String typeVehicle=sc.next().toLowerCase();
			if(typeVehicle.equals("car")){
				isaCar=true;
				chooseVehicle=true;
			}else if(typeVehicle.equals("moto")){
				isaMoto=true;
				chooseVehicle=true;			
			}
		}while(chooseVehicle==false);
		
		newCar=new Car(plate, brand, color);
		newMoto=new Moto(plate, brand, color);
		
		do {
			System.out.println("Type vehicle plate:");
			plate=sc.next().toUpperCase();	
			
			Matcher m = Pattern.compile("^[0-9]{4}[A-Z]{2,3}$").matcher(plate); 
			
			if (m.find()) {
				System.out.println(plate + " is a valid plate number.");
				newCar.plate=plate;
				newMoto.plate=plate;
				correctPlate=true;
			} 
			else {
				System.out.println(plate + " is not a valid plate number. Type 4 numbers + 2-3 letters.");
				correctPlate=false;
			}
		} while(correctPlate==false);
			
		System.out.println("Type vehicle brand:");
		brand=sc.next();
		newCar.brand=brand;
		newMoto.brand=brand;
		
		System.out.println("Type vehicle color:");
		color=sc.next();
		newCar.color=color;
		newMoto.color=color;
		
		//wheels parameters
		if(isaCar==true){
			System.out.println("Adding front wheels.");
			newCar.wheels.add(CreateWheel(sc));
			System.out.println("Adding back wheels.");
			newCar.wheels.add(CreateWheel(sc));
		}else if(isaMoto==true){
			System.out.println("Adding front wheel.");
			newMoto.wheels.add(CreateWheel(sc));
			System.out.println("Adding back wheel.");
			newMoto.wheels.add(CreateWheel(sc));
		}
							
		//print
		if(isaCar==true) {
			System.out.println(newCar);	
		} else if(isaMoto==true){
			System.out.println(newMoto);
		}
		
	}		

	public static Wheel CreateWheel(Scanner sc) {
			
		boolean diameterEntry=false;
		double diameter = 0.0;
		System.out.println("Type wheel brand:");
		String brandW = sc.next();
		
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