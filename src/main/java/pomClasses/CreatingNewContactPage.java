package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewContactPage {

	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstNameTextField;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameTextField;
	
	@FindBy(xpath="//select[@name='leadsource']")
	private WebElement leadSourceDropdown;
	
	@FindBy(xpath="//input[@name='title']")
	private WebElement titleTextField;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailTextField;
	
	@FindBy(xpath="//input[@name='mailingcity']")
	private WebElement mailingCityTextField;
	
	@FindBy(xpath="//input[@name='mailingstate']")
	private WebElement mailingStateTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public CreatingNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getLeadSourceDropdown() {
		return leadSourceDropdown;
	}

	public WebElement getTitleTextField() {
		return titleTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getMailingCityTextField() {
		return mailingCityTextField;
	}

	public WebElement getMailingStateTextField() {
		return mailingStateTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/**
	 * This is a business library to create a new contact based on first name, last name and lead source
	 * @param firstName
	 * @param lastName
	 * @param leadSource
	 */
	public void createNewContact(String firstName, String lastName, String leadSource)
	{
		getFirstNameTextField().sendKeys(firstName);
		getLastNameTextField().sendKeys(lastName);
		Select sel=new Select(getLeadSourceDropdown());
		sel.selectByValue(leadSource);
		getSaveButton().click();
	}
	
	/**
	 * This is a business library to create a new contact based on first name, last name, title and email
	 * @param firstName
	 * @param lastName
	 * @param title
	 * @param email
	 */
	public void createNewContact(String firstName, String lastName, String title, String email)
	{
		getFirstNameTextField().sendKeys(firstName);
		getLastNameTextField().sendKeys(lastName);
		getTitleTextField().sendKeys(title);
		getEmailTextField().sendKeys(email);
		getSaveButton().click();
	}
	
	/**
	 * This is a business library to create a new contact based on first name, last name, title, email, mailing city and mailing state
	 * @param firstName
	 * @param lastName
	 * @param title
	 * @param email
	 * @param mailingCity
	 * @param mailingState
	 */
	public void createNewContact(String firstName, String lastName, String title, String email, String mailingCity, String mailingState)
	{
		getFirstNameTextField().sendKeys(firstName);
		getLastNameTextField().sendKeys(lastName);
		getTitleTextField().sendKeys(title);
		getEmailTextField().sendKeys(email);
		getMailingCityTextField().sendKeys(mailingCity);
		getMailingStateTextField().sendKeys(mailingState);
		getSaveButton().click();
	}
}
