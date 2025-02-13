package runner;

	import java.io.IOException;

import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	import base.ProjectSpecificMethod;
	import pages.LoginPage;

	public class TC_001_LoginPagewithPropertyfile extends ProjectSpecificMethod{
		
		@Test
		public void loginPageClickLead() throws IOException {
			LoginPage lp=new LoginPage();
			lp.userName()
			.passWord()
			.clickLoginButton()
			.clickCrmsfa()
			.clickOnLeads();

	}

}
