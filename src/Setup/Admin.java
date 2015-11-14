package Setup;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Course.Course;
import Course.CourseGenerator;
import Session.Session;
import Student.Student;
import Utilities.RequestProcessor;
import Utilities.Validator;

public class Admin {
	/* read in the text file
	 * 1. session list
	 * 2. course list
	 */
	private static ArrayList<Session> sessionList = new ArrayList<Session>();
	private static ArrayList<Course> courseList = new ArrayList<Course>();
	private static ArrayList<Student> studentList = new ArrayList<Student>();

	public static void main(String[] args){
		makeSession();
		makeCourse();
		//makeStudent();
		
		//for print out
		
		for (int i=0;i<courseList.size();i++){
			System.out.println(i+ ". Course: " + courseList.get(i) + " Title: " + courseList.get(i).getCourseTitle());
			System.out.println("--------------------------------");
			
			int nOfSess = courseList.get(i).getSessionList().size();
			if (nOfSess>=1) {
				for (int j=0; j<nOfSess; j++) {
					Session temp = (Session)courseList.get(i).getSessionList().get(j);
					System.out.println(temp.getCourseCode() + " " + temp.getCRN());
					System.out.println();
				}
			} else {
				System.out.println("No session for this course");
			}
		}
	}
	
	private static void makeSession(){
		File sessionInfo = new File(".\\SetupInfo\\SessionInfo.txt");
		try {
			Scanner sessionIn = new Scanner(sessionInfo);
			
			while (sessionIn.hasNext()) {
				String session = sessionIn.nextLine();
				if (!session.isEmpty()) {
					Session tmp = new Session(session);
					if (getSession(tmp.getCRN())==null) {
						sessionList.add(tmp);
					} else {
						System.out.println("Duplicate!! " + tmp.getCRN() + " alrealy exists");
					}
				}
			}
			
			sessionIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void makeCourse(){
		File CourseInfo = new File(".\\SetupInfo\\CourseInfo.txt");
		try {
			Scanner courseIn = new Scanner(CourseInfo);
			
			while (courseIn.hasNext()) {
				String course = courseIn.nextLine();
				if (!course.isEmpty()) {
					Course tmp = CourseGenerator.createCourse(course);
					if (getCourse(tmp.getCourseCode())==null) {
						courseList.add(tmp);
					} else {
						System.out.println("Duplicate!! " + tmp.getCourseCode() + " alrealy exists");
					}
				}
			}
			
			courseIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void makeStudent(){
		File StudentInfo = new File(".\\SetupInfo\\StudentInfo.txt");
		try {
			Scanner studentIn = new Scanner(StudentInfo);
			
			while (studentIn.hasNext()) {
				String student = studentIn.nextLine();
				if (!student.isEmpty()) {
					Student tmp = new Student(student);
					if (getStudent(tmp.getSID())==null) {
						studentList.add(tmp);
					} else {
						System.out.println("Duplicate!! " + tmp.getSID() + " alrealy exists");
					}
					
				}
			}
			studentIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void getRequest() {
		File requestDir = new File (".\\Requests\\");
		File[] requests = requestDir.listFiles();
		try {
		//login
		for (File f:requests) {
			Scanner requestIn;
			requestIn = new Scanner(f);
			
			String SID = requestIn.nextLine();
			String pwd = requestIn.nextLine();
			
			Student student = Validator.login(SID, pwd);
			
			if (student!=null) {
				String command = requestIn.nextLine();
				
				ArrayList<String> courseList = new ArrayList<String>();
				while (requestIn.hasNext()) {
					courseList.add(requestIn.nextLine());
				}
				requestIn.close();
				RequestProcessor rp = new RequestProcessor();
				rp.processRequest(student, command, courseList);
			}
		}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Session> getSessionForCourse(String courseCode){
		ArrayList<Session> tmpList = new ArrayList<Session>();
		for(Session s: sessionList){
			if(s.getCourseCode().equals(courseCode))
				tmpList.add(s);
		}
		return tmpList;
	}
	
	public static Session getSession(String CRN){
		for(Session s: sessionList){
			if(s.getCRN().equals(CRN))
				return s;
		}
		return null;
	}

	public static Course getCourse(String courseCode) {
		for (Course c:courseList) {
			if (c.getCourseCode().equals(courseCode)) {
				System.out.println("system: " + c.getCourseCode() + " input: " + courseCode);
				return c;
			}
		}
		return null;
	}
	
	public static Student getStudent(String SID) {
		for (Student s:studentList) {
			if (s.getSID().equals(SID))
				return s;
		}
		return null;
	}
	
	public static String hashPwd(String pwd) {
		String hashedPwd = "";
		
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("SHA-256");
			md.update(pwd.getBytes());
	        
	        byte byteData[] = md.digest();
	 
	        //convert the byte to hex format
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	        	sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        hashedPwd = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        
		return hashedPwd;
	}
	
	public static ArrayList<Course> getCourseList() {return courseList;}
	
}
