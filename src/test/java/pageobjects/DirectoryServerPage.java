package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DirectoryServerPage extends UserDirectoryPage {
	@FindBy(css="[name='ldapForm:name']")
	private WebElement userDirectoryName;
	@FindBy(css="[name='ldapForm:dialect']")
	private WebElement userDirectoryType;
	@FindBy(css="[name='ldapForm:hostName']")
	private WebElement userDirectoryHostName;
	@FindBy(css="[name='ldapForm:idLdapUsername']")
	private WebElement userDistinguishedName;
	@FindBy(css="[name='ldapForm:idLDAPPassword']")
	private WebElement userDirectoryPassword;
	@FindBy(css="[id$='ldapForm:testLdapConnectionButton']")
	private WebElement testConnectionBtn;
	@FindBy(css="#idToolbarFormFacet_idToolbarFormFacet_idActionApplyProxy")
	private WebElement okBtn;
	@FindBy(css="#idToolbarFormFacet_idToolbarFormFacet_idActionCancelProxy")
	private WebElement cancelBtn;
	@FindBy(css="#pageErrorTableContainerTextPlaceTD")
	private WebElement errorMsg;
	@FindBy(css="[extradata='useSSLCheckbox']")
	private WebElement useSslEncryption;
	
	public DirectoryServerPage(WebDriver driver) {
		super(driver);
	}
	
	public void pressOkBtn() {
		click(okBtn);
	}
	
	public void pressCancelBtn() {
		click(cancelBtn);
	}
	
	public void pressTestConnectionBtn() {
		click(testConnectionBtn);
	}
	
	public String getErrorMsg() {
		return (getText(errorMsg));
	}
	
	public void feelAdData(String adName, String ipAddress, String userName, String password) {
		fillText(this.userDirectoryName, adName);
		fillText(this.userDirectoryHostName, ipAddress);
		fillText(this.userDistinguishedName, userName);
		fillText(this.userDirectoryPassword, password);
	}
	
	public void createNewUserDirectory(String adName, String ipAddress, String userName, String password) {
		pressNewButton();
		wait.until(ExpectedConditions.visibilityOf(userDirectoryName));
		
		feelAdData(adName, ipAddress, userName, password);
		
		pressTestConnectionBtn();
		wait.until(ExpectedConditions.visibilityOf(errorMsg));

		if (getText(errorMsg).equalsIgnoreCase("Test Connection Succeeded")) {
			pressOkBtn();
		} else {
			pressCancelBtn();
		}
	}
}
