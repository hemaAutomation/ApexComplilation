package Stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ApexClassTriggersPage.ApexPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class ApexclassStepDefinition extends CommonStepDefinition{
	
	ApexPage apexPage;
	
	@Then("^User is on home page$")
	public void User_is_on_home_page(){
		//String qaUrl = "landsend--qa";
		String Url = driver.getCurrentUrl();
		System.out.println(Url);
		Assert.assertEquals("https://landsend--qa.cs20.my.salesforce.com/home/home.jsp", Url);

	}
	
	@Then("^click setup$")
	public void click_setup(){
		apexPage = new ApexPage(driver);
		apexPage.clickon_setUp();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@When("^Enter Apex in search box$")
	public void Enter_Apex_in_search_box(){
		apexPage.enter_value_searchBox();
		
	}
	
	@Then("^click Apex classes")
	public void click_Apex_classes(){
		apexPage.clickon_apexClass();
	}
	
	@Then("^compile all classes$")
	public void compile_all_classes(){
		apexPage.clickon_allClasses();
		
	}
}
