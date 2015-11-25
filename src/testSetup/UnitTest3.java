/**
 * Unit Testing 3: Major Class
 * Date: 
 */

package testSetup;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import setup.Admin;
import course.Area3;
import course.Course;
import course.MajorReq;
import junit.framework.TestCase;
import major.BACM;
import major.BAS;
import major.BEngSE;
import major.BSCCM;
import major.LLB;
import major.Major;

public class UnitTest3 extends TestCase{
	
	@Test
    public void test_getName_01() throws Exception {
		Major m1 = new BACM("Bachelor of Arts in Creative Media");
		String result = m1.getName();
		assertEquals(result, "Bachelor of Arts in Creative Media");
    }
	
	@Test
    public void test_getName_02() throws Exception {
		Major m1 = new BAS("Bachelor of Arts and Science in New Media");
		String result = m1.getName();
		assertEquals(result, "Bachelor of Arts and Science in New Media");
    }
	
	@Test
    public void test_getName_03() throws Exception {
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
	/* Situtation same as test_getSessionList_01
	@Test
    public void test_getMajorReqList_01() throws Exception {
		boolean finalResult = false;
		String[] courseInfo1 = {"MajorReq", "BACM/BSCCM/BAS", "SM2704", "Creative Media Studio II"};
		String[] courseInfo2 = {"MajorReq", "BACM/BSCCM/BAS", "SM2705", "Creative Media Studio III : Technology, Coding and Tangible Media"};
		String[] courseInfo3 = {"MajorReq", "LLB", "LW2665", "Mooting"};
		Course c1 = new MajorReq(courseInfo1);
		Course c2 = new MajorReq(courseInfo2);
		Course c3 = new MajorReq(courseInfo3);
		Major m1 = new BSCCM("Bachelor of Science in Creative Media");
		ArrayList<Course> result = m1.getMajorReqList();
		ArrayList<Course> majorReqList = new ArrayList<>();
		majorReqList.add(c1);
		majorReqList.add(c2);
		if(result.equals(majorReqList))
			finalResult = true;
		
		assertEquals(finalResult, true);
    }
	*/
}
