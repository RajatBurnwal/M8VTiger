package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {

	@FindBy(xpath="//img[@title='Create Lead...']")
	private WebElement createLeadIcon;
	
	public LeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateLeadIcon() {
		return createLeadIcon;
	}
	
	/**
	 * This is a business library which will click on Create New Lead Icon
	 */
	public void clickOnCreateLeadIcon()
	{
		getCreateLeadIcon().click();
	}
}
