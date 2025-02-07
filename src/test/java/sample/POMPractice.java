package sample;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMPractice {

	@FindBy(xpath="//input[@id='name']")
	WebElement nameTextField;
	
	@FindAll({@FindBy(xpath="//input[@id='name']"), @FindBy(id="email")})
	WebElement element;
	
	public POMPractice(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		Thread.sleep(2000);
		POMPractice p=new POMPractice(driver);
//		p.nameTextField.sendKeys("Robin");
//		Thread.sleep(2000);
//		driver.navigate().refresh();
//		Thread.sleep(2000);
//		p.nameTextField.sendKeys("Hood");
		p.element.sendKeys("hello");
		

	}

}
