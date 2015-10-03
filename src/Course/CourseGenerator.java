package Course;

public class CourseGenerator {
	
	public static Course createCourse(String course){
		String[] courseInfo = course.split(" ");
		String courseType = courseInfo[0];
		
		if (courseType.equals("CollegeReq"))
			return new CollegeReq(courseInfo);
		else if (courseType.equals("EngChiReq"))
			return new EngChiReq(courseInfo);
			
		return null; 
	} 
}