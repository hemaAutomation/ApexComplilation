package ApexClassTriggersPage;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import cucumber.api.DataTable;
import dataProvider.configFileReader;

public class ApexPage{
	
	public static WebDriver driver;
	configFileReader configReader;
	WebDriverWait wait;
	WebDriverWait waitclass;
	
	
	public ApexPage(WebDriver driver){
		wait = new WebDriverWait(driver,240);
		waitclass = new WebDriverWait(driver,500);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.NAME,using="username")
	private WebElement username;
	
	@FindBy(how=How.NAME,using="pw")
	private WebElement password;
	
	@FindBy(how=How.XPATH,using="//input[@type='submit']")
	private WebElement loginbtn;
	
	@FindBy(how=How.XPATH,using="//a[@title= 'Setup']")
	private WebElement setUp;
	
	@FindBy(how=How.NAME,using="setupSearch")
	private WebElement setupSearchbox;
	
	@FindBy(how=How.XPATH,using="//a[@id = 'ApexClasses_font']")
	private WebElement apexclass;
	
	@FindBy(how=How.XPATH,using="//a[(@id = 'all_classes_page:theTemplate:messagesForm:compileAll')]")
	private WebElement allclasses;
	
	@FindBy(how=How.XPATH,using="//a[@id = 'ApexTriggers_font']")
	public WebElement Apextrigger;
	
	@FindBy(how=How.XPATH,using="//a[@id = 'all_triggers_page:theTemplate:messagesForm:compileAll']")
	private WebElement allTrigger;
	
	@FindBy(how=How.XPATH,using="//div[@id = 'all_classes_page:theTemplate:messagesForm:j_id54:j_id55:j_id57']")
	private WebElement classSuccess;
	
	@FindBy(how=How.XPATH,using="//div[@id='all_triggers_page:theTemplate:messagesForm:j_id24:j_id25:j_id27']")
	private WebElement triggerSuccess;
	
	@FindBy(how=How.XPATH,using="(//div[@id='userNav-arrow'])")
	public WebElement userName;
	
	@FindBy(how=How.XPATH,using="(//a[contains(text(), 'Logout')])")
	private WebElement logout;
	
	public void enterCredentials(DataTable login_table){
		//configReader = new configFileReader();
		List<List<String>> logindetail = login_table.raw();
		username.sendKeys(logindetail.get(1).get(1));
		password.sendKeys(logindetail.get(2).get(1));
		
	}
	
	public void clickon_loginbtn(){
		loginbtn.click();
	}
	
	public void clickon_setUp(){
		setUp.click();
	}
	
	public void enter_value_searchBox(){
		setupSearchbox.sendKeys("Apex");
	}
	
	public void clickon_apexClass(){
		apexclass.click();
	}
	
	public void clickon_allClasses(){
		allclasses.click();
	}
	
	/*public void clickon_apexTriggers(){
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).click(Apextrigger).keyUp(Keys.CONTROL).perform();
		
	}*/
	
	public void clickon_allTriggers(){
		allTrigger.click();
	}
	
	public void compileClass_Success(){
		waitclass.until(ExpectedConditions.visibilityOf(classSuccess));
		String msgclass = classSuccess.getText();
		System.out.println("Triggers are compiled :" + msgclass);
	}
	
	public void compileTrigger_Success(){
		wait.until(ExpectedConditions.visibilityOf(triggerSuccess));
		String msgtrigger = triggerSuccess.getText();
		System.out.println("Triggers are compiled :" + msgtrigger);
	}
	
	public void logout() throws InterruptedException
	{
		userName.click();
		logout.click();
		Thread.sleep(1000);
	}
		
	
}
