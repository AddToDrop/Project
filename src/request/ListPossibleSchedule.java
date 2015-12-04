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
		Admin admin = Admin.getInstance();
		ArrayList<Session> registeredSessions = student.getRegistered();
		ArrayList<Course> courseInputs = new ArrayList<Course>();
		ArrayList<ArrayList<Session>> sessionsFromInputedCourses = new ArrayList<ArrayList<Session>>();
		String invalid = "";
		
		//validate inputed course codes
		String[] courseCodes = courseInput.split(" ");
		for (String courseCode:courseCodes) {
			Course course = admin.getCourse(courseCode);
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
		ArrayList<ArrayList<Session>> tmpInputs = (ArrayList<ArrayList<Session>>) sessionsFromInputedCourses.clone();
		ArrayList<Session> tmp = (ArrayList<Session>) registeredSessions.clone();
		
		if (sessionsFromInputedCourses.size()==1) {
			if (registeredSessions.size()==0) {
				for (Session newInput:sessionsFromInputedCourses.get(0)){
					tmp.add(newInput);
					possibleSchedule.add(tmp);
					tmp = (ArrayList<Session>) registeredSessions.clone();
				}
			} else {
				for (Session newInput:sessionsFromInputedCourses.get(0)){
					for (Session registered:registeredSessions){
						if (!Validator.timeConflictValidation(newInput, registered)){
							tmp.add(newInput);
							possibleSchedule.add(tmp);
							tmp = (ArrayList<Session>) registeredSessions.clone();
						}
					}
				}
			}
		} else {
			for (Session newInput:sessionsFromInputedCourses.get(0)){
				for (Session registered:registeredSessions){
					if (!Validator.timeConflictValidation(newInput, registered)){
						tmp.add(newInput);
						tmpInputs.remove(0);
						getSchedule(tmp, tmpInputs);
						tmpInputs = (ArrayList<ArrayList<Session>>) sessionsFromInputedCourses.clone();
						tmp = (ArrayList<Session>) registeredSessions.clone();
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
		Admin admin = Admin.getInstance();
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		try {
			FileOutputStream fos = new FileOutputStream(result);
			for (int i=0;i<possibleSchedule.size();i++){
				fos.write(("Possible Schedule " + (i+1)).getBytes());
				fos.write(System.getProperty("line.separator").getBytes());
				fos.write("--------------------------------------------------".getBytes());
				fos.write(System.getProperty("line.separator").getBytes());
				for (Session session:possibleSchedule.get(i)) {
					String courseInfo = "Course: " + session.getCourseCode() + " " + admin.getCourse(session.getCourseCode()).getCourseTitle() + System.getProperty("line.separator");
					String sessionInfo = "CRN: " + session.getCRN() + " Time: " + session.getDayStr() + " " + session.getStart() + "-" + session.getEnd() + System.getProperty("line.separator");
					fos.write(courseInfo.getBytes());
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
