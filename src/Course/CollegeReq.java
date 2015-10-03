package Course;

public class CollegeReq extends Course {
	String courseCode;
	String courseTitle;
	
	public CollegeReq(String[] courseInfo){
		courseCode = courseInfo[1];
		courseTitle = courseInfo[2];
	}
	
	public String getCourseTitle(){
		return courseTitle;
	}
}