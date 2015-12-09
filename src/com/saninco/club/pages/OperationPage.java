package com.saninco.club.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OperationPage extends ClubDefaultPage{
	
	public OperationPage(WebDriver driver)  {
		super(driver);
		PageFactory.initElements(driver, this);
	}	



	@FindBy(css = ".pfour.pl.p41>a")
	public WebElement round;
	@FindBy(css = ".pfour.pl.p42>a")
	public WebElement award;
	@FindBy(css = ".pfour.pl.p43>a")
	public WebElement presentation;
	@FindBy(css = ".pfour.pl.p44>a")
	public WebElement projector;
	public void clickRound(){
		round.click();
	}
	public void clickAward(){
		award.click();
	}
	public void clickPresentation(){
		presentation.click();
	}
	public void clickProjector(){
		projector.click();
	}
	}
