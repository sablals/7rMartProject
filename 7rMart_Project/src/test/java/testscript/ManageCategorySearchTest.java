package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Locale.Category;

import org.testng.annotations.Test;

import pages.ManageCategorySearch;
import pages.LoginPage;
import pages.SubcategorySearch;
import utilities.ExcelUtility;

public class ManageCategorySearchTest extends BaseClass {
  @Test(description="To verify whether user is able to search for already existing title ")
  public void categoryPage() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginCrendentials");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginCrendentials");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterpassword(passwordvalue);
		loginpage.submit();
		String categoryvalue1 = ExcelUtility.getStringData(1, 0, "CategoryPage");
		ManageCategorySearch categors = new ManageCategorySearch(driver);
		categors.manageCategory();
		categors.search();
		categors.entercategory(categoryvalue1);
		categors.searched();
		boolean categorytitlefound= categors.searchcategorydetails(categoryvalue1);
		assertTrue(categorytitlefound, "Constants.ERRORMESSAGEFORCATEGORYSEARCH");
		
		
}
}
