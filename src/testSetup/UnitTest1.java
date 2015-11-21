/**
 * Unit Testing 1: Session Class
 * Date: 
 */

package testSetup;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import session.Session;
import org.junit.Test;
import junit.framework.TestCase;

public class UnitTest1 extends TestCase{
	
	@Test
    public void test_getCourseCode_01() throws Exception {
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
}
