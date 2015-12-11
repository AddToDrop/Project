/**
 * Unit Testing 4: RequestProcessor
 */

package testRequest;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import course.Course;
import course.CourseGenerator;
import junitx.framework.FileAssert;
import request.ListAllAvailable;
import request.ListPossibleSchedule;
import request.ListTakenRegistered;
import request.RequestProcessor;
import session.Session;
import setup.Admin;
import student.Student;

public class UnitTest4 {
	
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
    public void test_outputInvalidCommand() throws Exception {
		String SID = "11111111";
		String command = "InvalidCommand";
		
		RequestProcessor test_outputInvalidCommand = new RequestProcessor();
		test_outputInvalidCommand.outputInvalidCommand(SID, command);
		
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest4\\" + SID + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_processRequest_01() throws Exception {		
		class StubListTakenRegistered extends ListTakenRegistered {
			public void process(Student student, String command, String courseInput){
				try{
					File result = null;
					if (command.equalsIgnoreCase("ListTaken")) {
						result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
						FileOutputStream fos = new FileOutputStream(result);
						fos.write("The request is ListTaken".getBytes());
						fos.close();
					} else if (command.equalsIgnoreCase("ListRegistered")) {
						result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
						FileOutputStream fos = new FileOutputStream(result);
						fos.write("The request is ListRegistered".getBytes());
						fos.close();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}	
				
			}
		}
		
		Student student = new Student("EdnaBuchanan 22222222 password BACM NULL/NULL");
		String command = "ListTaken";
		
		StubListTakenRegistered test_processRequest = new StubListTakenRegistered();
		RequestProcessor rp = new RequestProcessor(test_processRequest);
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest4\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_processRequest_02() throws Exception {
		class StubListTakenRegistered extends ListTakenRegistered {
			public void process(Student student, String command, String courseInput){
				try{
					File result = null;
					if (command.equalsIgnoreCase("ListTaken")) {
						result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
						FileOutputStream fos = new FileOutputStream(result);
						fos.write("The request is ListTaken".getBytes());
						fos.close();
					} else if (command.equalsIgnoreCase("ListRegistered")) {
						result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
						FileOutputStream fos = new FileOutputStream(result);
						fos.write("The request is ListRegistered".getBytes());
						fos.close();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}	
				
			}
		}
		
		Student student = new Student("EdnaBuchanan 33333333 password BACM NULL/NULL");
		String command = "ListRegistered";

		StubListTakenRegistered test_processRequest = new StubListTakenRegistered();
		RequestProcessor rp = new RequestProcessor(test_processRequest);
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest4\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_processRequest_03() throws Exception {
		class StubListAllAvailable extends ListAllAvailable {
			public void process(Student student, String command, String courseInput){
				try{
					File result = null;
					result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
					FileOutputStream fos = new FileOutputStream(result);
					fos.write("The request is ListAllAvailable".getBytes());
					fos.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}	
				
			}
		}
		
		Student student = new Student("EdnaBuchanan 44444444 password BACM NULL/NULL");
		String command = "ListAllAvailable";
		
		StubListAllAvailable test_processRequest = new StubListAllAvailable();
		RequestProcessor rp = new RequestProcessor(test_processRequest);
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest4\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_processRequest_04() throws Exception {
		class StubListPossibleSchedule extends ListPossibleSchedule {
			public void process(Student student, String command, String courseInput){
				try{
					File result = null;
					result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
					FileOutputStream fos = new FileOutputStream(result);
					fos.write("The request is ListPossibleSchedule".getBytes());
					fos.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}	
				
			}
		}
		
		Student student = new Student("EdnaBuchanan 55555555 password BACM NULL/NULL");
		String command = "ListPossibleSchedule";
		
		StubListPossibleSchedule test_processRequest = new StubListPossibleSchedule();
		RequestProcessor rp = new RequestProcessor(test_processRequest);
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest4\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_processRequest_05() throws Exception {
		Student student = new Student("EdnaBuchanan 66666666 password BACM NULL/NULL");
		String command = "InvalidCommand";
		
		RequestProcessor rp = new RequestProcessor();
		rp.processRequest(student, command, "");
		
		File result = new File(".\\Result\\" + student.getSID() + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\UnitTest4\\" + student.getSID() + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
}
