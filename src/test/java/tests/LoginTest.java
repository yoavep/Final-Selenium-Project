package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.Excel;
import utils.Utils;

public class LoginTest extends BaseTest {
	
	@BeforeClass
	public void loginFirstTime() {
		loginPage.preLogin();		
	}
	
	@Test
	public void tc01_isVersionRight() {
		assertTrue(loginPage.isVersionRight());
	}
	
	@Test(dataProvider="getDataFromExcel")
	public void tc02_loginFailures(String userName, String password, String expectedError) {
		loginPage.login(userName, password);
		String expected = expectedError;
		String actual = loginPage.getErrorMsg();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void tc10_loginSucceed() {
		loginPage.login(Utils.readProperty("userName"),Utils.readProperty("password"));
		assertTrue(mainPage.isDeployAvailable());
		assertTrue(mainPage.isBusinessValueAvailable());
		assertTrue(mainPage.isHealthSummaryAvailable()); 
	}
	
	@DataProvider
	public Object[][] getDataFromExcel(){
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\Tests.xlsx";
		Object[][] table = Excel.getTableArray(excelPath, "Login");
		return table;
	}
}
