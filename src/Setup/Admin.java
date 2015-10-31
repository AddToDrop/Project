package Setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import Course.Course;
import Course.CourseGenerator;
import Session.Session;
import Student.Student;

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
		makeStudent();
		
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
				String course = courseIn.nextLine();
				Course tmp = CourseGenerator.createCourse(course);
				courseList.add(tmp);
			}
			
			courseIn.close();
		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void makeStudent(){
		File StudentInfo = new File("C:\\Users\\yanloklai3\\Desktop\\StudentInfo.txt");
		try {
			Scanner studentIn = new Scanner(StudentInfo);
			
			while (studentIn.hasNext()) {
				String student = studentIn.nextLine();
				Student tmp = new Student(student);
				studentList.add(tmp);
			}
			
			studentIn.close();
		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Session searchSession(String CRN){
		for(Session s: sessionList){
			if(s.getCRN().equals(CRN))
				return s;
		}
		return null;
	}

	public static Course getCourse(String courseCode) {
		for (Course c:courseList) {
			if (c.getCourseCode().equals(courseCode)) {
				return c;
			}
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
	
	public static Student getStudent(String SID) {
		for (Student s:studentList) {
			if (s.getSID().equals(SID))
				return s;
		}
		return null;
	}
	
}