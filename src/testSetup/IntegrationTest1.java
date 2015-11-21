/**
 * Integration Testing 1: CourseGenerator + Course Class
 * Date: 
 */

package testSetup;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

import course.Area1;
import course.Course;
import course.CourseGenerator;
import junit.framework.TestCase;
import setup.Admin;

public class IntegrationTest1 extends TestCase{
	
	@Test
    public void test_generateCourse_01() throws Exception {
		Admin admin = new Admin();
		boolean finalResult = false;
		Course c1 = CourseGenerator.createCourse("Area1#ALL#GE1101#Chinese Cultural Heritagein Modern Perspective");
		if(c1 != null) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_generateCourse_02() throws Exception {
		Admin admin = new Admin();
		boolean finalResult = false;
		Course c1 = CourseGenerator.createCourse("Area2#ALL#GE1201#Information Management and Its Social Impact");
		if(c1 != null) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_generateCourse_03() throws Exception {
		Admin admin = new Admin();
		boolean finalResult = false;
		Course c1 = CourseGenerator.createCourse("Area3#ALL#GE1301#Climate Change and Extreme Weather");
		if(c1 != null) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_generateCourse_04() throws Exception {
		Admin admin = new Admin();
		boolean finalResult = false;
		Course c1 = CourseGenerator.createCourse("EngChiReq#ALL#GE1401#University English");
		if(c1 != null) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_generateCourse_05() throws Exception {
		Admin admin = new Admin();
		boolean finalResult = false;
		Course c1 = CourseGenerator.createCourse("CollegeReq#SEE#MA1200#Calculus and Basic Linear Algebra I");
		if(c1 != null) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_generateCourse_06() throws Exception {
		Admin admin = new Admin();
		boolean finalResult = false;
		Course c1 = CourseGenerator.createCourse("MajorReq#LLB#LW3607A#Land Law I");
		if(c1 != null) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_generateCourse_07() throws Exception {
		Admin admin = new Admin();
		boolean finalResult = false;
		Course c1 = CourseGenerator.createCourse("MajorElectiveReq#BAS#SM2231#3D Animation I - Basic");
		if(c1 != null) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_generateCourse_08() throws Exception {
		Admin admin = new Admin();
		boolean finalResult = false;
		Course c1 = CourseGenerator.createCourse("PECourse#ALL#PED1306#Step Aerobic");
		if(c1 != null) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_generateCourse_09() throws Exception {
		Admin admin = new Admin();
		boolean finalResult = false;
		Course c1 = CourseGenerator.createCourse("FreeElective#ALL#CLA2602#Spanish 2");
		if(c1 != null) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_generateCourse_10() throws Exception {
		Admin admin = new Admin();
		boolean finalResult = false;
		Course c1 = CourseGenerator.createCourse("Course#ALL#MA1300#Enhanced Calculus and Linear Algebra I");
		if(c1 != null) {
			finalResult = true;
		}
		assertEquals(finalResult, false);
    }
	
}
