package com.nagarro.utils;

import java.util.Comparator;

import com.nagarro.entity.Flight;

//comparator to compare two flights by fare and duration.
public class SortByBothFareAndDuration implements Comparator<Flight>{
	public int compare(Flight flight1, Flight flight2) {
		if(flight1.getFare()==flight2.getFare()) {
			return flight1.getDuration()-flight2.getDuration()>0?1:-1;
		}
		return (int) (flight1.getFare()-flight2.getFare());
	}
}
