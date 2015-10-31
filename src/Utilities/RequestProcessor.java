package Utilities;

import java.util.ArrayList;

import Course.Course;
import Request.ListTakenRegistered;
import Student.Student;

public class RequestProcessor {
	public void processRequest(Student student, String command, ArrayList<String> courseList){
		if (command.equalsIgnoreCase("ListTaken") || command.equalsIgnoreCase("ListRegistered")){
			ListTakenRegistered request = new ListTakenRegistered();
			request.process(student, command);
		} else if (command.equalsIgnoreCase("ListAllAvailable")) {
			
		}
	}
		
}
