package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static void waitforPageSubmit(WebDriver driver,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void waitforShowTopMenu(WebDriver driver,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void waitforShowLeftMenu(WebDriver driver,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void waitForElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void fluentWait(WebDriver driver, WebElement element) {
		Wait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30L))
				.pollingEvery(Duration.ofSeconds(5L)).ignoring(NoSuchElementException.class);
		fluentwait.until(ExpectedConditions.elementToBeClickable(element));
	}


}
