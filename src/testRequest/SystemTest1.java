/**
 * System Testing 1
 * Date: 
 */

package testRequest;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junitx.framework.FileAssert;
import request.RequestProcessor;
import session.Session;
import setup.Admin;
import student.Student;

public class SystemTest1 {
	
	public static boolean init2 = false; 
	
	@After
	public void setup(){
		Admin admin = Admin.getInstance();
		if (!init2) {
			admin.startSetup();
			init2 = true;
		}
		admin.getRequest();
	}
	

	@Test
    public void test_01() throws Exception {
		String SID = "500001";
		String command = "ListPossibleSchedule";
		
		File request = new File (".\\Requests\\" + SID + "_" + command + "_SystemTest1.txt");
		FileOutputStream fos = new FileOutputStream(request);
				
		try {
			fos.write(SID.getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write("password".getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write(command.getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write("GE2401 GE1110".getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\SystemTest1\\" + SID + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_02() throws Exception {
		String SID = "50000001";
		String command = "ListTaken";
		
		File request = new File (".\\Requests\\" + SID + "_" + command + "_SystemTest1.txt");
		FileOutputStream fos = new FileOutputStream(request);
				
		try {
			fos.write(SID.getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write("password".getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write(command.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\SystemTest1\\" + SID + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_03() throws Exception {
		String SID = "50000002";
		String command = "ListTaken";
		
		File request = new File (".\\Requests\\" + SID + "_" + command + "_SystemTest1.txt");
		FileOutputStream fos = new FileOutputStream(request);
				
		try {
			fos.write(SID.getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write("password".getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write(command.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\SystemTest1\\" + SID + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_04() throws Exception {
		String SID = "50000017";
		String command = "ListRegistered";
		
		File request = new File (".\\Requests\\" + SID + "_" + command + "_SystemTest1.txt");
		FileOutputStream fos = new FileOutputStream(request);
				
		try {
			fos.write(SID.getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write("password".getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write(command.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\SystemTest1\\" + SID + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_05() throws Exception {
		String SID = "50000020";
		String command = "ListRegistered";
		
		File request = new File (".\\Requests\\" + SID + "_" + command + "_SystemTest1.txt");
		FileOutputStream fos = new FileOutputStream(request);
				
		try {
			fos.write(SID.getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write("password".getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write(command.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\SystemTest1\\" + SID + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_06() throws Exception {
		String SID = "50000014";
		String command = "ListAllAvailable";
		
		File request = new File (".\\Requests\\" + SID + "_" + command + "_SystemTest1.txt");
		FileOutputStream fos = new FileOutputStream(request);
				
		try {
			fos.write(SID.getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write("password".getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write(command.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\SystemTest1\\" + SID + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
	
	@Test
    public void test_07() throws Exception {
		String SID = "50000015";
		String command = "ListPossibleSchedule";
		
		File request = new File (".\\Requests\\" + SID + "_" + command + "_SystemTest1.txt");
		FileOutputStream fos = new FileOutputStream(request);
				
		try {
			fos.write(SID.getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write("password".getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write(command.getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
			fos.write("GE2401 GE1110".getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		File expected = new File(".\\TestRequest\\SystemTest1\\" + SID + "_" + command + ".txt");
		FileAssert.assertEquals(expected, result);
    }
}
