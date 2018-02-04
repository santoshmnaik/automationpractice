package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OrderItem {

	public OrderItem(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='block_top_menu']/ul/li[3]/a" )
	public WebElement linkTshirtTab;
	
	@FindBy(how = How.XPATH, using = "//input[@id='layered_id_attribute_group_2']" )
	public WebElement chkBoxMen;
	
	@FindBy(how = How.XPATH, using = "//a[@title='Faded Short Sleeve T-shirts'][@class='product-name']" )
	public WebElement imgItemTshirt;
	//img[@title='Faded Short Sleeve T-shirts']  //button[@name='Submit'][@class='exclusive']
	
	@FindBy(how = How.XPATH, using = "//button[@name='Submit']" )
	public WebElement btnAddToCart;
	
	
	@FindBy(how = How.XPATH, using = "//div[@id='layer_cart']/div[1]/div[1]/h2" )
	public WebElement msgAddedToCart;
	
	@FindBy(how = How.XPATH, using = "//a[@title='Proceed to checkout']" )
	public WebElement btnProceedToCheckOut;
	
	@FindBy(how = How.XPATH, using = "//a[@title='Proceed to checkout'][@class='button btn btn-default standard-checkout button-medium']" )
	public WebElement linkProceedToCheckOutInSummaryPage;
	
	@FindBy(how = How.XPATH, using = "//button[@name='processAddress']" )
	public WebElement btnProceedToCheckOutInAddressPage;
	
	@FindBy(how = How.XPATH, using = "//input[@id='cgv']" )
	public WebElement chkBoxTermsAndService;
	
	@FindBy(how = How.XPATH, using = "//button[@name='processCarrier']" )
	public WebElement btnProceedToCheckOutInShippingPage;
	
	@FindBy(how = How.XPATH, using = "//a[@title='Pay by bank wire']" )
	public WebElement linkPayByBankWire;
	
	@FindBy(how = How.XPATH, using = "//button[@type='submit'][@class='button btn btn-default button-medium']" )
	public WebElement btnConfirmMyOrder;
	
	@FindBy(how = How.XPATH, using = "//div[@class='box']" )
	public WebElement txtOrderConfirmationMessage;
	
	@FindBy(how = How.XPATH, using = "//a[@title='Back to orders']" )
	public WebElement linkBackToOrders;
	
	@FindBy(how = How.XPATH, using = "//table[@id='order-list']/tbody/tr[1]/td[1]/a" )
	public WebElement linkLastOrderedItem;
}
