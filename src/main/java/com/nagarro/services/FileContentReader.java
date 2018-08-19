package com.nagarro.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileContentReader {
	public void searchInFile(String file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line="";
		while((line=reader.readLine())!=null) {
			String[] words = line.split("\\|");
			for(String word: words) {
				System.out.print(word+" ");
			}
			System.out.println();
		}
		reader.close();
	}
}
