package com.nagarro.services;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;

import com.nagarro.constants.Constant;
import com.nagarro.dto.Input;


public class FileReaderService {
	
	public void searchInFiles(ArrayList<String> files, Input userInput, OutputService searchResult)  {
		ArrayList<Runnable> list = new ArrayList<Runnable>();
		for(String file: files) {
			list.add(new FileSearchingService(file, userInput, searchResult));
		}
		
		//thread pool is created.
		ExecutorService pool = Executors.newCachedThreadPool();
		for(Runnable task: list) {
			pool.execute(task);
		}
		
		// this is done to complete processing of single thread.
		try {
			pool.awaitTermination(Constant.THREAD_TIMEOUT, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pool.shutdown();
	}
}
