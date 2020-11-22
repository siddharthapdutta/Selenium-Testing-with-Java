package seleniumScripts;

import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithChrome {
	ChromeDriver driver;
	String url = "http://demo.guru99.com/v4/";
	
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Siddhartha Dutta\\Desktop\\Selenium Testing\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	public void getTitle() {
		String pageTitle = driver.getTitle();
		System.out.print("Title of the Page: " + pageTitle);
	}
	
	public void closeBrowser() {
		//driver.close();
		driver.quit();
	}
	
	public static void main(String[] args) {
		WorkingWithChrome obj = new WorkingWithChrome();
		obj.invokeBrowser();
		obj.getTitle();
		obj.closeBrowser();
	}
}
