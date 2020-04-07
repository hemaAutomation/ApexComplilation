package Stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ApexClassTriggersPage.ApexPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.configFileReader;
import junit.framework.Assert;

public class LoginStepDefinition extends CommonStepDefinition{
 
	WebDriver driver = startbrowser();
	configFileReader configReader;
	ApexPage apexPage;
	
	/*public LoginStepDefinition(){
		apexPage = new ApexPage(driver);	
	}*/
	
	@Given("^User is already on login page$")
	public void user_already_on_login_page(){
		configReader = new configFileReader();
		driver.get(configReader.geturl());
	}

	@When("^Title of login page is salesforce$")
	public void Title_of_login_page_is_salesforce(){
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Login | Salesforce", title);    
	}
	
	@Then("^Enter username and password$")
	public void Enter_username_and_password(DataTable table1){
		apexPage = new ApexPage(driver);
		apexPage.enterCredentials(table1);
	}
	
	@Then("^Click on login button$")
	public void Click_on_login_button(){
		apexPage.clickon_loginbtn();
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
}
