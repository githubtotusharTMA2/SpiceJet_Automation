package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Test_Base;

public class Flights_Page extends Test_Base
{
	// Step 1 - Initialize WebElements -
	
	@FindBy(id = "ControlGroupSelectView_AvailabilityInputSelectView_RadioButtonMkt1Fare4_")
	WebElement spiceMaxFlight;
	
//	@FindBy(xpath = "//span[contains(text(), 'Continue')]")
//	WebElement continueButton;
//	
//	@FindBy(xpath = "//span[@class = 'forward-icon']")
//	WebElement continueArrow;
	
	@FindBy(xpath = "//span[@class='button-continue-text' and text()='Continue']")
	WebElement finalcontinueButton;
	
	@FindBy(xpath = "(//span[@class = 'white-space-nowrap'])[1]")
	WebElement flightNumber;
	
	@FindBy(xpath = "(//span[@class = 'flightfare'])[2]")
	WebElement flightPrice;
	
	@FindBy(id = "spanamnt")
	WebElement totalPrice;
	
	// Step 2 - Constructor -
	
	public Flights_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	// Step 3 - Method Definition -
	
	public String[] chooseFlightAndContinue() throws Exception
	{
		spiceMaxFlight.click();
		
		String flightNum = flightNumber.getText();
		String flightFare = flightPrice.getText();
		String total_price = totalPrice.getText();
		
		// using continue written button -
		//continueButton.click();
		
		// using continue Arrow button -
		//continueArrow.click();
		
		// using Actions class -
		//new Actions(driver).moveToElement(continueArrow).click(continueArrow).perform();
		
		// using Javascript - this worked -
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", finalcontinueButton);
		
		// by using re-initializing the webelement (continueButton) -
//		WebElement cntbutton = driver.findElement(By.xpath("//span[contains(text(), 'Continue')]"));
//		cntbutton.click();
//		//or same with - continue arrow -
//		driver.findElement(By.xpath("//span[@class = 'forward-icon' and @onClick = 'StoreSpanamnt()']")).click();
//		driver.findElement(By.xpath("//span[@class = 'forward-icon' and @onClick = 'StoreSpanamnt()']")).click();
//		
//		// by using explicit wait -
//		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(continueArrow));
//		continueArrow.click();
//		*/
//		//finalcontinueButton.click();
//		finalcontinueButton.sendKeys(Keys.RETURN);
//		// by using clickAt -
		//Command : clickAt
		//Target: //span[@class='button-continue-text' and text()='Continue']
		//Value: 0,0

		return new String[]{"Flight " + flightNum, flightFare};
		
	
	}
	
}
