/**
 * Unit Testing 1: ListTakenRegistered
 */

package testRequest;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import course.Course;
import course.CourseGenerator;
import junitx.framework.FileAssert;
import request.ListTakenRegistered;
import request.RequestProcessor;
import session.Session;
import setup.Admin;
import student.Student;

public class UnitTest1 {
	
	public static boolean init = false; 
	
	@Before
	public void setup(){
		if (!init) {
			Admin admin = Admin.getInstance();
			admin.startSetup();
			init = true;
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
    public void test_process_01() throws Exception {
		Student student = new Student("SamuelLloyd 50000003 password LLB GE1401,GE1202,GE1107,GE1112,GE1310,GE2411,LW2600,LW2602A,LW2602B,LW2601,LW2603A,LW2603B,LW2665,LW3604,LW3609,LW3605A,LW3605B,LW3606A,LW3606B,LW3607A,LW3607B/LW4656_26399,LW4616_46784,LW4630_45315");
		RequestProcessor rp = new RequestProcessor();
		String command = "ListTaken";
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest1\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
	public void test_process_02() throws Exception {
		Student student = new Student("SamuelLloyd 50000003 password LLB GE1401,GE1202,GE1107,GE1112,GE1310,GE2411,LW2600,LW2602A,LW2602B,LW2601,LW2603A,LW2603B,LW2665,LW3604,LW3609,LW3605A,LW3605B,LW3606A,LW3606B,LW3607A,LW3607B/LW4656_26399,LW4616_46784,LW4630_45315");
		RequestProcessor rp = new RequestProcessor();
		String command = "ListRegistered";
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest1\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }

}
