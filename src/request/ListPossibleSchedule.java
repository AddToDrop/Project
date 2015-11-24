package request;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import course.Course;
import session.Session;
import setup.Admin;
import student.Student;
import utilities.Validator;

public class ListPossibleSchedule extends Request {
	private ArrayList<ArrayList<Session>> possibleSchedule = new ArrayList<ArrayList<Session>>();
	
	public void process(Student student, String command, String courseInput) {
		ArrayList<Session> registeredSessions = student.getRegistered();
		ArrayList<Course> courseInputs = new ArrayList<Course>();
		ArrayList<ArrayList<Session>> sessionsFromInputedCourses = new ArrayList<ArrayList<Session>>();
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
			getSchedule(registeredSessions, sessionsFromInputedCourses);
			
			if (possibleSchedule.size()==0){
				outputNoResult(student.getSID(), command);
			} else {
				outputPossibleSchedule(student.getSID(), command);
			}
		}
	}
	
	//make the combinations and test time conflicts
	private void getSchedule(ArrayList<Session> registeredSessions, ArrayList<ArrayList<Session>> sessionsFromInputedCourses) {
		ArrayList<Session> tmp = registeredSessions;
		
		if (sessionsFromInputedCourses.size()==1) {
			for (Session newInput:sessionsFromInputedCourses.get(0)){
				for (Session registered:tmp){
					if (!Validator.timeConflictValidation(newInput, registered)){
						tmp.add(newInput);
						possibleSchedule.add(tmp);
						tmp = registeredSessions;
					}
				}
			}
		} else {
			for (Session newInput:sessionsFromInputedCourses.get(0)){
				for (Session registered:tmp){
					if (!Validator.timeConflictValidation(newInput, registered)){
						tmp.add(newInput);
						sessionsFromInputedCourses.remove(0);
						getSchedule(tmp, sessionsFromInputedCourses);
						tmp = registeredSessions;
					}
				}
			}
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
	
	private void outputPossibleSchedule(String SID, String command) {
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		try {
			FileOutputStream fos = new FileOutputStream(result);
			for (int i=0;i<possibleSchedule.size();i++){
				fos.write(("Possible Schedule " + i).getBytes());
				fos.write("--------------------------------------------------".getBytes());
				for (Session session:possibleSchedule.get(i)) {
					String sessionInfo = "CRN: " + session.getCRN() + " Time: " + session.getDayStr() + " " + session.getStart() + "-" + session.getEnd() + System.getProperty("line.separator");
					fos.write(sessionInfo.getBytes());
					fos.write(System.getProperty("line.separator").getBytes());
				}
			}
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}
}