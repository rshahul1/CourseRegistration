package courseRegistration.scheduler;

public class Courses {
	private int capacity;
	private int c_timings;
	static enum courses {A,B,C,D,E,F,G,H,I};
	private courses course_name;
	
public Courses(String cname,int cap,int time){
		
		this.capacity=cap;
		this.c_timings=time;
		
		switch (cname) {
		case "A": course_name= courses.A; break;
		case "B": course_name= courses.B; break;
		case "C": course_name= courses.C; break;
		case "D": course_name= courses.D; break;
		case "E": course_name= courses.E; break;
		case "F": course_name= courses.F; break;
		case "G": course_name= courses.G; break;
		case "H": course_name= courses.H; break;
		case "I": course_name= courses.I; break;
		default: course_name= courses.A; break;
		}
	}
    public int getCapacity() {
	return capacity;
    }

    public void setCapacity(int capacity) {
	this.capacity = capacity;
    }

    public int getC_timings() {
	return c_timings;
    }

    public void setC_timings(int c_timings) {
	this.c_timings = c_timings;
    }

    public courses getCourse_name() {
	return this.course_name;
    }

    public void setCourse_name(courses course_name) {
	this.course_name = course_name;
    }


}
