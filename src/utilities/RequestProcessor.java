package utilities;

import java.util.ArrayList;

import course.Course;
import request.ListAllAvailable;
import request.ListTakenRegistered;
import student.Student;

public class RequestProcessor {
	public void processRequest(Student student, String command, ArrayList<String> courseList){
		if (command.equalsIgnoreCase("ListTaken") || command.equalsIgnoreCase("ListRegistered")){
			ListTakenRegistered request = new ListTakenRegistered();
			request.process(student, command);
		} else if (command.equalsIgnoreCase("ListAllAvailable")) {
			ListAllAvailable request = new ListAllAvailable();
			request.process(student, command);
		}
	}
		
}
