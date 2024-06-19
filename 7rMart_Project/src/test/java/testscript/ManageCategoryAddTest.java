package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryAdd;
import utilities.ExcelUtility;

public class ManageCategoryAddTest extends BaseClass {
	@Test(description="To verify Whether user is able to search for already existing title")
	public void ManagecategoryPage() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginCrendentials");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginCrendentials");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterpassword(passwordvalue);
		loginpage.submit();
		String categoryvalues = ExcelUtility.getStringData(1, 0, "ManageCategoryAddPage");
		String imagevalue = ExcelUtility.getStringData(1, 1, "ManageCategoryAddPage");
		ManageCategoryAdd categoryitem = new ManageCategoryAdd(driver);
		categoryitem.manageCategory();
		categoryitem.addItems();
		categoryitem.enterCategory(categoryvalues);
		categoryitem.selectGroupDrags();
		categoryitem.imageupload(imagevalue);
		categoryitem.isShowonTopMenuNoRaddiobuttonSelect();
		categoryitem.isShowonLeftMenuNoRaddiobuttonSelect();
		categoryitem.savedin();
		boolean categoryitemsadded = categoryitem.alertin();
		assertTrue(categoryitemsadded, "Constants.ERRORMESSAGECATEGORYSEARCH");

	}
		
	}

