package stepDefination;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefinations {
	public static WebDriver driver;

	@Given("^i open browser with url \"([^\"]*)\"$")
	public void launchApp(String url) throws Throwable  
	{
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(4000);
	}

	@Then("^i should see login page$")
	public void i_should_see_login_page()
	{
		if(driver.findElement(By.id("btnLogin")).isDisplayed())
		{
			System.out.println("System displayed Login Page");
		}
	}

	@When("^i enter username as \"([^\"]*)\"$")
	public void i_enter_username_as(String uid) 
	{
		driver.findElement(By.id("txtUsername")).sendKeys(uid);

	}

	@When("^i enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String pwd) 
	{
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);	    
	}

	@When("^i click login$")
	public void i_click_login() throws Throwable 
	{
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
	}

	@Then("^i should see admin module$")
	public void i_should_see_admin_module() 
	{
		if(driver.findElement(By.linkText("Admin")).isDisplayed())
		{
			System.out.println("System displayed Admin Module");
		}
	}

	@When("^i click logout$")
	public void i_click_logout() throws Throwable 
	{
		driver.findElement(By.partialLinkText("Welcome")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
	}

	@When("^i close browser$")
	public void i_close_browser() 
	{
		driver.close();
	}

	@Then("^i should see error message$")
	public void i_should_see_error_message() 
	{
		String errmsg;
		errmsg = driver.findElement(By.id("spanMessage")).getText();
		if(errmsg.toLowerCase().contains("invalid"))
		{
			System.out.println("System displaying expected error message for invalid inputs");
		}		
	}

}


