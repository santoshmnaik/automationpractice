package stepDefinitions;

import com.relevantcodes.extentreports.LogStatus;

import Base.BaseClass;
import commonAction.CommonAction;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.HomeAndLoginPage;
import page.PersonalInformation;
import property.PropertyReader;
import screenshot.ScreenShot;


public class updatePersonalInformation extends BaseClass {

	private BaseClass baseUtil;
	HomeAndLoginPage homeandLogin;
	PersonalInformation personalInfo;
	
	public updatePersonalInformation(BaseClass baseUtil){
		this.baseUtil = baseUtil;
		homeandLogin = new HomeAndLoginPage(baseUtil.driver);
		personalInfo = new PersonalInformation(baseUtil.driver);
	}
	
	@Given("^User navigates to home page$") 
	    // Write code here that turns the phrase above into concrete actions
	    public void Given_User_navigates_to_home_page () {
		try{
			String siteURL = new PropertyReader().readProperty("url");
			baseUtil.driver.navigate().to(siteURL);
	    	Thread.sleep(5000);
	    	extentTest.log(LogStatus.PASS, "User successfully navigated to " + siteURL);
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());		
			throw new AssertionError("User unable to navigate to home page", e);
		}
		}
	@When("^User clicks on Sign in link$")
	    // Write code here that turns the phrase above into concrete actions
	    public void When_User_clicks_on_Sign_in_link () {
		try{
			CommonAction.clickOnElement(homeandLogin.linkSignIn);
			extentTest.log(LogStatus.PASS, "SignIn clicked");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());			
			throw new AssertionError("User unable to click Sign in button", e);
		}
		}
	
	@And("^User enters \"(.*)\" and \"(.*)\"$") 
	    // Write code here that turns the phrase above into concrete actions
	    public void And_User_enters_Username_and_Password (String username, String password) {
		try{
			CommonAction.waitFor(homeandLogin.txtUsernameToLogin, baseUtil.driver);			
			CommonAction.enterText(homeandLogin.txtUsernameToLogin, username);
			CommonAction.enterText(homeandLogin.txtPasswordToLogin, password);
			CommonAction.clickOnElement(homeandLogin.btnSubmitToLogin);
			extentTest.log(LogStatus.PASS, "SignIn clicked");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());		
			throw new AssertionError("User unable to enter login credentials", e);
		}
		}
	
	@Then("^User is logged in and My Account page is displayed$") 
	    // Write code here that turns the phrase above into concrete actions
		public void Then_User_is_logged_in_and_My_Account_page_is_displayed () {
		try{
			CommonAction.waitFor(homeandLogin.myAccount, baseUtil.driver);
			extentTest.log(LogStatus.PASS, "User is logged in and my account page is displayed");
			ScreenShot.captureScreen(baseUtil.driver,"UserLoggedIn");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());		
			throw new AssertionError("User unable to login", e);
		}
		}

		
	@When("^User click on My Personal Information button$") 
	    // Write code here that turns the phrase above into concrete actions
	    public void When_User_click_on_My_Personal_Information_button () {
		try{
			CommonAction.clickOnElement(homeandLogin.btnUpdatePersonalInformation);
			extentTest.log(LogStatus.PASS, "My Personal Information button is clicked");
    	}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());	
			throw new AssertionError("User unable to click on Personal Information button", e);
		}
		}
	
	@And("^User update \"(.*)\" with valid allowed name and enter valid \"(.*)\"$") 
	    // Write code here that turns the phrase above into concrete actions
	    public void And_User_update_first_name_with_valid_allowed_name_and_enter_valid_password (String firstname, String reenter_password) {
		try{
			CommonAction.waitFor(personalInfo.txtFirstName, baseUtil.driver);
			personalInfo.txtFirstName.clear();
			CommonAction.enterText(personalInfo.txtFirstName, firstname);
			CommonAction.enterText(personalInfo.txtCurrentPassword, reenter_password);
			extentTest.log(LogStatus.PASS, "Firstname is updated");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());	
			throw new AssertionError("User unable to update the first name field", e);
		}
		}
	
	@And("^User clicks on Save$") 
	    // Write code here that turns the phrase above into concrete actions
	    public void And_User_clicks_on_Save () {
		try{
			CommonAction.clickOnElement(personalInfo.btnSave);
			extentTest.log(LogStatus.PASS, "Save button is clicked");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());		
			throw new AssertionError("User unable to click on Save button", e);
		}
		}

	@Then("^Your personal information has been successfully updated message is displayed$") 
	    // Write code here that turns the phrase above into concrete actions
		public void Then_Your_personal_information_has_been_successfully_updated_message_is_displayed () {
		try{
			CommonAction.waitFor(personalInfo.msgUpdateSuccessful, baseUtil.driver);
			extentTest.log(LogStatus.PASS, "Personal Information changes are saved successfully");
			ScreenShot.captureScreen(baseUtil.driver,"Personal_Information_Verified");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());		
			throw new AssertionError("Personal information update confirmation message not displayed", e);
		}
		}
}
