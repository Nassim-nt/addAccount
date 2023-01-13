package addBankAccount;



import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;





public class NewAccount {
	
	
	WebDriver driver; // declaration of driver
	
	//webElements list;
	By USER_NAME_FIELD = By.xpath("//input[@id='username']");
	By PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By SIGNIN_BUTTON_FIELD = By.xpath("//button[@name='login']");
	By DASHBOARD_HEADER_FIELD = By.xpath("//h2[text()=' Dashboard ']");
	By BANK_CASH_BUTTON_FIELD = By.xpath("//span[text()='Bank & Cash']");
	By NEW_ACCOUNT_FIELD = By.linkText("New Account");
	By ACCOUNT_HEADER_FIELD = By.xpath("//h2[text()=' Accounts ']");
	By ACCOUNT_TITLE_FIELD = By.xpath("//input[@id='account']");
	By DESCRIPTION_FIELD = By.xpath("//input[@id='description']");
	By INITIAL_BALANCE_FIELD = By.xpath("//input[@id='balance']");
	By ACCOUNT_NUMBER_FIELD = By.xpath("//input[@id='account_number']");
	By CONTACT_PERSON_FIELD =By.xpath("//input[@id='contact_person']");
	By PHONE_NUMBER_FIELD = By.xpath("//input[@id='contact_phone']");
	By SUBMIT_BUTTON_FIELD = By.xpath("//button[@class='btn btn-primary']");
	
	
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver(); //// to launch a browser, we need to create an object
		driver.manage().deleteAllCookies();
		driver.get("http://www.techfios.com/billing/?ng=admin/ ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
	}
	
	//@Test
	public void logInTest() {
		
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGNIN_BUTTON_FIELD).click();
		Assert.assertTrue("Dashboard page not found", driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());
	}
	@Test
	public void addAccount() {
		logInTest();
		
		driver.findElement(BANK_CASH_BUTTON_FIELD).click();
		driver.findElement(NEW_ACCOUNT_FIELD).click();
		
		String accountheadertext= driver.findElement(ACCOUNT_HEADER_FIELD).getText();
		Assert.assertEquals("Dashboard page not found", "Accounts", accountheadertext);
		
		driver.findElement(ACCOUNT_TITLE_FIELD).sendKeys("BusinessAccount03");
		driver.findElement(DESCRIPTION_FIELD).sendKeys("Checking");
		driver.findElement(INITIAL_BALANCE_FIELD).sendKeys("500");
		driver.findElement(ACCOUNT_NUMBER_FIELD).sendKeys("888 888 8888");
		driver.findElement(CONTACT_PERSON_FIELD).sendKeys("Mandi");
		driver.findElement(PHONE_NUMBER_FIELD).sendKeys("+12109999999");
		driver.findElement(SUBMIT_BUTTON_FIELD).click();
		
		String textalert = driver.findElement(By.xpath("//div[@class ='alert alert-success fade in']")).getText();
		System.out.println(textalert);
		
	}
	
	@After
	public void tearDown() {
		
			driver.close();
			driver.quit();
		
	}
}
