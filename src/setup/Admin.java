package setup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import college.College;
import college.CollegeGenerator;
import course.Course;
import course.CourseGenerator;
import major.Major;
import major.MajorGenerator;
import request.RequestProcessor;
import session.Session;
import student.Student;
import utilities.Validator;

public class Admin {
	/* read in the text file
	 * 1. session list
	 * 2. course list
	 */
	
	// Singleton Class
	private static Admin instance = new Admin();
	private ArrayList<Session> sessionList = new ArrayList<Session>();
	private ArrayList<Course> courseList = new ArrayList<Course>();
	private ArrayList<Major> majorList = new ArrayList<Major>();
	private ArrayList<College> collegeList = new ArrayList<College>();
	private ArrayList<Student> studentList = new ArrayList<Student>();

	private Admin(){
	}

	public static Admin getInstance() {
		return instance;
	}
	 
	public boolean startSetup() {
		if (makeSession(".\\SetupInfo\\SessionInfo.txt")) {
			if (makeCourse(".\\SetupInfo\\CourseInfo.txt")){
				if (linkPrereq(".\\SetupInfo\\Pre-requisitesInfo.txt")) {
					if (makeMajor(".\\SetupInfo\\Pre-requisitesInfo.txt")) {
						if (makeCollege(".\\SetupInfo\\CollegeInfo.txt")) {
							if (makeStudent(".\\SetupInfo\\StudentInfo.txt")) {
								return true;
							} else {
								System.out.println("makeStudent error");
								return false;
							}
						} else {
							System.out.println("makeCollege error");
							return false;
						}
					} else {
						System.out.println("makeMajor error");
						return false;
					}
				} else {
					System.out.println("linkPrereq error");
					return false;
				}
			} else {
				System.out.println("makeCourse error");
				return false;
			}
		} else {
			System.out.println("make session error");
			return false;
		}
	}
	
	public boolean makeSession(String path){
		File sessionInfo = new File(path);
		try {
			Scanner sessionIn = new Scanner(sessionInfo);
			
			while (sessionIn.hasNext()) {
				String session = sessionIn.nextLine(); 
				if (!session.isEmpty()) {
					Session tmp = new Session(session);
					if (getSession(tmp.getCRN())==null) {
						sessionList.add(tmp);
						//System.out.println("Session " + tmp.getCRN() + " created");
					} else {
						System.out.println("Duplicate!! " + tmp.getCRN() + " alrealy exists");
						sessionIn.close();
						return false;
					}
				}
			}
			
			sessionIn.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean makeCourse(String path){
		File CourseInfo = new File(path);
		try {
			Scanner courseIn = new Scanner(CourseInfo);
			
			while (courseIn.hasNext()) {
				String course = courseIn.nextLine();
				if (!course.isEmpty()) {
					Course tmp = CourseGenerator.createCourse(course);
					if (getCourse(tmp.getCourseCode())==null) {
						courseList.add(tmp);
						//System.out.println("Course " + tmp.getCourseCode() + " created");
					} else {
						System.out.println("Duplicate!! " + tmp.getCourseCode() + " alrealy exists");
						return false;
					}
				}
			}
			
			courseIn.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean linkPrereq(String path) {
		File preReqInfo = new File(path);
		try {
			Scanner preReqIn = new Scanner(preReqInfo);
			
			while (preReqIn.hasNext()) {
				String preReqLine = preReqIn.nextLine();
				if (!preReqLine.isEmpty()) {
					String[] preReqStr = preReqLine.split(" ");
					Course target = this.getCourse(preReqStr[0]);
					
					for (String courseName1:preReqStr[1].split("&")){
						ArrayList<Course> tmp = new ArrayList<Course>();
						if (!courseName1.contains("/")){
							tmp.add(this.getCourse(courseName1));
							target.addPreReq(tmp);
						} else {
							for (String courseName2:courseName1.split("/")){
								tmp.add(this.getCourse(courseName2));
							}
							target.addPreReq(tmp);
						}
						
					}
						
				}
			}
			preReqIn.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean makeStudent(String path){
		File StudentInfo = new File(path);
		try {
			Scanner studentIn = new Scanner(StudentInfo);
			
			while (studentIn.hasNext()) {
				String student = studentIn.nextLine();
				if (!student.isEmpty()) {
					Student tmp = new Student(student);
					if (getStudent(tmp.getSID())==null) {
						studentList.add(tmp);
						//System.out.println("Student " + tmp.getName() + " " + tmp.getSID() + " created");
					} else {
						System.out.println("Duplicate!! " + tmp.getSID() + " alrealy exists");
						return false;
					}
					
				}
			}
			studentIn.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean makeMajor(String path){
		File majorInfo = new File(path);
		try {
			Scanner majorIn = new Scanner(majorInfo);
			
			while (majorIn.hasNext()) {
				String major = majorIn.nextLine();
				if (!major.isEmpty()) {
					Major tmp = MajorGenerator.createMajor(major);
					if (tmp!=null) {
						if (this.getMajor(tmp.getName())==null) {
							majorList.add(tmp);
							//System.out.println("Major " + tmp.getName() + " created");
						} else {
							System.out.println("Duplicate!! " + tmp.getName() + " alrealy exists");
							return false;
						}
						
						
					} 
					
				}
			}
			majorIn.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean makeCollege(String path){
		File collegeInfo = new File(path);
		try {
			Scanner collegeIn = new Scanner(collegeInfo);
			
			while (collegeIn.hasNext()) {
				String college = collegeIn.nextLine();
				if (!college.isEmpty()) {
					College tmp = CollegeGenerator.createCollege(college);
					if (tmp!=null) {
						if (this.getCollege(tmp.getName())==null){
							collegeList.add(tmp);
							//System.out.println("College " + tmp.getName() + " created");
						} else {
							System.out.println("Duplicate!! " + tmp.getName() + " alrealy exists");
							return false;
						}
					} 
					
				}
			}
			collegeIn.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void getRequest() {
		File requestDir = new File (".\\Requests\\");
		File[] requests = requestDir.listFiles();
		try {
			for (File f:requests) {
				Scanner requestIn;
				requestIn = new Scanner(f);
				
				String SID = requestIn.nextLine();
				String pwd = requestIn.nextLine();
				String command = requestIn.nextLine();
				String courseInput = "";
				if (command.equalsIgnoreCase("ListPossibleSchedule")){
					courseInput = requestIn.nextLine();
				}
				requestIn.close();
				
				//login
				Student student = Validator.login(SID, pwd);
				if (student!=null) {
					RequestProcessor rp = new RequestProcessor();
					rp.processRequest(student, command, courseInput);
				} else {
					File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
					try {
						FileOutputStream fos = new FileOutputStream(result);
						
						fos.write("Invalid sid or password, Please check".getBytes());
						fos.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}		
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Session> getSessionForCourse(String courseCode){
		ArrayList<Session> tmpList = new ArrayList<Session>();
		for(Session s: sessionList){
			if(s.getCourseCode().equals(courseCode))
				tmpList.add(s);
		}
		return tmpList;
	}
	
	public ArrayList<Major> getMajorList() {
		return majorList;
	}
	
	public Session getSession(String CRN){
		for(Session s: sessionList){
			if(s.getCRN().equals(CRN))
				return s;
		}
		return null;
	}

	public Course getCourse(String courseCode) {
		for (Course c:courseList) {
			if (c.getCourseCode().equals(courseCode)) {
				//System.out.println("system: " + c.getCourseCode() + " input: " + courseCode);
				return c;
			}
		}
		return null;
	}
	
	public Major getMajor(String majorName) {
		for (Major m:majorList) {
			if (m.getName().equals(majorName)) {
				return m;
			}
		}
		return null;
	}
	
	public College getCollege(String collegeName) {
		for (College col:collegeList) {
			if (col.getName().equals(collegeName)) {
				return col;
			}
		}
		return null;
	}
	
	public Student getStudent(String SID) {
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

	public ArrayList<Course> getCourseList() {return courseList;}

	
}
