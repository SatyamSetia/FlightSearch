package com.nagarro.flightSearch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.nagarro.constants.Constant;
import com.nagarro.services.FileContentReader;
import com.nagarro.services.FolderReader;

public class FlightSearch {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FolderReader folder = new FolderReader();
		ArrayList<String> files = folder.readFiles(new File(Constant.FOLDER_PATH));
		FileContentReader file = new FileContentReader();
		file.searchInFiles(files);
	}

}
