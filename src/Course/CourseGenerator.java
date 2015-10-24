package Course;

public class CourseGenerator {
	
	public static Course createCourse(String course){
		String[] courseInfo = course.split(" ");
		String courseType = courseInfo[0];
		
		if (courseType.equals("EngChiReq"))
			return new CollegeReq(courseInfo);
		else if (courseType.equals("CollegeReq"))
			return new EngChiReq(courseInfo);
		else if (courseType.equals("MajorReq"))
			return new MajorReq(courseInfo);
		else if (courseType.equals("MajorElectiveReq"))
			return new MajorElectiveReq(courseInfo);
		else if (courseType.equals("GECourse"))
			return new GECourse(courseInfo);
		else if (courseType.equals("FreeElective"))
			return new FreeElective(courseInfo);
		else if (courseType.equals("PECourse"))
			return new PECourse(courseInfo);
			
		return null; 
	} 
}