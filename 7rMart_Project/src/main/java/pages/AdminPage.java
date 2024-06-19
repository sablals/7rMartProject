package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtilities;

public class AdminPage {
	WebDriver driver;
public AdminPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver , this);
}
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")WebElement adminpage;
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newenter;
@FindBy(id="username")WebElement adminusename;
@FindBy(id="password")WebElement adminpwd;
@FindBy(id="user_type")WebElement usertype;
@FindBy(xpath="//button[@name='Create']")WebElement save;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alerts;

public void adminpaged()
{
	adminpage.click();	
}
public void enternew()
{
	newenter.click();	
}
public void enterusername(String username)
{
	adminusename.sendKeys(username);
}
public void enterpassword(String password)
{
	adminpwd.sendKeys(password);
}
public void enterusertype(String elements)
{
	PageUtilities.selectUsertypeDropdown(elements, usertype);
}
public void savein()
{
	save.click();	
}
public boolean alertin()
{
	return alerts.isDisplayed();
}

}

	






