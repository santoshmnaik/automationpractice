package stepDefinitions;

import com.relevantcodes.extentreports.LogStatus;

import Base.BaseClass;
import commonAction.CommonAction;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import page.HomeAndLoginPage;



public class commonstepDefinitions extends BaseClass {
	
	private BaseClass baseUtil;
	HomeAndLoginPage homeandLogin;
	
	public commonstepDefinitions(BaseClass baseUtil){
		this.baseUtil = baseUtil;
		homeandLogin = new HomeAndLoginPage(baseUtil.driver);
		
	}
	
	@When("^User clicks on Sign out$") 
	    // Write code here that turns the phrase above into concrete actions
		public void When_User_clicks_on_Sign_out () {
		try{
			CommonAction.clickOnElement(homeandLogin.linkSignOut);
			extentTest.log(LogStatus.PASS, "Sign out button is clicked");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());		
			throw new AssertionError("User unable to click Sign out", e);
		}
		}
	
	@And("^User is logged out$") 
	    // Write code here that turns the phrase above into concrete actions
		public void And_User_is_logged_out () {
		try{
			CommonAction.waitFor(homeandLogin.linkSignIn, baseUtil.driver);
			extentTest.log(LogStatus.PASS, "User is Signed out successfully");
		}catch(Exception e){
			extentTest.log(LogStatus.FAIL, e.getMessage());	
			throw new AssertionError("User is not logged out", e);
		}
		}
	
	

}
