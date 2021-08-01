package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Test_Base;
import pages.Flights_Page;
import pages.Home_Page;
import pages.Passenger_Page;
import pages.Seat_Page;

public class Seat_Page_Test extends Test_Base
{
	
	// Step 1 - Global Variables -
	Seat_Page seatPage;
	
	// Step 2 - Constructor (super) -
	public Seat_Page_Test()
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
		new Passenger_Page().fillPassengerDetails("MRS", "TUSHAR", "SINGH", "7906454871", "tushar.singh.mm@gmail.com", "BENGALURU");
		seatPage = new Seat_Page();
	}
	
	// Step 4 - Test -
	
	@Test
	public void seatTest() throws Exception
	{
		seatPage.selectSeat("Raseele chole"); 
		Assert.assertEquals(driver.getCurrentUrl(), "https://book.spicejet.com/Payment.aspx");
	}
	
	// Step 5 - AfterMethod -
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
