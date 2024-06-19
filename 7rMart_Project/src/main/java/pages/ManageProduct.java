package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProduct {
	WebDriver driver;
	public ManageProduct(WebDriver driver)
	
	{
		this.driver=driver;
		PageFactory.initElements(driver ,this);
	}
	@FindBy(xpath="//a[contains(@href,'/admin/list-product')and contains(@class,'small-box-footer')]")WebElement manageproduct;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement search;
	@FindBy(xpath="//input[@type='text']")WebElement title;
	@FindBy(xpath="//button[@value='sr']")WebElement searchin;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")WebElement searchtitle;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alerts;

	public void manage()
	{
		manageproduct.click();	
	}
	public void search()
	{
		search.click();	
	}
	public void entertitle(String titles)
	{
		title.sendKeys(titles);
	}
	public void searches()
	{
		searchin.click();	
	}
	public boolean alertin()
	{
		return alerts.isDisplayed();
	}
	public boolean searchproductdetails(String prdtdetail)
	{
		return searchtitle.getText().contains(prdtdetail);
	}
}
