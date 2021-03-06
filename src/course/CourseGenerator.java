package course;

public class CourseGenerator {
	
	public static Course createCourse(String course){
		String[] courseInfo = course.split("#");
		String courseType = courseInfo[0];
		
		if (courseType.equals("Area1"))
			return new Area1(courseInfo);
		else if (courseType.equals("Area2"))
			return new Area2(courseInfo);
		else if (courseType.equals("Area3"))
			return new Area3(courseInfo);
		else if (courseType.equals("CollegeReq"))
			return new CollegeReq(courseInfo);	
		else if (courseType.equals("EngChiReq"))
			return new EngChiReq(courseInfo);
		else if (courseType.equals("FreeElective"))
			return new FreeElective(courseInfo);	
		else if (courseType.equals("MajorElectiveReq"))
			return new MajorElectiveReq(courseInfo);	
		else if (courseType.equals("MajorReq"))
			return new MajorReq(courseInfo);
		else if (courseType.equals("PECourse"))
			return new PECourse(courseInfo);
		return null; 
	} 
}