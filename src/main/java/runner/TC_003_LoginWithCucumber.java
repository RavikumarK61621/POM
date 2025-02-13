package runner;

import base.ProjectSpecificMethod;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/java/feature/Login.feature",glue="pages",publish=true)

public class TC_003_LoginWithCucumber extends ProjectSpecificMethod{

	
}
