package com.form.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.form.test.base.TestBase;

public class SubmitPage extends TestBase{
	
	@FindBy(xpath="//p")
	WebElement submitted;
	
	//Initialize the page object
	public SubmitPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Method
	
	//Checking the
	public String pageSubmitted() {
		return submitted.getText();
	}
	

	

}
