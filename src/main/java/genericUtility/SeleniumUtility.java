package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

/**
 * This is an utility class which contains generic methods from Selenium library
 * @author rajat burnwal
 * @version 01.10.25
 */
public class SeleniumUtility {

	/**
	 * This is a generic method to open an application in the browser
	 * @param driver
	 * @param URL
	 */
	public void accessToApplication(WebDriver driver, String URL)
	{
		driver.get(URL);
	}
	
	/**
	 * This is a generic method to perform browser maximization
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	/**
	 * This is a generic method to apply implicit wait to the script
	 * @param driver
	 * @param maxTime
	 */
	public void implicitWait(WebDriver driver, int maxTime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(maxTime));
	}

	////////////******Handling Dropdown******/////////
	
	/**
	 * This is a generic method to select an option in a drop down using the index
	 * @param dropdownElement
	 * @param index
	 */
	public void selectOptionUsingIndex(WebElement dropdownElement, int index)
	{
		Select sel=new Select(dropdownElement);
		sel.selectByIndex(index);
	}

	/**
	 * This is a generic method to select an option in a drop down using the value attribute
	 * @param dropdownElement
	 * @param value
	 */
	public void selectOptionUsingValueAttribute(WebElement dropdownElement, String value)
	{
		Select sel=new Select(dropdownElement);
		sel.selectByValue(value);
	}
	
	/**
	 * This is a generic method to select an option in a drop down using the visible text
	 * @param dropdownElement
	 * @param visibleText
	 */
	public void selectOptionUsingVisibleText(WebElement dropdownElement, String visibleText)
	{
		Select sel=new Select(dropdownElement);
		sel.selectByVisibleText(visibleText);
	}

	///////********Handling Alert*******/////////
	
	/**
	 * This is a generic method to accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This is a generic method to cancel the alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This is a generic method to fetch the alert message from the alert popup
	 * @param driver
	 * @return
	 */
	public String getAlertMessage(WebDriver driver)
	{
		String alertMessage=driver.switchTo().alert().getText();
		return alertMessage;
	}
	
	/**
	 * This is a generic method to pass value to the alert popup
	 * @param driver
	 * @param value
	 */
	public void sendValueToAlert(WebDriver driver, String value)
	{
		driver.switchTo().alert().sendKeys(value);
	}
	
	///////******Handling Mouse Actions*******//////////
	
	/**
	 * This is a generic method to perform mouse hovering action on a webelement
	 * @param driver
	 * @param element
	 */
	public void mouseHoveringAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/////////******Handling Frames*******////////
	
	/**
	 * This is a generic method to switch the driver control to a frame using index
	 * @param driver
	 * @param index
	 */
	public void switchToAFrameUsingIndex(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}

	/**
	 * This is a generic method to switch the driver control to a frame using name or id attribute
	 * @param driver
	 * @param nameOrIdAttribute
	 */
	public void switchToAFrameUsingNameOrId(WebDriver driver, String nameOrIdAttribute)
	{
		driver.switchTo().frame(nameOrIdAttribute);
	}
	
	/**
	 * This is a generic method to switch the driver control to a frame using frame element
	 * @param driver
	 * @param frameElement
	 */
	public void switchToAFrameUsingFrameElement(WebDriver driver, WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	/**
	 * This is a generic method to take the screenshot of a webpage
	 * @param driver
	 * @param dateTimeStamp
	 * @return
	 * @throws IOException
	 */
	public String getWebpageScreenshot(WebDriver driver, String dateTimeStamp) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\Screenshot\\image-"+dateTimeStamp+".png");
		Files.copy(src, dest);
		return dest.getAbsolutePath();			//used in Listeners
	}
	
	
}