package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCategorySearch {
	WebDriver driver;
	public ManageCategorySearch(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver ,this);
	}
	@FindBy(xpath="//a[contains(@class,'small-box-footer')and contains(@href,'/admin/list-category')]")WebElement managecateg;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement search;
	@FindBy(xpath="//input[@name='un']")WebElement categorys;
	@FindBy(xpath="//button[@value='sr']")WebElement searchin;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")WebElement searchtitle;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alerts;
	
	public void manageCategory()
	{
		managecateg.click();	
	}
	public void search()
	{
		search.click();	
	}
	public void entercategory(String category)
	{
		categorys.sendKeys(category);
	}
	public void searched()
	{
		searchin.click();	
	}
	public boolean alertin()
	{
		return alerts.isDisplayed();
	}
	public boolean searchcategorydetails(String categorydetails)
	{
		return searchtitle.getText().contains(categorydetails);
	}

}
