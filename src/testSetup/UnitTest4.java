/**
 * Unit Testing 4: College Class
 */

package testSetup;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

import college.College;
import college.Law;
import college.SCM;
import college.SEE;
import junit.framework.TestCase;

public class UnitTest4 extends TestCase{
	
	@Test
    public void test_getName_01() throws Exception {
		College c1 = new Law("Law LLB");
		String result = c1.getName();
		assertEquals(result, "Law");
    }
	
	@Test
    public void test_getName_02() throws Exception {
		College c1 = new SCM("SCM BACM/BSCCM/BAS");
		String result = c1.getName();
		assertEquals(result, "SCM");
    }
	
	@Test
    public void test_getName_03() throws Exception {
		College c1 = new SEE("SEE BEngSE");
		String result = c1.getName();
		assertEquals(result, "SEE");
    }
	
}
