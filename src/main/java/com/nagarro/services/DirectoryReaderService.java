package com.nagarro.services;

import java.io.File;
import java.util.ArrayList;

import com.nagarro.constants.Constant;
import com.nagarro.dto.Input;
import com.nagarro.utils.FolderReader;

public class DirectoryReaderService extends Thread{
	Input input;
	OutputService searchResult;
	
	public DirectoryReaderService(InputService input) {
		this.input = input.getInputDetails();
		this.searchResult = new OutputService();
	}
	
	public void run() {
		while(true) {
			this.searchResult.emptyList();
			
			//reading folder containing all files.
			FolderReader folder = new FolderReader();
			ArrayList<String> files = folder.readFiles(new File(Constant.FOLDER_PATH));
					
			//searching flights in all files obtained from folder based on user inputs. 
			FileReaderService file = new FileReaderService();
			file.searchInFiles(files,input,searchResult);
			
			System.out.println();
			System.out.println("Number of flights: "+searchResult.numOfFlights());
			
			//sorting results based on input preference.
			if(input.getOutputPref().equals("1")) {
				searchResult.sortByFare();
			} else {
				searchResult.sortByFareAndDuration();
			}
			
			//Displaying result
			searchResult.display();
			try {
				Thread.sleep(Constant.DIRECTORY_READING_TIMEOUT);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
