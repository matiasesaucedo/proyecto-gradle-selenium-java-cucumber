package pages;

public class AutomationSandboxPage extends BasePage {
    private String categoryDropdown = "//*[@id=\"formBasicSelect\"]";

    public AutomationSandboxPage(){
        super(driver);
    }
    public void navigateToSandbox(){
        navigateTo("https://thefreerangetester.github.io/sandbox-automation-testing/");
    }

    public void selectCategory(String category){
        selectFromDropdownByText(categoryDropdown, category);
    }
}
