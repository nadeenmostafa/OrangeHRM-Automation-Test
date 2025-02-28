package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class AdminPage extends BasePage {

    By numberOfRecordsText= By.xpath("//span[contains(normalize-space(.), 'Found')]");
    By addButton=By.xpath("//button[text()=' Add ']");
    By userName=By.cssSelector(".oxd-input-group input.oxd-input");
    By userRoleClick=By.xpath("//label[text()='User Role']/parent::*/following-sibling::div//div[text()='-- Select --']");
    By userRoleSelect=By.cssSelector(".oxd-select-wrapper .oxd-select-option");
    By employeeNameClick=By.xpath("//input[@placeholder='Type for hints...']");
    By employeeNameSelect=By.cssSelector(".oxd-autocomplete-option");
    By statusClick=By.xpath("//label[text()='Status']/parent::*/following-sibling::div//div[text()='-- Select --']");
    By statusSelect=By.cssSelector(".oxd-select-wrapper .oxd-select-option:nth-of-type(2)");
    By searchButton=By.xpath("//button[text()=' Search ']");
    By resetButton=By.xpath("//button[text()=' Reset ']");
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
        List<WebElement> elementList = explicitWaitForDropDown(userRoleSelect);
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
        List<WebElement> elementList = explicitWaitForDropDown(employeeNameSelect);
        for (WebElement option : elementList) {
            if (option.getText().equals(employeeName)) {
                option.click();
                break;
            }
        }
    }
    public void enterStatus(String status)
    {
        List<WebElement> elementList = explicitWaitForDropDown(statusSelect);
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

   public void checkNavigationToAdminPage(WebDriver driver,String message)
   {
       String currentURL=getCurrentURL(driver);
       Assert.assertEquals(currentURL,"https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers",message);

   }
   public void numberOfRecordsAssertion(int actualNumber, int expectedNumber, String message)
   {
       Assert.assertEquals(actualNumber,expectedNumber,message);

   }

}
