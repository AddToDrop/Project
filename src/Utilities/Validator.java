package Utilities;

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
<<<<<<< HEAD
	public static boolean passwordValidation(Session session1, Session session2){
		int s1=session1.getDay();
		int s1s=session1.getStart();
		int s1e=session1.getEnd();
		int s2=session2.getDay();
		int s2s=session1.getStart();
		int s2e=session1.getEnd();
		
		
		
		return false;
	}
	//Check studied Validation
	
	//Session Validation
	
	//Course Validation
	
}
=======
	/*
		1st: new start in between original start and end
		2nd: new end in between original start and end
		3rd: original start in between new start and end
		detail please go to=>
		https://docs.google.com/drawings/d/1TIIiGRoavAuEsFviz_qOEFtDer6gyT-bWEETRtXjP_I/edit
	*/
	
	//Check studied Validation
	
	//
}
>>>>>>> origin/branchjoshua
