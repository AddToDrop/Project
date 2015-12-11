package testTotal;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import junitx.framework.FileAssert;
import major.BACM;
import major.BAS;
import major.BEngSE;
import major.BSCCM;
import major.LLB;
import major.Major;
import major.MajorGenerator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
import request.ListAllAvailable;
import request.ListPossibleSchedule;
import request.ListTakenRegistered;
import request.RequestProcessor;
import session.Session;
import setup.Admin;
import student.Student;

public class TestTotal {

	public void setup(){
		Admin admin = Admin.getInstance();
		admin.startSetup();
	}
	
	@After
	public void init(){
		Admin.init();
	}
	
	public void getReq(){
		Admin admin = Admin.getInstance();
		admin.startSetup();
		admin.getRequest();
	}
	
	@Test
    public void test_getCourseCode_010() throws Exception {
		Session s1 = new Session("GE1101 46620 3/1000/1150");
		String result = s1.getCourseCode();
		assertEquals(result, "GE1101");
    }
	
	@Test
    public void test_getCourseCode_02() throws Exception {
		Session s2 = new Session("CS2116 45516 5/1300/1450");
		String result = s2.getCourseCode();
		assertEquals(result, "CS2116");
    }
	
	@Test
    public void test_getCRN_01() throws Exception {
		Session s1 = new Session("GE1101 46620 3/1000/1150");
		String result = s1.getCRN();
		assertEquals(result, "46620");
    }
	
	@Test
    public void test_getCRN_02() throws Exception {
		Session s2 = new Session("CS2116 45516 5/1300/1450");
		String result = s2.getCRN();
		assertEquals(result, "45516");
    }
	
	@Test
    public void test_getDay_01() throws Exception {
		Session s1 = new Session("GE1101 46620 3/1000/1150");
		int result = s1.getDay();
		assertEquals(result, 3);
    }
	
	@Test
    public void test_getDay_02() throws Exception {
		Session s2 = new Session("CS2116 45516 5/1300/1450");
		int result = s2.getDay();
		assertEquals(result, 5);
    }
	
	@Test
    public void test_getStart_01() throws Exception {
		Session s1 = new Session("GE1101 46620 3/1000/1150");
		int result = s1.getStart();
		assertEquals(result, 1000);
    }
	
	@Test
    public void test_getStart_02() throws Exception {
		Session s2 = new Session("CS2116 45516 5/1300/1450");
		int result = s2.getStart();
		assertEquals(result, 1300);
    }
	
	@Test
    public void test_getEnd_01() throws Exception {
		Session s1 = new Session("GE1101 46620 3/1000/1150");
		int result = s1.getEnd();
		assertEquals(result, 1150);
    }
	
	@Test
    public void test_getEnd_02() throws Exception {
		Session s2 = new Session("CS2116 45516 5/1300/1450");
		int result = s2.getEnd();
		assertEquals(result, 1450);
    }
	
	@Test
    public void test_isEqual_01() throws Exception {
		Session s1 = new Session("CS2116 45516 5/1300/1450");
		Session s2 = new Session("CS2116 45516 5/1300/1450");
		boolean result = s1.isEqual(s2);
		assertEquals(result, true);
    }
	
	@Test
    public void test_isEqual_02() throws Exception {
		Session s1 = new Session("CS2116 45516 5/1300/1450");
		Session s2 = new Session("CS2116 45516 5/1200/1350");
		boolean result = s1.isEqual(s2);
		assertEquals(result, false);
    }
	
	@Test
    public void test_isEqual_03() throws Exception {
		Session s1 = new Session("CS2116 45516 5/1300/1450");
		Session s2 = new Session("CS2115 45517 5/1300/1450");
		boolean result = s1.isEqual(s2);
		assertEquals(result, false);
    }
	
	@Test
    public void test_isEqual_04() throws Exception {
		Session s1 = new Session("CS2116 45516 5/1300/1450");
		Session s2 = new Session("CS2116 45515 5/1300/1450");
		boolean result = s1.isEqual(s2);
		assertEquals(result, false);
    }
	
	@Test
    public void test_isEqual_05() throws Exception {
		Session s1 = new Session("CS2116 45516 5/1300/1450");
		Session s2 = new Session("CS2116 45516 5/1300/1350");
		boolean result = s1.isEqual(s2);
		assertEquals(result, false);
    }
	
	@Test
    public void test_isEqual_06() throws Exception {
		Session s1 = new Session("CS2116 45516 5/1300/1450");
		Session s2 = new Session("CS2116 45516 3/1300/1350");
		boolean result = s1.isEqual(s2);
		assertEquals(result, false);
    }
	
	@Test
	public void test_getDayStr_01() throws Exception {
		Session s1 = new Session("GE1104 46444 1/1400/1550");
		String result = s1.getDayStr();
		assertEquals(result, "Monday");
	}
	
	@Test
	public void test_getDayStr_02() throws Exception {
		Session s1 = new Session("GE1107 47039 2/1200/1350");
		String result = s1.getDayStr();
		assertEquals(result, "Tuesday");
	}
	
	@Test
	public void test_getDayStr_03() throws Exception {
		Session s1 = new Session("GE1101 46620 3/1000/1150");
		String result = s1.getDayStr();
		assertEquals(result, "Wednesday");
	}
	
	@Test
	public void test_getDayStr_04() throws Exception {
		Session s1 = new Session("GE1201 47500 4/1200/1450");
		String result = s1.getDayStr();
		assertEquals(result, "Thursday");
	}
	
	@Test
	public void test_getDayStr_05() throws Exception {
		Session s1 = new Session("CS2116 45516 5/1300/1450");
		String result = s1.getDayStr();
		assertEquals(result, "Friday");
	}
	
	@Test
	public void test_getDayStr_06() throws Exception {
		Session s1 = new Session("GE1305 43911 6/1200/1250");
		String result = s1.getDayStr();
		assertEquals(result, "Saturday");
	}
	
	@Test
	public void test_getDayStr_07() throws Exception {
		Session s1 = new Session("CLA2602 36606 7/0900/1150");
		String result = s1.getDayStr();
		assertEquals(result, "Sunday");
	}
	
	@Test
	public void test_getDayStr_08() throws Exception {
		Session s1 = new Session("CLA2602 36606 9/0900/1150");
		String result = s1.getDayStr();
		assertEquals(result, "");
	}
	
	@Test
    public void test_getColOrMaj_001() throws Exception {
		String[] courseInfo = {"Area1", "ALL", "GE1104", "Chinese Cultural Canonsand Their Modern Application"};
		Course c1 = new Area1(courseInfo);
		ArrayList<String> result = c1.getColOrMaj();
		ArrayList<String> colOrMaj = new ArrayList<>(Arrays.asList("ALL"));
		assertEquals(result, colOrMaj);
    }
	
	@Test
    public void test_getColOrMaj_002() throws Exception {
		String[] courseInfo = {"MajorElectiveReq", "BACM/BSCCM/BAS", "SM3703", "Media Art and the Environment"};
		Course c1 = new MajorElectiveReq(courseInfo);
		ArrayList<String> result = c1.getColOrMaj();
		ArrayList<String> colOrMaj = new ArrayList<>(Arrays.asList("BACM", "BSCCM", "BAS"));
		assertEquals(result, colOrMaj);
    }
	
	@Test
    public void test_getCourseTitle_001() throws Exception {
		String[] courseInfo = {"Area2", "ALL", "GE1201", "Information Management and Its Social Impact"};
		Course c1 = new Area2(courseInfo);
		String result = c1.getCourseTitle();
		assertEquals(result, "Information Management and Its Social Impact");
    }
	
	@Test
    public void test_getCourseCode_001() throws Exception {
		String[] courseInfo = {"Area3", "ALL", "GE1301", "Climate Change and Extreme Weather"};
		Course c1 = new Area3(courseInfo);
		String result = c1.getCourseCode();
		assertEquals(result, "GE1301");
		
    }
	
	@Test
    public void test_isEquals_01() throws Exception {
		String[] courseInfo1 = {"CollegeReq", "SCM", "SM1701", "Contemporary and New Media Art"};
		String[] courseInfo2 = {"CollegeReq", "SCM", "SM1701", "Contemporary and New Media Art"};
		Course c1 = new CollegeReq(courseInfo1);
		Course c2 = new CollegeReq(courseInfo2);
		boolean result = c1.isEquals(c2);
		assertEquals(result, true);
    }
	
	@Test
    public void test_isEquals_02() throws Exception {
		String[] courseInfo1 = {"MajorReq", "BACM/BSCCM/BAS", "SM2704", "Creative Media Studio II"};
		String[] courseInfo2 = {"MajorReq", "BACM/BSCCM/BAS", "SM2705", "Creative Media Studio III : Technology, Coding and Tangible Media"};
		Course c1 = new MajorReq(courseInfo1);
		Course c2 = new MajorReq(courseInfo2);
		boolean result = c1.isEquals(c2);
		assertEquals(result, false);
    }
	
	@Test
    public void test_getName_010() throws Exception {
		Major m1 = new BACM("Bachelor of Arts in Creative Media");
		String result = m1.getName();
		assertEquals(result, "Bachelor of Arts in Creative Media");
    }
	
	@Test
    public void test_getName_020() throws Exception {
		Major m1 = new BAS("Bachelor of Arts and Science in New Media");
		String result = m1.getName();
		assertEquals(result, "Bachelor of Arts and Science in New Media");
    }
	
	@Test
    public void test_getName_030() throws Exception {
		Major m1 = new BSCCM("Bachelor of Science in Creative Media");
		String result = m1.getName();
		assertEquals(result, "Bachelor of Science in Creative Media");
    }
	
	@Test
    public void test_getName_004() throws Exception {
		Major m1 = new BEngSE("Bachelor of Engineering in Energy Science and Engineering");
		String result = m1.getName();
		assertEquals(result, "Bachelor of Engineering in Energy Science and Engineering");
    }
	
	@Test
    public void test_getName_005() throws Exception {
		Major m1 = new LLB("Bachelor of Laws");
		String result = m1.getName();
		assertEquals(result, "Bachelor of Laws");
    }
	
	@Test
    public void test_getName_0100() throws Exception {
		College c1 = new Law("Law LLB");
		String result = c1.getName();
		assertEquals(result, "Law");
    }
	
	@Test
    public void test_getName_0200() throws Exception {
		College c1 = new SCM("SCM BACM/BSCCM/BAS");
		String result = c1.getName();
		assertEquals(result, "SCM");
    }
	
	@Test
    public void test_getName_0003() throws Exception {
		College c1 = new SEE("SEE BEngSE");
		String result = c1.getName();
		assertEquals(result, "SEE");
    }
	
	@Test
    public void test_getName_0001() throws Exception {
		Student s1 = new Student("RonaldRichardson 50000001 password LLB NULL/GE1401_47326,GE1202_44812,LW2600_39585");
		String result = s1.getName();
		assertEquals(result, "RonaldRichardson");
    }
	
	@Test
    public void test_getName_0002() throws Exception {
		Student s1 = new Student("EdnaBuchanan 50000005 password BACM NULL/GE1401_47327,SM1701_39195,SM1702_38734,CS1103_47967");
		String result = s1.getName();
		assertEquals(result, "EdnaBuchanan");
    }
	
	@Test
    public void test_getSID_01() throws Exception {
		Student s1 = new Student("RonaldRichardson 50000001 password LLB NULL/GE1401_47326,GE1202_44812,LW2600_39585");
		String result = s1.getSID();
		assertEquals(result, "50000001");
    }
	
	@Test
    public void test_getSID_02() throws Exception {
		Student s1 = new Student("EdnaBuchanan 50000005 password BACM NULL/GE1401_47327,SM1701_39195,SM1702_38734,CS1103_47967");
		String result = s1.getSID();
		assertEquals(result, "50000005");
    }
	
	@Test
    public void test_getPassword_01() throws Exception {
		Student s1 = new Student("RonaldRichardson 50000001 password LLB NULL/GE1401_47326,GE1202_44812,LW2600_39585");
		String result = s1.getPassword();
		Admin admin = Admin.getInstance();
		String pwd = admin.hashPwd("password");
		assertEquals(result, pwd);
    }
	
	@Test
    public void test_getPassword_02() throws Exception {
		Student s1 = new Student("EdnaBuchanan 50000005 password BACM NULL/GE1401_47327,SM1701_39195,SM1702_38734,CS1103_47967");
		String result = s1.getPassword();
		Admin admin = Admin.getInstance();
		String pwd = admin.hashPwd("password");
		assertEquals(result, pwd);
    }
	
	@Test
    public void test_getProgramme_01() throws Exception {
		Student s1 = new Student("RonaldRichardson 50000001 password LLB NULL/GE1401_47326,GE1202_44812,LW2600_39585");
		String result = s1.getProgramme();
		assertEquals(result, "LLB");
    }
	
	@Test
    public void test_getProgramme_02() throws Exception {
		Student s1 = new Student("EdnaBuchanan 50000005 password BACM NULL/GE1401_47327,SM1701_39195,SM1702_38734,CS1103_47967");
		String result = s1.getProgramme();
		assertEquals(result, "BACM");
    }
	
	@Test
    public void test_setRegistered_01() throws Exception {
		boolean finalResult = false;
		Student st1 = new Student("BrandiVaughn 50000004 password LLB GE1401,GE1202,GE1107,GE1112,GE1310,GE2411,LW2600,LW2602A,LW2602B,LW2601,LW2603A,LW2603B,LW2665,LW3604,LW3609,LW3605A,LW3605B,LW3606A,LW3606B,LW3607A,LW3607B,LW4656,LW4616,LW4630,LW4657,LW3608,CLN2601/NULL");
		Session ss1 = new Session("PED1102 16425 2/1000/1150");
		ArrayList<Session> registered = new ArrayList<>();
		registered.add(ss1);
		st1.setRegistered(registered);
		
		if(st1.getRegistered().equals(registered))
			finalResult = true;
		assertEquals(finalResult, true);
    }

	@Test
    public void test_setRegistered_02() throws Exception {
		boolean finalResult = false;
		Student st1 = new Student("BrandiVaughn 50000004 password LLB GE1401,GE1202,GE1107,GE1112,GE1310,GE2411,LW2600,LW2602A,LW2602B,LW2601,LW2603A,LW2603B,LW2665,LW3604,LW3609,LW3605A,LW3605B,LW3606A,LW3606B,LW3607A,LW3607B,LW4656,LW4616,LW4630,LW4657,LW3608,CLA2601/NULL");
		Session ss1 = new Session("PED1102 16425 2/1000/1150");
		Session ss2 = new Session("CLA2602 36606 5/0900/1150");
		ArrayList<Session> registered = new ArrayList<>();
		registered.add(ss1);
		registered.add(ss2);
		st1.setRegistered(registered);
		
		if(st1.getRegistered().equals(registered))
			finalResult = true;
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_createCourse_01() throws Exception {
		boolean finalResult = false;
		Course c1 = CourseGenerator.createCourse("Area1#ALL#GE1101#Chinese Cultural Heritagein Modern Perspective");
		if(c1 instanceof Area1) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_createCourse_02() throws Exception {
		boolean finalResult = false;
		Course c1 = CourseGenerator.createCourse("Area2#ALL#GE1201#Information Management and Its Social Impact");
		if(c1 instanceof Area2) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_createCourse_03() throws Exception {
		boolean finalResult = false;
		Course c1 = CourseGenerator.createCourse("Area3#ALL#GE1301#Climate Change and Extreme Weather");
		if(c1 instanceof Area3) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_createCourse_04() throws Exception {
		boolean finalResult = false;
		Course c1 = CourseGenerator.createCourse("EngChiReq#ALL#GE1401#University English");
		if(c1 instanceof EngChiReq) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_createCourse_05() throws Exception {
		boolean finalResult = false;
		Course c1 = CourseGenerator.createCourse("CollegeReq#SEE#MA1200#Calculus and Basic Linear Algebra I");
		if(c1 instanceof CollegeReq) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_createCourse_06() throws Exception {
		boolean finalResult = false;
		Course c1 = CourseGenerator.createCourse("MajorReq#LLB#LW3607A#Land Law I");
		if(c1 instanceof MajorReq) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_createCourse_07() throws Exception {
		boolean finalResult = false;
		Course c1 = CourseGenerator.createCourse("MajorElectiveReq#BAS#SM2231#3D Animation I - Basic");
		if(c1 instanceof MajorElectiveReq) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_createCourse_08() throws Exception {
		boolean finalResult = false;
		Course c1 = CourseGenerator.createCourse("PECourse#ALL#PED1306#Step Aerobic");
		if(c1 instanceof PECourse) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_createCourse_09() throws Exception {
		boolean finalResult = false;
		Course c1 = CourseGenerator.createCourse("FreeElective#ALL#CLA2602#Spanish 2");
		if(c1 instanceof FreeElective) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_createCourse_10() throws Exception {
		boolean finalResult = false;
		Course c1 = CourseGenerator.createCourse("Course#ALL#MA1300#Enhanced Calculus and Linear Algebra I");
		if(c1 instanceof Course) {
			finalResult = true;
		}
		assertEquals(finalResult, false);
    }
	
	@Test
    public void test_getColOrMaj_01() throws Exception {
		String[] courseInfo = {"Area1", "ALL", "GE1104", "Chinese Cultural Canonsand Their Modern Application"};
		Course c1 = new Area1(courseInfo);
		ArrayList<String> result = c1.getColOrMaj();
		ArrayList<String> colOrMaj = new ArrayList<>(Arrays.asList("ALL"));
		assertEquals(result, colOrMaj);
    }
	
	@Test
    public void test_getColOrMaj_02() throws Exception {
		String[] courseInfo = {"MajorElectiveReq", "BACM/BSCCM/BAS", "SM3703", "Media Art and the Environment"};
		Course c1 = new MajorElectiveReq(courseInfo);
		ArrayList<String> result = c1.getColOrMaj();
		ArrayList<String> colOrMaj = new ArrayList<>(Arrays.asList("BACM", "BSCCM", "BAS"));
		assertEquals(result, colOrMaj);
    }
	
	@Test
    public void test_getCourseTitle_01() throws Exception {
		String[] courseInfo = {"Area2", "ALL", "GE1201", "Information Management and Its Social Impact"};
		Course c1 = new Area2(courseInfo);
		String result = c1.getCourseTitle();
		assertEquals(result, "Information Management and Its Social Impact");
    }
	
	@Test
    public void test_getCourseCode_01() throws Exception {
		String[] courseInfo = {"Area3", "ALL", "GE1301", "Climate Change and Extreme Weather"};
		Course c1 = new Area3(courseInfo);
		String result = c1.getCourseCode();
		assertEquals(result, "GE1301");
		
    }
	
	@Test
    public void test_createMajor_01() throws Exception {
		boolean finalResult = false;
		Major m1 = MajorGenerator.createMajor("LLB");
		if(m1 instanceof LLB) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_createMajor_02() throws Exception {
		boolean finalResult = false;
		Major m1 = MajorGenerator.createMajor("BACM");
		if(m1 instanceof BACM) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_createMajor_03() throws Exception {
		boolean finalResult = false;
		Major m1 = MajorGenerator.createMajor("BSCCM");
		if(m1 instanceof BSCCM) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_createMajor_04() throws Exception {
		boolean finalResult = false;
		Major m1 = MajorGenerator.createMajor("BAS");
		if(m1 instanceof BAS) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_createMajor_05() throws Exception {
		boolean finalResult = false;
		Major m1 = MajorGenerator.createMajor("BEngSE");
		if(m1 instanceof BEngSE) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_getName_00001() throws Exception {
		Major m1 = new BACM("Bachelor of Arts in Creative Media");
		String result = m1.getName();
		assertEquals(result, "Bachelor of Arts in Creative Media");
    }
	
	@Test
    public void test_getName_00002() throws Exception {
		Major m1 = new BAS("Bachelor of Arts and Science in New Media");
		String result = m1.getName();
		assertEquals(result, "Bachelor of Arts and Science in New Media");
    }
	
	@Test
    public void test_getName_00003() throws Exception {
		Major m1 = new BSCCM("Bachelor of Science in Creative Media");
		String result = m1.getName();
		assertEquals(result, "Bachelor of Science in Creative Media");
    }
	
	@Test
    public void test_getName_04() throws Exception {
		Major m1 = new BEngSE("Bachelor of Engineering in Energy Science and Engineering");
		String result = m1.getName();
		assertEquals(result, "Bachelor of Engineering in Energy Science and Engineering");
    }
	
	@Test
    public void test_getName_05() throws Exception {
		Major m1 = new LLB("Bachelor of Laws");
		String result = m1.getName();
		assertEquals(result, "Bachelor of Laws");
    }
	

	@Test
    public void test_createCollege_01() throws Exception {
		boolean finalResult = false;
		College c1 = CollegeGenerator.createCollege("Law LLB");
		if(c1 instanceof Law) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_createCollege_02() throws Exception {
		boolean finalResult = false;
		College c1 = CollegeGenerator.createCollege("SCM BACM/BSCCM/BAS");
		if(c1 instanceof SCM) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_createCollege_03() throws Exception {
		boolean finalResult = false;
		College c1 = CollegeGenerator.createCollege("SEE BEngSE");
		if(c1 instanceof SEE) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_getName_01() throws Exception {
		College c1 = new Law("Law LLB");
		String result = c1.getName();
		assertEquals(result, "Law");
    }
	
	@Test
    public void test_getName_02() throws Exception {
		College c1 = new SCM("SCM BACM/BSCCM/BAS");
		String result = c1.getName();
		assertEquals(result, "SCM");
    }
	
	@Test
    public void test_getName_03() throws Exception {
		College c1 = new SEE("SEE BEngSE");
		String result = c1.getName();
		assertEquals(result, "SEE");
    }
	
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
    public void test_makeSession_03() throws Exception {
		String path = ".\\TestInfo\\TestMakeSession99.txt";
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
	
	@Test
    public void test_makeCourse_03() throws Exception {
		String path = ".\\TestInfo\\TestMakeCourse99.txt";
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
	
	@Test
    public void test_linkPrereq_01() throws Exception {
		String addPath = ".\\TestInfo\\TestLinkMake01.txt";
		String path = ".\\TestInfo\\TestLinkPrereq01.txt";
		Admin admin = Admin.getInstance();
		int counter = 0;
		boolean temp = admin.makeCourse(addPath);
		boolean result = admin.linkPrereq(path);
		boolean finalResult = false;
		
		if(result == true) {
			Course c1;
			int add = 0;
			ArrayList<String> current = infoScanner(" ", 0, path);
			ArrayList<String> prereq = infoScanner(" ", 1, path);
			ArrayList<ArrayList<Course>> prereqList;
			
			for(String c: current){
				c1 = admin.getCourse(c);
				prereqList = c1.getPreReq();
				for(String p: prereq){
					for(ArrayList<Course> s: prereqList) {
						for(Course c2: s) {
							if(p.equals(c2.getCourseCode())) {
								counter++;
							}
							if(p.contains("/")) {
								add = p.length() - p.replace("/", "").length();
								String[] course = p.split("/");
								for(int i=0; i<2; i++){
									if(course[i].equals(c2.getCourseCode())) {
										counter++;
									}
								}
							}
							
						}
					}
				}
			}
			if(counter == current.size()+add) {
				finalResult = true;
			}
		} 
		
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_linkPrereq_02() throws Exception {
		String addPath = ".\\TestInfo\\TestLinkMake99.txt";
		String path = ".\\TestInfo\\TestLinkPrereq99.txt";
		Admin admin = Admin.getInstance();
		int counter = 0;
		boolean temp = admin.makeCourse(addPath);
		boolean result = admin.linkPrereq(path);
		boolean finalResult = false;
		
		if(result == true) {
			Course c1;
			int add = 0;
			ArrayList<String> current = infoScanner(" ", 0, path);
			ArrayList<String> prereq = infoScanner(" ", 1, path);
			ArrayList<ArrayList<Course>> prereqList;
			
			for(String c: current){
				c1 = admin.getCourse(c);
				prereqList = c1.getPreReq();
				for(String p: prereq){
					for(ArrayList<Course> s: prereqList) {
						for(Course c2: s) {
							if(p.equals(c2.getCourseCode())) {
								counter++;
							}
							if(p.contains("/")) {
								add = p.length() - p.replace("/", "").length();
								String[] course = p.split("/");
								for(int i=0; i<2; i++){
									if(course[i].equals(c2.getCourseCode())) {
										counter++;
									}
								}
							}
							
						}
					}
				}
			}
			if(counter == current.size()+add) {
				finalResult = true;
			}
		} 
		
		assertEquals(finalResult, false);
    }

	@Test
    public void test_makeStudent_01() throws Exception {
		String path = ".\\TestInfo\\TestMakeStudent01.txt";
		Admin admin = Admin.getInstance();
		boolean result = admin.makeStudent(path);
		boolean finalResult = true;
		
		if(result == true) {
			ArrayList<String> items = infoScanner(" ", 1, path);
			for(String s: items){
				if(admin.getStudent(s) == null) {
					finalResult = false;
				}
			}
		} else {
			finalResult = false;
		}
		
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_makeStudent_02() throws Exception {
		String path = ".\\TestInfo\\TestMakeStudent02.txt";
		Admin admin = Admin.getInstance();
		boolean result = admin.makeStudent(path);
		boolean finalResult = true;
		
		if(result == true) {
			ArrayList<String> items = infoScanner(" ", 1, path);
			for(String s: items){
				if(admin.getStudent(s) == null) {
					finalResult = false;
				}
			}
		} else {
			finalResult = false;
		}
		
		assertEquals(finalResult, false);
    }
	
	@Test
    public void test_makeStudent_03() throws Exception {
		String path = ".\\TestInfo\\TestMakeStudent99.txt";
		Admin admin = Admin.getInstance();
		boolean result = admin.makeStudent(path);
		boolean finalResult = true;
		
		if(result == true) {
			ArrayList<String> items = infoScanner(" ", 1, path);
			for(String s: items){
				if(admin.getStudent(s) == null) {
					finalResult = false;
				}
			}
		} else {
			finalResult = false;
		}
		
		assertEquals(finalResult, false);
    }

	
	@Test
    public void test_makeMajor_01() throws Exception {
		String path = ".\\TestInfo\\TestMakeMajor01.txt";
		Admin admin = Admin.getInstance();
		boolean result = admin.makeMajor(path);
		boolean finalResult = true;
		
		if(result == true) {
			ArrayList<String> items = infoScanner("", 0, path);
			for(String s: items){
				if(admin.getMajor(s) == null) {
					finalResult = false;
				}
			}
		} else {
			finalResult = false;
		}
		
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_makeMajor_02() throws Exception {
		String path = ".\\TestInfo\\TestMakeMajor01.txt";
		Admin admin = Admin.getInstance();
		boolean result = admin.makeMajor(path);
		boolean finalResult = true;
		
		if(result == true) {
			ArrayList<String> items = infoScanner("", 0, path);
			items.add("BAS");
			for(String s: items){
				if(admin.getMajor(s) == null) {
					finalResult = false;
				}
			}
		} else {
			finalResult = false;
		}
		
		assertEquals(finalResult, false);
    }
	
	@Test
    public void test_makeMajor_03() throws Exception {
		String path = ".\\TestInfo\\TestMakeMajor99.txt";
		Admin admin = Admin.getInstance();
		boolean result = admin.makeMajor(path);
		boolean finalResult = true;
		
		if(result == true) {
			ArrayList<String> items = infoScanner("", 0, path);
			items.add("BAS");
			for(String s: items){
				if(admin.getMajor(s) == null) {
					finalResult = false;
				}
			}
		} else {
			finalResult = false;
		}
		
		assertEquals(finalResult, false);
    }
	
	@Test
    public void test_makeCollege_01() throws Exception {
		String path = ".\\TestInfo\\TestMakeCollege01.txt";
		Admin admin = Admin.getInstance();
		boolean result = admin.makeCollege(path);
		boolean finalResult = true;
		
		if(result == true) {
			ArrayList<String> items = infoScanner(" ", 0, path);
			for(String s: items){
				if(admin.getCollege(s) == null) {
					finalResult = false;
				}
			}
		} else {
			finalResult = false;
		}
		
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_makeCollege_02() throws Exception {
		setup();
		String path = ".\\TestInfo\\TestMakeCollege01.txt";
		Admin admin = Admin.getInstance();
		boolean result = admin.makeCollege(path);
		boolean finalResult = true;
		
		if(result == true) {
			ArrayList<String> items = infoScanner(" ", 0, path);
			for(String s: items){
				if(admin.getCollege(s) == null) {
					finalResult = false;
				}
			}
		} else { 
			finalResult = false;
		}
		
		assertEquals(finalResult, false);
    }
	
	@Test
    public void test_makeCollege_03() throws Exception {
		String path = ".\\TestInfo\\TestMakeCollege99.txt";
		Admin admin = Admin.getInstance();
		boolean result = admin.makeCollege(path);
		boolean finalResult = true;
		
		if(result == true) {
			ArrayList<String> items = infoScanner(" ", 0, path);
			for(String s: items){
				if(admin.getCollege(s) == null) {
					finalResult = false;
				}
			}
		} else {
			finalResult = false;
		}
		
		assertEquals(finalResult, false);
    }
	
	

	
	
	private static ArrayList<String> infoScanner(String separator, int index, String path) {
		File info = new File(path);
		try{
			Scanner infoIn = new Scanner(info);
			ArrayList<String> result = new ArrayList<>();
			ArrayList<String> lines = new ArrayList<>();
			while(infoIn.hasNext()){
				lines.add(infoIn.nextLine());
				if(separator == ""){
					return lines;
				}
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
	
	@Test
    public void test_outputTaken() throws Exception {
		Course course1 = CourseGenerator.createCourse("MajorElectiveReq#BACM/BSCCM/BAS#SM2007#Culture, Society and New Technologies");
		Course course2 = CourseGenerator.createCourse("Area2#ALL#GE1202#Managing Your Personal Finance");
		Course course3 = CourseGenerator.createCourse("Area3#ALL#GE1301#Climate Change and Extreme Weather");
		
		ArrayList<Course> taken = new ArrayList<Course>();
		taken.add(course1);
		taken.add(course2);
		taken.add(course3);
		
		ListTakenRegistered test_outputTaken = new ListTakenRegistered();
		test_outputTaken.outputTaken("12345678", taken, "ListTaken");

		String SID = "12345678";
		String command = "ListTaken";
		
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest1\\" + SID + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_outputRegistered() throws Exception {
		setup();
		Session session1 = new Session("CS1103 47964 1/1600/1850");
		Session session2 = new Session("CS2313 43176 4/900/1050");
		Session session3 = new Session("GE1104 46443 5/1400/1550");
		
		ArrayList<Session> taken = new ArrayList<Session>();
		taken.add(session1);
		taken.add(session2);
		taken.add(session3);
		
		String SID = "12345678";
		String command = "ListRegistered";
		
		ListTakenRegistered test_outputRegistered = new ListTakenRegistered();
		test_outputRegistered.outputRegistered(SID, taken, command);
		
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest1\\" + SID + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_process_0001() throws Exception {
		setup();
		Student student = new Student("SamuelLloyd 50000003 password LLB GE1401,GE1202,GE1107,GE1112,GE1310,GE2411,LW2600,LW2602A,LW2602B,LW2601,LW2603A,LW2603B,LW2665,LW3604,LW3609,LW3605A,LW3605B,LW3606A,LW3606B,LW3607A,LW3607B/LW4656_26399,LW4616_46784,LW4630_45315");
		RequestProcessor rp = new RequestProcessor();
		String command = "ListTaken";
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest1\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
	public void test_process_002() throws Exception {
		setup();
		Student student = new Student("SamuelLloyd 50000003 password LLB GE1401,GE1202,GE1107,GE1112,GE1310,GE2411,LW2600,LW2602A,LW2602B,LW2601,LW2603A,LW2603B,LW2665,LW3604,LW3609,LW3605A,LW3605B,LW3606A,LW3606B,LW3607A,LW3607B/LW4656_26399,LW4616_46784,LW4630_45315");
		RequestProcessor rp = new RequestProcessor();
		String command = "ListRegistered";
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest1\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }


	@Test
    public void test_outputAllAvailable() throws Exception {
		setup();
		Session session1 = new Session("CS1103 47964 1/1600/1850");
		Session session2 = new Session("CS2313 43176 4/900/1050");
		Session session3 = new Session("GE1104 46443 5/1400/1550");
		
		ArrayList<Session> taken = new ArrayList<Session>();
		taken.add(session1);
		taken.add(session2);
		taken.add(session3);
		
		String SID = "12345678";
		String command = "ListAllAvailable";
		
		ListTakenRegistered test_ListAllAvailable = new ListTakenRegistered();
		test_ListAllAvailable.outputRegistered(SID, taken, command);
		
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest2\\" + SID + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_process_001() throws Exception {
		setup();
		Student student = new Student("MarvinPena 50000021 password BAS GE1401,SM1701,SM1702,CS1103,GE2411,SM2702,SM2703,CS1303,GE1206/SM2704_42322,SM2705_42329,CS2116_45516,CS2313_43175");
		RequestProcessor rp = new RequestProcessor();
		String command = "ListAllAvailable";
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest2\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_outputInvalidInput() throws Exception {
		String SID = "87654321";
		String command = "ListPossibleSchedule";
		
		ListPossibleSchedule test_outputInvalidInput = new ListPossibleSchedule();
		test_outputInvalidInput.outputInvalidInput(SID, command, "CO1234 DE5678", "DU1234 PL5678");
		
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest3\\" + SID + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_outputNoResult() throws Exception {
		String SID = "98765432";
		String command = "ListPossibleSchedule";
		
		ListPossibleSchedule test_outputNoResult = new ListPossibleSchedule();
		test_outputNoResult.outputNoResult(SID, command);
		
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest3\\" + SID + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_outputPossibleSchedule() throws Exception {
		setup();
		Session session1 = new Session("GE1401 47326 3/900/1150");
		Session session2 = new Session("GE1202 44812 1/1100/1150");
		Session session3 = new Session("LW2600 39585 1/1700/1850");
		Session session4 = new Session("GE2401 41304 5/900/1150");
		Session session5 = new Session("GE1110 41456 5/1500/1750");
		Session session6 = new Session("GE1110 41168 3/1500/1750");
		Session session7 = new Session("GE1110 38779 2/1200/1450");
		
		ArrayList<Session> schedule1 = new ArrayList<Session>();
		schedule1.add(session1);
		schedule1.add(session2);
		schedule1.add(session3);
		schedule1.add(session4);
		schedule1.add(session5);
		
		ArrayList<Session> schedule2 = new ArrayList<Session>();
		schedule2.add(session1);
		schedule2.add(session2);
		schedule2.add(session3);
		schedule2.add(session4);
		schedule2.add(session6);
		
		ArrayList<Session> schedule3 = new ArrayList<Session>();
		schedule3.add(session1);
		schedule3.add(session2);
		schedule3.add(session3);
		schedule3.add(session4);
		schedule3.add(session7);
		
		ArrayList<ArrayList<Session>> scheduleList = new ArrayList<ArrayList<Session>>();
		scheduleList.add(schedule1);
		scheduleList.add(schedule2);
		scheduleList.add(schedule3);
		
		String SID = "51111111";
		String command = "ListPossibleSchedule";
		
		ListPossibleSchedule test_outputPossibleSchedule = new ListPossibleSchedule();
		test_outputPossibleSchedule.possibleSchedule = scheduleList;
		test_outputPossibleSchedule.outputPossibleSchedule(SID, command);
		
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest3\\" + SID + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_getSchedule() throws Exception {
		Session session1 = new Session("GE1401 47326 3/900/1150");
		Session session2 = new Session("GE1202 44812 1/1100/1150");
		Session session3 = new Session("LW2600 39585 1/1700/1850");
		
		Session session4 = new Session("GE2401 39269 3/900/1150");
		Session session5 = new Session("GE2401 41304 5/900/1150");
		Session session6 = new Session("GE2401 39270 5/1500/1750");
		
		Session session7 = new Session("GE1110 41456 5/1500/1750");
		Session session8 = new Session("GE1110 41168 3/1500/1750");
		Session session9 = new Session("GE1110 44566 3/900/1150");
		Session session10 = new Session("GE1110 38779 2/1200/1450");
		
		ArrayList<Session> registered = new ArrayList<Session>();
		registered.add(session1);
		registered.add(session2);
		registered.add(session3);
		
		ArrayList<Session> sessions1 = new ArrayList<Session>();
		sessions1.add(session4);
		sessions1.add(session5);
		sessions1.add(session6);
		
		ArrayList<Session> sessions2 = new ArrayList<Session>();
		sessions2.add(session7);
		sessions2.add(session8);
		sessions2.add(session9);
		sessions2.add(session10);
		
		ArrayList<ArrayList<Session>> newInputs = new ArrayList<ArrayList<Session>>();
		newInputs.add(sessions1);
		newInputs.add(sessions2);
		
		ArrayList<Session> schedule1 = new ArrayList<Session>();
		schedule1.add(session1);
		schedule1.add(session2);
		schedule1.add(session3);
		schedule1.add(session5);
		schedule1.add(session7);
		
		ArrayList<Session> schedule2 = new ArrayList<Session>();
		schedule2.add(session1);
		schedule2.add(session2);
		schedule2.add(session3);
		schedule2.add(session5);
		schedule2.add(session8);
		
		ArrayList<Session> schedule3 = new ArrayList<Session>();
		schedule3.add(session1);
		schedule3.add(session2);
		schedule3.add(session3);
		schedule3.add(session5);
		schedule3.add(session10);
		
		ArrayList<Session> schedule4 = new ArrayList<Session>();
		schedule4.add(session1);
		schedule4.add(session2);
		schedule4.add(session3);
		schedule4.add(session6);
		schedule4.add(session8);
		
		ArrayList<Session> schedule5 = new ArrayList<Session>();
		schedule5.add(session1);
		schedule5.add(session2);
		schedule5.add(session3);
		schedule5.add(session6);
		schedule5.add(session10);
		
		ArrayList<ArrayList<Session>> expectedSchedules = new ArrayList<ArrayList<Session>>();
		expectedSchedules.add(schedule1);
		expectedSchedules.add(schedule2);
		expectedSchedules.add(schedule3);
		expectedSchedules.add(schedule4);
		expectedSchedules.add(schedule5);
		
		ListPossibleSchedule test_getSchedule = new ListPossibleSchedule();
		test_getSchedule.getSchedule(registered, newInputs);
		ArrayList<ArrayList<Session>> resultSchedules = test_getSchedule.possibleSchedule;
		
		resultSchedules.removeAll(expectedSchedules);
		boolean result = resultSchedules.isEmpty();
		
		assertEquals(true, result);
    }
	
	@Test
    public void test_process_01() throws Exception {
		setup();
		Student student = new Student("RonaldRichardson 52222221 password LLB NULL/GE1401_47326,GE1202_44812,LW2600_39585");
		RequestProcessor rp = new RequestProcessor();
		String command = "ListPossibleSchedule";
		rp.processRequest(student, command, "GE2401 GE1110");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest3\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_process_02() throws Exception {
		setup();
		Student student = new Student("RonaldRichardson 53333331 password LLB NULL/GE1401_47326,GE1202_44812,LW2600_39585");
		RequestProcessor rp = new RequestProcessor();
		String command = "ListPossibleSchedule";
		rp.processRequest(student, command, "IN1234 VA1110 GE1401");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest3\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_process_03() throws Exception {
		setup();
		Student student = new Student("RonaldRichardson 54444441 password LLB NULL/GE1401_47326,GE1202_44812,LW2600_39585");
		RequestProcessor rp = new RequestProcessor();
		String command = "ListPossibleSchedule";
		rp.processRequest(student, command, "CLA3603");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest3\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_process_04() throws Exception {
		setup();
		Student student = new Student("KelvinBlair 50000016 password BAS GE1401,SM1701,SM1702,CS1103,GE2411,SM2702,SM2703,"
				+ "CS1303,GE1206,SM2704,SM2705,CS2116,CS2313,GE1101,GE1325,PED1305,MA1005,JC2001,SM2714,SM3601,"
				+ "SM3611,CS3402,SM2202,CS3347,SM2276/NULL");
		RequestProcessor rp = new RequestProcessor();
		String command = "ListPossibleSchedule";
		rp.processRequest(student, command, "CLA3603");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest3\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_outputInvalidCommand() throws Exception {
		String SID = "11111111";
		String command = "InvalidCommand";
		
		RequestProcessor test_outputInvalidCommand = new RequestProcessor();
		test_outputInvalidCommand.outputInvalidCommand(SID, command);
		
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest4\\" + SID + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_processRequest_001() throws Exception {		
		class StubListTakenRegistered extends ListTakenRegistered {
			public void process(Student student, String command, String courseInput){
				try{
					File result = null;
					if (command.equalsIgnoreCase("ListTaken")) {
						result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
						FileOutputStream fos = new FileOutputStream(result);
						fos.write("The request is ListTaken".getBytes());
						fos.close();
					} else if (command.equalsIgnoreCase("ListRegistered")) {
						result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
						FileOutputStream fos = new FileOutputStream(result);
						fos.write("The request is ListRegistered".getBytes());
						fos.close();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}	
				
			}
		}
		
		Student student = new Student("EdnaBuchanan 22222222 password BACM NULL/NULL");
		String command = "ListTaken";
		
		StubListTakenRegistered test_processRequest = new StubListTakenRegistered();
		RequestProcessor rp = new RequestProcessor(test_processRequest);
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest4\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_processRequest_002() throws Exception {
		class StubListTakenRegistered extends ListTakenRegistered {
			public void process(Student student, String command, String courseInput){
				try{
					File result = null;
					if (command.equalsIgnoreCase("ListTaken")) {
						result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
						FileOutputStream fos = new FileOutputStream(result);
						fos.write("The request is ListTaken".getBytes());
						fos.close();
					} else if (command.equalsIgnoreCase("ListRegistered")) {
						result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
						FileOutputStream fos = new FileOutputStream(result);
						fos.write("The request is ListRegistered".getBytes());
						fos.close();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}	
				
			}
		}
		
		Student student = new Student("EdnaBuchanan 33333333 password BACM NULL/NULL");
		String command = "ListRegistered";

		StubListTakenRegistered test_processRequest = new StubListTakenRegistered();
		RequestProcessor rp = new RequestProcessor(test_processRequest);
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest4\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_processRequest_003() throws Exception {
		class StubListAllAvailable extends ListAllAvailable {
			public void process(Student student, String command, String courseInput){
				try{
					File result = null;
					result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
					FileOutputStream fos = new FileOutputStream(result);
					fos.write("The request is ListAllAvailable".getBytes());
					fos.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}	
				
			}
		}
		
		Student student = new Student("EdnaBuchanan 44444444 password BACM NULL/NULL");
		String command = "ListAllAvailable";
		
		StubListAllAvailable test_processRequest = new StubListAllAvailable();
		RequestProcessor rp = new RequestProcessor(test_processRequest);
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest4\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_processRequest_004() throws Exception {
		class StubListPossibleSchedule extends ListPossibleSchedule {
			public void process(Student student, String command, String courseInput){
				try{
					File result = null;
					result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
					FileOutputStream fos = new FileOutputStream(result);
					fos.write("The request is ListPossibleSchedule".getBytes());
					fos.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}	
				
			}
		}
		
		Student student = new Student("EdnaBuchanan 55555555 password BACM NULL/NULL");
		String command = "ListPossibleSchedule";
		
		StubListPossibleSchedule test_processRequest = new StubListPossibleSchedule();
		RequestProcessor rp = new RequestProcessor(test_processRequest);
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest4\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_processRequest_005() throws Exception {
		Student student = new Student("EdnaBuchanan 66666666 password BACM NULL/NULL");
		String command = "InvalidCommand";
		
		RequestProcessor rp = new RequestProcessor();
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest4\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_processRequest_01() throws Exception {
		Student student = new Student("RonaldRichardson 50000001 password LLB NULL/GE1401_47326,GE1202_44812,LW2600_39585");
		RequestProcessor rp = new RequestProcessor();
		String command = "InvalidCommand";
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\IntegrationTest1\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_processRequest_02() throws Exception {
		setup();
		Student student = new Student("LyleHoward 50000006 password BACM GE1401,SM1701,SM1702,CS1103,SM2702,SM2703,CS1303,GE2410,GE1201,GE1101/SM2704_42322,SM2705_42327,SM2706_42346");
		RequestProcessor rp = new RequestProcessor();
		String command = "ListTaken";
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\IntegrationTest1\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_processRequest_03() throws Exception {
		setup();
		Student student = new Student("LyleHoward 50000006 password BACM GE1401,SM1701,SM1702,CS1103,SM2702,SM2703,CS1303,GE2410,GE1201,GE1101/SM2704_42322,SM2705_42327,SM2706_42346");
		RequestProcessor rp = new RequestProcessor();
		String command = "ListRegistered";
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\IntegrationTest1\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_processRequest_04() throws Exception {
		setup();
		Student student = new Student("LyleHoward 50000006 password BACM GE1401,SM1701,SM1702,CS1103,SM2702,SM2703,CS1303,GE2410,GE1201,GE1101/SM2704_42322,SM2705_42327,SM2706_42346");
		RequestProcessor rp = new RequestProcessor();
		String command = "ListAllAvailable";
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\IntegrationTest1\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_processRequest_05() throws Exception {
		setup();
		Student student = new Student("LyleHoward 50000006 password BACM GE1401,SM1701,SM1702,CS1103,SM2702,SM2703,CS1303,GE2410,GE1201,GE1101/SM2704_42322,SM2705_42327,SM2706_42346");
		RequestProcessor rp = new RequestProcessor();
		String command = "ListPossibleSchedule";
		rp.processRequest(student, command, "GE2401 GE1202");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\IntegrationTest1\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_01() throws Exception {
		getReq();
		String SID = "500001";
		String command = "ListPossibleSchedule";
		
		File request = new File (".\\Requests\\" + SID + "_" + command + "_SystemTest1.txt");
		FileOutputStream fos = new FileOutputStream(request);
				
		try {
			fos.write(SID.getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write("password".getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write(command.getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write("GE2401 GE1110".getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\SystemTest1\\" + SID + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_02() throws Exception {
		getReq();
		String SID = "50000001";
		String command = "ListTaken";
		
		File request = new File (".\\Requests\\" + SID + "_" + command + "_SystemTest1.txt");
		FileOutputStream fos = new FileOutputStream(request);
				
		try {
			fos.write(SID.getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write("password".getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write(command.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\SystemTest1\\" + SID + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_03() throws Exception {
		getReq();
		String SID = "50000002";
		String command = "ListTaken";
		
		File request = new File (".\\Requests\\" + SID + "_" + command + "_SystemTest1.txt");
		FileOutputStream fos = new FileOutputStream(request);
				
		try {
			fos.write(SID.getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write("password".getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write(command.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\SystemTest1\\" + SID + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_04() throws Exception {
		getReq();
		String SID = "50000017";
		String command = "ListRegistered";
		
		File request = new File (".\\Requests\\" + SID + "_" + command + "_SystemTest1.txt");
		FileOutputStream fos = new FileOutputStream(request);
				
		try {
			fos.write(SID.getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write("password".getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write(command.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\SystemTest1\\" + SID + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_05() throws Exception {
		getReq();
		String SID = "50000020";
		String command = "ListRegistered";
		
		File request = new File (".\\Requests\\" + SID + "_" + command + "_SystemTest1.txt");
		FileOutputStream fos = new FileOutputStream(request);
				
		try {
			fos.write(SID.getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write("password".getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write(command.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\SystemTest1\\" + SID + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_06() throws Exception {
		getReq();
		String SID = "50000014";
		String command = "ListAllAvailable";
		
		File request = new File (".\\Requests\\" + SID + "_" + command + "_SystemTest1.txt");
		FileOutputStream fos = new FileOutputStream(request);
				
		try {
			fos.write(SID.getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write("password".getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write(command.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\SystemTest1\\" + SID + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_07() throws Exception {
		getReq();
		String SID = "50000015";
		String command = "ListPossibleSchedule";
		
		File request = new File (".\\Requests\\" + SID + "_" + command + "_SystemTest1.txt");
		FileOutputStream fos = new FileOutputStream(request);
				
		try {
			fos.write(SID.getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write("password".getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write(command.getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write("GE2401 GE1110".getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\SystemTest1\\" + SID + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }

}
