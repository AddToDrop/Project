package Course;

public class CollegeReq extends Course {
	
	public CollegeReq(String[] courseInfo){
		super(courseInfo);
	}
	
	public boolean fulfillReq(){
		return false;
	}
}