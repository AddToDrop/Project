/**
 * Unit Testing 1: RequestProcessor
 * Date: 
 */

package testRequest;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import junitx.framework.FileAssert;
import request.RequestProcessor;
import session.Session;
import setup.Admin;
import student.Student;

public class UnitTest1 {
	@Test
    public void test_processRequest_01() throws Exception {
		Admin.startSetup();
		Student student = new Student("RonaldRichardson 50000001 password LLB NULL/GE1401_47326,GE1202_44812,LW2600_39585");
		RequestProcessor rp = new RequestProcessor();
		String command = "InvalidCommand";
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\Expected\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_processRequest_02() throws Exception {
		Student student = new Student("LyleHoward 50000006 password BACM GE1401,SM1701,SM1702,CS1103,SM2702,SM2703,CS1303,GE2410,GE1201,GE1101/SM2704_42322,SM2705_42327,SM2706_42346");
		RequestProcessor rp = new RequestProcessor();
		String command = "ListTaken";
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\Expected\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_processRequest_03() throws Exception {
		Student student = new Student("LyleHoward 50000006 password BACM GE1401,SM1701,SM1702,CS1103,SM2702,SM2703,CS1303,GE2410,GE1201,GE1101/SM2704_42322,SM2705_42327,SM2706_42346");
		RequestProcessor rp = new RequestProcessor();
		String command = "ListRegistered";
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\Expected\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_processRequest_04() throws Exception {
		Student student = new Student("LyleHoward 50000006 password BACM GE1401,SM1701,SM1702,CS1103,SM2702,SM2703,CS1303,GE2410,GE1201,GE1101/SM2704_42322,SM2705_42327,SM2706_42346");
		RequestProcessor rp = new RequestProcessor();
		String command = "ListAvailable";
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\Expected\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_processRequest_05() throws Exception {
		Student student = new Student("LyleHoward 50000006 password BACM GE1401,SM1701,SM1702,CS1103,SM2702,SM2703,CS1303,GE2410,GE1201,GE1101/SM2704_42322,SM2705_42327,SM2706_42346");
		RequestProcessor rp = new RequestProcessor();
		String command = "ListPossibleSchedule";
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\Expected\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
}
