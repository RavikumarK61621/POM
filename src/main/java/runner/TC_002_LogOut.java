package runner;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class TC_002_LogOut extends ProjectSpecificMethod{

	@BeforeTest
	public void setExcelData() {
		datasheet = "Login";
	}
	
	@Test(dataProvider = "xdata")
	public void logOut(String Uname, String pWord) throws IOException {
	LoginPage lp=new LoginPage();
	lp.userName()
	.passWord()
	.clickLoginButton()
	.ClickSubmit();
	
}

}