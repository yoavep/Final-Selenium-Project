package tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.Utils;

public class MainTest extends BaseTest {
	
	@BeforeClass
	private void login() {
		loginPage.preLogin();
		loginPage.login(Utils.readProperty("userName"),Utils.readProperty("password"));
	}
	
	@Test
	private void tc01_isProductBtn() {
		assertTrue(mainPage.isProductName());
	}

	@Test
	private void tc02_isDeployAvailable() {
		assertTrue(mainPage.isDeployAvailable());
	}
	
	@Test
	private void tc03_isRoleSuperAdmin() {
		assertTrue(mainPage.isRoleSuperAdmin());
	}

	@Test
	private void tc04_isHealthSummary() {	
		assertTrue(mainPage.isHealthSummaryAvailable());
	}
	
	@Test
	private void tc05_isBusinessValue() {	
		assertTrue(mainPage.isBusinessValueAvailable());
	}
	
	@Test
	private void tc06_isIncidentsCollected() {	
		assertTrue(mainPage.isIncidentCollected());
	}

}