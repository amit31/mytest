package Operate;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import testclasses.TestCase1;

import entity.LoginPage;





public class OperateLogin {

	private RemoteWebDriver driver = null;
	private String baseUrl = null;
   // private static Logger logger = Logger.getLogger("Mylog");
   //private static Logger logger = Logger.getLogger(MyclassName.class);
	Logger logger = Logger.getLogger(OperateLogin.class.getName());

	public OperateLogin(RemoteWebDriver driver, String baseUrl)
	{
		this.driver = driver;
		this.baseUrl = baseUrl;
	}
	
	/*This function creates AddressContext
	 * @parameter EntityAddressContext object
	 * @return SonusReturn Object
	 */
/*	public SonusReturn createAddressContext(EntityAddressContext entityAddressContext)throws Exception
	{
		System.out.println(" Into createAddressContext **********************");
		logger.log(Level.FINE,"Into createAddressContext **********************");
		SonusReturn sonusReturn = new SonusReturn();
		sonusReturn.setErrorCode(-1);
		sonusReturn.setErrorMessage(null);

		String name = entityAddressContext.getName();

		System.out.println("Create Address Context " + name);
		try {
			if (driver == null) {
				System.out
				.println("Create_add_context:: Null driver obtained, returning null");
				return null;
			}

			driver = common.switchToTreeFrame(driver);

			driver.findElement(By.xpath("//a[text()='Address Context']")).click();

			driver = common.switchToNavReportFrame(driver);

			try {
				// search to see if address context exists via the filter
				driver.findElement(By.name("filter_control_name")).clear();sleep.SleepFor(1);
				driver.findElement(By.name("filter_control_name")).sendKeys(new CharSequence[] { name });sleep.SleepFor(1);
				driver.findElement(By.id("filterButton")).click();
				sleep.SleepFor(1);

				//driver.findElement(By.xpath("//tr[@id='name=" + name + "']//td[1]/div/input[@type='radio']")).click();
				//tr[@id="/addressContext^name=a10^"]//td[1]
				driver.findElement(By.xpath("//tr[@id=\"/addressContext^name="+name+"^\"]//td[1]")).click();
				System.out.println("Address context already exists, returning");
				sonusReturn.setErrorCode(2);
				sonusReturn.setErrorMessage("Address context already exists, returning");

				//return driver;
			}

			catch (Exception e) {
				System.out.println("About to create Address context with name "	+ name);
				driver = common.clickOnCreate(driver);

				driver.switchTo().frame(0);

				System.out.println("About to provide inputs to create address context");

				driver.findElement(By.name("name")).clear();sleep.SleepFor(1);
				driver.findElement(By.name("name")).sendKeys(new CharSequence[] { name });sleep.SleepFor(1);

				//driver = common.saveConfiguration(driver);
				driver.findElement(By.xpath("//button[@title=\"Create\"]")).click();

				sonusReturn = common.handleAlertMessage(driver, "createAddressContext", name);

				System.out.println("Address Context over ");
				sleep.SleepFor(1);

				//
				if(sonusReturn.getErrorCode()<0)
				{
					System.out.println("error code < 0 ");
					return null;
				}

				//
				String alertmsg=common.AlertMessage(driver);
				if(alertmsg!=null)
				{
					if(alertmsg.contains("Unable"))
					{
						sonusReturn.setErrorCode(-2);
						sonusReturn.setErrorMessage(alertmsg);

					}



					else
					{
						sonusReturn.setErrorCode(1);
						sonusReturn.setErrorMessage("Successfully Create Address Context");

					}
				}
				else
				{
					sonusReturn.setErrorCode(1);
					sonusReturn.setErrorMessage("Successfully Create Address Context");

				}
				//
			}

		} catch (Exception addressContextException) {
			System.out.println("Exception occurred while creating address context "+ addressContextException.getMessage());
			//screenshot.takeScreenShot(driver, "CREATEADDRESSCONTEXT");
			sonusReturn.setErrorCode(-3);
			sonusReturn.setErrorMessage(addressContextException.getMessage());
			throw addressContextException;
		}
		System.out.println("refreshing page");
		//driver.navigate().refresh();Thread.sleep(1000);
		//return driver;
		sonusReturn.DisplaySonusReturn(sonusReturn);
		System.out.println(" End of  createAddressContext ***************************** ");
		logger.log(Level.FINE,"End of  createAddressContext **************************");
		return sonusReturn;
	}*/

	public int LogmeIn(LoginPage lp) {
		// TODO Auto-generated method stub
		
		System.out.println(" Into Login Method**********************");
		logger.log(Level.FINE,"Into Login method **********************");
		logger.log(Level.INFO, "Inside the test case");
		int testresult=0;

		String username = lp.getUsername();
		String password = lp.getPassword();

		System.out.println("login to application");
		try {
			if (driver == null) {
				System.out
				.println("Create_add_context:: Null driver obtained, returning null");
				return 0;
			}

			

			WebElement element = driver.findElement(By
					.cssSelector(".style4 > b:nth-child(1) > a:nth-child(4)"));
			element.click();

			Thread.sleep(3000);
			element = driver.findElement(By.name("txtOldUserID"));
			element.sendKeys(username);

			element = driver.findElement(By.name("txtOldPassword"));
			element.sendKeys(password);

			element = driver.findElement(By.name("Submit2"));
			element.click();
			
		        String text = driver.findElement(By.xpath("//table[3]//tr[2]//td[2]")).getText();
		        System.out.println(text);
		        if (text.contains("Hello"))
		        {
		        	testresult=1;
		        }
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
			return testresult;
		}
		return testresult;
		
		
		
	
}

	
}