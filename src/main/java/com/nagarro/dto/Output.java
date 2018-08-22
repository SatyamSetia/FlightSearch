package com.nagarro.dto;

import java.util.ArrayList;

import com.nagarro.entity.Flight;

public class Output {
	ArrayList<Flight> flightList;
	
	//constructor initializing result list.
	public Output() {
		this.flightList = new ArrayList<Flight>();
	}
	
	public ArrayList<Flight> getFlightList() {
		return this.flightList;
	}
}
