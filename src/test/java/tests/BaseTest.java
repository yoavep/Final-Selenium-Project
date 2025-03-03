package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pageobjects.DirectoryServerPage;
import pageobjects.DocsPage;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.UserDirectoryPage;
import utils.Utils;

public class BaseTest {
	WebDriver driver;
	LoginPage loginPage;
	DocsPage docsPage;
	MainPage mainPage;
	UserDirectoryPage userDirectoryPage;
	DirectoryServerPage directoryServerPage; 

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Utils.readProperty("url"));
		loginPage = new LoginPage(driver);
		docsPage = new DocsPage(driver);
		mainPage = new MainPage(driver);
		userDirectoryPage = new UserDirectoryPage(driver);
		directoryServerPage = new DirectoryServerPage(driver);
	} 
	
	@AfterClass
	public void tearDown() {		
		driver.quit();
	}
}


