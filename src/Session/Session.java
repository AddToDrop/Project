package Session;

public class Session {
	String courseCode;
	String CRN;
	int day = 0;
	int start = 0;
	int end = 0;
	
	public Session(String session){
		String[] sessionInfo = session.split(" ");
		this.courseCode = sessionInfo[0];
		this.CRN = sessionInfo[1];
		
		String[] sessionTime = sessionInfo[2].split("/");
		this.day = Integer.parseInt(sessionTime[0]);
		this.start = Integer.parseInt(sessionTime[1]);
		this.end = Integer.parseInt(sessionTime[2]);
	}
	
	public String getCourseCode(){
		return courseCode;
	}
	
	public String getCRN(){
		return CRN;
	}
	
	public int getDay(){
		return day;
	}
	
	public int getStart(){
		return start;
	}
	public int getEnd(){
		return end;
	}
}
