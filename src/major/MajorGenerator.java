package major;

public class MajorGenerator {
	public static Major createMajor(String major){
		if (major.equals("LLB"))
			return new LLB(major);
		else if (major.equals("BACM"))
			return new BACM(major);
		else if (major.equals("BSCCM"))
			return new BSCCM(major);
		else if (major.equals("BAS"))
			return new BAS(major);	
		else if (major.equals("BEngSE"))
			return new BEngSE(major);
		return null; 
	} 
}
