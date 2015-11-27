/**
 * Integration Testing 2: MajorGenerator + Major Class
 * Date: 
 */

package testSetup;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import junit.framework.TestCase;
import major.BACM;
import major.BAS;
import major.BEngSE;
import major.BSCCM;
import major.LLB;
import major.Major;
import major.MajorGenerator;

public class IntegrationTest2 extends TestCase{
	
	@Test
    public void test_createMajor_01() throws Exception {
		boolean finalResult = false;
		Major m1 = MajorGenerator.createMajor("LLB");
		if(m1 instanceof LLB) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_createMajor_02() throws Exception {
		boolean finalResult = false;
		Major m1 = MajorGenerator.createMajor("BACM");
		if(m1 instanceof BACM) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_createMajor_03() throws Exception {
		boolean finalResult = false;
		Major m1 = MajorGenerator.createMajor("BSCCM");
		if(m1 instanceof BSCCM) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_createMajor_04() throws Exception {
		boolean finalResult = false;
		Major m1 = MajorGenerator.createMajor("BAS");
		if(m1 instanceof BAS) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_createMajor_05() throws Exception {
		boolean finalResult = false;
		Major m1 = MajorGenerator.createMajor("BEngSE");
		if(m1 instanceof BEngSE) {
			finalResult = true;
		}
		assertEquals(finalResult, true);
    }
	
	@Test
    public void test_getName_01() throws Exception {
		Major m1 = new BACM("Bachelor of Arts in Creative Media");
		String result = m1.getName();
		assertEquals(result, "Bachelor of Arts in Creative Media");
    }
	
	@Test
    public void test_getName_02() throws Exception {
		Major m1 = new BAS("Bachelor of Arts and Science in New Media");
		String result = m1.getName();
		assertEquals(result, "Bachelor of Arts and Science in New Media");
    }
	
	@Test
    public void test_getName_03() throws Exception {
		Major m1 = new BSCCM("Bachelor of Science in Creative Media");
		String result = m1.getName();
		assertEquals(result, "Bachelor of Science in Creative Media");
    }
	
	@Test
    public void test_getName_04() throws Exception {
		Major m1 = new BEngSE("Bachelor of Engineering in Energy Science and Engineering");
		String result = m1.getName();
		assertEquals(result, "Bachelor of Engineering in Energy Science and Engineering");
    }
	
	@Test
    public void test_getName_05() throws Exception {
		Major m1 = new LLB("Bachelor of Laws");
		String result = m1.getName();
		assertEquals(result, "Bachelor of Laws");
    }
}
