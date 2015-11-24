/**
 * Integration Testing 3: CollegeGenerator + College Class
 * Date: 
 */

package testSetup;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

import college.College;
import college.CollegeGenerator;
import college.Law;
import college.SCM;
import college.SEE;
import junit.framework.TestCase;

public class IntegrationTest3 extends TestCase{
	
	@Test
    public void test_createCollege_01() throws Exception {
		boolean finalResult = false;
		College c1 = CollegeGenerator.createCollege("Law LLB");
		if(c1 instanceof Law) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_createCollege_02() throws Exception {
		boolean finalResult = false;
		College c1 = CollegeGenerator.createCollege("SCM BACM/BSCCM/BAS");
		if(c1 instanceof SCM) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_createCollege_03() throws Exception {
		boolean finalResult = false;
		College c1 = CollegeGenerator.createCollege("SEE BEngSE");
		if(c1 instanceof SEE) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
}
