package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends MenuPage {
	@FindBy(css=".pageGoDeployText")
	private WebElement deployBtn;
	@FindBy(css=".healthAlertTable")
	private WebElement healthAlertsummary;
	@FindBy(css="#j_id_jsp_1857596851_22")
	private WebElement businessValueTable;
	@FindBy(css="#j_id_jsp_1857596851_82")
	private WebElement incidentsCollected;
	@FindBy(css=".topLogoLabelB")
	private WebElement roleName;
	@FindBy(css="#bnrProductName")
	private WebElement productNameBtn;
	@FindBy(css="#eipApplicationFrame_dataSecurityProduct_")
	private WebElement eipAppFrame;
	@FindBy(css="#dataFrame")
	private WebElement eipDataFrame;	
	@FindBy(css="#objMSM-systemConfigurationMenuItem-cont")
	private WebElement generalBtn;	
	@FindBy(css=".msmCollapsedPaneItem")
	private List<WebElement> leftMenuItem;
	@FindBy(css="#objMSM-userDirectoriesMenuItem-secondCont")
	private WebElement userDirectory;
	@FindBy(css=".toolbarCenterImg")
	private WebElement mainToolBarUserDirectory;	
		
	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isProductName() {
		wait.until(ExpectedConditions.visibilityOf(productNameBtn));
		return (productNameBtn.getText().equalsIgnoreCase("Data"));
	}
	
	public boolean isDeployAvailable() {
		switchToFrame("app");
		wait.until(ExpectedConditions.visibilityOf(deployBtn));
		return (deployBtn.getText().equalsIgnoreCase("deploy"));
	}
	
	public boolean isRoleSuperAdmin() {
		switchToFrame("app");
		wait.until(ExpectedConditions.visibilityOf(roleName));
		return (roleName.getText().equalsIgnoreCase("Super Administrator"));
	}
	
	public boolean isHealthSummaryAvailable() {
		switchToFrame("data");		
		wait.until(ExpectedConditions.visibilityOf(healthAlertsummary));
		return (healthAlertsummary.isEnabled());
	}
	
	public boolean isBusinessValueAvailable() {
		switchToFrame("data");
		wait.until(ExpectedConditions.visibilityOf(businessValueTable));
		return (businessValueTable.isEnabled());
	}
	
	public boolean isIncidentCollected() {	
		switchToFrame("data");
		wait.until(ExpectedConditions.visibilityOf(incidentsCollected));
		return (incidentsCollected.isEnabled());
	}	
	
	public void openUserDirectory() {
		pressleftItemMenuBtn("General");
		switchToFrame("app");
		wait.until(ExpectedConditions.visibilityOf(userDirectory));
		//Mouse hover - open User Directories Menu
		Actions mouseAction = new Actions(driver);
		mouseAction.moveToElement(userDirectory).build().perform();
		wait.until(ExpectedConditions.visibilityOf(userDirectory));
		userDirectory.click();
	}
	
	public boolean isUserDirectory() {
		//Verify that we are on the User Directory page
		switchToFrame("data");
		wait.until(ExpectedConditions.visibilityOf(mainToolBarUserDirectory));
		return (mainToolBarUserDirectory.isDisplayed());
	}
	
	public void pressleftItemMenuBtn(String title) {
		switchToFrame("app");
		wait.until(ExpectedConditions.visibilityOf(generalBtn));
		for (WebElement menuItem : leftMenuItem) {
			if (getText(menuItem).equalsIgnoreCase(title)) {
				click(menuItem);
				break;
			}			
		}
	}
}
