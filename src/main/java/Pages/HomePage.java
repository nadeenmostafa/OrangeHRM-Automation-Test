package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePage {

    By adminButton=By.xpath("//*[@href='/web/index.php/admin/viewAdminModule']");

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public void clickAdminButton()
    {
        explicitWaitForVisibility(adminButton);
        webElementClick(adminButton);
    }
    public void checkNavigationToHomePage(WebDriver driver,String message)
    {
        String currentURL=getCurrentURL(driver);
        Assert.assertEquals(currentURL,"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",message);

    }

}
