package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AdminPage;
import pages.LoginPage;
import pages.SubcategorySearch;
import utilities.ExcelUtility;

public class SubcategorySearchTest extends BaseClass {
  @Test(description="To Verify user is able to search for an  already existing category ")
  public void subCategoryPage() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginCrendentials");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginCrendentials");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterpassword(passwordvalue);
		loginpage.submit();
		String categoryvalue = ExcelUtility.getStringData(1, 0, "SubCateSearch");
		String subcategoryvalue = ExcelUtility.getStringData(1, 1, "SubCateSearch");
		SubcategorySearch categors = new SubcategorySearch(driver);
		categors.manageCategory();
		categors.search();
		categors.entercategory(categoryvalue);
		categors.entersubcategory(subcategoryvalue);
		categors.searched();
		boolean categorynameisFound= categors.Subcategorynamesearch(subcategoryvalue);
		assertTrue(categorynameisFound ," Constants.ERRORMESSAGEFORSUBCATEGORYSEARCH");
		
		
}
}
