package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import utils.Excel;
import utils.Utils;

public class DirectoryServerTest extends BaseTest {
	
	@BeforeClass
	public void createNewAD() {
		loginPage.preLogin();
		loginPage.login(Utils.readProperty("userName"),Utils.readProperty("password"));
		mainPage.openUserDirectory();
	}
	
	@Test(dataProvider="createNewAd", description = "Create a new active directory")
	@Description("Create a new valid active directory")
	public void tc01_createNewAd(String adName, String ipAddress,
			  String userName, String password, String expectedError) {
		directoryServerPage.createNewUserDirectory(adName, ipAddress, userName, password); 
		String expected = expectedError;
		String actual = directoryServerPage.getErrorMsg();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(dataProvider="createNewAdErrors", description = "Try to create an invalid active directory")
	@Description("Try to create an invalid active directory")
	public void tc02_createNewAdWithErrors(String adName, String ipAddress,
			  String userName, String password, String expectedError) {
		directoryServerPage.createNewUserDirectory(adName, ipAddress, userName, password); 
		String expected = expectedError;
		String actual = directoryServerPage.getErrorMsg();
		Assert.assertEquals(actual, expected);
	}
	
	@DataProvider
	public Object[][] createNewAd(){
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\Tests.xlsx";
		Object[][] table = Excel.getTableArray(excelPath, "ActiveDirectory");
		return table;
	}
	
	@DataProvider
	public Object[][] createNewAdErrors(){
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\Tests.xlsx";
		Object[][] table = Excel.getTableArray(excelPath, "ActiveDirectoryErrors");
		return table;
	}
}

