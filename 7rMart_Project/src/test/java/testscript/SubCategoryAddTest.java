package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;


import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SubcategoryUserAdd;
import utilities.ExcelUtility;

public class SubCategoryAddTest  extends BaseClass{
  @Test(description="To verify Whether if a user can add a new subcategory")
  public void subCategoryPage() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginCrendentials");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginCrendentials");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterpassword(passwordvalue);
		loginpage.submit();
		String categoryvalue = ExcelUtility.getStringData(1, 0, "SubCateAdd");
		String subcategoryvalue = ExcelUtility.getStringData(1, 1, "SubCateAdd");
		String imagevalue = ExcelUtility.getStringData(1, 2, "SubCateAdd");
		SubcategoryUserAdd categors = new SubcategoryUserAdd(driver);
		categors.manageCategoryNew();
		categors.newCategory();
		categors.entercategory(categoryvalue);
		categors.entersubcategory(subcategoryvalue);
		categors.imageupload(imagevalue);
		categors.savedin();
		boolean subcategoryuserAdded= categors.alertin();
		assertTrue(subcategoryuserAdded ," Constants.ERRORMESSAGEFORSUBCATEGORYADD");
		
		
}
}
