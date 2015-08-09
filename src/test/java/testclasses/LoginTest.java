package testclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import testngclasses.util.DataProviderUtil;

public class LoginTest {

	// to test invalid logins
	@Test(dataProvider = "invalidLogin", dataProviderClass = DataProviderUtil.class)
	public void testInvalidLogin(String username, String pwd)
			throws InterruptedException {
		WebDriver driver = new FirefoxDriver();

		driver.get("http://www.bookshopofindia.com/");

		WebElement element = driver.findElement(By
				.cssSelector(".style4 > b:nth-child(1) > a:nth-child(4)"));
		element.click();

		Thread.sleep(3000);
		element = driver.findElement(By.name("txtOldUserID"));
		element.sendKeys(username);

		element = driver.findElement(By.name("txtOldPassword"));
		element.sendKeys(pwd);

		element = driver.findElement(By.name("Submit2"));
		element.click();

		Thread.sleep(3000);
		try {
			element = driver
					.findElement(By
							.cssSelector("body > table:nth-child(5) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > form:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > div:nth-child(1) > font:nth-child(1)"));
		} catch (Exception e) {
			System.err.println("element not present");
			driver.quit();

			Assert.assertTrue(false);

		}
		boolean contains = false;
		if (element != null)
			contains = element.getText().contains("Invalid Login");

		driver.quit();

		Assert.assertTrue(contains);

	}

	// to test valid logins

}
