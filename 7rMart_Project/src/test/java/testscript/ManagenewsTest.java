package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.ManageCategorySearch;
import pages.LoginPage;
import pages.NewsManage;
import utilities.ExcelUtility;

public class ManagenewsTest extends BaseClass {
  @Test(description="To verify user is able to search for an already existing news title")
  public void newsCategoryPage() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginCrendentials");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginCrendentials");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue);
		loginpage.enterpassword(passwordvalue);
		loginpage.submit();
		String newstitlevalue1 = ExcelUtility.getStringData(1, 0, "NewsPage");
		NewsManage new1 = new NewsManage(driver);
		new1.managenews();
		new1.search();
		new1.enterNewsTitle(newstitlevalue1);
		new1.searched();
		boolean newstitleisfound= new1.searchnewsdetails(newstitlevalue1);
		assertTrue(newstitleisfound, "Constants.ERRORMESSAGEMANAGENEWSSEARCH");
		
}
}
