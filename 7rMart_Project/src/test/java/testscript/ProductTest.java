package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManagePage;
import pages.ManageProduct;
import utilities.ExcelUtility;

public class ProductTest  extends BaseClass{
  @Test(description="verify user is able to search for already existing product")
  public void ManageProduct() throws IOException {

		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginCrendentials");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginCrendentials");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterpassword(passwordvalue);
		loginpage.submit();
		String titlevaluess=ExcelUtility.getStringData(1, 0,"ProductManage");
		ManageProduct products = new ManageProduct(driver);
		products.manage();
		products.search();
		products.entertitle(titlevaluess);
		products.searches();
		boolean productisfound = products.searchproductdetails(titlevaluess);
		assertTrue(productisfound ," Constants.ERRORMESSAGEFORMANAGEPRODUCT");
   
  }
}
