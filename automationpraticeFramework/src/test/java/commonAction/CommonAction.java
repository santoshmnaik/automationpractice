package commonAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonAction {

	public static void clickOnElement(WebElement element) throws InterruptedException{
		element.click();
		Thread.sleep(3000);
	}
	
	public static void enterText(WebElement element, String data){
		element.sendKeys(data);
	}
	
	public static String getText(WebElement element){
		return element.getText();
	}
	
	public static void waitFor(WebElement element, WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
