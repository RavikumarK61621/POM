package runner;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class TC_004_CreateLead extends ProjectSpecificMethod{

	@BeforeTest
	public void setExcelData() {
		datasheet = "Login";
	}
	
	@Test
	public void createLead() throws IOException {
		LoginPage Lop = new LoginPage();
		Lop.userName()
		.passWord()
		.clickLoginButton()
		.clickCrmsfa()
		.clickOnLeads()
		.clickOnCreateLead()
		.clickOnCompanyName("Cname")
		.clickOnFirstName("Fname")
		.clickOnLastName("Lname")
		.clickOnCreateLead();

	}
	
}
