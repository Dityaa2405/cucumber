package stepDefination1;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmployeeSteps {
	public static WebDriver driver;
	String Expected_EID= "";
	String Actual_EID = "";
	@Given("^Launch url \"([^\"]*)\"$")
	public void launch_url(String url) throws Throwable {
		driver = new FirefoxDriver();
		   driver.manage().window().maximize();
		   driver.get(url);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}

	

	@When("^user Enter username as \"([^\"]*)\"$")
	public void user_Enter_username_as(String user) throws Throwable {
		driver.findElement(By.name("txtUsername")).sendKeys(user);
	    
	}

	@When("^user Enter password as \"([^\"]*)\"$")
	public void user_Enter_password_as(String pass) throws Throwable {
		driver.findElement(By.name("txtPassword")).sendKeys(pass);
	   
	}

	@When("^user Click login button$")
	public void user_Click_login_button() throws Throwable {
		driver.findElement(By.name("Submit")).click();
	    Thread.sleep(2000);
	   
	}

	@Then("^user verify test in url$")
	public void user_verify_test_in_url() throws Throwable {
		String Expected = "dashboard";
	    String Actual = driver.getCurrentUrl();
	    if(Actual.contains(Expected))
	    {
	    	System.out.println("login success");
	    }
	    else 
	    {
	    	System.out.println("login fail");
	    }
	    
	}

	@When("^user navigate to  Add employee page$")
	public void user_navigate_to_Add_employee_page() throws Throwable {
		driver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@id='btnAdd']"));
	    Thread.sleep(1000);
	    
	}

	@When("^user Enter fname as \"([^\"]*)\"$")
	public void user_Enter_fname_as(String FirstName) throws Throwable {
		driver.findElement(By.name("firstName")).sendKeys("dityaa");
	}

	@When("^user Enter Mname as \"([^\"]*)\"$")
	public void user_Enter_Mname_as(String MiddleName) throws Throwable {
		driver.findElement(By.name("middleName")).sendKeys("yella");
	    
	}

	@When("^user enter Lname as \"([^\"]*)\"$")
	public void user_enter_Lname_as(String LastName) throws Throwable {
		driver.findElement(By.name("lastName")).sendKeys("apparao");
	    
	}

	@When("^user capture Employee id$")
	public void user_capture_Employee_id() throws Throwable {
		Expected_EID = driver.findElement(By.name("employeeId")).getAttribute("value");
		
	    }

	@When("^user click save button$")
	public void user_click_save_button() throws Throwable {
		 driver.findElement(By.id("btnSave")).click();
		    Thread.sleep(2000);
	    
	}

	@Then("^Validate Employee id$")
	public void validate_Employee_id() throws Throwable {
		Actual_EID = driver.findElement(By.name("personal[txtEmployeeId]")).getAttribute("value");
	    if(Expected_EID.equals(Actual_EID))
	    {
	    	System.out.println("Employee added success::"+Expected_EID+"     "+Actual_EID);
	    }
	    else {
	    	System.out.println("Employee added Fail::"+Expected_EID+"   "+Actual_EID );
	    }
	}

	@When("^user close browser$")
	public void user_close_browser() throws Throwable {
		driver.close();
	   
	}



	
}
