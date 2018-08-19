package com.nagarro.services;

import java.io.File;
import java.util.ArrayList;

public class FolderReader {
	public ArrayList<String> readFiles(File folder) {
		ArrayList<String> files = new ArrayList<String>();
		for(File file: folder.listFiles()) {
			files.add(file.getPath());
		}
		return files;
	}
}
