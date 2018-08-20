package com.nagarro.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

import com.nagarro.constants.Constant;

class Search implements Runnable {
	
	String file;
	
	public Search(String file) {
		this.file = file;
	}

	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line="";
			while((line=reader.readLine())!=null) {
				String[] words = line.split("\\|");
				for(String word: words) {
					System.out.print(word+" ");
				}
				System.out.println();
			}
			Thread.sleep(Constant.THREAD_EXECUTION_TIME);
			reader.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
}

public class FileContentReader {
	
	public void searchInFiles(ArrayList<String> files)  {
		ArrayList<Runnable> list = new ArrayList<Runnable>();
		for(String file: files) {
			list.add(new Search(file));
		}
		ExecutorService pool = Executors.newCachedThreadPool();
		for(Runnable task: list) {
			pool.execute(task);
		}
		pool.shutdown();
	}
}
