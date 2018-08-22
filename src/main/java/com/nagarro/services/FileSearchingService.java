package com.nagarro.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

import com.nagarro.dto.Input;
import com.nagarro.utils.DateFormatter;

public class FileSearchingService implements Runnable{
	
	String file;
	Input searchCriteria;
	OutputService searchResult;
	
	public FileSearchingService(String file, Input userInput, OutputService searchResult) {
		this.file = file;
		this.searchCriteria = userInput;
		this.searchResult = searchResult;
	}

	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			reader.readLine();
			String line="";
			while((line=reader.readLine())!=null) {
				String[] words = line.split("\\|");
				matchFlightWithInput(searchCriteria,words);
			}
			reader.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//function to match each flight with user input.
	private void matchFlightWithInput(Input searchCriteria, String[] words) {
		
		boolean isSeatAvailable = words[7].equals("Y");
		boolean isFlightOperating = searchCriteria.getFlightDate().isEqual(LocalDate.parse(DateFormatter.convertToYyyymmdd(words[3]))) || searchCriteria.getFlightDate().isBefore(LocalDate.parse(DateFormatter.convertToYyyymmdd(words[3])));
		boolean hasRouteFromDepToArr = words[1].equals(searchCriteria.getDeparture()) && words[2].equals(searchCriteria.getArrival());
		boolean isInputBusinessClass = searchCriteria.getFlightClass().equals("B");
		
		if(isSeatAvailable){
			if(isFlightOperating){
				if(hasRouteFromDepToArr) {
					if(isInputBusinessClass) {
						if(words[8].equals("EB")) {
							this.searchResult.addFlight(words,"B");
						} else {
							return;
						}
					} else {
						this.searchResult.addFlight(words,"E");
					}
				}
			}
		}
		
	}
	
}
