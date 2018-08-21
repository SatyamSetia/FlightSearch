package com.nagarro.flightSearch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.nagarro.constants.Constant;
import com.nagarro.io.Input;
import com.nagarro.io.Output;
import com.nagarro.services.FileContentReader;
import com.nagarro.services.FolderReader;

public class FlightSearch {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FolderReader folder = new FolderReader();
		ArrayList<String> files = folder.readFiles(new File(Constant.FOLDER_PATH));
		Input input = new Input();
		input.setUserInputs(new Scanner(System.in));
		FileContentReader file = new FileContentReader();
		Output searchResult = new Output();
		file.searchInFiles(files,input,searchResult);
		searchResult.display();
	}

}
