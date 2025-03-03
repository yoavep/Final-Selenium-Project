package pageobjects;

import java.util.List;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserDirectoryPage extends MainPage {
	@FindBy(css="[src='/dlp/rs-ldr/::cp::web-resources/components/topToolbar/images/new.svg']")
	private WebElement newBtn;
	@FindBy(css=".dtHeaderCellText")
	private List<WebElement> tableColumnName;	
	@FindBy(css=".toolbarItemText")
	private List<WebElement> toolbarColumnName;	
	@FindBy(css="#pageErrorTableContainerTextPlaceTD")
	private WebElement errorMsg;
	@FindBy(css=".mainContainerHeaderText")
	private WebElement userDirectoryList;	
	@FindBy(css=".regularTextCol.dataTableType1NoTooltip")
	private List<WebElement> adItem;	
	
	public UserDirectoryPage(WebDriver driver) {
		super(driver);
	}
	
	public void pressNewButton() {
		switchToFrame("data");
		wait.until(ExpectedConditions.visibilityOf(newBtn));
		click(newBtn); 
	}

	public String returnErrorMsg() {
		return (getText(errorMsg));
	}
	
	public boolean verifyToolbarMenus() {
		boolean[] toolbarMenuItems = {false, false, false, false, false};
		
		switchToFrame("data");
		
		for (WebElement wl : toolbarColumnName) {
			switch (getText(wl)) {
			case "New...":
				toolbarMenuItems[0] = true;
			case "Delete":
				toolbarMenuItems[1] = true;
				break; 
			case "Rearrange Servers": 
				toolbarMenuItems[2] = true;
				break;
			case "Import Now": 
				toolbarMenuItems[3] = true;
				break;
			case "": 
				toolbarMenuItems[4] = true;
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + getText(wl));
			}
		}
		
		for (boolean b : toolbarMenuItems) {
			if (!(b)) {
				return false;
			}
			return true; 
		}
		return false;
	}
	
	public boolean verifyTableMenus() {
		boolean[] tableMenuItems = {false, false, false, false, false, false, false};
		
		for (WebElement wl : tableColumnName) {
			switch (getText(wl)) {
			case "":
				tableMenuItems[0] = true;
			case "Name":
				tableMenuItems[1] = true;
				break; 
			case "Enabled": 
				tableMenuItems[2] = true;
				break;
			case "Type": 
				tableMenuItems[3] = true;
				break;
			case "Last Import": 
				tableMenuItems[4] = true;
				break;
			case "Status": 
				tableMenuItems[5] = true;
				break;
			case "Usage": 
				tableMenuItems[6] = true;
				break;	
			default:
				throw new IllegalArgumentException("Unexpected value: " + getText(wl));
			}
		}
		
		for (boolean b : tableMenuItems) {
			if (!(b)) {
				return false;
			}
			return true; 
		}
		return false;
	}

	public void pressToolbarBtn(String title) {
		for (WebElement wl : toolbarColumnName) {
			if (getText(wl).equalsIgnoreCase(title)) {
				wl.click();
			}	
		}
	}

	public String deleteBtnPressedNothingSelected() {
		pressToolbarBtn("Delete");
		return (returnErrorMsg());
	}
	
	public String importNowBtnPressed() {
		try {
			pressToolbarBtn("Import Now");
			return (returnErrorMsg());
		} catch (UnhandledAlertException e) {
			//Press OK
			driver.switchTo().alert().accept();
			System.out.println("bla");
			} 
		return ("test failed");
	}
	
	public boolean isAdListEmpty() {
		switchToFrame("data");
		wait.until(ExpectedConditions.visibilityOf(userDirectoryList));
		
		//Creating the list of AD entries
//     	List<WebElement> adList = driver.findElements(By.cssSelector(".regularTextCol.dataTableType1NoTooltip"));
	
		if (adItem.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
