package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {
	public static void selectUsertypeDropdown(String usertype,WebElement elements)
	{
		Select select=new Select(elements);
		select.selectByVisibleText(usertype);
	}
	
	public static void selectOptionByText(String category, WebElement selectElement) {
        Select select = new Select(selectElement);
        select.selectByVisibleText(category);
	}
	public static void selectDropdown(String usertype,WebElement elements)
	{
		Select select=new Select(elements);
		select.selectByValue(usertype);
	}

	public static void doubleClickToMoveCategorySelectGroup(WebDriver driver,WebElement selectgroup)
	{
		Actions action=new Actions(driver);//Double click action
		action.doubleClick(selectgroup).perform();
	}
	public static void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).build().perform();
    }
	
	//javaScriptExecutor
	public static void scrollBy(WebDriver driver,WebElement element)
	{

	((JavascriptExecutor)driver).executeScript("arguments[0].scrollBy(true);",element);	
	
	}
	public static void clickBy(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].click();",element);
	}
}

