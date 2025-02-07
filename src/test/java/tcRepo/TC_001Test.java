package tcRepo;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import pomClasses.CreatingNewLeadPage;
import pomClasses.HomePage;
import pomClasses.LeadsPage;

@Listeners(genericUtility.ListenersImplementation.class)
public class TC_001Test extends BaseClass{

	@Test(groups = {"Smoke","Regression"})
	public void leads_001() throws Exception
	{
		System.out.println("Test execution started");
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadsMenu();
		
//		Assert.fail();
		
		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnCreateLeadIcon();
		
		String lName=eUtil.getDataFromExcel("Leads", 2, 1);
		String company=eUtil.getDataFromExcel("Leads", 2, 2);
		CreatingNewLeadPage cnlp=new CreatingNewLeadPage(driver);
		cnlp.createNewLead(lName, company);
		System.out.println("Test execution ended");
	}
}
