package tcRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import pomClasses.CreatingNewLeadPage;
import pomClasses.HomePage;
import pomClasses.LeadsPage;

public class TC_002 extends BaseClass{

	@Test(groups = {"Regression"})
	public void leads_002() throws Exception
	{
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadsMenu();
		
		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnCreateLeadIcon();
		
		String fName=eUtil.getDataFromExcel("Leads", 5, 1);
		String lName=eUtil.getDataFromExcel("Leads", 5, 2);
		String company=eUtil.getDataFromExcel("Leads", 5, 3);
		String phone=eUtil.getDataFromExcel("Leads", 5, 4);
		String website=eUtil.getDataFromExcel("Leads", 5, 5);
		CreatingNewLeadPage cnlp=new CreatingNewLeadPage(driver);
		cnlp.createNewLead(fName, lName, company, phone, website);		
		
	}
}
