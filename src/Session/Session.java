package Session;

public class Session {
	String courseCode;
	String CRN;
	String time;
	
	public Session(String session){
		String[] sessionInfo = session.split(" ");
		courseCode = sessionInfo[0];
		CRN = sessionInfo[1];
		time = sessionInfo[2];
	}
	
	public String getCRN(){
		return CRN;
	}
}