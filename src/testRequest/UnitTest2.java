/**
 * Unit Testing 2: ListAllAvailable
 * Date: 
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

public class UnitTest2 {
	
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
    public void test_outputAllAvailable() throws Exception {
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
    public void test_process_01() throws Exception {
		Student student = new Student("MarvinPena 50000014 password BAS GE1401,SM1701,SM1702,CS1103,GE2411,SM2702,SM2703,CS1303,GE1206/SM2704_42322,SM2705_42329,CS2116_45516,CS2313_43175");
		RequestProcessor rp = new RequestProcessor();
		String command = "ListAllAvailable";
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest2\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
}
