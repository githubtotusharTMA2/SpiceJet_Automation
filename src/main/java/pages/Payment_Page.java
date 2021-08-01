package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Test_Base;

public class Payment_Page extends Test_Base
{
	// Step 1 - Global Variable (WebElement) -
	@FindBy(xpath = "//span[@class = 'floatLeft font-size-20']")
	WebElement price;
	
	@FindBy(xpath = "//td[@class = 'SwissLight']")
	WebElement flight_Name;
	
	// Step 2 - Constructor -
	
	public Payment_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	// Step 3 - Methods -
	
	public boolean finalTest(String initial_flight_name, String initial_price)
	{
		String price_in_payment = price.getText();
		String flight_name_in_payment = flight_Name.getText();
		
		if(initial_price.equals(price_in_payment))
		{
			System.out.println("initial_price = final_price");
			if(initial_flight_name.equals(flight_name_in_payment))
			{
				System.out.println("initial_flight_name = final_flight_name");
				return true;
			}
			return false;
		}
		else
		{
			System.out.println("initial_price = " + initial_price);
			System.out.println("price_in_payment = " + price_in_payment);
			return false;
		}
		
	}
}
