package com.newjob.groupon.testcases;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.newjob.groupon.bo.GrouponUser;

import com.newjob.groupon.pages.SignUpPage;
import com.newjob.groupon.pages.UserPage;
import com.newjob.groupon.util.FileForUser;

/*
 * New User Register
 * 
 * 
 */

@RunWith(value = Parameterized.class)
public class UserRegister {

	private WebDriver driver;
	GrouponUser user;

	@Parameters
	public static Collection<GrouponUser> testData() throws IOException {

		ArrayList<GrouponUser> users = FileForUser.readFile();
		for (GrouponUser user : users) {
			System.out.println("user:" + user.getEmail());
		}
		return users;
	}

	public UserRegister(GrouponUser user) {
		this.user = user;

	}

	@Before
	public void setUp() throws Exception {
		String browser = user.getBrowser();
		System.out.println(" browser: " + browser);
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver",
					"D:\\downloadSoftware\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		} else if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"D:\\downloadSoftware\\driver\\chromedriver.exe");

			/*
			 * 
			 * Get rid of "You are using an unsupported command-line flag
			 * –ignore-certificate-errors. Stability and security will suffer "
			 */

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--test-type");
			driver = new ChromeDriver(options);

		} else {

			System.out
					.println("Browser is not exist, use the firefox driver as a default driver ");
			driver = new FirefoxDriver();
		}

		driver.get("http://www.groupon.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}

	@Test
	public void testUserSignUp() throws Exception {
		SignUpPage signUpPage;

		signUpPage = new SignUpPage(driver);

		signUpPage.checkYouEmailAddress(user.getEmail(), user.getPostalCode());
		signUpPage.waitSignUpButton(driver);
		signUpPage.clickIsSignUpButton();
		signUpPage.inputEmail(user.getEmail());
		signUpPage.inputFullName(user.getFullName());
		signUpPage.inputPassword(user.getPassword());
		signUpPage.inputPasswordConfirmationInput(user.getPassword());
		signUpPage.uncheckRememberMe();
		signUpPage.checkTerms();
		signUpPage.clickSigninButton();

		UserPage userPage = new UserPage(driver);
		String firstName = userPage.getUserFirstNameText();

		// verify firstName is correct
		System.out.println(firstName);
		GrouponUser databaseUser = FileForUser.userSearch(user.getEmail());
		String databaseFirstName = databaseUser.getFirstName();
		assertEquals(databaseFirstName, firstName);
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();

	}

}
