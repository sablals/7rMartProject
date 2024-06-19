package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUpload;
import utilities.PageUtilities;
import utilities.WaitUtility;

public class ManagePageAdd {
	WebDriver driver;
	public ManagePageAdd(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver ,this);
	} 
	@FindBy(xpath="//a[contains(@href,'/admin/list-page')and contains(@class,'small-box-footer')]")WebElement managepage;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement enternew;
	@FindBy(xpath="//input[@type='text']")WebElement title;
	@FindBy(xpath="//div[@class='note-editable card-block']")WebElement description;
	@FindBy(id="page")WebElement page;
	@FindBy(id="main_img")WebElement chooseimage;
	@FindBy(xpath="//button[@type='button']")WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alerts;
	
	public void manage()
	{
		managepage.click();	
	}
	public void newCategory()
	{
		enternew.click();	
	}
	public void entertitlevalue(String titles)
	{
		title.sendKeys(titles);	
	}
	public void enterdescrpitnvalue(String descrptn)
	{
		description.sendKeys(descrptn);	
	}
	public void enterpagevalue(String paged)
	{
		page.sendKeys(paged);	
	}
	public void enterimagevalue(String images)
	{
		FileUpload.fileUploadSendkey(chooseimage,images);	
	}
	public void saved()
	{
		PageUtilities.scrollBy(driver,save);
		WaitUtility.waitforPageSubmit(driver,save);
		save.click();	
	}
	public boolean alertin()
	{
		return alerts.isDisplayed();
	}

}
