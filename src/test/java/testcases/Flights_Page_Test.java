package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.Test_Base;
import pages.Flights_Page;
import pages.Home_Page;

public class Flights_Page_Test extends Test_Base
{ 
	// Step 1 - Global variable -
	
	Home_Page homePage;
	Flights_Page flightsPage;
	
	// Step 2 - Constructor - 
	
	public Flights_Page_Test()
	{
		super();
	}
	
	// Step 3 - BeforeMethod -
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		homePage = new Home_Page();
		flightsPage = new Flights_Page();
	}
	
	// Step 4 - Test -
	
	@Test
	public void FlightsTest() throws Exception
	{
		homePage.homePageFill("Delhi", "Goa", "10-August-2021", "2,2,1", "INR");
		flightsPage.chooseFlightAndContinue();
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(), 'Details')]")).isDisplayed());
	}
	
	// Step 5 - AfterMethod -
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
