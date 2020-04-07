package Stepdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

import dataProvider.configFileReader;

public class CommonStepDefinition {
	protected static WebDriver driver;
	configFileReader configReader;
	
	protected WebDriver startbrowser(){
		configReader = new configFileReader();
		System.setProperty("webdriver.chrome.driver", configReader.getDriverPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(configReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		return driver;
	}
	
	protected void closebrowser(){
		driver.close();
		driver.quit();
	}
	
	public void switchToWindow(WebDriver driver, int index) {
		try {
			ArrayList<String> arr = new ArrayList<String>(driver.getWindowHandles()); 
			driver.switchTo().window(arr.get(index));
		} catch (NoSuchWindowException e) {
			//reportStep("The driver could not move to the given window by index "+index,"PASS");
		} catch (WebDriverException e) {
			//reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}
	}

	public void ctrlClick(WebDriver driver, WebElement ele) throws InterruptedException {		
		try {
			Actions action = new Actions(driver);
			action.keyDown(Keys.CONTROL)
			.click(ele)
			.keyUp(Keys.CONTROL).perform();	
			Thread.sleep(2000);
		} catch (InvalidElementStateException e) {
			e.toString();

		} catch (WebDriverException e) {
			e.toString();
		} 
	}
	
}
