package Setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Course.Course;
import Course.CourseGenerator;
import Session.Session;

public class Admin {
	/* read in the text file
	 * 1. session list
	 * 2. course list
	 */
	private static ArrayList<Session> sessionList = new ArrayList<Session>();
	private static ArrayList<Course> courseList = new ArrayList<Course>();

	public static void main(String[] args){
		makeSession();
		makeCourse();
		
		//for print out
		for (int i=0;i<sessionList.size();i++){
			System.out.println("Session " + i + " CRN: " + sessionList.get(i).getCRN());
		}
		
		for (int i=0;i<courseList.size();i++){
			System.out.println("Course " + i + " Title: " + courseList.get(i).getCourseTitle());
		}
	}
	
	private static void makeSession(){
		File sessionInfo = new File("C:\\Users\\yanloklai3\\Desktop\\SessionInfo.txt");
		try {
			Scanner sessionIn = new Scanner(sessionInfo);
			
			while (sessionIn.hasNext()) {
				String session = sessionIn.nextLine();
				Session tmp = new Session(session);
				sessionList.add(tmp);
			}
			
			sessionIn.close();
		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void makeCourse(){
		File CourseInfo = new File("C:\\Users\\yanloklai3\\Desktop\\CourseInfo.txt");
		try {
			Scanner courseIn = new Scanner(CourseInfo);
			
			while (courseIn.hasNext()) {
				String Course = courseIn.nextLine();
				Course tmp = CourseGenerator.createCourse(Course);
				courseList.add(tmp);
			}
			
			courseIn.close();
		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Session searchSession(String CRN){
		for(Session s: sessionList){
			if(s.getCRN() == CRN)
				return s;
		}
		return null;
	}
	
	
	
}