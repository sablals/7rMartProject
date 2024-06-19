package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.AdminPage;
import pages.LoginPage;
import pages.ManagePage;
import utilities.ExcelUtility;

public class AdminTest extends BaseClass {

	@Test(description="To Verify  Whether if a user can add a new user Details")
	public void adminPage() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginCrendentials");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginCrendentials");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterpassword(passwordvalue);
		loginpage.submit();
		String usernamevalues = ExcelUtility.getStringData(1, 0, "Adminpage");
		String passwordvalues = ExcelUtility.getStringData(1, 1, "Adminpage");
		String usertypevalues = ExcelUtility.getStringData(1, 2, "Adminpage");
		AdminPage admins = new AdminPage(driver);
		admins.adminpaged();
		admins.enternew();
		admins.enterusername(usernamevalues);
		admins.enterpassword(passwordvalues);
		admins.enterusertype(usertypevalues);
		admins.savein();
		boolean adduser = admins.alertin();
		assertTrue(adduser ," Constants.ERRORMESSAGEFORUSER");
	}

}
