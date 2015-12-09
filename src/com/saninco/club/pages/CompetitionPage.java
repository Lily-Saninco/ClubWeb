package com.saninco.club.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompetitionPage extends ClubDefaultPage{
	
	public CompetitionPage(WebDriver driver)  {
		super(driver);
		PageFactory.initElements(driver, this);
	}	



	@FindBy(css = ".pr.pent>a")
	public List<WebElement> prizePicture;
	

	
	public void clickIngeMorathEnterButton(){
		prizePicture.get(0).click();
	}
	public void clickPulitzerEnterButton(){
		prizePicture.get(1).click();
	}
	public void clickChrisHondrosButton() {
		prizePicture.get(2).click();
		
	}
	}
