package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.FileUpload;
import utilities.PageUtilities;

public class SubcategoryUserAdd {
	WebDriver driver;
	public SubcategoryUserAdd (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver ,this);
	}
	@FindBy(xpath="//a[contains(@href,'/admin/list-sub-category')and contains(@class,'small-box-footer')]")WebElement newcategories;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement enternew;
	@FindBy(xpath="//select[@class='form-control selectpicker']")WebElement category;
	@FindBy(xpath="//input[@class='form-control']")WebElement subcatego;
	@FindBy(xpath="//input[@type='file']")WebElement images;
	@FindBy(xpath="//button[@name='create']")WebElement saved;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alerts;
	

	public void manageCategoryNew()
	{
		newcategories.click();	
	}
	public void newCategory()
	{
		enternew.click();	
	}
	public void entercategory(String selectElement)
	{
		PageUtilities.selectOptionByText(selectElement,category);
	}
	public void entersubcategory(String categoryi)
	{
		subcatego.sendKeys(categoryi);
	}
	public void imageupload(String image)
	{
	
		FileUpload.fileUploadSendkey(images, image);
	}
	public void savedin()
	{
		saved.click();	
	}
	public boolean alertin()
	{
		return alerts.isDisplayed();
	}
	
	public boolean newCategoryAdd()
	{
		return newcategories.isDisplayed();
	}
}

