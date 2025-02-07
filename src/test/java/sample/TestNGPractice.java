package sample;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(genericUtility.ListenersImplementation.class)
public class TestNGPractice {

	@Test(priority = 3)
	public void createUser()
	{
		System.out.println("User created");
	}
	
//	@Ignore
	@Test(priority = 1, invocationCount = 3)
	public void modifyUser()
	{
		System.out.println("User modified");
//		Assert.fail();
	}
	
	@Test(dependsOnMethods = {"modifyUser"}, enabled = true)
	public void deleteUser()
	{
		System.out.println("User deleted");
	}
}
