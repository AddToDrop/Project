/**
 * Unit Testing 2: Course Class
 * Date: 
 */

package testSetup;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import course.Area1;
import course.Area2;
import course.Area3;
import course.CollegeReq;
import course.Course;
import course.EngChiReq;
import course.MajorElectiveReq;
import course.MajorReq;

import org.junit.Test;

import session.Session;
import setup.Admin;
import junit.framework.TestCase;

public class UnitTest2 extends TestCase{
	
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
		System.out.println("test");
		String[] courseInfo = {"Area3", "ALL", "GE1301", "Climate Change and Extreme Weather"};
		Course c1 = new Area3(courseInfo);
		String result = c1.getCourseCode();
		assertEquals(result, "GE1301");
		
    }
	/*
	@Test
    public void test_getSessionList_01() throws Exception {
		class StubSession extends Admin {
			public void makeSession() {
				Session s1 = new Session("GE1401 40971 3/1500/1750");
				Session s2 = new Session("GE1401 47326 3/0900/1150");
				Session s3 = new Session("GE1401 47327 2/1500/1750");
				sessionList.add(s1);
				sessionList.add(s2);
				sessionList.add(s3);
			}
		}
		StubSession admin = new StubSession();
		boolean finalResult = false;
		int counter = 0;
		Session s1 = new Session("GE1401 40971 3/1500/1750");
		Session s2 = new Session("GE1401 47326 3/0900/1150");
		Session s3 = new Session("GE1401 47327 2/1500/1750");
		admin.makeSession();
		ArrayList<Session> sessionList = new ArrayList<>();
		
		String[] courseInfo = {"EngChiReq", "ALL", "GE1401", "University English"};
		Course c1 = new EngChiReq(courseInfo);
		
		ArrayList<Session> result = c1.getSessionList();
		System.out.println(result.isEmpty());
		for(Session s: result){
			System.out.println(s);
			if(s.isEqual(s1)){
				counter++;
			}
			
			System.out.println(s.isEqual(s2));
			if(s.isEqual(s2)){
				counter++;
			} 			
			
			System.out.println(s.isEqual(s3));
			if(s.isEqual(s3)){
				counter++;
			}
		}
		if(counter == 3)
			finalResult = true;
		
		assertEquals(true, finalResult);
    }
	*/
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
		System.out.println("test");
		String[] courseInfo1 = {"MajorReq", "BACM/BSCCM/BAS", "SM2704", "Creative Media Studio II"};
		String[] courseInfo2 = {"MajorReq", "BACM/BSCCM/BAS", "SM2705", "Creative Media Studio III : Technology, Coding and Tangible Media"};
		Course c1 = new MajorReq(courseInfo1);
		Course c2 = new MajorReq(courseInfo2);
		boolean result = c1.isEquals(c2);
		assertEquals(result, false);
    }
	
	
}
