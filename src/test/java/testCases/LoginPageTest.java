package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import page.DatabasePage;
import page.LoginPage;

public class LoginPageTest extends TestBase {
//	We initialized the loginpageObject here
	LoginPage loginpageObj;
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
// This step calls the driver in the 'TestBase.java' by initializing it. Just hover over and click when it turns blue to direct you to the 'TestBase.java'		
		initializeDriver();
// If we define the loginpageObj here in the 'BeforeMethod' then we can use it throughout the loginTest class below.	
		loginpageObj = PageFactory.initElements(driver, LoginPage.class);
	}
	
	@Test(priority=1)
	public void loginTest() throws Throwable {
//		loginpageObj.enterUserName("demo@techfios.com");
		loginpageObj.enterUserName(DatabasePage.getData("username"));
		Thread.sleep(2000);	
		
//		loginpageObj.enterPassword("abc123");
		loginpageObj.enterPassword(DatabasePage.getData("password"));
		Thread.sleep(2000);
		
		loginpageObj.clickOnSignInButton();
		
		takeScreenshotAtEndOfTest(driver);
	}

	@AfterMethod
	public void tearDown() {		
		driver.close();
		driver.quit();
	}


}
