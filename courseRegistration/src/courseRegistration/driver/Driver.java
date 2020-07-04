package courseRegistration.driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import courseRegistration.scheduler.Courses;
import courseRegistration.scheduler.Scheduler;
import courseRegistration.scheduler.Student;
import courseRegistration.util.FileProcessor;
import courseRegistration.util.Results;

public class Driver {
	
	public static void main(String args[]){
		
		if ( (args.length != 3) || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {
		    
		    System.err.println("Error: Incorrect number of arguments. Program accepts 3 argumnets.");
		    System.exit(0);
	    }
		
		FileProcessor fp=new FileProcessor();
		
		List<String> student_info=new ArrayList<String>();
		List<String> course_info=new ArrayList<String>();
		List<String> output=new ArrayList<String>();
		
		String[] init_values_s;
		String[] values_s;
		String[] preferences_s;
		
		int student_id;
		String student_year;
		
		
		String[] init_values_c=null;
		String[] values_c=null;
		String[] values1_c=null;
		String[] values2_c=null;
		
		String course_name;
		int course_capacity;
		int course_timing;
		
		student_info=fp.readLine(args[0]);
		course_info=fp.readLine(args[1]);
		
		
		List<Courses> courseList=new ArrayList<Courses>();   //parsing the course info 
		for(int i=0;i<course_info.size();i++){
			
			init_values_c=course_info.get(i).split(" ");
			course_name=init_values_c[0];
			
			values_c=init_values_c[1].split(";");
			values1_c=values_c[0].split(":");
			course_capacity=Integer.parseInt(values1_c[1]);
			
			values2_c=values_c[1].split(":");
			course_timing=Integer.parseInt(values2_c[1]);
			
		//	System.out.println(" "+course_name+" "+course_capacity+" "+course_timing);
			Courses course =new Courses(course_name,course_capacity,1);
		//	System.out.println(course.getCourse_name());
			courseList.add(course);
		}
		
	//	for(int i=0;i<courseList.size();i++) {
	//		System.out.println(" "+courseList.get(i).getCourse_name());
	//	}
		
		List<Student> studentList=new ArrayList<Student>();     //parsing the student info
		for(int i=0;i<student_info.size();i++){
			
			init_values_s=student_info.get(i).split(" ");
			student_id=Integer.parseInt(init_values_s[0]);
			
			values_s=init_values_s[1].split("::");
			
			student_year=values_s[1];
			
			preferences_s=values_s[0].split(",");
			
		//	System.out.println(" "+student_id+" "+student_year+" "+Arrays.toString(preferences_s));
			Student student = new Student(student_id,student_year,preferences_s);
			studentList.add(student);
						
		}
		
		
		
		Scheduler schedule=new Scheduler();
		
		output=schedule.assign(studentList,courseList);
		
		
		String outputString="";
		String outputString1="";
		
		for(int i=0;i<output.size();i++) {
			
			outputString1=outputString+output.get(i)+'\n';
		
		}
		
		Results r=new Results();

		r.writeToStdout(outputString1);
		r.writeToFile(outputString1,args[2]);  
		
	}

}
