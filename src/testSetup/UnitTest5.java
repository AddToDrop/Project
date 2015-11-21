/**
 * Unit Testing 5: Student Class
 * Date: 
 */

package testSetup;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

import course.Course;
import junit.framework.TestCase;
import session.Session;
import setup.Admin;
import student.Student;

public class UnitTest5 extends TestCase{
	
	@Test
    public void test_getName_01() throws Exception {
		Student s1 = new Student("RonaldRichardson 50000001 password LLB NULL/GE1401_47326,GE1202_44812,LW2600_39585");
		String result = s1.getName();
		assertEquals(result, "RonaldRichardson");
    }
	
	@Test
    public void test_getName_02() throws Exception {
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
		Admin admin = new Admin();
		String pwd = admin.hashPwd("password");
		assertEquals(result, pwd);
    }
	
	@Test
    public void test_getPassword_02() throws Exception {
		Student s1 = new Student("EdnaBuchanan 50000005 password BACM NULL/GE1401_47327,SM1701_39195,SM1702_38734,CS1103_47967");
		String result = s1.getPassword();
		Admin admin = new Admin();
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
	/*
	@Test
    public void test_getPrevTaken_01() throws Exception {
		Student s1 = new Student("RonaldRichardson 50000001 password LLB NULL/GE1401_47326,GE1202_44812,LW2600_39585");
		ArrayList<Course> result = s1.getPrevTaken();
		ArrayList<Course> prevTaken = new ArrayList<>();
		assertEquals(result, prevTaken);
    }
	
	
	@Test
    public void test_getRegistered_01() throws Exception {
		boolean finalResult = false;
		Student st1 = new Student("RonaldRichardson 50000001 password LLB NULL/GE1401_47326,GE1202_44812,LW2600_39585");
		ArrayList<Session> registered = new ArrayList<>();
		if(st1.getRegistered().equals(registered))
			finalResult = true;
		assertEquals(finalResult, true);
    }
	*/
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

}
