package session;

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
	
	public boolean isEqual(Session s) {
        if(!s.getCourseCode().equals(this.getCourseCode()))
            return false;
        if(!s.getCRN().equals(this.getCRN()))
            return false;
        if(s.getDay() != this.getDay())
            return false;
        if(s.getStart() != this.getStart())
            return false;
        if(s.getEnd() != this.getEnd())
            return false;
        return true;
    }
	
	public String getDayStr() {
		if (day == 1)
			return "Monday";
		else if (day == 2)
			return "Tuesday";
		else if (day == 3)
			return "Wednesday";
		else if (day == 4)
			return "Thursday";
		else if (day == 5)
			return "Friday";
		else if (day == 6)
			return "Saturday";
		else if (day == 7)
			return "Sunday";
		else
			return "";
		
	}
}
