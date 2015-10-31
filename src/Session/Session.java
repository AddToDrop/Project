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
		this.day = Integer.parseInt(sessionInfo[2]);
		this.start = Integer.parseInt(sessionInfo[3]);
		this.end = Integer.parseInt(sessionInfo[4]);
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
