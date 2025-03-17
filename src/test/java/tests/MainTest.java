package tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import utils.Utils;

public class MainTest extends BaseTest {
	
	@BeforeClass
	private void login() {
		loginPage.preLogin();
		loginPage.login(Utils.readProperty("userName"),Utils.readProperty("password"));
	}
	
	@Epic("Main Page Tests")
	@Story("Check product name")
	@Test
	private void tc01_isProductBtn() {
		assertTrue(mainPage.isProductName());
	}

	@Epic("Main Page Tests")
	@Story("Check Deploy button")
	@Test
	private void tc02_isDeployAvailable() {
		assertTrue(mainPage.isDeployAvailable());
	}
	
	@Epic("Main Page Tests")
	@Story("Check user's role")
	@Test
	private void tc03_isRoleSuperAdmin() {
		assertTrue(mainPage.isRoleSuperAdmin());
	}

	@Epic("Main Page Tests")
	@Story("Check health table")
	@Test
	private void tc04_isHealthSummary() {	
		assertTrue(mainPage.isHealthSummaryAvailable());
	}
	
	@Epic("Main Page Tests")
	@Story("Check business value table")
	@Test
	private void tc05_isBusinessValue() {	
		assertTrue(mainPage.isBusinessValueAvailable());
	}

	@Epic("Main Page Tests")
	@Story("Check incident table")
	@Test
	private void tc06_isIncidentsCollected() {	
		assertTrue(mainPage.isIncidentCollected());
	}
}