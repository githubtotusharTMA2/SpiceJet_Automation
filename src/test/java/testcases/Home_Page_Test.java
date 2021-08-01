package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Test_Base;
import pages.Home_Page;

public class Home_Page_Test extends Test_Base
{
	
	// Step 1 - Make Global Variable -
	
	Home_Page homepage;
	
	// Step 2 - Constructor -
	
	public Home_Page_Test()
	{
		super();
	}
	
	// Step 3 - BeforeMethod -
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		homepage = new Home_Page();	
	}
	
	// Step 4 - Tests -
	
	@Test
	public void HomeTest()
	{
		homepage.homePageFill("Delhi", "Goa", "2-April-2022", "2,2,1", "INR");
		String title = driver.getTitle();
		Assert.assertEquals(title, "Cheap Air Tickets Online, International Flights to India, Cheap International Flight Deals | SpiceJet Airlines");
	}
	
	// Step 5 - AfterMethod -
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
