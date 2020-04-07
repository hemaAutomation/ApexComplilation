package Stepdefinition;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ApexClassTriggersPage.ApexPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Apextrigger extends CommonStepDefinition{
	ApexPage apexPage;	
	
	@Then("^Enter the Apex in search box$")
	public void Enter_Apex_in_search_box(){
		apexPage = new ApexPage(driver);
		apexPage.enter_value_searchBox();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Then("^click Apex trigger$")
	public void click_Apex_trigger() throws InterruptedException{
		ctrlClick(driver,apexPage.Apextrigger);
		switchToWindow(driver, 1);
	}
	
	
	@Then("^compile all triggers$")
	public void compile_all_triggers(){
		apexPage.clickon_allTriggers();
		
	}
	
	@Then("^Display success message$")
	public void Display_success_message(){
		apexPage.compileTrigger_Success();
		switchToWindow(driver,0);
		apexPage.compileClass_Success();
	}
	
	@Then("^click on username$")
	public void click_on_username() throws InterruptedException{
		scrollDown(driver, apexPage.userName);
		apexPage.clickon_loginbtn();
	}
}