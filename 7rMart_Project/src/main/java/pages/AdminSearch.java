package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtilities;

public class AdminSearch {
	WebDriver driver;
	public AdminSearch (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver ,this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")WebElement manageadmin;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement search;
	@FindBy(id=("un"))WebElement username;
	@FindBy(id=("ut"))WebElement usertype;
	@FindBy(xpath="//button[@value='sr']")WebElement searchin;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")WebElement searchtitle;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alerts;

	public void admin()
	{
		manageadmin.click();	
	}
	public void searched()
	{
		search.click();	
	}
	public void enterusername(String usernames)
	{
		username.sendKeys(usernames);
	}
	public void enterusertype(String elements)
	{
		PageUtilities.selectUsertypeDropdown(elements, usertype);
	}
	public void savein()
	{
		searchin.click();	
	}
	public boolean alertin()
	{
		return alerts.isDisplayed();
	}
	public boolean searchuserdetails(String userdetail)
	{
		return searchtitle.getText().contains(userdetail);
	}
	
}
