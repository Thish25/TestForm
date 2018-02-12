package com.form.test.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.form.test.base.TestBase;
import com.form.test.pages.FormPage;
import com.form.test.pages.SubmitPage;
import com.form.test.util.UtilPage;



public class FormPageTest extends TestBase{

	FormPage formPage;
	SubmitPage submitPage;
	UtilPage testUtil;
	static String sName = "testData";
	static String negativeSheetName = "negativeCase";
	
	public FormPageTest() {
		super();
	}
		
	@BeforeMethod	
	public void setup() {
		initialization();
		testUtil = new UtilPage();
		formPage = new FormPage(); 
		}
		
	//positive test cases
	@Test(dataProvider="getFormTestData")
	public void formSubmitTest(String firstName,String lastName,String phoneNumber) throws InterruptedException {
		submitPage = formPage.formSubmit(firstName,lastName,phoneNumber);
		Assert.assertEquals(submitPage.pageSubmitted(), "Form submitted!"); 
		Reporter.log( "Verify Form Submitted with correct values", true );
	}
	
	//Negative test cases	
	@Test(dataProvider="getFormNegativeTestData")
	public void negativeFormSubmitTest(String firstName,String lastName,String phoneNumber) throws InterruptedException {
		formPage.formSubmitError(firstName, lastName, phoneNumber);
		Assert.assertEquals(formPage.formPageHeading(), "Test Form"); 
		Reporter.log( "Verify Form is not submitted", true );
	}
	
	//Clear form test case	
	@Test
	public void formSubmitWrongFnameTest() throws InterruptedException {
		formPage.clearForm("Adam", "Peter", "33352364444");
        Thread.sleep(2000);
		Assert.assertEquals(formPage.formPageHeading(), "Test Form"); 
		Reporter.log( "Verify Clear Page", true );
	}
	
	//Positive test data	
	@DataProvider
	public static Object[][] getFormTestData(){
		Object data[][] = UtilPage.getTestData(sName);
		System.out.println(data.length);
		return data;
	}
	
	//Negative test data	
	@DataProvider
	public static Object[][] getFormNegativeTestData(){
		Object data[][] = UtilPage.getTestData(negativeSheetName);
		System.out.println(data.length);
		return data;
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
		
}
