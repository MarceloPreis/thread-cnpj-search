package src;

import java.io.File;
import java.util.ArrayList;

public class FileManager {
	private String path;
	private ArrayList<String> files;
	
	public FileManager(String path) {
		this.path = path;
		this.files = new ArrayList<String>();
	}
	
	public FileManager scanDir() {
		File directory = new File(this.path);
		String [] directoryContents = directory.list();
		
		for(String fileName: directoryContents) {
		    File temp = new File(String.valueOf(directory),fileName);
		    this.files.add(String.valueOf(temp));
		}
		
		return this;
	}
	
	public ArrayList<String> getFiles() {
		return this.files;
	}
	
	public int fileCount() {
		return this.files.size();	
	}
	
}
