package stepDefinition;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.*;
import utilities.WebDriverUtils;

public class Test_Steps {
	public static WebDriver driver;
	
	@Given("^Browser is opened$")
	public void browser_is_opened() throws Throwable {
		// declaration and chromedriver
		System.setProperty("webdriver.chrome.driver","F:\\Driver\\chromedriver.exe");
		WebDriverUtils.setDriver(new ChromeDriver());
		driver = WebDriverUtils.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Browser has been opened");
	}

	@Given("^User Navigate to Add customer Page$")
	public void user_Navigate_to_Add_customer_Page() throws Throwable {
		String baseUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/addCust";
		driver.get(baseUrl);
		System.out.println("Navigated to URL: "+baseUrl);
		Thread.sleep(5000);
	}

	@When("^User enters \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String arg1, String arg2, String arg3) throws Throwable {
		String Fname = arg1;
	    String Lname = arg2;
	    String Pcode = arg3;
	    
	    String ActualTitle = driver.findElement(By.xpath(".//strong[@class='mainHeading']")).getText();
	    String ExpectedTitle = "XYZ Bank";
	    assertEquals(ExpectedTitle,ActualTitle);
	    System.out.println("Title Verified succefully as: "+ActualTitle);
	    
	    WebElement FristName = driver.findElement(By.xpath(".//input[@ng-model='fName']"));
	    FristName.click();
	    FristName.clear();
	    FristName.click();
	    FristName.sendKeys(Fname);
	    Thread.sleep(2000);

	    WebElement LastName = driver.findElement(By.xpath(".//input[@ng-model='lName']"));
	    LastName.click();
	    LastName.clear();
	    LastName.click();
	    LastName.sendKeys(Lname);
	    Thread.sleep(2000);
	    
	    WebElement PostCode = driver.findElement(By.xpath(".//input[@ng-model='postCd']"));
	    PostCode.click();
	    PostCode.clear();
	    PostCode.click();
	    PostCode.sendKeys(Pcode);
	    Thread.sleep(2000);
	    
	    System.out.println("Customer details filled successfully");
	    System.out.println("First name as: "+Fname);
	    System.out.println("last name succefully as: "+Lname);
	    System.out.println("post code succefully as: "+Pcode);
	    
	    WebElement Addcustomer = driver.findElement(By.xpath(".//button[@type='submit']"));
	    Addcustomer.click();
	    Thread.sleep(4000);
	    System.out.println("Clicked on Add Customer button");
	}

	@Then("^Message displayed Customer added Successfully$")
	public void message_displayed_Customer_added_Successfully() throws Throwable {
		Alert alert = driver.switchTo().alert();
        String alertMessage= driver.switchTo().alert().getText();
        
        // Displaying alert message		
        System.out.println("Alert message as:"+alertMessage);
        Thread.sleep(1000);
  		
        // Accepting alert		
        alert.accept();	
        Thread.sleep(8000);
        System.out.println("Click Ok button of alert button");
        
        //driver.close();
        //System.out.println("Browser has been closed");
	}
}
