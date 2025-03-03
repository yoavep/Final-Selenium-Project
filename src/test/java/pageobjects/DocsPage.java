package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DocsPage extends BasePage {
	 @FindBy(css="div>h1")
	 private WebElement welcomeTitle;
	 @FindBy(css=".login-link")
	 private WebElement loginLink;	
	 @FindBy(css="[data-item-id='2b50bed7-7b3b-477e-a1ca-86637ca48156']")
	 private WebElement inputSearch;
	 @FindBy(css="h3>b")
	 private WebElement dlpVersion;	 
	 @FindBy(css="[href='https://help.forcepoint.com/dlp/10.3.0/release-notes/dlp_release_notes.pdf']")
	 private WebElement releaseNotesPdf;		 	 
	
	public DocsPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isDocsPage() {
		wait.until(ExpectedConditions.visibilityOf(welcomeTitle));
		return (welcomeTitle.getText().equalsIgnoreCase("Welcome to the Forcepoint Customer Hub!"));
	}
	
	public boolean loginButtonExist() {
		return (loginLink.getText().equalsIgnoreCase("login"));
	}
	
	public boolean inputSearchExist() {
		return (inputSearch.isEnabled()); 
	}
	
	public boolean dlpVersionExist() {		
		return (dlpVersion.getText().equalsIgnoreCase("Data Loss Prevention (DLP) version 10.3")); 
	}
	
	public boolean releaseNotesPdfExist() {
		return (releaseNotesPdf.isDisplayed()); 
	}
	
	public String releaseNotesUrl() {
		return (releaseNotesPdf.getAttribute("href"));
	}
}
