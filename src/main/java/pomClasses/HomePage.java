package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath="//td[@class='tabUnSelected']/a[text()='Leads']")
	private WebElement leadsMenu;
	
	@FindBy(xpath="//td[@class='tabUnSelected']/a[text()='Contacts']")
	private WebElement contactsMenu;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement accountsIcon;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutOption;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLeadsMenu() {
		return leadsMenu;
	}

	public WebElement getContactsMenu() {
		return contactsMenu;
	}

	public WebElement getAccountsIcon() {
		return accountsIcon;
	}

	public WebElement getSignOutOption() {
		return signOutOption;
	}
	
	/**
	 * This is a business library to click on Leads menu in Home Page
	 */
	public void clickOnLeadsMenu()
	{
		getLeadsMenu().click();
	}
	
	/**
	 * This is a business library to click on Contacts menu in Home Page
	 */
	public void clickOnContactsMenu()
	{
		getContactsMenu().click();
	}
	
	/**
	 * This is a business library to perform sign out operation from the application
	 * @param driver
	 */
	public void signOutOperation(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(getAccountsIcon()).perform();
		getSignOutOption().click();
	}
}
