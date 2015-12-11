package course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import session.Session;
import setup.Admin;

public abstract class Course {
	private ArrayList<String> collegeOrMajor = new ArrayList<String>();
	private String courseCode;
	private String courseTitle;
	private HashMap<String, Session> sessionList = new HashMap<String, Session>();
	private ArrayList<ArrayList<Course>> preReqList = new ArrayList<ArrayList<Course>>();
	
	public Course(String[] courseInfo){ //add hashmap and store
		for (String colOrmaj:courseInfo[1].split("/")) {
			collegeOrMajor.add(colOrmaj);
		}
		courseCode = courseInfo[2];
		courseTitle = courseInfo[3];
		
		Admin admin = Admin.getInstance();
		ArrayList<Session> tmp = admin.getSessionForCourse(courseInfo[2]);
		if(tmp!=null){
			for (Session s:tmp) {
				sessionList.put(s.getCRN(), s);
			}
		} else {
			System.out.println("There is no session for " + courseInfo[1] + " " + courseInfo[2]);
		}
	}
	
	public ArrayList<String> getColOrMaj(){
		return collegeOrMajor;
	}
	
	public String getCourseTitle(){
		return courseTitle;
	}
	
	public String getCourseCode(){
		return courseCode;
	}
	
	public ArrayList<Session> getSessionList() {
		ArrayList<Session> session = new ArrayList<Session>();
		for(Map.Entry<String, Session> s : sessionList.entrySet()) {
			session.add(s.getValue());
		}
		return session;
	}
	

	public boolean isEquals(Course course){
		if(this.getCourseCode().equals(course.getCourseCode()))
			return true;
		else
			return false;
	}
	
	public void addPreReq(ArrayList<Course> preReq){
		preReqList.add(preReq);
	}
	
	public ArrayList<ArrayList<Course>> getPreReq(){
		return preReqList;
	}

}
