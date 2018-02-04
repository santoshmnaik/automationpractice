package stepDefinitions;



import java.util.Map;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

//import java.lang.ref.Reference;

import Base.BaseClass;
import commonAction.CommonAction;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.HomeAndLoginPage;
import page.OrderItem;
import property.PropertyReader;
import screenshot.ScreenShot;

public class placeOrderandVerify extends BaseClass {
	
	public String confirmationMessage=null;
	public String refNo=null;
	private BaseClass baseUtil;
	HomeAndLoginPage homeandLogin; //= new HomeAndLoginPage(baseUtil.driver);
	OrderItem orderItem; //= new OrderItem(baseUtil.driver);
	public placeOrderandVerify(BaseClass baseUtil){
		this.baseUtil = baseUtil;
		homeandLogin = new HomeAndLoginPage(baseUtil.driver);
		orderItem = new OrderItem(baseUtil.driver);
	}
	
	@Given("^User is on home page$") 
	    // Write code here that turns the phrase above into concrete actions
	    public void Given_User_is_on_home_page (){
		try{
			String siteURL = new PropertyReader().readProperty("url");
			baseUtil.driver.navigate().to(siteURL);
	    	Thread.sleep(5000);
	    	extentTest.log(LogStatus.PASS,"User successfully navigated to "+siteURL);
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());			
			throw new AssertionError("User unable to navigate to home page", e);
		}
		}
	@When("^User Navigate to Sign in Page$")
	    // Write code here that turns the phrase above into concrete actions		
	    public void When_User_Navigate_to_Sign_in_Page ()    {
		try{
			CommonAction.clickOnElement(homeandLogin.linkSignIn);
			extentTest.log(LogStatus.PASS, "SignIn clicked");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());	
			throw new AssertionError("User unable to click Sign in button", e);
		}
	    }
	@And("^User enters Username and Password on Sign in Page$") 
	    // Write code here that turns the phrase above into concrete actions
	    public void And_User_enters_Username_and_Password_on_Sign_in_Page (DataTable credentials)  {
		try{
			CommonAction.waitFor(homeandLogin.txtUsernameToLogin, baseUtil.driver);	
			for (Map<String, String> data : credentials.asMaps(String.class, String.class)){
				CommonAction.enterText(homeandLogin.txtUsernameToLogin, data.get("username"));
				CommonAction.enterText(homeandLogin.txtPasswordToLogin, data.get("password"));
			}
			CommonAction.clickOnElement(homeandLogin.btnSubmitToLogin);
			extentTest.log(LogStatus.PASS,"Sign in button is clicked");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());	
			throw new AssertionError("User unable to enter login credentials", e);
		}
	    }
	
	@Then("^User is logged in and is on My Account page$") 
	    // Write code here that turns the phrase above into concrete actions
		public void Then_User_is_logged_in_and_is_on_My_Account_page ()  {
		try{
			CommonAction.waitFor(homeandLogin.myAccount, baseUtil.driver);
			extentTest.log(LogStatus.PASS,"User is logged in and my account page is displayed");
			ScreenShot.captureScreen(baseUtil.driver,"UserLoggedIn");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());	
			throw new AssertionError("User unable to login", e);
		}
	    }

	@Given("^User clicks on T-SHIRTS tab$")
	    // Write code here that turns the phrase above into concrete actions
	    public void Given_User_clicks_on_TSHIRTS_tab ()    {
		try{
			CommonAction.clickOnElement(orderItem.linkTshirtTab);
			extentTest.log(LogStatus.PASS,"T-shirts tab is clicked");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());		
			throw new AssertionError("User unable to click on T-SHIRTS tab", e);
		}
	    }

	@And("^User clicks on the first displayed T-shirt$")
	    // Write code here that turns the phrase above into concrete actions
	    public void And_User_clicks_on_the_first_displayed_Tshirt ()    {
		try{
			CommonAction.waitFor(orderItem.imgItemTshirt, baseUtil.driver);
			CommonAction.clickOnElement(orderItem.chkBoxMen);
			CommonAction.clickOnElement(orderItem.imgItemTshirt);
			extentTest.log(LogStatus.PASS,"First T-shirt is selected");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());	
			throw new AssertionError("User unable to select T-shirt", e);
		}
	    }

	@Then("^T-shirt product page is displayed$")
	    // Write code here that turns the phrase above into concrete actions
	    public void Then_Tshirt_product_page_is_displayedd ()  {
		try{
			CommonAction.waitFor(orderItem.btnAddToCart, baseUtil.driver);
			extentTest.log(LogStatus.PASS,"Selected T-shirt product page is displayed");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());		
			throw new AssertionError("T-shirt product page is not displayed", e);
		}
	    }

	@When("^User clicks on Add to Cart on product page$")
	    // Write code here that turns the phrase above into concrete actions
	    public void When_User_clicks_on_Add_to_Cart_on_product_page ()   {
		try{
			CommonAction.clickOnElement(orderItem.btnAddToCart);
			extentTest.log(LogStatus.PASS,"Add to cart button clicked on product page");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());		
			throw new AssertionError("User unable to click on Add to cart", e);
		}
	    }

	@Then("^Product successfully added to your shopping cart message is displayed$")
	    // Write code here that turns the phrase above into concrete actions
	    public void Then_Product_successfully_added_to_your_shopping_cart_message_is_displayed ()   {
		try{
			CommonAction.waitFor(orderItem.msgAddedToCart, baseUtil.driver);
			ScreenShot.captureScreen(baseUtil.driver, "Successful_Added_Cart");
			extentTest.log(LogStatus.PASS,"Product successfullt added message is displayed");
			ScreenShot.captureScreen(baseUtil.driver,"Product_successfully_added");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());	
			throw new AssertionError("Product not added to the cart", e);
		}
	    }

	@When("^User clicks on Proceed to checkout$")
	    // Write code here that turns the phrase above into concrete actions
	    public void When_User_clicks_on_Proceed_to_checkout ()  {
		try{
			CommonAction.clickOnElement(orderItem.btnProceedToCheckOut);
			extentTest.log(LogStatus.PASS,"Click on Proceed button clicked");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());	
			throw new AssertionError("User unable to click on proceed to checkout", e);
		}
	    }

	@Then("^Shopping cart summary page is displayed$")
	    // Write code here that turns the phrase above into concrete actions
	    public void Then_Shopping_cart_summary_page_is_displayed ()    {
		try{
			CommonAction.waitFor(orderItem.linkProceedToCheckOutInSummaryPage, baseUtil.driver);
			extentTest.log(LogStatus.PASS,"Shopping cart summary page is displayed");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());		
			throw new AssertionError("Shopping cart summary page is not displayed", e);
		}
	    }

	@When("^User clicks on Proceed to checkout on Summary breadcrumb$")
	    // Write code here that turns the phrase above into concrete actions
	    public void When_User_clicks_on_Proceed_to_checkout_on_Summary_breadcrumb ()  {
		try{
			CommonAction.clickOnElement(orderItem.linkProceedToCheckOutInSummaryPage);
			extentTest.log(LogStatus.PASS,"Click on Proceed button clicked on summary breadcrumb");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());		
			throw new AssertionError("User unable to click on proceed to checkout", e);
		}
	    }

	@And("^User clicks on Proceed to checkout on Address breadcrumb$")
	    // Write code here that turns the phrase above into concrete actions
	    public void And_User_clicks_on_Proceed_to_checkout_on_Address_breadcrumb ()    {
		try{
			CommonAction.clickOnElement(orderItem.btnProceedToCheckOutInAddressPage);
			extentTest.log(LogStatus.PASS,"Click on Proceed button clicked on address breadcrumb");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());		
			throw new AssertionError("User unable to click on proceed to checkout", e);
		}
	    }

	@And("^User agrees to terms and condition on Shipping breadcrumb$")
	    // Write code here that turns the phrase above into concrete actions
	    public void And_User_agrees_to_terms_and_condition_on_Shipping_breadcrumb ()   {
		try{
			CommonAction.clickOnElement(orderItem.chkBoxTermsAndService);
			extentTest.log(LogStatus.PASS,"Terms and condition checkbox is checked");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());	
			throw new AssertionError("User unable to check terms and condition checkbox", e);
		}
	    }

	@And("^User clicks on Proceed to checkout on Shipping breadcrumb$")
	    // Write code here that turns the phrase above into concrete actions
	    public void And_User_clicks_on_Proceed_to_checkout_on_Shipping_breadcrumb ()    {
		try{
			CommonAction.clickOnElement(orderItem.btnProceedToCheckOutInShippingPage);
			extentTest.log(LogStatus.PASS,"Click on Proceed button clicked on shipping breadcrumb");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());	
			throw new AssertionError("User unable to click on proceed to checkout", e);
		}
	    }

	@And("^User clicks on Pay by bank wire on payment breadcrumb$")
	    // Write code here that turns the phrase above into concrete actions
	    public void And_User_clicks_on_Pay_by_bank_wire ()  {
		try{
			CommonAction.clickOnElement(orderItem.linkPayByBankWire);
			extentTest.log(LogStatus.PASS,"User selects the payment mode");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());	
			throw new AssertionError("User unable to pay the order", e);
		}
	    }

	@And("^User clicks on I confirm my order on Payment breadcrumb$")
	    // Write code here that turns the phrase above into concrete actions
	    public void And_User_clicks_on_I_confirm_my_order_on_Payment_breadcrumb ()   {
		try{
			CommonAction.clickOnElement(orderItem.btnConfirmMyOrder);
			extentTest.log(LogStatus.PASS,"User confirms the order");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());		
			throw new AssertionError("User unable to confirm the order", e);
		}
	    }

	@Then("^Order confirmation page along with order reference number is displayed$")
	    // Write code here that turns the phrase above into concrete actions
	    public void Then_Order_confirmation_page_along_with_order_reference_number_is_displayed ()  {
		try{
			CommonAction.waitFor(orderItem.txtOrderConfirmationMessage, baseUtil.driver);
			confirmationMessage=CommonAction.getText(orderItem.txtOrderConfirmationMessage);
			extentTest.log(LogStatus.PASS,"Order confirmation page is displayed with order reference number");
			ScreenShot.captureScreen(baseUtil.driver,"Order_confirmed");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());	
			throw new AssertionError("Order confirmation page is not displayed", e);
		}
	    }

	@When("^User clicks on Back to orders link$")
	    // Write code here that turns the phrase above into concrete actions
	    public void When_User_clicks_on_Back_to_orders_link ()  {
		try{
			CommonAction.clickOnElement(orderItem.linkBackToOrders);
			extentTest.log(LogStatus.PASS,"Back to order button is clicked to go to order history table");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());	
			throw new AssertionError("User unable to click on Back to order link", e);
		}
	    }

	@Then("^Order History page is displayed$")
	    // Write code here that turns the phrase above into concrete actions
	    public void Then_Order_History_page_is_displayed () {
		try{
			CommonAction.waitFor(orderItem.linkLastOrderedItem, baseUtil.driver);
			refNo=CommonAction.getText(orderItem.linkLastOrderedItem);
			extentTest.log(LogStatus.PASS,"Order history page is displayed");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());		
			throw new AssertionError("Order history page is not displayed", e);
		}
	    }

	@And("^User is able to see the ordered product by verifying the reference number$")
	    // Write code here that turns the phrase above into concrete actions
	    public void And_User_is_able_to_see_the_ordered_product_by_verifying_the_reference_number () {
		try{
			Assert.assertTrue(confirmationMessage.indexOf(refNo)>0,"Presense of OrderReference Number in order history table");
			extentTest.log(LogStatus.PASS,"Order reference number is present in order history table");
			ScreenShot.captureScreen(baseUtil.driver,"Order_reference_verified");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());	
			throw new AssertionError("Order reference not displayed in order history page", e);
		}
	    }
}

