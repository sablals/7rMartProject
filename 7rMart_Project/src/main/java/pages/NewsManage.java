package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsManage {
	WebDriver driver;
	public NewsManage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver ,this);
	}
	@FindBy(xpath="//a[contains(@href,'/admin/list-news')and contains(@class,'small-box-footer')]")WebElement news;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement search;
	@FindBy(xpath="//input[@class='form-control']")WebElement newstitle;
	@FindBy(xpath="//button[@value='sr']")WebElement searchin;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")WebElement searchtitle;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alerts;
	
	
	public void managenews()
	{
		news.click();	
	}
	public void search()
	{
		search.click();	
	}
	public void enterNewsTitle(String newe)
	{
		newstitle.sendKeys(newe);
	}
	public void searched()
	{
		searchin.click();	
	}
	public boolean alertin()
	{
		return alerts.isDisplayed();
	}
	public boolean searchnewsdetails(String newsdetail)
	{
		return searchtitle.getText().contains(newsdetail);
	}
	

}
