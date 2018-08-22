package com.nagarro.services;

import java.util.Scanner;

import com.nagarro.dto.Input;
import com.nagarro.validations.ValidateInputs;

public class InputService {
	
	Input input;
	
	public InputService() {
		this.input = new Input();
	}
	
	public Input getInputDetails() {
		return this.input;
	}
	
	//function to get input from user and validate before setting.
	public void getUserInputs(Scanner scan) {
		ValidateInputs valObj = new ValidateInputs();
			
		System.out.print("Enter Departure Location: ");
		String dep = scan.nextLine();
		this.input.setDeparture(validateDeparture(dep,valObj,scan).toUpperCase());
		
		System.out.print("Enter Arrival Location: ");
		String arrival =scan.nextLine();
		this.input.setArrival(validateArrival(arrival,valObj,scan).toUpperCase());
		
		System.out.print("Enter date (yyyy-mm-dd): ");
		String inputDate = scan.nextLine();
		this.input.setFlightDate(validateDate(inputDate,valObj,scan));
			
		System.out.print("Enter class: ");
		String inputClass = scan.nextLine().toUpperCase();
		this.input.setFlightClass(validateClass(inputClass,valObj,scan));
			
		System.out.println("Enter Output Preference (1/2): ");
		System.out.println("(1) By Fare\t (2) By both Fare and Duration");
		String preference = scan.nextLine();
		this.input.setOutputPref(validatePref(preference,valObj,scan));
	}
		
	private String validateDeparture(String departure, ValidateInputs valObj,Scanner scan) {
		while(!valObj.isValidDep(departure)){
			System.out.print("Invalid Departure!! Please re-enter: ");
			departure = scan.nextLine();
		}
		return departure;
	}
	
	private String validateArrival(String arrival, ValidateInputs valObj,Scanner scan) {
		while(!valObj.isValidArr(arrival)){
			System.out.print("Invalid Arrival!! Please re-enter: ");
			arrival = scan.nextLine();
		}
		return arrival;
	}
		
	private String validateClass(String inputClass, ValidateInputs valObj,Scanner scan) {
		while(!valObj.isValidClass(inputClass)) {
			System.out.print("Invalid Class!! Please re-enter: ");
			inputClass = scan.nextLine().toUpperCase();
		}
		return inputClass;
	}
	
	private String validatePref(String pref, ValidateInputs valObj,Scanner scan) {
		while(!valObj.isValidPref(pref)) {
			System.out.print("Invalid Preference!! Please re-enter: ");
			pref = scan.nextLine();
		}
		return pref;
	}
	
	private String validateDate(String inputDate, ValidateInputs valObj, Scanner scan) {
		while(!valObj.isValidDate(inputDate)) {
			System.out.print("Invalid Date!! Please re-enter: ");
			inputDate = scan.nextLine();
		}
		return inputDate;
	}

}
