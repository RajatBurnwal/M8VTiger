package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is a Login page POM class
 * @author rajat burnwal
 * @version 01.07.25
 */
public class LoginPage {

	@FindBy(xpath="//input[@name='user_name']")
	private WebElement usernameTextField;
	
	@FindBy(xpath="//input[@name='user_password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//input[@id='submitButton']")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	/**
	 * This is a business library to perform login operation to the application
	 * @param username
	 * @param password
	 */
	public void loginToApplication(String username, String password)
	{
		getUsernameTextField().sendKeys(username);
		getPasswordTextField().sendKeys(password);
		getLoginButton().click();
	}
}
