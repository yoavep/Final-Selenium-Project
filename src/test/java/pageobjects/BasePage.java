package pageobjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	WebDriverWait wait; 
	JavascriptExecutor js;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		js = (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void fillText(WebElement el, String text) {
		//Highlight element
		js.executeScript("arguments[0].setAttribute('style', 'background-color:yellow; border: 1px solid blue;');", el);
		el.clear();
		el.sendKeys(text);
	}
	
	public String getText(WebElement el) {
		//Highlight element
		js.executeScript("arguments[0].setAttribute('style', 'background-color:green; border: 1px solid blue;');", el);
		return el.getText();
	}
	
	public void click(WebElement el) {
		//Highlight element
		js.executeScript("arguments[0].setAttribute('style', 'background-color:orange; border: 1px solid blue;');", el);
		el.click();
	}
	
	public void sleep(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
