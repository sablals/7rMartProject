package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUpload;
import utilities.PageUtilities;
import utilities.WaitUtility;

public class ManageCategoryAdd {
	WebDriver driver;
	public ManageCategoryAdd(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver ,this);
	}
	@FindBy(xpath="//a[contains(@class,'small-box-footer')and contains(@href,'/admin/list-category')]")WebElement managecategadd;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement selectone;
	@FindBy(xpath="//input[@name='category']")WebElement category;
	@FindBy(xpath ="//li[@id ='134-selectable']")WebElement selectgroup;
	@FindBy(xpath="//input[@type='file']")WebElement chooseimag;
	@FindBy(xpath="//input[@value='no']")WebElement showtopmenu;
	@FindBy(xpath="//input[@value='no']")WebElement showleftmenu;
	@FindBy(xpath="//button[@name='create']")WebElement saved;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alerts;
	
	public void manageCategory()
	{
		managecategadd.click();	
	}
	public void addItems()
	{
		selectone.click();	
	}
	public void enterCategory(String categorys)
	{
		category.sendKeys(categorys);
	}
	public void selectGroupDrags()
	{
		PageUtilities.doubleClickToMoveCategorySelectGroup(driver, selectgroup);	
	}
	public void imageupload(String image)
	{
		
		FileUpload.fileUploadSendkey(chooseimag, image);
	}
	public void showonTopMenu()
	{
		PageUtilities.scrollBy(driver,showtopmenu);
		WaitUtility.waitforShowTopMenu(driver,showtopmenu);
		showtopmenu.click();	
	}
	public boolean isShowonTopMenuNoRaddiobuttonSelect()
	{
		return showtopmenu.isSelected();
	}
	
	public void showonLeftMenu()
	{
		PageUtilities.scrollBy(driver,showleftmenu);
		WaitUtility.waitforShowLeftMenu(driver,showleftmenu);
		showleftmenu.click();	
	}
	public boolean isShowonLeftMenuNoRaddiobuttonSelect()
	{
		return showleftmenu.isSelected();
	}
	public void savedin()
	{
		PageUtilities.scrollBy(driver,saved);
		WaitUtility.waitforPageSubmit(driver,saved);
		saved.click();
	}
	public boolean alertin()
	{
		return alerts.isDisplayed();
	}
	
	}

	


