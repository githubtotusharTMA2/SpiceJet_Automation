package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.Test_Base;
import pages.Flights_Page;
import pages.Home_Page;
import pages.Passenger_Page;
import pages.Payment_Page;
import pages.Seat_Page;

public class Payment_Page_Test extends Test_Base
{
	// Step 1 - Global Variable Objects -
	
	Payment_Page paymentPage;
	String[] ss;
	
	// Step 2 - Constructor (super()) -
	
	public Payment_Page_Test()
	{
		super();
	}
	
	// Step 3 - BeforeMethod -
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
		new Home_Page().homePageFill("Delhi", "Goa", "2-April-2022", "1,0,0", "INR");
		ss = new Flights_Page().chooseFlightAndContinue();
		new Passenger_Page().fillPassengerDetails("MRS", "TUSHAR", "SINGH", "7906454871", "tushar.singh.mm@gmail.com", "BENGALURU");
		new Seat_Page().selectSeat("Vegetable upma");
		paymentPage = new Payment_Page();
	}
	

	// Step 4 - Test -
	
	@Test
	public void finalVerification()
	{
		Assert.assertTrue(paymentPage.finalTest(ss[0], ss[1].substring(0, 6)));
	}
	
	// Step 5 - AfterMethod -
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
