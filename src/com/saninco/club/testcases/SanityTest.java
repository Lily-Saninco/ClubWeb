package com.saninco.club.testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class SanityTest {
	public static void main(String[] args) {

	WebDriver driver = new FirefoxDriver();
	driver.get("http://192.168.1.77:8080/Club");
	driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

	WebElement username=driver.findElement(By.id("j_username"));
	username.sendKeys("user1");
	WebElement password=driver.findElement(By.id("j_password"));
	password.sendKeys("1");
	WebElement loginButton=driver.findElement(By.cssSelector(".loginbut.pmar>a"));
	loginButton.click();

	driver.quit();

}
}
