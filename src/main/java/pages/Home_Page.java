package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Test_Base;

public class Home_Page extends Test_Base
{
	// Step 1 - WebElements -
	
	@FindBy(id = "ctl00_mainContent_ddl_originStation1_CTXT")
	WebElement departureCity;
	
	@FindBy(id = "ctl00_mainContent_ddl_destinationStation1_CTXT")
	WebElement arrivalCity;
	
	@FindBy(xpath = "(//span[@class = 'ui-datepicker-year'])[2]")
	WebElement year;
	
	@FindBy(xpath = "//span[contains(text(), 'Next')]")
	WebElement nextButton;
	
	@FindBy(xpath = "(//span[@class = 'ui-datepicker-month'])[2]")
	WebElement month;
	
	@FindBy(id = "divpaxinfo")
	WebElement passengerDropDown;
	
	@FindBy(id = "ctl00_mainContent_ddl_Adult")
	WebElement adult;
	
	@FindBy(id = "ctl00_mainContent_ddl_Child")
	WebElement child;
	
	@FindBy(id = "ctl00_mainContent_ddl_Infant")
	WebElement infant;
	
	@FindBy(id = "ctl00_mainContent_DropDownListCurrency")
	WebElement currency;
	
	@FindBy(id = "ctl00_mainContent_btn_FindFlights")
	WebElement searchButton;
	
	
	// Step 2 - Contructor -
	
	public Home_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	// Step 3 - Methods -
	
	public void homePageFill(String dpcity, String arcity, String date_specified, String passengers, String currency_in_method)
	{
		String common_start_part = "//a[contains(text(), '";
		String common_end_part = "')]";
		
		// Step 1 - choose the departure city -
		departureCity.click();
		driver.findElement(By.xpath(common_start_part + dpcity + common_end_part)).click();
		
		// Step 2 - choose the arrival city -
		arrivalCity.click();
		driver.findElement(By.xpath(common_start_part + arcity + common_end_part)).click();
		
		// Step 3 - choose date -
		String date[] = date_specified.split("-");
		
		
		// choose year -
		while(!year.getText().equals(date[2]))
			nextButton.click();
		
		// choose month -
		while(!month.getText().equals(date[1]))
			nextButton.click();
		
		String day_start_part = "/html/body/div[2]/div[2]/table/tbody/tr[";
		String day_middle_part = "]/td[";
		String day_end_part = "]/a";
		
		boolean flag = false;
		for(int i = 1; i <= 5; i++)
		{
			for(int j = 1; j <= 7; j++)
			{
				String date_xpath = "";
				WebElement day_in_calendar = null;
				try
				{
					date_xpath = day_start_part + i + day_middle_part + j + "]";
					day_in_calendar = driver.findElement(By.xpath(date_xpath));
					if(day_in_calendar.getText().equals(date[0]))
					{
						day_in_calendar.click();
						flag = true;
						break;
					}
					
				}
				catch(Exception e)
				{
					date_xpath = day_start_part + i + day_middle_part + j + day_end_part;
					day_in_calendar = driver.findElement(By.xpath(date_xpath));
					if(day_in_calendar.getText().equals(date[0]))
					{
						day_in_calendar.click();
						flag = true;
						break;
					}
				}
			}
			if(flag)
				break;
		}
		
		// Step 4 - Choose Passengers -
		String[] psngr = passengers.split(",");
		passengerDropDown.click();
		new Select(adult).selectByVisibleText(psngr[0]);
		new Select(child).selectByVisibleText(psngr[1]);
		new Select(infant).selectByVisibleText(psngr[2]);
		
		// Step 5 - Choose currency -
		new Select(currency).selectByVisibleText(currency_in_method);
		
		// Step 6 - Press Search button -
		searchButton.click();
		
	}
	
}