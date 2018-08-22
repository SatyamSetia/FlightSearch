package com.nagarro.utils;

import java.util.Comparator;

import com.nagarro.entity.Flight;

//Comparator to compare two flights by fare.
public class SortByFare implements Comparator<Flight>{

	public int compare(Flight flight1, Flight flight2) {
		if(flight1.getFare()==flight2.getFare()){
			return 0;
		}
		return flight1.getFare()>flight2.getFare()?1:-1;
	}
}
