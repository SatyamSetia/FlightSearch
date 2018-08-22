package com.nagarro.flightSearch;

import java.io.IOException;
import java.util.Scanner;

import com.nagarro.services.DirectoryReaderService;
import com.nagarro.services.InputService;

public class FlightSearch {

	public static void main(String[] args) throws IOException {
		
		//taking user input
		InputService inputService = new InputService();
		inputService.getUserInputs(new Scanner(System.in));
				
		DirectoryReaderService dr = new DirectoryReaderService(inputService);
		dr.start();
	
	}

}
