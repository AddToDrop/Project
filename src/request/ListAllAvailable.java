package request;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import course.Course;
import session.Session;
import setup.Admin;
import student.Student;
import utilities.Validator;

public class ListAllAvailable extends Request {

	@Override
	public void process(Student student, String command, String courseInput) {
		if (command.equalsIgnoreCase("ListAllAvailable")) {
			ArrayList<Course> taken = student.getPrevTaken();
			ArrayList<Session> registeredSessions = student.getRegistered();
			ArrayList<Course> registeredCourses = new ArrayList<Course>();
			ArrayList<Course> courseList = Admin.getCourseList();
			ArrayList<Course> availableCourses = new ArrayList<Course>();
			ArrayList<Session> availableSessions = new ArrayList<Session>();
			
			//convert registered sessions to courses
			for (Session session:registeredSessions){
				registeredCourses.add(Admin.getCourse(session.getCourseCode()));
			}
			
			//if not taken && if not registered && enroll in right programme && if satisfied the pre-requisites, then add to availableCourses
			for (Course possible : courseList) {
				if (!taken.contains(possible)) {
					if (!registeredCourses.contains(possible)) {
						if (possible.getColOrMaj().contains("ALL") || possible.getColOrMaj().contains(student.getProgramme())) {
							ArrayList<ArrayList<Course>> preReq = possible.getPreReq();
							if (preReq != null && !preReq.isEmpty()) {
								int numOfConditions = preReq.size();
								int numOfSatisfied = 0;
								for (ArrayList<Course> condition:preReq) {
									if (condition.size() == 1) {
										if (taken.contains(condition.get(0))){
											numOfSatisfied++;
										}
									} else if (condition.size() > 1) {
										for (Course subCondition:condition){
											if (taken.contains(subCondition)){
												numOfSatisfied++;
												break;
											}
										}
									}
								}
								
								if (numOfConditions==numOfSatisfied){
									availableCourses.add(possible);
								}
							} else if (preReq.size()==0) {
								availableCourses.add(possible);
							}
						}
					}
				}
			}
			
			//from available courses, get the available session that doesn't have time conflicts
			for (Course availble:availableCourses){
				ArrayList<Session> possibleList = availble.getSessionList();
				for (Session possibleSess:possibleList){
					boolean isOverlap = false;
					for (Session registeredSess:registeredSessions) {
						if (Validator.timeConflictValidation(possibleSess, registeredSess)){
							isOverlap = true;
						}
					}
					
					if (!isOverlap){
						availableSessions.add(possibleSess);
					}
				}
				
			}
			
			outputAllAvailable(student.getSID(), availableSessions, command);
		
		}
	}
	
	public void outputAllAvailable(String SID, ArrayList<Session> sessionList, String command) {
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		try {
			FileOutputStream fos = new FileOutputStream(result);
			//please close the fos asap
			ArrayList<String> strResult = new ArrayList<String>();
			strResult.add(command);
			strResult.add(System.getProperty("line.separator"));
			strResult.add("--------------------------------------------------");
			strResult.add(System.getProperty("line.separator"));
			
			String currentCourse = "";
			for (Session session:sessionList) {
				String course = "";
				if (!currentCourse.equalsIgnoreCase(session.getCourseCode())) {
					currentCourse = session.getCourseCode();
					course = System.getProperty("line.separator") + System.getProperty("line.separator") + session.getCourseCode() + " " + Admin.getCourse(session.getCourseCode()).getCourseTitle() + System.getProperty("line.separator");
				} else {
					course = System.getProperty("line.separator");
				}
				
				String tmp =  course + "CRN: " + session.getCRN() + " Time: " + session.getDayStr() + " " + session.getStart() + "-" + session.getEnd() + System.getProperty("line.separator");
				strResult.add(tmp);
			}
			
			for (String str:strResult){
				fos.write(str.getBytes());
				fos.write("\n".getBytes());
			}
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
