package com.nagarro.services;

import java.util.ArrayList;
import java.util.Collections;

import com.nagarro.constants.Constant;
import com.nagarro.dto.Output;
import com.nagarro.entity.Flight;
import com.nagarro.utils.SortByBothFareAndDuration;
import com.nagarro.utils.SortByFare;

public class OutputService {
	
	Output result;
	
	public OutputService() {
		this.result = new Output(); 
	}
	
	public ArrayList<Flight> getOutputList() {
		return this.result.getFlightList();
	}
	
	public void emptyList() {
		for(int i=this.getOutputList().size()-1;i>=0;i--) {
			this.getOutputList().remove(i);
		}
	}
	
	public void addFlight(String[] details,String inputClass) {
		//calculating fare on the basis of input class.
		if(inputClass.equals("B")){
			details[6] = Constant.EXTRA_FARE_PERCENTAGE*Float.parseFloat(details[6])+"";
		}
		Flight flight = new Flight(details);
		this.getOutputList().add(flight);
	}
	
	public int numOfFlights() {
		return this.getOutputList().size();
	}
	
	//using inbuilt sort method from Collection interface to sort results.
	public void sortByFare() {
		Collections.sort(this.getOutputList(),new SortByFare());
	}
	
	public void sortByFareAndDuration() {
		Collections.sort(this.getOutputList(), new SortByBothFareAndDuration());
	}
	
	//function to display all results.
	public void display() {
		System.out.println("-----------------------------------------------------");
		System.out.println("FlightNo.\tDeparture\tArrival\t\tDate\t\t\tTime\t\tDuration\tFare\t\tSeats\t\tClass");
		System.out.println();
		for(int i=0;i<this.getOutputList().size();i++) {
			this.getOutputList().get(i).printDetails();
		}
	}
	
}
