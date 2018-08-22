package com.nagarro.entity;

import java.time.LocalDate;

import com.nagarro.utils.DateFormatter;

public class Flight {
	private String flightNo;
	private String departure;
	private String arrival;
	private LocalDate validTillDate;
	private int flightTime;
	private float flightDur;
	private float fare;
	private char seats;
	private String flightClass;
	
	//constructor initializing flight details.
	public Flight(String[] flight) {
		this.flightNo = flight[0];
		this.departure = flight[1];
		this.arrival = flight[2];
		this.validTillDate = LocalDate.parse(DateFormatter.convertToYyyymmdd(flight[3]));
		this.flightTime = Integer.parseInt(flight[4]);
		this.flightDur = Float.parseFloat(flight[5]);
		this.seats = flight[7].charAt(0);
		this.flightClass = flight[8];
		this.fare = Float.parseFloat(flight[6]);
	}
	
	public float getFare() {
		return this.fare;
	}
	
	public float getDuration() {
		return this.flightDur;
	}
	
	public LocalDate getDate() {
		return this.validTillDate;
	}
	
	
	//function to print details of each flight.
	public void printDetails() {
		System.out.println(this.flightNo+"\t\t"+this.departure+"\t\t"+this.arrival+"\t\t"+this.validTillDate+"\t\t"+this.flightTime+"\t\t"+this.flightDur+"\t\t"+this.fare+"\t\t"+this.seats+"\t\t"+this.flightClass);
	}
}