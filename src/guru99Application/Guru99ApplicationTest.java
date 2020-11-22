package guru99Application;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Guru99ApplicationTest {
	ChromeDriver driver;
	String url = "http://demo.guru99.com/v4/";
	
	@Test(priority = -1)
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Siddhartha Dutta\\Desktop\\Selenium Testing\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 0)
	public void verifyPageTitle() {
		String expectedTitle = "Guru99 Bank Home Page";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority = 1)
	public void verifyPageLogin() {
		WebElement inputUserID = driver.findElementByName("uid");
		WebElement inputPassword = driver.findElementByName("password");
		WebElement inputLoginButton = driver.findElementByName("btnLogin");
		
		inputUserID.sendKeys("mngr295959");
		inputPassword.sendKeys("qeqegep");
		inputLoginButton.click();
	}
	
	@Test(priority = 2)
	public void addCustomer() {
		WebElement linkAddCustomer = driver.findElementByLinkText("New Customer");
		linkAddCustomer.click();
		
		driver.findElementByName("name").sendKeys("Siddhartha Dutta");
		//driver.findElementByXPath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]").click();
		driver.findElementByXPath("//input[@value=\"m\"]").click();
		driver.findElementByName("dob").sendKeys("06/08/1999");
		driver.findElementByName("addr").sendKeys("Mumbai");
		driver.findElementByName("city").sendKeys("Mumbai");
		driver.findElementByName("state").sendKeys("Maharashtra");
		driver.findElementByName("pinno").sendKeys("400000");
		driver.findElementByName("telephoneno").sendKeys("1234567890");
		driver.findElementByName("emailid").sendKeys("siddharthadutta@protonmail.com");
		driver.findElementByName("password").sendKeys("HelloWorld");
		driver.findElementByName("sub").click();
	}
	
	@Test(priority = 3)
	public void getCustomerId() {
		String customerID = driver.findElementByXPath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]").getText();
		System.out.println("Customer Created with Customer ID: " + customerID);
	}
	
	
}
