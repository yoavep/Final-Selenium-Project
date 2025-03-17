package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import utils.Excel;
import utils.Utils;

public class LoginTest extends BaseTest {
	
	@BeforeClass
	public void loginFirstTime() {
		loginPage.preLogin();		
	}
	
	@Epic("Login Tests")
	@Feature("Login Page Tests")
	@Story("Check version correctness")
	@Test (description = "Check that the version is correct")
	@Description("Check that the version is correct")
	public void tc01_isVersionRight() {
		assertTrue(loginPage.isVersionRight());
	}
	
	@Epic("Login Tests")
	@Feature("Login Tests")
	@Story("Login using invalid credentials")
	@Test(dataProvider="getDataFromExcel", description = "Try to login using wrong parameters")
	@Description("Try to login using wrong parameters")
	public void tc02_loginFailures(String userName, String password, String expectedError) {
		loginPage.login(userName, password);
		String expected = expectedError;
		String actual = loginPage.getErrorMsg();
		Assert.assertEquals(actual, expected);
	}
	
	@Epic("Login Tests")
	@Feature("Login Tests")
	@Story("Valid login")
	@Test(description = "Login to FSM")
	@Description("Login to FSM")
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
