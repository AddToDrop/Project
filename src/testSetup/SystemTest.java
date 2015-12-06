package testSetup;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import junit.framework.TestCase;
import setup.Admin;

public class SystemTest {
	
	@Test
    public void test_startSetup_01() throws Exception {
		Admin admin = Admin.getInstance();
		admin.startSetup();
		boolean finalResult = true;
		
		assertEquals(finalResult, true);
    }
	
}
