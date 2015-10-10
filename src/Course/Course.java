package Course;

import java.util.ArrayList;
import Session.Session;

public abstract class Course {
	private String courseCode;
	private String courseTitle;
	//private ArrayList<Session> session;
	
	public Course(String[] courseInfo){
		courseCode = courseInfo[1];
		courseTitle = courseInfo[2];
	}
	
	public String getCourseTitle(){
		return courseTitle;
	}
	

}