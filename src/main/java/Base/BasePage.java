package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected static WebDriver driver;
    Actions action;
    public BasePage(WebDriver driver)
    {
        this.driver=driver;
        this.action=new Actions(driver);
    }

    public WebElement locateElement(By locator)
    {
        return driver.findElement(locator);
    }
    public void webElementClick(By locator)
    {
        WebElement locatorElement=locateElement(locator);
        locatorElement.click();
    }
    public void webElementSendKeys(By locator, String choiceString)
    {
        WebElement locatorElement=locateElement(locator);
        locatorElement.sendKeys(choiceString);
    }
    public String getCurrentURL(WebDriver driver)
    {
        return driver.getCurrentUrl();
    }
    public static WebDriver getDriver()
    {
        return driver;
    }
    public List<WebElement> explicitWaitForDropDown(By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        return options;
    }
    public void explicitWaitForTextBoxesValues(By locator, String value)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementValue(locator, value))  ;
    }
    public void explicitWaitForClickableItems(By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void explicitWaitForVisibility(By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator))  ;
    }

}
