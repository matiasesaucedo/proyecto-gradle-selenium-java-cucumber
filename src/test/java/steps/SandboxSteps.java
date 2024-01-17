package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.AutomationSandboxPage;

public class SandboxSteps {
    AutomationSandboxPage sandboxPage = new AutomationSandboxPage();

    @Given("^I navigate to the sandbox page$")
    public void navigateToTheSandBoxSite(){
        sandboxPage.navigateToSandbox();
    }

    @And("^select a value from the dropdown$")
    public void selectState(){
        sandboxPage.selectCategory("Basketball");
    }
}
