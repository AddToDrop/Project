package Request;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import Course.Course;
import Session.Session;
import Setup.Admin;
import Student.Student;
import Utilities.Validator;

public class ListAllAvailable extends Request {

	@Override
	public void process(Student student, String command) {
		if (command.equalsIgnoreCase("ListAllAvailable")) {
			ArrayList<Course> taken = student.getPrevTaken();
			ArrayList<Course> registered = student.getRegistered();
			ArrayList<Course> courseList = Admin.getCourseList();
			ArrayList<Course> availableList = courseList;
			
			//List All - List Taken 
			for(Course c1: courseList) {
				for(Course c2: taken) {
					if(c1.getCourseCode().equals(c2.getCourseCode()))
							availableList.remove(c1);
				}
			}
			
			//Available - Registered
			for(Course c1: availableList) {
				for(Course c2: registered) {
					if(c1.getCourseCode().equals(c2.getCourseCode()))
							availableList.remove(c1);
				}
			}
			
			//Available - time available
			//for the registered course, which session is the registered one?
			/*
			for(Course c1: availableList){
				ArrayList<Session> sessionList = c1.getSessionList();
				for(Session s1: sessionList) {
					for(Course c2: registered) {
						ArrayList<Session> rSessionList = c2.getSessionList(); 
						int crushCounter = 0;
						for(Session s2: rSessionList) {
							if(Validator.timeConflictValidation(s1, s2) == true)
								crushCounter++;
						}
						if(crushCounter == sessionList.size())
							availableList.remove(c1);
					}
				}
			}
			*/
			//outputResult(student.getSID(), taken, command);
		}
	}
	
	public void outputResult(String SID, ArrayList<Course> courseList, String command) {
		File result = new File(".\\Result\\" + SID + "_" + command);
		try {
			FileOutputStream fos = new FileOutputStream(result);
			//please close the fos asap
			ArrayList<String> strResult = new ArrayList<String>();
			strResult.add(command);
			strResult.add("--------------------------------------------------");
			
			for (Course course:courseList) {
				String tmp = course.getCourseCode() + " " + course.getCourseTitle();
				strResult.add(tmp);
			}
			
			for (String str:strResult){
				fos.write(str.getBytes());
				fos.write("\n".getBytes());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
