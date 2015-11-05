package Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Session.Session;
import Setup.Admin;

public abstract class Course {
	private String courseCode;
	private String courseTitle;
	private HashMap<String, Session> sessionList = new HashMap<String, Session>();
	
	public Course(String[] courseInfo){ //add hashmap and store
		courseCode = courseInfo[1];
		courseTitle = courseInfo[2];
		
		ArrayList<Session> tmp = Admin.getSessionForCourse(courseInfo[1]);
		if(tmp!=null){
			for (Session s:tmp) {
				sessionList.put(s.getCRN(), s);
			}
		} else {
			System.out.println("There is no session for " + courseInfo[1] + " " + courseInfo[2]);
		}
	}
	
	public String getCourseTitle(){
		return courseTitle;
	}
	
	public String getCourseCode(){
		return courseCode;
	}
	
	public ArrayList getSessionList() {
		ArrayList<Session> session = new ArrayList<Session>();
		for(Map.Entry<String, Session> s : sessionList.entrySet()) {
			session.add(s.getValue());
		}
		return session;
	}
	
	//function arraylist getCRN ()
	public ArrayList<String> getSessionCRN(){
		ArrayList<String> sessionCRNList = new ArrayList<String>();
		Set<String> keys = sessionList.keySet();
		
		for(String key:keys) {
			String code = sessionList.get(key).getCRN();
			sessionCRNList.add(code);
		}
		return sessionCRNList;
	}

	//function getinfo(crn, string time/day) non static
	public int getInfo(String CRN, String info){
		Session session = sessionList.get(CRN);
		int time = 0;
		if(info.equals("day"))
			time = session.getDay();
		else if(info.equals("start"))
			time = session.getStart();
		else if(info.equals("end"))
			time = session.getEnd();
		return time;
	}
	
	//static version
	public static int getSessionInfo(String CRN, String info){
		Session session = Admin.getSession(CRN);
		int time = 0;
		if(info.equals("day"))
			time = session.getDay();
		else if(info.equals("start"))
			time = session.getStart();
		else if(info.equals("end"))
			time = session.getEnd();
		return time;
	}
	
	public boolean isEquals(Course course){
		if(this.getCourseCode().equals(course.getCourseCode()))
			return true;
		else
			return false;
	}

}
