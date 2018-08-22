package com.nagarro.dto;

import java.time.LocalDate;

public class Input {
	private String depLoc;
	private String arrLoc;
	private LocalDate flightDate;
	private String flightClass;
	private String outputPref;
	
	public void setDeparture(String dep) {
		this.depLoc = dep;
	}
	
	public void setArrival(String arrival) {
		this.arrLoc = arrival;
	}
	
	public void setFlightDate(String date) {
		this.flightDate = LocalDate.parse(date);
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
	
	public LocalDate getFlightDate() {
		return this.flightDate;
	}
	
	public String getFlightClass() {
		return this.flightClass;
	}
	
	public String getOutputPref() {
		return this.outputPref;
	}
}
