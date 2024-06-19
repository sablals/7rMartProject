package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AdminPage;
import pages.AdminSearch;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdsearchTest extends BaseClass {
  @Test(description=" To verify  Whether user is able to search for  new added user details")
  public void adminSearchPage() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginCrendentials");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginCrendentials");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterpassword(passwordvalue);
		loginpage.submit();
		String usernamevalues1 = ExcelUtility.getStringData(1, 0,"AdminSearch");
		String usertypevalues1= ExcelUtility.getStringData(1, 1, "AdminSearch");
		AdminSearch admine = new AdminSearch (driver);
		admine.admin();
		admine.searched();
		admine.enterusername(usernamevalues1);
		admine.enterusertype(usertypevalues1);
		admine.savein();
		boolean userisfound = admine.searchuserdetails(usernamevalues1);
		assertTrue(userisfound ," Constants.ERRORMESSAGEFORUSERSEARCH");
  }
}
