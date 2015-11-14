package College;

public class CollegeGenerator {
	public static College createCollege(String college){
		if (college.equals("Law"))
			return new Law(college);
		else if (college.equals("SCM"))
			return new SCM(college);
		else if (college.equals("SEE"))
			return new SEE(college);
		return null; 
	} 
}
