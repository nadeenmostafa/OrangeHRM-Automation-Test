package steps;

import Pages.AddUserPage;
import Pages.AdminPage;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {
    LoginPage loginPage;
    HomePage homePage;
    AdminPage adminPage=new AdminPage(Hooks.getDriver());
    AddUserPage addUserPage=new AddUserPage(Hooks.getDriver());
    public static int firstNumberOfRecords;
    public static int secondNumberOfRecords;
    public static int thirdNumberOfRecords;
    public static String userNameValue;
    @Given("The user logins as admin")
    public void The_user_opens_the_website()
    {
        loginPage=new LoginPage(Hooks.getDriver());
    }
    @When("The user fills in valid username {string} and password {string}")
    public void The_user_fills_in_valid_username_and_password(String userName,String password)
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);

    }
    @When("Click login button")
    public void Click_login_button()
    {
        loginPage.clickLoginButton();
    }
    @Then("The user is navigated to home page")
    public void The_user_is_navigated_to_home_page()
    {
        homePage=new HomePage(Hooks.getDriver());
        Assert.assertEquals(Hooks.getDriver().getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index","first assertion");
    }
    @When("Clicks on admin button on the sidebar")
    public void Clicks_on_admin_button_on_the_sidebar()
    {
        homePage.clickAdminButton();
    }
    @Then("The user is navigated to admin page")
    public void The_user_is_navigated_to_admin_page()
    {
        Assert.assertEquals(Hooks.getDriver().getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers","second assertion");

    }
    @When("The user gets the number of current records")
    public void The_user_gets_the_number_of_current_records()
    {
        firstNumberOfRecords=Integer.parseInt(adminPage.getNumberOfRecords());
        System.out.println(firstNumberOfRecords);

    }
    @When("Clicks to add a new record")
    public void Click_to_add_a_new_record()
    {
        adminPage.addButtonClick();
    }
    @When("Enter the userRole {string} and employeeInitial {string} and status {string} and userName {string} and password {string} and confirmationPassword {string}")
    public void Enter_the_userRole_and_employeeInitial_and_status_and_userName_and_password_and_confirmationPassword(String userRole, String employeeInit, String status, String Nameuser,String password, String confirmPassword) throws InterruptedException {
        addUserPage.userRoleInputBoxClick();
        addUserPage.enterUserRole(userRole);
        addUserPage.employeeNameInputBoxClick();
        userNameValue= addUserPage.enterEmployeeName(employeeInit);
        System.out.println(userNameValue);
        addUserPage.statusInputBoxClick();
        addUserPage.enterStatus(status);
        addUserPage.userNameInputBoxClick();
        addUserPage.enterUserName(Nameuser);
        addUserPage.passwordInputBoxClick();
        addUserPage.enterPassword(password);
        addUserPage.confirmationPasswordInputBoxClick();
        addUserPage.enterConfirmationPassword(confirmPassword);

    }
    @Given("Clicks on save button")
    public void Clicks_on_save_button()
    {
        addUserPage.saveButtonClick();
    }
    @Given("Gets the number of records again")
    public void Gets_the_number_of_records_again()
    {
        secondNumberOfRecords=Integer.parseInt(adminPage.getNumberOfRecords());
        System.out.println(secondNumberOfRecords);
    }
    @Then("The number of records is increased by one")
    public void The_number_of_records_is_increased_by_one()
    {
        int difference=secondNumberOfRecords-firstNumberOfRecords;
        System.out.println(difference);
        Assert.assertEquals(difference,1,"Number of records increased by one");
    }
    @Then ("The user enters the userName {string} and userRole {string} and status {string} for search")
    public void The_user_enters_the_userName_and_userRole_and_status_for_search(String uName, String userRole, String status) throws InterruptedException {
        adminPage.userNameInputBoxClick();
        adminPage.enterUserName(uName);
        adminPage.userRoleInputBoxClick();
        adminPage.enterUserRole(userRole);
        adminPage.employeeNameInputBoxClick();
        adminPage.enterEmployeeName(userNameValue);
        adminPage.statusInputBoxClick();
        adminPage.enterStatus(status);

    }
    @When("Clicks on search button")
    public void Click_on_search_button()
    {
        adminPage.searchButtonClick();
    }
    @Then("The record of the user with specified data should appear")
    public void The_record_of_the_user_with_specified_data_should_appear()
    {
        int number=Integer.parseInt(adminPage.getNumberOfRecords());
        Assert.assertEquals(number,1,"A record added");
    }
    @Then("Click on delete button")
    public void Click_on_delete_button()
    {
        adminPage.deleteButtonClick();
    }
    @When("Confirm deletion")
    public void Confirm_deletion()
    {
        adminPage.confirmDeleteClick();
    }
    @Then("Click reset button")
    public void Click_reset_button()
    {
        adminPage.resetButtonClick();
    }
    @When("Get the number of records")
    public void Get_the_number_of_records()
    {
        thirdNumberOfRecords=Integer.parseInt(adminPage.getNumberOfRecords());
        System.out.println(thirdNumberOfRecords);
        int diff=thirdNumberOfRecords-secondNumberOfRecords;
        Assert.assertEquals(-1,diff,"Number of records decreased by one");

    }
}
