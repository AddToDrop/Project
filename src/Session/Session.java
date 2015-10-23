package Session;

public class Session {
	String courseCode;
	String CRN;
	int day = 0;
	int start = 0;
	int end = 0;
	
	public Session(String session){
		String[] sessionInfo = session.split(" ");
		courseCode = sessionInfo[0];
		CRN = sessionInfo[1];
		day = Integer.parseInt(sessionInfo[2]);
		start = Integer.parseInt(sessionInfo[3]);
		end = Integer.parseInt(sessionInfo[4]);
	}
	
	public String getCRN(){
		return CRN;
	}
}
