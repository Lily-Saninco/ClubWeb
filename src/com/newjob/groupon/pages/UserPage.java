package com.newjob.groupon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.saninco.club.pages.GrouponDefaultPage;

public class UserPage extends GrouponDefaultPage{

	public UserPage(WebDriver driver) {
		super(driver);
	}
		
	
	//@FindBy(id="ctl00_LoginName1")
	@FindBy(css="a#user-name.last.user-menu-item.user-menu-action.user-name.icon-arrow-down-large")
	public WebElement firstNameText;
	
	public void loadUserPage(WebDriver driver){
		driver.get("");		
	}
		

	public String getUserFirstNameText() {
		return firstNameText.getText();
	}	
}
