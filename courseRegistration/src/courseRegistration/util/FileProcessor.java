package courseRegistration.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {
	public List<String> readLine(String filename){
		List<String> lines=new ArrayList<String>();
		String line = null;
		
		try {
			FileReader fileReader = new FileReader(filename);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while((line=bufferedReader.readLine())!=null) {
				lines.add(line);
			}
			bufferedReader.close();
		}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch(IOException e) {
			e.printStackTrace();
			
		}
		return lines;
	}

}
