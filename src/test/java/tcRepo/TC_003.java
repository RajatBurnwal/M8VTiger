package tcRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import pomClasses.CreatingNewLeadPage;
import pomClasses.HomePage;
import pomClasses.LeadsPage;

public class TC_003 extends BaseClass {

	@Test(groups = {"Sanity"})
	public void leads_003() throws Exception
	{
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadsMenu();
		
		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnCreateLeadIcon();
		
		String fName=eUtil.getDataFromExcel("Leads", 8, 1);
		String lName=eUtil.getDataFromExcel("Leads", 8, 2);
		String company=eUtil.getDataFromExcel("Leads", 8, 3);
		String phone=eUtil.getDataFromExcel("Leads", 8, 4);
		String website=eUtil.getDataFromExcel("Leads", 8, 5);
		String noOfEmployees=eUtil.getDataFromExcel("Leads", 8, 6);
		String country=eUtil.getDataFromExcel("Leads", 8, 7);
		String city=eUtil.getDataFromExcel("Leads", 8, 8);
		String state=eUtil.getDataFromExcel("Leads", 8, 9);
		CreatingNewLeadPage cnlp=new CreatingNewLeadPage(driver);
		cnlp.createNewLead(fName, lName, company, phone, website, noOfEmployees, country, city, state);
	}
}
