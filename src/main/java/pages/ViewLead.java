package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class ViewLead extends ProjectSpecificMethod{
	
//	public ViewLead(ChromeDriver driver) {
//		this.driver=driver;
//	}

	public ViewLead firstName() {
		try {
			String title = getDriver().getTitle();
			if(title.contains("View Lead")) {
				System.out.println("The Lead has been created Successfully");
			}else
			{
				System.out.println("The Lead has not created Successfully");
			}test.info("pass");
		} catch (Exception e) {
			test.info("fail");
		}
		return this;
	}
}
