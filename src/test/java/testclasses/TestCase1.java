package testclasses;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;



import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;



import Operate.OperateLogin;

import entity.LoginPage;





import util.PropertyLoader;
import util.SaveTestResult;


public class TestCase1 {
	
	SaveTestResult    saveresult= new SaveTestResult();
	private String test_case_desc;
    private String testCaseResult = null;
	private StringBuffer verificationErrors = new StringBuffer();
	//private PrerequisteSetup prerequisteSetup = new PrerequisteSetup();

	private RemoteWebDriver driver = null;
	private String baseUrl = null;
	private String userName = null;
	private String password = null;
	private String testCaseId=null;
	private static Boolean logEnabled = true;
	Logger logger = Logger.getLogger(TestCase1.class.getName());
	Properties prop = PropertyLoader.getTestProperty();

	


	@Test
	public void Provision() throws IOException{
  
            int result = 0;
		try
		{
		
		//System.setProperty("SuiteName", this.getClass().getName());
		Boolean testResult = false;
		logger.log(Level.INFO, "Inside the test case");
		logger.log(Level.FINE,"Inside the test");
        /*
         * Properties jdbcProperty = PropertyLoader.getJDBCProperty();
		// load jdbc with the properties provlogger.log(Level.WARNING, "this");ided
		Class.forName(jdbcProperty.getProperty("jdbcDriver"));
		// url, username, password
		Connection conn = DriverManager.getConnection(
				jdbcProperty.getProperty("url"),
				jdbcProperty.getProperty("username"),
				jdbcProperty.getProperty("password"));
         */
		baseUrl = prop.getProperty("homepage");
		userName = prop.getProperty("username");
		password = prop.getProperty("password");
		testCaseId="12345";
		test_case_desc="This is a login case ";
          driver = new FirefoxDriver();
         
         driver.get(baseUrl);
         
            LoginPage lp = new LoginPage();
            lp.setUsername(userName);
            
            
            logger.log(Level.INFO, "this");
            lp.setPassword(password);
            
                
            logger.info("inside invalid list method");

			OperateLogin operateLogin=new OperateLogin(driver, baseUrl);

			     result = operateLogin.LogmeIn(lp);
			if(result != 1)
			{
				System.out.println("Error: Could not Delete AddressContext, returned :"+result);
				logger.log(Level.INFO,"Error: Could not Delete AddressContext, returned :"+result);
				saveresult.recordresult(false, testCaseId, test_case_desc);
				//Exception exp = new Exception("Error: Could not Delete AddressContext, error code returned :"+result);
				//throw exp;
				driver.close();
			}
             
			else {
				System.out.println(" Sucess:  Logged in :"+result);
				logger.log(Level.FINE," Success :"+result);
				saveresult.recordresult(true, testCaseId, test_case_desc);
				driver.close();
				
			}


		
		//LoginLogout loginEMA = new LoginLogout();


     }
		catch(Exception e){
			
			e.printStackTrace();
			driver.close();
			saveresult.recordresult(false, testCaseId, test_case_desc);
			System.out.println("Error: Could not Delete AddressContext, error code returned :"+result);
		  }
		}
	} 
