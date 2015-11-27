/**
 * Integration Testing 1: CourseGenerator + Course Class
 * Date: 
 */

package testSetup;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

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
import setup.Admin;

public class IntegrationTest1 extends TestCase{
	
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
}
