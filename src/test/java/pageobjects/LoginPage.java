package pageobjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Utils;

public class LoginPage extends BasePage {
	@FindBy(id="details-button")
	private WebElement advanced;
	@FindBy(id="proceed-link")
	private WebElement proceed;
	@FindBy(css="[id$='idUserName']")
	private WebElement userNameField;
	@FindBy(css="[id$='idPassword']")
	private WebElement passwordField;
	@FindBy(css="[id$='loginButtonGroup']")
	private WebElement loginBtn;
	@FindBy(css="[id$='idGlobalErrorMessages']")
	private WebElement errorMsg;
	@FindBy(css="#idTechnicalLibraryLink")
	private WebElement docsLink;	
	@FindBy(css="#j_id_jsp_1969817719_102")
	private WebElement fsmVersion;	
	@FindBy(css="#eipApplicationFrame_dataSecurityProduct_")
	private WebElement eipAppFrame;
	@FindBy(css="#dataFrame")
	private WebElement eipDataFrame;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void preLogin() {
		advanced.click();
		proceed.click();
		wait.until(ExpectedConditions.visibilityOf(loginBtn));
	}
	
	public void login (String userName, String password) {
		fillText(userNameField, userName);
		fillText(passwordField, password);
		click(loginBtn);
	}
	
	public String getErrorMsg() {
		wait.until(ExpectedConditions.visibilityOf(errorMsg));
		return getText(errorMsg); 		
	}
	
	public boolean isVersionRight() {
		return (fsmVersion.getText().equalsIgnoreCase("Version "+ Utils.readProperty("version")));
	}
	
	public void openDocsPage() {
//		String main = driver.getWindowHandle();
		click(docsLink);
		Set<String> list = driver.getWindowHandles();

		for (String win : list) {
			driver.switchTo().window(win);
		}
	}
}