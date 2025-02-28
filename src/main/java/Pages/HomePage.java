package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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


}
