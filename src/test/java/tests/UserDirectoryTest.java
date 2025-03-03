package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.Utils;

public class UserDirectoryTest extends BaseTest {
	
	@BeforeClass
	public void enterUserDirectoryPage() {
		loginPage.preLogin();
		loginPage.login(Utils.readProperty("userName"),Utils.readProperty("password"));
		mainPage.openUserDirectory();
	}
	
	@Test
	private void tc01_verifyToolbarMenu() {
		userDirectoryPage.verifyToolbarMenus();
		assertTrue(userDirectoryPage.verifyToolbarMenus());
	}
	
	@Test
	private void tc02_verifyTableMenu() {
		userDirectoryPage.verifyTableMenus();
		assertTrue(userDirectoryPage.verifyTableMenus());
	}
	
	@Test
	private void tc03_deleteBtnPressedNothingSelected() {
		String expected = "Please select the name(s) of the user directory server(s) to delete.";
		String actual = userDirectoryPage.deleteBtnPressedNothingSelected();
		assertEquals(actual, expected);		
	}
	
	@Test
	private void tc04_importNowBtnPressedNothingSelected() {
		String expected = "Please select the user directory or directories to import.";
		String actual = userDirectoryPage.importNowBtnPressed();
		assertEquals(actual, expected);		
	}
	
	@Test
	private void tc05_isAdListEmpty() {
		assertTrue(userDirectoryPage.isAdListEmpty());
	}
}
