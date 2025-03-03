package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DocsTest extends BaseTest {
	@BeforeClass
	public void openLoginPage() {
		loginPage.preLogin();
		loginPage.openDocsPage();
	}
	
	@Test
	public void tc01_isDocsPage() {
		assertTrue(docsPage.isDocsPage());
	}
	
	@Test
	public void tc02_isLoginButtonExist() {
		assertTrue(docsPage.loginButtonExist());
	}
	
	@Test
	public void tc03_isInputSearchExist() {
		assertTrue(docsPage.inputSearchExist());
	}
	
	@Test
	public void tc04_dlpVersionExist() {
		assertTrue(docsPage.dlpVersionExist());
	}
	
	@Test
	public void tc05_releaseNotesPdfExist() {
		assertTrue(docsPage.releaseNotesPdfExist());
		String expected = "https://help.forcepoint.com/dlp/10.3.0/release-notes/dlp_release_notes.pdf";
		String actual = docsPage.releaseNotesUrl();
		assertEquals(actual, expected);				
	}
}