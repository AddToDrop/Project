package Student;

import java.util.ArrayList;

import Course.Course;

public class Student {
	//JEONG Alex
	String name;
	String EID;
	String password;
	String programme;
	ArrayList<Course> prevTaken;
	ArrayList<Course> registered;
	
	//Joshua: Alex please provide a function allowing me to get password with sid(add a parameter in getPassword(Strong sid) OR Where you store the student list
	
	public Student(String studentInfo){
		
	}
	
	public String getName() {
		return this.name;
	}

	public String getEID() {
		return this.EID;
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