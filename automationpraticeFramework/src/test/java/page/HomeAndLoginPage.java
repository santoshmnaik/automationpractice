package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomeAndLoginPage {

	public HomeAndLoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[@title='Log in to your customer account']" )
	public WebElement linkSignIn;
	
	@FindBy(how = How.XPATH, using = "//input[@id='email']" )
	public WebElement txtUsernameToLogin;
	
	@FindBy(how = How.XPATH, using = "//input[@id='passwd']" )
	public WebElement txtPasswordToLogin;
	
	@FindBy(how = How.XPATH, using = "//button[@id='SubmitLogin']" )
	public WebElement btnSubmitToLogin;
	
	@FindBy(how = How.XPATH, using = "//div[@id='columns']/div[1]/span[2]")
	public WebElement myAccount;
	
	@FindBy(how = How.XPATH, using = "//*[@id='center_column']/div/div[1]/ul/li[4]/a/span")
	public WebElement btnUpdatePersonalInformation;
	
	@FindBy(how = How.XPATH, using = "//a[@title='Log me out']" )
	public WebElement linkSignOut;
}
