package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PersonalInformation {

	public PersonalInformation(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[@title='Information']" )
	public WebElement linkInformationPage;
	
	@FindBy(how = How.XPATH, using = "//input[@id='firstname']" )
	public WebElement txtFirstName;
	
	@FindBy(how = How.XPATH, using = "//input[@id='old_passwd']" )
	public WebElement txtCurrentPassword;
	
	@FindBy(how = How.XPATH, using = "//button[@name='submitIdentity']" )
	public WebElement btnSave;
	
	@FindBy(how = How.XPATH, using = "//p[@class='alert alert-success']" )
	public WebElement msgUpdateSuccessful;
	
}
