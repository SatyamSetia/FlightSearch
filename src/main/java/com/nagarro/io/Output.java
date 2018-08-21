package com.nagarro.io;

import java.util.ArrayList;

import com.nagarro.entity.Flight;

public class Output {
	ArrayList<Flight> result;
	
	public Output() {
		this.result = new ArrayList<Flight>();
	}
	
	public void addFlight(String[] details) {
		Flight flight = new Flight(details[0],details[1],details[2],details[3],details[4],details[5],details[6],details[7],details[8]);
		result.add(flight);
	}
	
	public void display() {
		System.out.println(this.result.size());
		for(int i=0;i<this.result.size();i++) {
			this.result.get(i).printDetails();
		}
	}
}
