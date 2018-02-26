package poe.spring;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest_defaultBySpring extends TestCase
{
	public AppTest_defaultBySpring(String testName)
	{
		super(testName);
	}

	public static Test suite()
	{
		return new TestSuite(AppTest_defaultBySpring.class);
	}

	public void testApp()
	{
		assertTrue(true);
	}
}
