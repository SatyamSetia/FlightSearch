package com.nagarro.entity;

public class Flight {
	private String flightNo;
	private String departure;
	private String arrival;
	private String validTillDate;
	private int flightTime;
	private float flightDur;
	private int fare;
	private char seats;
	private String flightClass;
	
	public Flight(String flightNo,String dep,String arr,String date,String time,String duration,String fare,String seats,String flightClass) {
		this.flightNo = flightNo;
		this.departure = dep;
		this.arrival = arr;
		this.validTillDate = date;
		this.flightTime = Integer.parseInt(time);
		this.flightDur = Float.parseFloat(duration);
		this.fare = Integer.parseInt(fare);
		this.seats = seats.charAt(0);
		this.flightClass = flightClass;
	}
	
	public void printDetails() {
		System.out.println(this.flightNo+" "+this.departure+" "+this.arrival+" "+this.validTillDate+" "+this.flightTime+" "+this.flightDur+" "+this.fare+" "+this.seats+" "+this.flightClass);
	}
}