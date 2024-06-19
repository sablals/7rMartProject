package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManagePage;
import pages.ManagePageAdd;
import utilities.ExcelUtility;

public class ManagePageAddTest  extends BaseClass{

	@Test(description="To verify Whether if a user can add a new  Manage page,retryAnalyzer = reTry.Retry.class")
	public void verifyManagePage() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginCrendentials");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginCrendentials");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterpassword(passwordvalue);
		loginpage.submit();
		String titlevalue = ExcelUtility.getStringData(1, 0,"ManagepageAdd");
		String descriptionvalue =ExcelUtility.getStringData(1, 1,"ManagepageAdd");
		String pagevalue = ExcelUtility.getStringData(1, 2,"ManagepageAdd");
		String imagevalue = ExcelUtility.getStringData(1, 3,"ManagepageAdd");
		ManagePageAdd manages = new ManagePageAdd(driver);
		manages.manage();
		manages.newCategory();
		manages.entertitlevalue(titlevalue);
		manages.enterdescrpitnvalue(descriptionvalue);
		manages.enterpagevalue(pagevalue);
		manages.enterimagevalue(imagevalue);
		boolean pageDetailsIsadded = manages.alertin();
		assertTrue(pageDetailsIsadded,"Constants.ERRORMESSAGEMANAGEPAGEADD");
		
	}

	
	}

