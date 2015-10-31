package Utilities;

import java.util.ArrayList;

import Course.Course;
import Session.Session;
import Student.Student;

public class Validator {
	
	//Password Validation
	public static boolean passwordValidation(String userinputPwd,String SID){
		//await Alex's response
		if (userinputPwd.equals(Student.getPassword(SID))){
			return true;
		}else{
		return false;
		}
	}
	//Time Conflict Validation
	public static boolean timeConflictValidation(Session session1, Session session2){
		int s1=session1.getDay();
		int s1s=session1.getStart();
		int s1e=session1.getEnd();
		int s2=session2.getDay();
		int s2s=session1.getStart();
		int s2e=session1.getEnd();
		
		if (s1==s2){
			if(timeConflictCal(s1s,s2s)==timeConflictCal(s1e,s2e)==timeConflictCal(s1s,s2e)==timeConflictCal(s1e,s2s)){
				return false;
			}else return true;
		}else return false;
	}
	private static boolean timeConflictCal(int time1, int time2){
		if(time1-time2>0){
			return true;
		}
		else return false;
	}
	//Check studied Validation
	public static boolean studiedValidation(Student student, Course courseInput){
		ArrayList<Course> prevTaken = student.getPrevTaken();				
		for(Course prev:prevTaken){
			if(courseInput.isEquals(prev)){
				return false;
			}else return true;
		}
		
		
		
		return false;
	}
	//Session Validation
	
	//Course Validation
	
}

	/*
		1st: new start in between original start and end
		2nd: new end in between original start and end
		3rd: original start in between new start and end
		8 case in taotal
		detail please go to=>
		https://docs.google.com/drawings/d/1TIIiGRoavAuEsFviz_qOEFtDer6gyT-bWEETRtXjP_I/edit
		Done! Thanks Tom
	*/
	
	//Check studied Validation
	


