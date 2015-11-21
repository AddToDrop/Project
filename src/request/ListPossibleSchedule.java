package request;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import course.Course;
import session.Session;
import setup.Admin;
import student.Student;

public class ListPossibleSchedule extends Request {
	
	public void process(Student student, String command, String courseInput) {
		ArrayList<Session> registeredSessions = student.getRegistered();
		ArrayList<Course> courseInputs = new ArrayList<Course>();
		ArrayList<ArrayList<Session>> sessionsFromInputedCourses = new ArrayList<ArrayList<Session>>();
		ArrayList<Session> possibleInputCombination = new ArrayList<Session>();
		String invalid = "";
		
		//validate inputed course codes
		String[] courseCodes = courseInput.split(" ");
		for (String courseCode:courseCodes) {
			Course course = Admin.getCourse(courseCode);
			if (course!=null) {
				courseInputs.add(course);
			} else {
				invalid += courseCode + " ";
			}
		}
		
		//if all valid course code, get the possibleInputCombination first
		if (!invalid.isEmpty()) {
			outputInvalidCode(student.getSID(), command, invalid);
		} else {
			//get sessionList from each of inputed courses
			for (Course inputedCourse:courseInputs) {
				sessionsFromInputedCourses.add(inputedCourse.getSessionList());
			}
			
			//make the combinations and test time conflicts
			ArrayList<Session> tmp = new ArrayList<Session>();
			//permutation here
		}
	}
	
	private void outputInvalidCode(String SID, String command, String invalidCode) {
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		try {
			FileOutputStream fos = new FileOutputStream(result);
			fos.write(("Invalid Course Code: " + invalidCode).getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	private void outputNoResult(String SID, String command) {
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		try {
			FileOutputStream fos = new FileOutputStream(result);
			fos.write(("There is no possible schedule").getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
