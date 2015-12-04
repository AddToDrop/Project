/**
 * Integration Testing 4: Admin + Session + CourseGenerator + Course + MajorGenerator + CollegeGenerator + College + Student Class
 * Date: 
 */

package testSetup;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import major.BACM;
import major.BAS;
import major.BEngSE;
import major.BSCCM;
import major.LLB;
import major.Major;
import major.MajorGenerator;

import org.junit.Test;

import session.Session;
import setup.Admin;
import student.Student;
import college.College;
import college.CollegeGenerator;
import college.Law;
import college.SCM;
import college.SEE;
import course.Area1;
import course.Area2;
import course.Area3;
import course.CollegeReq;
import course.Course;
import course.CourseGenerator;
import course.EngChiReq;
import course.FreeElective;
import course.MajorElectiveReq;
import course.MajorReq;
import course.PECourse;
import junit.framework.TestCase;

public class IntegrationTest4 extends TestCase{
	
	@Test
    public void test_makeSession_01() throws Exception {
		String path = ".\\TestInfo\\TestMakeSession01.txt";
		Admin admin = Admin.getInstance();
		boolean result = admin.makeSession(path);
		boolean finalResult = true;
		
		if(result == true) {
			ArrayList<String> items = infoScanner(" ", 1, path);
			for(String s: items){
				if(admin.getSession(s) == null) {
					finalResult = false;
				}
			}
		} else {
			finalResult = false;
		}
		
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_makeSession_02() throws Exception {
		String path = ".\\TestInfo\\TestMakeSession02.txt";
		Admin admin = Admin.getInstance();
		boolean result = admin.makeSession(path);
		boolean finalResult = true;
		
		if(result == true) {
			ArrayList<String> items = infoScanner(" ", 1, path);
			items.add("40255");
			for(String s: items){
				if(admin.getSession(s) == null) {
					finalResult = false;
				}
			}
		} else {
			finalResult = false;
		}
		
		assertEquals(finalResult, false);
    }
	
	@Test
    public void test_makeCourse_01() throws Exception {
		String path = ".\\TestInfo\\TestMakeCourse01.txt";
		Admin admin = Admin.getInstance();
		boolean result = admin.makeCourse(path);
		boolean finalResult = true;
		
		if(result == true) {
			ArrayList<String> items = infoScanner("#", 2, path);
			for(String s: items){
				if(admin.getCourse(s) == null) {
					finalResult = false;
				}
			}
		} else {
			finalResult = false;
		}
		
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_makeCourse_02() throws Exception {
		String path = ".\\TestInfo\\TestMakeCourse02.txt";
		Admin admin = Admin.getInstance();
		boolean result = admin.makeCourse(path);
		boolean finalResult = true;
		
		if(result == true) {
			ArrayList<String> items = infoScanner("#", 2, path);
			items.add("LW4656");
			for(String s: items){
				if(admin.getCourse(s) == null) {
					finalResult = false;
				}
			}
		} else {
			finalResult = false;
		}
		
		assertEquals(finalResult, false);
    }
	

	/*
	 * makeSession
	 * makeCourse
	 * linkPrereq
	 * makeStudent
	 * makeMajor
	 * makeCollege
	 * startSetup
	 */
	
	private static ArrayList<String> infoScanner(String separator, int index, String path) {
		File info = new File(path);
		try{
			Scanner infoIn = new Scanner(info);
			ArrayList<String> result = new ArrayList<>();
			ArrayList<String> lines = new ArrayList<>();
			while(infoIn.hasNext()){
				lines.add(infoIn.nextLine());
			}
			
			for(String s: lines){
				String[] item = s.split(separator);
				result.add(item[index]);
			}
			return result;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
}
	

	
