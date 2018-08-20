package com.nagarro.io;

import java.util.Scanner;

public class Input {
	private String depLoc;
	private String arrLoc;
	private String flightDate;
	private String flightClass;
	private String outputPref;
	
	public void setDeparture(String dep) {
		this.depLoc = dep;
	}
	
	public void setArrival(String arrival) {
		this.arrLoc = arrival;
	}
	
	public void setFlightDate(String date) {
		this.flightDate = date;
	}
	
	public void setFlightClass(String fClass) {
		this.flightClass = fClass;
	}
	
	public void setOutputPref(String pref) {
		this.outputPref = pref;
	}
	
	public String getDeparture() {
		return this.depLoc;
	}
	
	public String getArrival() {
		return this.arrLoc;
	}
	
	public String getFlightDate() {
		return this.flightDate;
	}
	
	public String getFlightClass() {
		return this.flightClass;
	}
	
	public String getOutputPref() {
		return this.outputPref;
	}
	
	public void setUserInputs(Scanner scan) {
		System.out.print("Enter Departure Location: ");
		this.setDeparture(scan.nextLine());
		System.out.print("Enter Arrival Location: ");
		this.setArrival(scan.nextLine());
		System.out.print("Enter date: ");
		this.setFlightDate(scan.nextLine());
		System.out.print("Enter class: ");
		this.setFlightClass(scan.nextLine());
		System.out.print("Enter Output Preference: ");
		this.setOutputPref(scan.nextLine());
	}
}
