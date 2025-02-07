package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewLeadPage {

	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstNameTextField;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameTextField;
	
	@FindBy(xpath="//input[@name='company']")
	private WebElement companyTextField;
	
	@FindBy(xpath="//input[@id='phone']")
	private WebElement phoneTextField;
	
	@FindBy(xpath="//input[@name='website']")
	private WebElement websiteTextField;
	
	@FindBy(xpath="//input[@name='noofemployees']")
	private WebElement noOfEmployeesTextField;
	
	@FindBy(xpath="//input[@name='country']")
	private WebElement countryTextField;
	
	@FindBy(xpath="//input[@name='city']")
	private WebElement cityTextField;
	
	@FindBy(xpath="//input[@name='state']")
	private WebElement stateTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public CreatingNewLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getCompanyTextField() {
		return companyTextField;
	}

	public WebElement getPhoneTextField() {
		return phoneTextField;
	}

	public WebElement getWebsiteTextField() {
		return websiteTextField;
	}

	public WebElement getNoOfEmployeesTextField() {
		return noOfEmployeesTextField;
	}

	public WebElement getCountryTextField() {
		return countryTextField;
	}

	public WebElement getCityTextField() {
		return cityTextField;
	}

	public WebElement getStateTextField() {
		return stateTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/**
	 * This is a business library to create a new lead based on lastname and company
	 * @param lastName
	 * @param company
	 */
	public void createNewLead(String lastName, String company)
	{
		getLastNameTextField().sendKeys(lastName);
		getCompanyTextField().sendKeys(company);
		getSaveButton().click();
	}
	
	/**
	 * This is a business library to create a new lead based on firts name, last name, phone and website
	 * @param firstName
	 * @param lastName
	 * @param phone
	 * @param website
	 */
	public void createNewLead(String firstName, String lastName, String company, 
			String phone, String website)
	{
		getFirstNameTextField().sendKeys(firstName);
		getLastNameTextField().sendKeys(lastName);
		getCompanyTextField().sendKeys(company);
		getPhoneTextField().sendKeys(phone);
		getWebsiteTextField().sendKeys(website);
		getSaveButton().click();
	}
	
	/**
	 * This is a business library to create a new lead based on firts name, last name, phone, website,
	 * no of employees, country, city and state
	 * @param firstName
	 * @param lastName
	 * @param phone
	 * @param website
	 * @param noOfEmployees
	 * @param country
	 * @param city
	 * @param state
	 */
	public void createNewLead(String firstName, String lastName, String company, 
			String phone, String website, String noOfEmployees, String country, 
			String city, String state)
	{
		getFirstNameTextField().sendKeys(firstName);
		getLastNameTextField().sendKeys(lastName);
		getCompanyTextField().sendKeys(company);
		getPhoneTextField().sendKeys(phone);
		getWebsiteTextField().sendKeys(website);
		getNoOfEmployeesTextField().sendKeys(noOfEmployees);
		getCountryTextField().sendKeys(country);
		getCityTextField().sendKeys(city);
		getStateTextField().sendKeys(state);
		getSaveButton().click();
	}
}
