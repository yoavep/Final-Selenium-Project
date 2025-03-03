package pageobjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {
	@FindBy(css="#eipApplicationFrame_dataSecurityProduct_")
	private WebElement eipAppFrame;
	@FindBy(css="#dataFrame")
	private WebElement eipDataFrame;
	
	public MenuPage(WebDriver driver) {
		super(driver);
	}
	
	protected void switchToFrame(String frame) {
		try {
			if (frame.equalsIgnoreCase("app")) {
				driver.switchTo().defaultContent();
				driver.switchTo().frame(eipAppFrame);					
			} else if (frame.equalsIgnoreCase("data")) {
				driver.switchTo().defaultContent();
				driver.switchTo().frame(eipAppFrame);
				driver.switchTo().frame(eipDataFrame);
			}
		} catch (NoSuchElementException e) {
			System.out.println("No such frame " + frame);
		}		
	}
}
