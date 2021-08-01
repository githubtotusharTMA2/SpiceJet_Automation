package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Test_Base;

public class Seat_Page extends Test_Base
{
	// Step 1 - Global Variables webelements -
	
	@FindBy(xpath = "(//acronym[contains(text(), '16A')])[1]")
	WebElement seat;
	
	@FindBy(id = "emerygencySeatChkBox")
	WebElement check;
	
	@FindBy(xpath = "//span[contains(text(), 'Confirm')]")
	WebElement confirm;
	
	@FindBy(xpath = "(//span[contains(text(), 'Cancel')])[2]")
	WebElement cancel;
	
	@FindBy(xpath = "//span[contains(text(), 'Continue')]")
	WebElement continueButton;
	
	@FindBy(id = "ControlGroupUnitMapView_UnitMapViewControl_HiddenEquipmentConfiguration_0_PassengerNumber_0_MaxMealSSR_ddl")
	WebElement meal;
	
	@FindBy(xpath = "(//span[@class = 'ui-button-text' and contains(text(), 'Confirm')])[2]")
	WebElement confirm_meal;
	
	
	// Step 2 - Constructor (PageFactor.initElements())
	
	public Seat_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	// Step 3 - Methods -
	
	public void selectSeat(String meal_in_method)
	{
		seat.click();
		check.click();
		confirm.click();
		try
		{
			if(cancel.isDisplayed())
				cancel.click();
		}
		catch(Exception e)
		{
			
		}
		continueButton.click();
		new Select(meal).selectByVisibleText(meal_in_method);
		confirm_meal.click();
	}
	
}
