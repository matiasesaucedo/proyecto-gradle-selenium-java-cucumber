package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private static Actions action;

    static {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\matia\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage (WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void navigateTo(String url){
        driver.get(url);
    }
    public static void closeBrowser(){
        driver.quit();
    }
    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
    public void clickElement(String locator){
        Find(locator).click();
    }
    public void write(String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }
    public void buscar(String locator){
        Find(locator).sendKeys(Keys.ENTER);
    }
    //  "String locator" -> como encontramos el dropdown, "String valueToSelect" -> que valor elegimos del dropdown
    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select (Find(locator));
        dropdown.selectByValue(valueToSelect);
    }
    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select (Find(locator));
        dropdown.selectByIndex (valueToSelect);
    }
    public void selectFromDropdownByText(String locator, String valueToSelect){
        Select dropdown = new Select (Find(locator));
        dropdown.selectByVisibleText (valueToSelect);
    }
    public void hoverOverElement(String locator){
        action.moveToElement(Find(locator));
    }
    public void doubleClick(String locator){
        action.doubleClick(Find(locator));
    }
    public void rightClick(String locator){
        action.contextClick(Find(locator));
    }
    public String getValueFromTable(String locator, int row, int column){
//        "cellINeed" lo creó él
        String cellINeed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        return Find(cellINeed).getText();
    }
    public void setValueOnTable(String locator, int row, int column, String stringToSend){
        String cellToFill = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        Find(cellToFill).sendKeys(stringToSend);
    }
    public void switchToIframe (int iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }
    public void switchToParentFrame (int parentFrame){
        driver.switchTo().parentFrame();
    }
    //    Para cerrar popups
    public void dissmisAlert(){
        driver.switchTo().alert().dismiss();
    }
    public String textFromElement(String locator){
        return Find(locator).getText();
    }
    public boolean elementIsDisplayed(String locator){
        return Find(locator).isDisplayed();
    }
    public boolean elementIsEnabled(String locator){
        return Find(locator).isEnabled();
    }
    public boolean elementIsSelected(String locator){
        return Find(locator).isSelected();
    }
}

