package testscript;

import static org.testng.Assert.assertTrue;


import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends BaseClass {
	
	
@Test(groups= {"smoketest"},description="To verify Whether user is able to login valid Credentials")
@Parameters("browser")
	public void verifyTheUserAbleToLoginValidCredentials(String browser) throws IOException {

		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginCrendentials");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginCrendentials");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterpassword(passwordvalue);
		loginpage.submit();
		boolean homepageisloaded = loginpage.dashboard();
		assertTrue(homepageisloaded, "Constants.ERRORMESSAGEHOMEPAGE");
	}
	@Test (description="To verify Whether user is able to login valid usename and invalid password, retryAnalyzer = reTry.Retry.class")

	public void verifyValidUsernameAndInvalidPassword() throws IOException {
		String usernamevalues = ExcelUtility.getStringData(2, 0, "LoginCrendentials");
		String passwordvalues = ExcelUtility.getStringData(2, 1, "LoginCrendentials");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalues);
		loginpage.enterpassword(passwordvalues);
		loginpage.submit();
		boolean ValidusernameAndPasswordInvalid = loginpage.alert();
		assertTrue(ValidusernameAndPasswordInvalid, "Constants.ERRORMESSAGEINVALIDPASSWORD");
	}
	
	@DataProvider(name="Crendentials")
	public Object[][] testData() {  
		Object[][] input = new Object[2][2];
		input[0][0] = "admin";
		input[0][1] = "admin";
		input[1][0] = "admin@123";
		input[1][1] = "admin123";
		return input;
	}
	

	@Test(dataProvider ="Crendentials",description="To verify Whether user is able to login with Invalid username and Valid password ")
	public void verifyInvalidUsernameAndValidPassword(String usernamevalues1, String passwordvalues1 ) throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalues1);
		loginpage.enterpassword(passwordvalues1);
		loginpage.submit();
		boolean InvalidusernameAndPasswordvalid = loginpage.alert();
		assertTrue(InvalidusernameAndPasswordvalid, "Constants.ERRORMESSAGEINVALIDUSERNAME");
	}

	@Test(description="To verify Whether user is able to login with invalid crenditials")
	@Parameters({"username","password"})
	public void verifyTheUserAbleToLoginInValidCredentials(String usernames, String passwords) throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernames);
		loginpage.enterpassword(passwords);
		loginpage.submit();
		boolean InvalidusernameAndInvalidPassword = loginpage.alert();
		assertTrue(InvalidusernameAndInvalidPassword , "Constants.ERRORMESSAGEINVALIDCREDENTIALS");
	}

}
