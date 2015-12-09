package com.newjob.groupon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.saninco.club.pages.GrouponDefaultPage;

public class SignUpPage extends GrouponDefaultPage {

	public SignUpPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "full-name-input")
	public WebElement fullNameInput;	
	
	@FindBy(id = "email-input")
	public WebElement emailInput;
	
	@FindBy(id = "password-input")
	public WebElement passwordInput;
	
	@FindBy(id = "password-confirmation-input")
	public WebElement passwordConfirmationInput;
	
	
	@FindBy(id = "remember-me-checkbox")
	public WebElement rememberMeCheckbox;
	
	@FindBy(id = "terms-checkbox")
	public WebElement termsCheckbox;	
	

	
	@FindBy(css = ".btn.btn-small.signup-btn")
	public WebElement signUpButton;	
	

	public void inputEmail(String email){
		emailInput.clear();
		emailInput.sendKeys(email);
	}
	public void inputFullName(String fullName){
		fullNameInput.clear();
		fullNameInput.sendKeys(fullName);
	}
	public void inputPassword(String password){
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}
	
	public void inputPasswordConfirmationInput(String password){
		passwordConfirmationInput.clear();
		passwordConfirmationInput.sendKeys(password);
	}
	
	public void clickSigninButton(){
		signUpButton.click();
	}
	
	public void uncheckRememberMe(){
		if (rememberMeCheckbox.isSelected()){
			rememberMeCheckbox.click();
		}
	}
	public void checkTerms(){
		if (!termsCheckbox.isSelected()){
			termsCheckbox.click();
		}
	}

	public void loadSignUpPage(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	}
