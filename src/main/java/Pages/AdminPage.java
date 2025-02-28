package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminPage extends BasePage {

    By numberOfRecordsText= By.xpath("//div[contains(@class,'orangehrm-horizontal-padding')]//span[contains(@class,'oxd-text--span')]");
    By addButton=By.xpath("//button[text()=' Add ']");
    By userName=By.cssSelector(".oxd-input-group input.oxd-input");
  //  By userRoleClick=By.xpath("(//div[contains(@class,'oxd-select-text--active')])[1]");
    By userRoleClick=By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='User Role']]//div[contains(@class, 'oxd-select-text-input')]");
    By userRoleSelect=By.cssSelector(".oxd-select-wrapper .oxd-select-option");
    By employeeNameClick=By.xpath("//input[@placeholder='Type for hints...']");
    By employeeNameSelect=By.cssSelector(".oxd-autocomplete-option");
   // By statusClick=By.xpath("(//div[contains(@class,'oxd-select-text--active')])[2]");
    By statusClick=By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[text()='Status']]//div[contains(@class, 'oxd-select-text-input')]");
    By statusSelect=By.cssSelector(".oxd-select-wrapper .oxd-select-option:nth-of-type(2)");
    By searchButton=By.xpath("//button[text()=' Search ']");
    By resetButton=By.xpath("//button[text()=' Reset ']");
    //By empNameAfterSearch=By.xpath("//div[contains(@class,'card-header-slot-content')]//div[@class='oxd-table-card-cell']//div[@class='data']");
    By deleteButton=By.xpath("//i[contains(@class,'bi-trash')]");
    By confirmDeleteButton=By.xpath("//button[text()=' Yes, Delete ']");

    public AdminPage(WebDriver driver)
    {
        super(driver);
    }
    public String getNumberOfRecords()
    {
      String numberOfRecordsMsg= locateElement(numberOfRecordsText).getText();
      String numberOfRecords=numberOfRecordsMsg.split("\\(")[1].split("\\)")[0];
      return numberOfRecords;
    }
    public void addButtonClick()
    {
        explicitWaitForClickableItems(addButton);
        webElementClick(addButton);
    }
    public void userNameInputBoxClick()
    {
        explicitWaitForVisibility(userName);
        explicitWaitForClickableItems(userName);
        webElementClick(userName);
    }
    public void userRoleInputBoxClick()
    {
        explicitWaitForClickableItems(userRoleClick);
        webElementClick(userRoleClick);
    }
    public void employeeNameInputBoxClick()
    {
        explicitWaitForClickableItems(employeeNameClick);
        webElementClick(employeeNameClick);
    }
    public void statusInputBoxClick()
    {
        explicitWaitForClickableItems(statusClick);
        webElementClick(statusClick);
    }
    public void searchButtonClick()
    {
        explicitWaitForClickableItems(searchButton);
        webElementClick(searchButton);
    }
    public void deleteButtonClick()
    {
        explicitWaitForClickableItems(deleteButton);
        webElementClick(deleteButton);
    }
    public void confirmDeleteClick()
    {
        explicitWaitForClickableItems(confirmDeleteButton);
        webElementClick(confirmDeleteButton);
    }
    public void resetButtonClick()
    {
        explicitWaitForClickableItems(resetButton);
        webElementClick(resetButton);
    }

    public void enterUserRole(String role)
    {
        List<WebElement> elementList = explicitwaitfordropdown(userRoleSelect);
        for (WebElement option : elementList) {
            if (option.getText().equals(role)) {
                option.click();
                break;
            }
        }
    }
    public void enterEmployeeName(String employeeName) throws InterruptedException {

        webElementSendKeys(employeeNameClick,employeeName);
        Thread.sleep(2000);

        List<WebElement> elementList = explicitwaitfordropdown(employeeNameSelect);
        for (WebElement option : elementList) {
            if (option.getText().equals(employeeName)) {
                option.click();
                break;
            }
        }
    }
    public void enterStatus(String status)
    {
        List<WebElement> elementList = explicitwaitfordropdown(statusSelect);
        for (WebElement option : elementList) {
            if (option.getText().equals(status)) {
                option.click();
                break;
            }
        }
    }
    public void enterUserName(String uName)
    {
        webElementSendKeys(userName,uName);
        explicitWaitForTextBoxesValues(userName,uName);
    }

}
