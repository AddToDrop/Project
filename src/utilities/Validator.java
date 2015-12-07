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
	
	//true: overlap
	//false: no overlap
	public static boolean timeConflict(Session session1, Session session2){
		int s1=session1.getDay();
		int s1s=session1.getStart();
		int s1e=session1.getEnd();
		int s2=session2.getDay();
		int s2s=session2.getStart();
		int s2e=session2.getEnd();
		
		if (s1==s2) {
			if (s1s==s2s) {
				//same start time
				return true;
			} else if (s1e==s2e) {
				//same end time
				return true;
			} else if (s2s<s1s && s1s<s2e) {
				//if session1 start is in between session2 start and end
				return true;
			} else if (s1s<s2s && s2s<s1e) {
				//if session2 start is in between session1 start and end
				return true;
			}
			return false;
		} else {
			return false;
		}
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
	


