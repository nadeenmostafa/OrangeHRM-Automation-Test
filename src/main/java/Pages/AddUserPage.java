package Pages;

import Base.BasePage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddUserPage extends BasePage {

    //By userRoleClick= By.xpath("(//div[contains(@class,'oxd-select-text--active')])[1]");
    By userRoleClick=By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='User Role']]//div[contains(@class, 'oxd-select-text-input')]");
    By userRoleSelect=By.cssSelector(".oxd-select-wrapper .oxd-select-option");
    By employeeNameClick=By.xpath("//input[@placeholder='Type for hints...']");
    By employeeNameSelect=By.cssSelector(".oxd-autocomplete-option");
    //By statusClick=By.xpath("(//div[contains(@class,'oxd-select-text--active')])[2]");
    By statusClick=By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Status']]//div[contains(@class, 'oxd-select-text-input')]");
    By statusSelect=By.cssSelector(".oxd-select-wrapper .oxd-select-option:nth-of-type(2)");
    By userName=By.cssSelector("input[autocomplete='off']");
    By password=By.xpath("//div[contains(@class,'user-password-cell')]//input[@type='password']");
  //  By confirmationPassword=By.xpath("(//input[@type='password'])[2]");
    By confirmationPassword=By.xpath("//div[contains(@class, 'oxd-grid-item')][.//label[text()='Confirm Password']]//input[@type='password']");
    By saveButton=By.xpath("//button[text()=' Save ']");
    String username;

    public AddUserPage(WebDriver driver)
    {
        super(driver);
    }
    public void userRoleInputBoxClick() {

        explicitWaitForClickableItems(userRoleClick);
        webElementClick(userRoleClick);
    }
    public void employeeNameInputBoxClick()  {
        explicitWaitForClickableItems(employeeNameClick);
        webElementClick(employeeNameClick);
    }
    public void statusInputBoxClick()  {
        explicitWaitForClickableItems(statusClick);
        webElementClick(statusClick);
    }
    public void userNameInputBoxClick()  {
        explicitWaitForClickableItems(userName);
        webElementClick(userName);
    }
    public void passwordInputBoxClick() {
        explicitWaitForClickableItems(password);
        webElementClick(password);
    }
    public void confirmationPasswordInputBoxClick()  {
        explicitWaitForClickableItems(confirmationPassword);
        webElementClick(confirmationPassword);
    }
    public void saveButtonClick()  {
        explicitWaitForClickableItems(saveButton);
        webElementClick(saveButton);
    }
    public void enterUserRole(String role)  {
        List<WebElement> elementList = explicitwaitfordropdown(userRoleSelect);
        for (WebElement option : elementList) {
            if (option.getText().equals(role)) {
                option.click();
                break;
            }
        }
    }
    public String enterEmployeeName(String employeeInit) throws InterruptedException
    {

        webElementSendKeys(employeeNameClick,employeeInit);
            Thread.sleep(2000);
        //explicitwait(employeeNameSelect);
        List<WebElement> elementList = explicitwaitfordropdown(employeeNameSelect);
        if (!elementList.isEmpty()) {
            username= elementList.get(0).getText();
            elementList.get(0).click();
        }
        return username;
    }
    public void enterStatus(String status) {

        List<WebElement> elementList = explicitwaitfordropdown(statusSelect);
        for (WebElement option : elementList) {
            if (option.getText().equals(status)) {
                option.click();
                break;
            }
        }
    }
    public void enterUserName(String uName) {

        webElementSendKeys(userName,uName);
        explicitWaitForTextBoxesValues(userName,uName);

    }
    public void enterPassword(String passwd)  {

        webElementSendKeys(password,passwd);
        explicitWaitForTextBoxesValues(password,passwd);
    }
    public void enterConfirmationPassword(String password)
    {
        webElementSendKeys(confirmationPassword,password);
        explicitWaitForTextBoxesValues(confirmationPassword,password);
    }
}
