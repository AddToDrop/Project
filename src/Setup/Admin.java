package Setup;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import College.College;
import College.CollegeGenerator;
import Course.Course;
import Course.CourseGenerator;
import Major.Major;
import Major.MajorGenerator;
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
	private static ArrayList<Major> majorList = new ArrayList<Major>();
	private static ArrayList<College> collegeList = new ArrayList<College>();
	private static ArrayList<Student> studentList = new ArrayList<Student>();

	

	public static void main(String[] args){
		makeSession();
		makeCourse();
		linkPrereq();
		makeMajor();
		makeCollege();
		makeStudent();
		
		//for print out
		for (int i=0;i<courseList.size();i++){
			Course target = courseList.get(i);
			System.out.println();
			System.out.println(i+ ". Course: " + target.getCourseCode() + " Title: " + target.getCourseTitle());
			System.out.println("--------------------------------------------------");
			
			System.out.println();
			System.out.println("Session Check");
			int nOfSess = target.getSessionList().size();
			if (nOfSess>=1) {
				for (int j=0; j<nOfSess; j++) {
					Session temp = (Session)target.getSessionList().get(j);
					System.out.println("Session: " + temp.getCourseCode() + " " + temp.getCRN());
					
				}
				System.out.println();
			} else {
				System.out.println("No session for this course");
				System.out.println();
			}
			
			System.out.println();
			System.out.println("College or Major Check");
			for (String str:target.getColOrMaj()){
				System.out.println("College or Major: " + str);
			}
			
			System.out.println();
			System.out.println("PreReq Check");
			if (target.getPreReq().size()!=0){
				for (ArrayList<Course> req:target.getPreReq()){
					if (req.size()==0){
						System.out.println("No PreReq2");
					} else if (req.size()==1) {
						System.out.println(req.get(0).getCourseCode());
					} else {
						for (Course course:req) {
							System.out.println();
						}
						System.out.println();
					}
				}
			} else {
				System.out.println("No PreReq1");
			}
		}
		System.out.println();
		System.out.println();
		for (Major major:majorList) {
			System.out.println("Major: " + major.getName());
			System.out.println("--------------------------------------------------");
			for(Course course:major.getMajorElecReq()){
				System.out.println("ElecReq: " + course.getCourseCode());
			}
			for(Course course:major.getMajorReqList()){
				System.out.println("MajorReq: " + course.getCourseCode());
			}
		}
		System.out.println();
		System.out.println();
		for (College college:collegeList) {
			System.out.println("College: " + college.getName());
			System.out.println("--------------------------------------------------");
			for(Major major:college.getMajorList()){
				System.out.println("Major: " + major.getName());
			}
			for(Course course:college.getCollegeReqList()){
				System.out.println("CollegeReq: " + course.getCourseCode());
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
						System.out.println("Session " + tmp.getCRN() + " created");
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
						System.out.println("Course " + tmp.getCourseCode() + " created");
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
	private static void linkPrereq() {
		File preReqInfo = new File(".\\SetupInfo\\Pre-requisitesInfo.txt");
		try {
			Scanner preReqIn = new Scanner(preReqInfo);
			
			while (preReqIn.hasNext()) {
				String preReqLine = preReqIn.nextLine();
				if (!preReqLine.isEmpty()) {
					String[] preReqStr = preReqLine.split(" ");
					Course target = Admin.getCourse(preReqStr[0]);
					
					for (String courseName1:preReqStr[1].split("&")){
						ArrayList<Course> tmp = new ArrayList<Course>();
						if (!courseName1.contains("/")){
							tmp.add(Admin.getCourse(courseName1));
							target.addPreReq(tmp);
						} else {
							for (String courseName2:courseName1.split("/")){
								tmp.add(Admin.getCourse(courseName2));
							}
							target.addPreReq(tmp);
						}
						
					}
						
				}
			}
			preReqIn.close();
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
						System.out.println("Student " + tmp.getName() + " " + tmp.getSID() + " created");
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
	
	private static void makeMajor(){
		File majorInfo = new File(".\\SetupInfo\\MajorInfo.txt");
		try {
			Scanner majorIn = new Scanner(majorInfo);
			
			while (majorIn.hasNext()) {
				String major = majorIn.nextLine();
				if (!major.isEmpty()) {
					Major tmp = MajorGenerator.createMajor(major);
					if (tmp!=null) {
						if (Admin.getMajor(tmp.getName())==null) {
							majorList.add(tmp);
							System.out.println("Major " + tmp.getName() + " created");
						} else {
							System.out.println("Duplicate!! " + tmp.getName() + " alrealy exists");
						}
						
						
					} 
					
				}
			}
			majorIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	private static void makeCollege(){
		File collegeInfo = new File(".\\SetupInfo\\CollegeInfo.txt");
		try {
			Scanner collegeIn = new Scanner(collegeInfo);
			
			while (collegeIn.hasNext()) {
				String college = collegeIn.nextLine();
				if (!college.isEmpty()) {
					College tmp = CollegeGenerator.createCollege(college);
					if (tmp!=null) {
						if (Admin.getCollege(tmp.getName())==null){
							collegeList.add(tmp);
							System.out.println("College " + tmp.getName() + " created");
						} else {
							System.out.println("Duplicate!! " + tmp.getName() + " alrealy exists");
						}
					} 
					
				}
			}
			collegeIn.close();
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
	
	public static ArrayList<Major> getMajorList() {
		return majorList;
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
				//System.out.println("system: " + c.getCourseCode() + " input: " + courseCode);
				return c;
			}
		}
		return null;
	}
	
	public static Major getMajor(String majorName) {
		for (Major m:majorList) {
			if (m.getName().equals(majorName)) {
				return m;
			}
		}
		return null;
	}
	
	public static College getCollege(String collegeName) {
		for (College col:collegeList) {
			if (col.getName().equals(collegeName)) {
				return col;
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
