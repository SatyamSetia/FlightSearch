package com.nagarro.utils;

import java.io.File;
import java.util.ArrayList;

public class FolderReader {
	
	//function to return path of all files stored in any folder.
	public ArrayList<String> readFiles(File folder) {
		ArrayList<String> files = new ArrayList<String>();
		for(File file: folder.listFiles()) {
			files.add(file.getPath());
		}
		return files;
	}
}
