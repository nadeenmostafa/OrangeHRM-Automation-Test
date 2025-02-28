package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    By userName= By.xpath("//input[@name='username']");
    By password= By.xpath("//*[@placeholder='Password']");
    By loginButton= By.xpath("//*[text()=' Login ']");
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }
    public void enterUsername(String uName)
    {
        explicitWaitForVisibility(userName);
        webElementSendKeys(userName,uName);
    }
    public void enterPassword(String passwd)
    {
        webElementSendKeys(password,passwd);
    }
    public void clickLoginButton()
    {
      webElementClick(loginButton);
    }
}
