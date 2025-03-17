package tests;

import org.testng.ITestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Utils;

import pageobjects.DirectoryServerPage;
import pageobjects.DocsPage;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.UserDirectoryPage;

public class BaseTest {
	WebDriver driver;
	LoginPage loginPage;
	DocsPage docsPage;
	MainPage mainPage;
	UserDirectoryPage userDirectoryPage;
	DirectoryServerPage directoryServerPage; 

	@BeforeClass
	protected void setup(ITestContext testContext) {	
		driver = WebDriverManager.chromedriver().create();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Utils.readProperty("url"));
		loginPage = new LoginPage(driver);
		docsPage = new DocsPage(driver);
		mainPage = new MainPage(driver);
		userDirectoryPage = new UserDirectoryPage(driver);
		directoryServerPage = new DirectoryServerPage(driver);
	
		testContext.setAttribute("WebDriver", this.driver);
	} 
	
	@AfterClass
	public void tearDown() {	
		driver.quit();
	}
}


