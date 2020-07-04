package courseRegistration.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Results implements FileDisplayInterface , StdoutDisplayInterface {
	
	
	
	public void writeToStdout(String s) {
		
		String [] lines=s.split(";");
		  for(String line : lines) {
			  System.out.println(line);  
		      System.out.println();
		  }
		
	}
	

	public void writeToFile(String s,String args) {
		
		BufferedWriter bw = null;
	      try {
		 
		 File f = new File(args);

		  if (!f.exists()||f.exists()) {
		     f.createNewFile();
		  }

		  FileWriter fw = new FileWriter(f);
		  bw = new BufferedWriter(fw);
		  String [] lines=s.split(";");
		  for(String line : lines) {
			  
		  bw.write(line);
		  bw.newLine();

	      }
	      }catch (IOException e) {
		   e.printStackTrace();
		}
		finally
		{ 
		   try{
		      if(bw!=null)
			 bw.close();
		   }catch(Exception e){
		       System.out.println("BufferedWriter closing error "+e);
		    }
		}
	   }
		
	}

