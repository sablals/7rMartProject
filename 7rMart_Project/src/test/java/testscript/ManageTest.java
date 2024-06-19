package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManagePage;
import utilities.ExcelUtility;

public class ManageTest extends BaseClass {

	

	@Test(description="To verify if a user can search for an already existing title on a Manage page")
	public void verifyTheUserIsAbleToManagePage() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginCrendentials");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginCrendentials");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterpassword(passwordvalue);
		loginpage.submit();
		String titlevalue = ExcelUtility.getStringData(1, 0,"Managepage");
		ManagePage manages = new ManagePage(driver);
		manages.manage();
		manages.search();
		manages.entertitle(titlevalue);
		manages.searches();
		boolean pageTitleIsFound = manages.searchpagedetails(titlevalue);
		assertTrue(pageTitleIsFound,"Constants.ERRORMESSAGEFORMANAGEPAGE");
		
	}

	
	}

