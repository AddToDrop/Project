/**
 * Unit Testing 1: RequestProcessor
 * Date: 
 */

package testRequest;

import org.junit.Test;

import request.RequestProcessor;
import session.Session;
import student.Student;

public class UnitTest1 {
	@Test
    public void test_processRequest_01() throws Exception {
		Student student = new Student("RonaldRichardson 50000001 password LLB NULL/GE1401_47326,GE1202_44812,LW2600_39585");
		RequestProcessor rp = new RequestProcessor();
		rp.processRequest(student, "InvalidCommand", "GE1202");
		
    }
	
}
