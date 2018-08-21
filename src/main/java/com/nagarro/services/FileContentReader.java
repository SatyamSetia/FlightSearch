package com.nagarro.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;

import com.nagarro.constants.Constant;
import com.nagarro.io.Input;
import com.nagarro.io.Output;

class Search implements Runnable {
	
	String file;
	Input searchCriteria;
	Output searchResult;
	
	public Search(String file, Input userInput, Output searchResult) {
		this.file = file;
		this.searchCriteria = userInput;
		this.searchResult = searchResult;
	}

	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line="";
			while((line=reader.readLine())!=null) {
				String[] words = line.split("\\|");
				matchFlightWithInput(searchCriteria,words);
			}
			Thread.sleep(Constant.THREAD_EXECUTION_TIME);
			reader.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void matchFlightWithInput(Input searchCriteria, String[] words) {
		if(words[1].equals(searchCriteria.getDeparture()) && words[2].equals(searchCriteria.getArrival())) {
			//System.out.println(words[0]+" "+words[1]+" "+words[2]);
			this.searchResult.addFlight(words);
		}
	}
	
}

public class FileContentReader {
	
	public void searchInFiles(ArrayList<String> files, Input userInput, Output searchResult)  {
		ArrayList<Runnable> list = new ArrayList<Runnable>();
		for(String file: files) {
			list.add(new Search(file, userInput, searchResult));
		}
		ExecutorService pool = Executors.newCachedThreadPool();
		for(Runnable task: list) {
			pool.execute(task);
		}
		try {
			pool.awaitTermination(50, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pool.shutdown();
	}
}
