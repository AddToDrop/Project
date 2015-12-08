/**
 * Unit Testing 3: ListPossibleSchedule
 * Date: 
 */

package testRequest;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import course.Course;
import course.CourseGenerator;
import junitx.framework.FileAssert;
import request.ListPossibleSchedule;
import request.ListTakenRegistered;
import request.RequestProcessor;
import session.Session;
import setup.Admin;
import student.Student;

public class UnitTest3 {
	
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
	
}
