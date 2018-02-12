package com.form.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import com.form.test.base.TestBase;

public class FormPage extends TestBase{
	
	
	//Web elements for Form Page
	@FindBy(xpath="//input[1]")
	WebElement firstName;
	
	@FindBy(xpath="//input[2]")
	WebElement lastName;
	
	@FindBy(xpath="//input[3]")
	WebElement phone;
	
	@FindBy(xpath="//*[@id='submit']")
	WebElement submit;
	
	@FindBy(xpath="//h1")
	WebElement heading;
	
	@FindBy(xpath="//button[contains(text(), 'Clear Form')]")
	WebElement clearFormButton;
	
	@FindBy(xpath="//*[@id='fname-error']")
	WebElement firstNameError;
	
	@FindBy(xpath="//*[@id='lname-error']")
	WebElement lastNameError;
	
	@FindBy(xpath="//*[@id='phone-error']")
	WebElement phoneError;
	
	//Initialize the page object
	public FormPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	
	//Fill the form and submit
	public SubmitPage formSubmit(String fname, String lname, String pnumber) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		phone.sendKeys(pnumber);
		submit.click();		
		return new SubmitPage();
	}
	
	//Fill the form with wrong info and submit
	public FormPage formSubmitError(String fname, String lname, String pnumber) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		phone.sendKeys(pnumber);
		submit.click();		
		return new FormPage();
	}
	
	//Heading text
	public String formPageHeading() {
		return heading.getText();
	}
	
	//Invalid phone number format error message
	public String phoneError() {
		return phoneError.getText();
	}
	
	//Invalid first name error message 
	public String firstNameError() {
		return firstNameError.getText();		
	}
	
	//Invalid last name error message
	public String lastNameError() {
		return lastNameError.getText();		
	}
	
	//Clear the form
	public void clearForm(String fname, String lname, String pnumber){
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		phone.sendKeys(pnumber);
		clearFormButton.click();
		driver.navigate().refresh();
	}


	
}
