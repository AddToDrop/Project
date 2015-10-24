package College;

public class Law extends College {
	
	public Law () {
		this.collegeName = "Law";
		
		// Setup the majors that this college has 
		collegeMajorList.add("Law");
		
		// Setup the courses that this college has
		collegeCourseList.add("LW1000");
		collegeCourseList.add("LW1001");
		collegeCourseList.add("LW1002");
		collegeCourseList.add("LW1003");
		collegeCourseList.add("LW1004");
	}
}