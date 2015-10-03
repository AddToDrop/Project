package Course;

public class EngChiReq extends Course {
	String courseCode;
	String courseTitle;
	
	public EngChiReq(String[] courseInfo){
		courseCode = courseInfo[1];
		courseTitle = courseInfo[2];
	}
	
	public String getCourseTitle(){
		return courseTitle;
	}
}