package utilities;

import java.util.ArrayList;

import course.Course;
import session.Session;
import setup.Admin;
import student.Student;

public class Validator {
	
	//Password Validation
	public static Student login(String SID, String pwd){
		Admin admin = Admin.getInstance();
		Student tmp = admin.getStudent(SID);
		
		if (tmp==null){
			return null;
		}
		
		if (Admin.hashPwd(pwd).equals(tmp.getPassword())){
			return tmp;
		} else {
			return null;
		}
	}
	
	//Time Conflict Validation
	//true: overlap
	//false: no overlap
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
	


