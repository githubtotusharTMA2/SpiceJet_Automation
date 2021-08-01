package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Test_Base;
import pages.Flights_Page;
import pages.Home_Page;
import pages.Passenger_Page;

public class Passenger_Details_Test extends Test_Base
{
	// Step 1 - Global Objects -
	
	Home_Page homePage;
	Flights_Page flightsPage;
	Passenger_Page passengerPage;
	
	// Step 2 - Constructor -
	
	public Passenger_Details_Test()
	{
		super();
	}
	
	// Step 3 - BeforeMethod -
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
		new Home_Page().homePageFill("Delhi", "Goa", "10-August-2021", "1,0,0", "INR");
		new Flights_Page().chooseFlightAndContinue();
		passengerPage = new Passenger_Page();
	}
	
	// Step 4 - Test -
	
	@Test
	public void passengerPageTest() throws Exception
	{
		passengerPage.fillPassengerDetails("MR", "MainAttacker", "SINGH", "contact_number", "email_id", "BENGALURU");
		Assert.assertEquals(driver.getCurrentUrl(), "https://book.spicejet.com/SeatMapFromPayment.aspx");
		Thread.sleep(5000);
	}
	
	// Step 5 - AfterMethod -
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
