package courseRegistration.scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scheduler {
	float s_average;

	public List<String> assign(List<Student> studentList,
			List<Courses> courseList) {
		
		
		Collections.sort(studentList,Student.Compareyear);  //sorting based on the year
		
		List<String> output=new ArrayList<String>();
		int sum=0;
		for(int i=0;i<studentList.size();i++){
			
			String[] course_wanted=studentList.get(i).getCourse_preference();
			int[] time = new int[3];
			int count=0;
		
			for(int j=0;j<course_wanted.length;j++) {     //course allocation
				
				for(int k=0;k<courseList.size();k++){    //to check the capacity and course per student constraint
					if(course_wanted[j].equals(courseList.get(k).getCourse_name().toString())&&(courseList.get(k).getCapacity()>0)&&count<3){
						int flag=0;
						for(int z=0;z<3;z++) {
							if(time[z]==courseList.get(k).getC_timings()) {  //checking courses with same timing
								flag=1;
							}
						}
						if(flag==0) {
						studentList.get(i).setCourses_allocated(course_wanted[j]);
						}
					//	System.out.println("coursewanted:"+course_wanted[j]);
						studentList.get(i).setS_rating(9-k);
						
						count++;
						break;
					}	
					if (count == 3)
						break;
				}
					
			}
			sum+=studentList.get(i).getS_rating();
			 s_average= (float)sum/studentList.size();     //average satisfaction rating
		}
	//	System.out.println("AVG:"+s_average);
		String ss="";
		List<String> list=new ArrayList<>();
		for(int i=0;i<studentList.size();i++) {
			
			//System.out.println(studentList.get(i).getStudent_id());
			String s=studentList.get(i).getCourses_allocated()[0];
			for(int j=1;j<studentList.get(i).getCourses_allocated().length;j++) {
				
				s+=","+studentList.get(i).getCourses_allocated()[j];
			}
			
		ss+=studentList.get(i).getStudent_id()+" : "+s+" :: "+studentList.get(i).getS_rating()+";"; // returning student id, course allocated and the satisafaction rating as a string
		   
		   
			
		}
		
		ss+=s_average;
		output.add(ss);
		return output;
	}

}
