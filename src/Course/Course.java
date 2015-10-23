package Course;

import java.util.ArrayList;
import Session.Session;

public abstract class Course {
	private String courseCode;
	private String courseTitle;
	//private HashMap key: CRN(string) value:session(object);
	
	public Course(String[] courseInfo){ //add hashmap and store
		courseCode = courseInfo[1];
		courseTitle = courseInfo[2];
		
	}
	
	public String getCourseTitle(){
		return courseTitle;
	}

	//function arraylist getCRN ()

	//function getinfo(crn, string time/day)
	

}
