package sample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertionPractice {

	@Test
	public void strictLevelHardAssertion()
	{
		String expectedName="Ravi";
		String actualName="Rani";
//		Assert.assertEquals(actualName, expectedName);
		Assert.assertEquals(actualName.equals(expectedName), true);
		System.out.println("Validation ended");
	}
	
	@Test
	public void containsLevelHardAssertion()
	{
		String expectedName="don";
		String actualName="London";
		Assert.assertTrue(actualName.contains(expectedName));
		System.out.println("Validation ended");
	}
}
