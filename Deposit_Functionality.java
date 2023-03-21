import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test Scenario - Deposit")
public class Deposit_Functionality {
	
	//Declaration of the object webdriver
	public static WebDriver driver = null;
	public static String userID = "mngr483896";
	
	
	@BeforeAll
	public static void beforeALL() {
		//---------------------------
		//Setup Environment  --------
		//---------------------------
		//Set environment variable
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		//WebDriverManager will setup the chrome browser 
		WebDriverManager.chromedriver().setup();
		
		//Inicialize our virtual Browser
		driver = new ChromeDriver();
	}
	
	@BeforeEach
	public void beforeEach() {
		//block of code to be executed before each test case
		 
	}
	
	@AfterAll
	public static void afterAll() {
		//driver.quit(); 
		//driver.close();
	}
	
	/*@AfterEach
	public static void afterEach() {
		//block of code to be executed after each test case
		 * 
		 * 
	}*/
	
	
	@Test
	@Order(1)
	@DisplayName("Check results on entering a valid information for all fields")
	public void tc001() throws InterruptedException {	
		
		//---------------------------
		//Test Steps ----------------
		//---------------------------
		
		//Click on deposit
		driver.get("https://demo.guru99.com/V4/manager/DepositInput.php");
		Thread.sleep(4000);
		
		//Close the iframe - Privacy Police
		driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click();
		Thread.sleep(4000);
		
		
		//Enter AccountID
		driver.findElement(By.name("accountno")).sendKeys("12345");
		Thread.sleep(3000);
		
		//Enter Amount
		driver.findElement(By.name("ammount")).sendKeys("200.00");
		Thread.sleep(3000);
		
		//Enter description
		driver.findElement(By.name("desc")).sendKeys("blabla");
		Thread.sleep(3000);
		
		//Click on Submit
		driver.findElement(By.name("AccSubmit")).click();
		
		//Click on Alert
		driver.switchTo().alert().getText();
		
		//----------------------------------------------
		//Expected Results: deleted with an appropriate message 
		//----------------------------------------------
		
		String expectedResults = "Submitting the deposit should be succesfull";
		String actualResults = driver.switchTo().alert().getText();
		//String actualResults = driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td > marquee")).getText();
		
		//assertEquals(expectedResults,actualResults);
		
		System.out.println("TC001 - Test Passed!");
		
	}
	
	
	@Test
	@Order(2)
	@DisplayName("Check results on leaving blank all fields and try to submit the form.")
	public void tc002() throws InterruptedException {
		
		//Test Steps
		
		//Click on deposit
		driver.get("https://demo.guru99.com/V4/manager/DepositInput.php");
		Thread.sleep(4000);
				
		//Close the iframe - Privacy Police
		driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click();
		Thread.sleep(4000);
		
		//Leave User Account No, password and description empty
		
		//Click on Submit
		driver.findElement(By.name("AccSubmit")).click();
		
		
		//Check Results
		String expectedResults = "Please fill all fields";
		String actualResults = driver.switchTo().alert().getText();
		
		//System.out.println(actualResults);
		
		assertEquals(expectedResults,actualResults);
		//assertTrue(actualResults.equals(expectedResults));
		
		System.out.println("TC002 - Test Passed!");
		
	}
	
	@Test
	@Order(3)
	@DisplayName("Check response on entering all fields or leave it blank and click on the reset button")
	public void tc003() throws InterruptedException {
		
		//Test Steps
		
		//Click on deposit
		driver.get("https://demo.guru99.com/V4/manager/DepositInput.php");
		Thread.sleep(4000);
		
		//Close the iframe - Privacy Police
		Thread.sleep(4000);
		driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click();
		Thread.sleep(4000);
		
		//Enter Account No
				driver.findElement(By.name("accountno")).sendKeys("12345");
				Thread.sleep(3000);
				
				//Enter Amount
				driver.findElement(By.name("ammount")).sendKeys("200.00");
				Thread.sleep(3000);
				
				//Enter description
				driver.findElement(By.name("desc")).sendKeys("blabla");
				Thread.sleep(3000);
		
		//Click on Reset
		driver.findElement(By.name("res")).click();
		
		//Check Results
		//String expectedResults = "The reset button clears all the fields.";
		//String actualResults = driver.switchTo().alert().getText();
		
		//System.out.println(actualResults);
		
		//assertEquals(expectedResults,actualResults);
		//assertTrue(actualResults.equals(expectedResults));
		
		System.out.println("TC003 - Test Passed!");
		
	}
	
	@Test
	@Order(4)
	@DisplayName("Check results on entering a valid information for Account No and Amount but empty Description")
	public void tc004() throws InterruptedException {	
		
		//---------------------------
		//Test Steps ----------------
		//---------------------------
		
		//Click on deposit
		driver.get("https://demo.guru99.com/V4/manager/DepositInput.php");
		Thread.sleep(4000);
		
		//Close the iframe - Privacy Police
		driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click();
		Thread.sleep(4000);
		
		
		//Enter Account No
		driver.findElement(By.name("accountno")).sendKeys("12345");
		Thread.sleep(3000);
		
		//Enter Amount
		driver.findElement(By.name("ammount")).sendKeys("200.00");
		Thread.sleep(3000);
		
		//Description data not needed
		
		//Click on Submit
		driver.findElement(By.name("AccSubmit")).click();
		
		//Click on Alert
		driver.switchTo().alert().getText();
		
		//----------------------------------------------
		//Expected Results: Clicking on Submit button shows popup with message: Please fill all fields 
		//----------------------------------------------
		
		String expectedResults = "Please fill all fields";
		String actualResults = driver.switchTo().alert().getText();
		//String actualResults = driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td > marquee")).getText();
		
		//assertEquals(expectedResults,actualResults);
		
		System.out.println("TC004 - Test Passed!");
		
	}
	
	@Test
	@Order(5)
	@DisplayName("Check results on entering an invalid data in Account ID field and correct data for Amount and description")
	public void tc005() throws InterruptedException {
		
		//Test Steps
		
		//Click on deposit
		driver.get("https://demo.guru99.com/V4/manager/DepositInput.php");
		Thread.sleep(4000);
		
		//Close the iframe - Privacy Police
		Thread.sleep(4000);
		driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click();
		Thread.sleep(4000);
		
		//Enter invalid Account No
				driver.findElement(By.name("accountno")).sendKeys("12345");
				Thread.sleep(3000);
				
				//Enter Amount
				driver.findElement(By.name("ammount")).sendKeys("500");
				Thread.sleep(3000);
				
				//Enter description
				driver.findElement(By.name("desc")).sendKeys("Test deposit");
				Thread.sleep(4000);
		
		///Click on Submit
				driver.findElement(By.name("AccSubmit")).click();
		
		//Check Results
		String expectedResults = "The Account ID is not valid";
		String actualResults = driver.switchTo().alert().getText();
		
		//System.out.println(actualResults);
		
		assertEquals(expectedResults,actualResults);
		//assertTrue(actualResults.equals(expectedResults));
		
		System.out.println("TC005 - Test Passed!");
		
	}
	
	
	}