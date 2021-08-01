package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Test_Base;

public class Passenger_Page extends Test_Base
{
	// Step 1 - Global Variables webelements -
	
	@FindBy(id = "CONTROLGROUPPASSENGER_ContactInputPassengerView_DropDownListTitle")
	WebElement title;
	
	@FindBy(id = "CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxFirstName")
	WebElement first_name;
	
	@FindBy(id = "CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxLastName")
	WebElement last_name;
	
	@FindBy(id = "CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxHomePhone")
	WebElement number;
	
	@FindBy(id = "CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxEmailAddress")
	WebElement email_address;
	
	@FindBy(name = "contact_cities_list_india")
	WebElement city;
	
	@FindBy(id = "CONTROLGROUPPASSENGER_ContactInputPassengerView_CheckBoxPromoOpt")
	WebElement noFutureMailsCheckBox;
	
	@FindBy(id = "CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_SJFlyingView_IamFlying")
	WebElement iamflyingCheckBox;
	
	@FindBy(xpath = "(//span[@class = 'button-continue-text' and contains(text(), 'Continue')])[1]")
	WebElement continueButton;
	
	
	// Step 2 - Constructor -
	
	public Passenger_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	// Step 3 - Methods -
	
	public void fillPassengerDetails(String title_in_method, String firstName, String lastName, String phn, String email, String city_in_method)
	{
		new Select(title).selectByIndex(1);;
		first_name.sendKeys(firstName);
		last_name.sendKeys(lastName);
		number.sendKeys(phn);
		email_address.sendKeys(email);
		new Select(city).selectByIndex(10);
		noFutureMailsCheckBox.click();
		iamflyingCheckBox.click();
		continueButton.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueButton);
		
	}
	
}
