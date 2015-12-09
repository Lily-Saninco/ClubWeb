package com.saninco.club.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends ClubDefaultPage {

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}	


	@FindBy(id = "j_username")
	public WebElement userNameInput;	
	

	@FindBy(id = "j_password")

	public WebElement passwordInput;
	


	
	@FindBy(css = ".loginbut.pmar>a")
	public WebElement signinButton;	
	
	public void loadLoginPage(WebDriver driver){
		//driver.get("http://www.groupon.com");	
	}

	public void inputEmail(String userName){
		userNameInput.clear();
		userNameInput.sendKeys(userName);
	}
	
	public void inputPassword(String password){
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}
	

	public void clickSigninButton(){
		signinButton.click();
	}


}
