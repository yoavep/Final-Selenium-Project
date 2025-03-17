package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;


public class DocsTest extends BaseTest {
	@BeforeClass
	public void openLoginPage() {
		loginPage.preLogin();
		loginPage.openDocsPage();
	}
	
	@Test(description = "Check if this is the Docs page")
	@Description("Check if this is the Docs page")
	public void tc01_isDocsPage() {
		assertTrue(docsPage.isDocsPage());
	}
	
	@Test(description = "Check if the Login button exists")
	@Description("Check if the Login button exists")
	public void tc02_isLoginButtonExist() {
		assertTrue(docsPage.loginButtonExist());
	}
	
	@Test(description = "Does the Searchbutton exist")
	@Description("Does the Searchbutton exist")
	public void tc03_isInputSearchExist() {
		assertTrue(docsPage.inputSearchExist());
	}
	
	@Test(description = "Check the DLP version")
	@Description("Check the DLP version")
	public void tc04_dlpVersionExist() {
		assertTrue(docsPage.dlpVersionExist());
	}
	
	@Test(description = "Check that release notes pdf exists")
	@Description("Check that release notes pdf exists")
	public void tc05_releaseNotesPdfExist() {
		assertTrue(docsPage.releaseNotesPdfExist());
		String expected = "https://help.forcepoint.com/dlp/10.3.0/release-notes/dlp_release_notes.pdf";
		String actual = docsPage.releaseNotesUrl();
		assertEquals(actual, expected);				
	}
}