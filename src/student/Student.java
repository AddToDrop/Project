package student;

import java.util.ArrayList;

import session.Session;
import setup.Admin;
import course.Course;

public class Student {
	String name;
	String SID;
	String password;
	String programme;
	ArrayList<Course> prevTaken = new ArrayList<Course>();
	ArrayList<Session> registered = new ArrayList<Session>();
	
	
	public Student(String student){
		String[] studentInfo = student.split(" ");
		this.name = studentInfo[0];
		this.SID = studentInfo[1];
		this.password = Admin.hashPwd(studentInfo[2]);
		this.programme = studentInfo[3];
		
		String[] courseTakenRegistered = studentInfo[4].split("/");
		
		String[] courseTaken = courseTakenRegistered[0].split(",");
		String[] courseRegistered = courseTakenRegistered[1].split(",");
		
		Admin admin = Admin.getInstance();
		
		if (!courseTaken[0].equalsIgnoreCase("null")){
			for (int i=0;i<courseTaken.length;i++) {
				if (admin.getCourse(courseTaken[i])!=null)
					prevTaken.add(admin.getCourse(courseTaken[i]));
			}
		}
		
		if (!courseRegistered[0].equalsIgnoreCase("null")){
			for (int i=0;i<courseRegistered.length;i++) {
				String sessionCRN = courseRegistered[i].substring(courseRegistered[i].lastIndexOf("_") + 1);
				if (admin.getSession(sessionCRN)!=null)
					registered.add(admin.getSession(sessionCRN));
			}
		}
	}
	
	public String getName() {
		return this.name;
	}

	public String getSID() {
		return this.SID;
	}

	public String getPassword() {
		return this.password;
	}

	public String getProgramme() {
		return this.programme;
	}

	public ArrayList<Course> getPrevTaken() {
		return this.prevTaken;
	}
	public void setRegistered(ArrayList<Session> registered) {
		this.registered=registered;
	}
	public ArrayList<Session> getRegistered() {
		return this.registered;
	}
	
}