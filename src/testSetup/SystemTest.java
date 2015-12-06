package testSetup;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import college.College;
import course.Course;
import junit.framework.TestCase;
import major.Major;
import session.Session;
import setup.Admin;
import student.Student;

public class SystemTest {
	
	@Test
    public void test_startSetup_01() throws Exception {
		Admin admin = Admin.getInstance();
		admin.startSetup();
		boolean finalResult = false;
		
		String sessionPath = ".\\SetupInfo\\SessionInfo.txt";
		String coursePath = ".\\SetupInfo\\CourseInfo.txt";
		String prereqPath = ".\\SetupInfo\\Pre-requisitesInfo.txt";
		String majorPath = ".\\SetupInfo\\MajorInfo.txt";
		String collegePath = ".\\SetupInfo\\CollegeInfo.txt";
		String studentPath = ".\\SetupInfo\\StudentInfo.txt";
		int sessionCounter = 0;
		int courseCounter = 0;
		int prereqCounter = 0;
		int majorCounter = 0;
		int collegeCounter = 0;
		int studentCounter = 0;
		
		ArrayList<Course> courseList = admin.getCourseList();
		for(Course c: courseList) {
			ArrayList<Session> sessionList = admin.getSessionForCourse(c.getCourseCode());
			sessionCounter += sessionList.size();
			
			ArrayList<ArrayList<Course>> prereqList = c.getPreReq();
			if(prereqList.size() != 0) {
				prereqCounter++;
			}
		}
		
		courseCounter += courseList.size();
		
		ArrayList<Major> majorList = admin.getMajorList();
		majorCounter += majorList.size();
		
		ArrayList<College> collegeList = admin.getCollegeList();
		collegeCounter += collegeList.size();
		
		ArrayList<Student> studentList = admin.getStudentList();
		studentCounter += studentList.size();
		
		if(sessionCounter == infoScannerSize(sessionPath)) {
			if(courseCounter == infoScannerSize(coursePath)) {
				if(prereqCounter == infoScannerSize(prereqPath)) {
					if(majorCounter == infoScannerSize(majorPath)) {
						if(collegeCounter == infoScannerSize(collegePath)) {
							if(studentCounter == infoScannerSize(studentPath)) {
								finalResult = true;
							}
						}
					}
				}
			}
		}
		
		assertEquals(finalResult, true);
    }
	
	
	
	
	private static int infoScannerSize(String path) {
		File info = new File(path);
		try{
			Scanner infoIn = new Scanner(info);
			ArrayList<String> lines = new ArrayList<>();
			while(infoIn.hasNext()){
				lines.add(infoIn.nextLine());
			}
			
			return lines.size();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
		
		
	}
}
