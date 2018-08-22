package com.nagarro.utils;

public class DateFormatter {
	
	public static String convertToYyyymmdd(String date) {
		String dd = "";
		String mm = "";
		String yyyy = "";
		dd = date.substring(0,2);
		mm = date.substring(3,5);
		yyyy = date.substring(6);
		return yyyy+"-"+mm+"-"+dd;	
	}
}
