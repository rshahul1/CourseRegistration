package courseRegistration.scheduler;

import java.util.Comparator;

public class Student implements Comparable<Student>{

	private int student_id;
	private int count=0;
	private String[] course_preference = new String[9];
	private String[] courses_allocated= new String[3];
	private int s_rating;
	public enum grad_level {FIRST_YEAR,SECOND_YEAR,THIRD_YEAR};
	private static grad_level level;
	
public Student(int sid,String year,String[] c_pref){
		
		this.student_id=sid;
		this.course_preference=c_pref;
		this.s_rating=0;
		
		if(year.equals("FIRST_YEAR")){
			
			Student.level=grad_level.FIRST_YEAR;
		}
		else if(year.equals("SECOND_YEAR")){
			
			Student.level=grad_level.SECOND_YEAR;
		}
		else if(year.equals("THIRD_YEAR")){
			
			Student.level=grad_level.THIRD_YEAR;
		}
		else{
			
			System.out.println("Invalid Year entry. Automatically assigning First Year");
			Student.level=grad_level.FIRST_YEAR;
		}
	}
	public int getStudent_id() {
	return student_id;
	}

	public void setStudent_id(int student_id) {
	this.student_id = student_id;
	}

	public String[] getCourse_preference() {
	return course_preference;
	}

	public void setCourse_preference(String[] course_preference) {
	this.course_preference = course_preference;
	}

	public String[] getCourses_allocated() {
	return courses_allocated;
	}

	public void setCourses_allocated(String course) {
		
	this.courses_allocated[count] = course;
	count++;
	}

	public int getS_rating() {
	return s_rating;
	}

	public void setS_rating(int s_rating) {
	this.s_rating = this.s_rating + s_rating;           //satisfaction rating of a student
	}

	public grad_level getLevel() {
	return level;
	}

	public static void setLevel(grad_level level) {
	Student.level = level;
	}
	
	public static final Comparator<Student> Compareyear=new Comparator<Student>() {
		
		
		public int compare(Student s1,Student s2) {
			
			return s1.level.compareTo(s2.level);
		}
	};


	public int compareTo(Student arg0) {
		
		return 0;
	}

}
