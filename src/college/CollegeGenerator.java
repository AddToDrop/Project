package college;

public class CollegeGenerator {
	public static College createCollege(String college){
		String col[] = college.split(" ");
		if (col[0].equals("Law"))
			return new Law(college);
		else if (col[0].equals("SCM"))
			return new SCM(college);
		else if (col[0].equals("SEE"))
			return new SEE(college);
		return null; 
	} 
}
