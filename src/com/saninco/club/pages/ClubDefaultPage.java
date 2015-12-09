package com.saninco.club.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClubDefaultPage {
	
	WebDriver driver;
	@FindBy(id = "ls-user-signin")
	private WebElement isSigninButton;
		
	@FindBy(id = "ls-user-signup")
	private WebElement isSignUpButton;
		
	public ClubDefaultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickIsSigninButton(){
		isSigninButton.click();
	}
	
	public void clickIsSignUpButton(){
		isSignUpButton.click();
	}
	public void loadDefaultPage(WebDriver driver){
		driver.get("http://192.168.1.77:8080/Club");	
	}
	
	private String yourEmailAddress="input#email.js-email.email";	
	private String submitButton1="button#email_submit_button.btn.btn-small";
	private String yourPostalCode="input#postal_code.js-zip";
	private String submitButton2="button#zip_submit.btn.btn-small";	

	private boolean existsElement(String yourEmailAddress) {
	    try {
	        driver.findElement(By.cssSelector(yourEmailAddress));
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	    return true;
	}
	
	
	public void checkYouEmailAddress(String yourAddress,String postalCode ){
		if (existsElement(yourEmailAddress)){
			inputYouEmailAddress(yourAddress);
			clickContinueButton1();
			inputYouPostalCode(postalCode);
			clickContinueButton2();
		}
	}
	
	private void inputYouPostalCode(String PostalCode) {
		WebElement yourPostalCodeTextBox = driver.findElement(By.cssSelector(yourPostalCode));
		yourPostalCodeTextBox.sendKeys(PostalCode);
		
	}

	public void inputYouEmailAddress(String yourAddress){
		WebElement yourEmailAddressTextBox = driver.findElement(By.cssSelector(yourEmailAddress));
		yourEmailAddressTextBox.sendKeys(yourAddress);
	}
	public void clickContinueButton1(){
		WebElement continueButton1 = driver.findElement(By.cssSelector(submitButton1));
		continueButton1.click();
	}
	public void clickContinueButton2(){
	
	//	WebDriverWait wait = new WebDriverWait(driver, 40);
	 //   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(submitButton2))));
	    WebElement continueButton2 = driver.findElement(By.cssSelector(submitButton2));
		continueButton2.click();
		
		
	}

	public void waitSignInButton(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 40);
//	    wait.until(ExpectedConditions.elementToBeClickable(isSigninButton));	
	
}
	
	public void waitSignUpButton(WebDriver driver) {
//		WebDriverWait wait = new WebDriverWait(driver, 40);
//	    wait.until(ExpectedConditions.elementToBeClickable(isSignUpButton));

	}
}

