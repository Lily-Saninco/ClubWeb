package com.newjob.groupon.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourEmailAddressPage {


	public void HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		
		@FindBy(css = "input#email.js-email.email")
		private WebElement yourEmailAddress;
		
		@FindBy(css = "button#email_submit_button.btn.btn-small")
		private WebElement continueButton;
			
		
		public void inputYouEmailAddress(String yourAddress){
			yourEmailAddress.sendKeys(yourAddress);
		}
		public void clickContinueButton(String yourAddress){
			continueButton.click();
		}
	}


