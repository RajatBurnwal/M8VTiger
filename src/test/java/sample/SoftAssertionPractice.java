package sample;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionPractice {

	@Test
	public void strictLevelSoftAssertion()
	{
		String expectedValue="hello";
		String actualValue="Hello";
		SoftAssert s=new SoftAssert();
		s.assertEquals(actualValue, expectedValue);
		System.out.println("Before assert all");
		System.out.println("Validation ended");
		s.assertAll();
	}
	
	@Test
	public void containsLevelSoftAssertion()
	{
		String expectedCity="Banga";
		String actualCity="Bangalore";
		SoftAssert s=new SoftAssert();
		s.assertEquals(actualCity.contains(expectedCity), true);
		s.assertFalse(actualCity.contains(expectedCity));
		System.out.println("Validation ended");
		s.assertAll();
	}
}
