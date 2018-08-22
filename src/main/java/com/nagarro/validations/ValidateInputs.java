package com.nagarro.validations;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ValidateInputs {
	public boolean isValidDep(String dep) {
		if(dep.length()!=3) {
			return false;
		}
		return true;
	}
	
	public boolean isValidArr(String arr) {
		if(arr.length()!=3) {
			return false;
		}
		return true;
	}
	
	public boolean isValidClass(String inputClass) {
		if(inputClass.equals("E") || inputClass.equals("B")) {
			return true;
		}
		return false;
	}
	
	public boolean isValidPref(String pref) {
		int preference;
		try {
			preference = Integer.parseInt(pref);
		} catch(NumberFormatException e) {
			return false;
		}
		if(preference==1 || preference==2) {
			return true;
		}
		return false;
	}
	
	public boolean isValidDate(String inputDate) {
		try {
			LocalDate.parse(inputDate);
		} catch(DateTimeParseException e) {
			return false;
		}
		return true;
	}
}
