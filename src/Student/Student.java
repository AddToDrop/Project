package Student;

import java.util.ArrayList;

import Setup.Admin;
import Course.Course;

public class Student {
	//JEONG Alex
	String name;
	String SID;
	String password;
	String programme;
	ArrayList<Course> prevTaken = new ArrayList<Course>();
	ArrayList<Course> registered = new ArrayList<Course>();
	
	//Joshua: Alex please provide a function allowing me to get password with sid(add a parameter in getPassword(Strong sid) OR Where you store the student list
	
	public Student(String student){
		String[] studentInfo = student.split(" ");
		this.name = studentInfo[0];
		this.SID = studentInfo[1];
		this.password = Admin.hashPwd(studentInfo[2]);
		this.programme = studentInfo[3];
		
		String[] courseTakenRegistered = studentInfo[4].split("/");
		
		String[] courseTaken = courseTakenRegistered[0].split(",");
		String[] courseRegistered = courseTakenRegistered[1].split(",");
		
		for (int i=0;i<courseTaken.length;i++) {
			System.out.println("getting " + courseTaken[i]);
			prevTaken.add(Admin.getCourse(courseTaken[i]));
		}
		
		for (int i=0;i<courseRegistered.length;i++) {
			registered.add(Admin.getCourse(courseRegistered[i]));
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
	public void setRegistered(ArrayList<Course> registered) {
		this.registered=registered;
	}
	public ArrayList<Course> getRegistered() {
		return this.registered;
	}
	
}