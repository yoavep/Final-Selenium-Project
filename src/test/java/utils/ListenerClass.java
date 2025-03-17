package utils;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import io.qameta.allure.Allure;

public class ListenerClass extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        Allure.addAttachment("Screen shot on failure", new ByteArrayInputStream(((TakesScreenshot) result.getTestContext().getAttribute("WebDriver")).getScreenshotAs(OutputType.BYTES)));
    }
}
