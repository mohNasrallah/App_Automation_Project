package com.testCases;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pages.P01_homePage;
import com.pages.P03_loginPage;
import com.pages.P02_registerPage;
import org.testng.Assert;

import java.time.Duration;

import static com.testCases.T013_Hooks.driver;


public class T02_Login {
    // Defining pages containing elements methods.
    P02_registerPage registration = new P02_registerPage();
    P03_loginPage login = new P03_loginPage();
    P01_homePage home = new P01_homePage();


    @And("user navigates to login page.")
    public void user_navigates_to_login_page() throws InterruptedException {
        driver.navigate().to(login.loginPageURL());
        Thread.sleep(3000);
    }


    @When("user enters valid  email.")
    public void user_enters_valid_email() {
        login.EmailField().sendKeys(registration.registerEmail());

    }

    @When("user enters invalid email.")
    public void user_enters_invalid_email() {
        login.EmailField().sendKeys(login.invalidEmail());
    }


    @And("user enters valid password.")
    public void user_enters_valid_password() {
        login.passwordEmailTxtFld().sendKeys(registration.registerPassword());
    }

    @And("user enters invalid password.")
    public void user_enters_invalid_password() {
        login.passwordEmailTxtFld().sendKeys(login.invalidLoginPassword());
    }


    @And("user press on login button.")
    public void user_press_on_login_button() {
        login.loginButton().click();
    }


    @Then("user login successfully.")
    public void user_login_successfully() {
        String actualResult = login.loginSuccessTxtFld().getText();
        String expectedResult = "Log out";
        Assert.assertTrue(actualResult.contains(expectedResult));
        System.out.println("\n--- TC #3 (Login) | User logged in (logout button text displayed) Comparison: ---");
        System.out.println("** Actual Result = " + actualResult);
        System.out.println("** Expected Result = " + expectedResult);
    }


    @And("returned to home page.")
    public void returned_to_home_page() throws InterruptedException {
       Thread.sleep(2000);
       String actualResult = driver.getCurrentUrl();
       String expectedResult = home.homepageURL();
       System.out.println("\n--- TC #3 (Login) | Redirected to home page Comparison: ---");
       System.out.println("** Actual Result = " + actualResult);
       System.out.println("** Expected Result = " + expectedResult);

    }


    @Then("user could not login successfully.")
    public void user_could_not_login_successfully() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        String actualResult = login.loginUnSuccessTxtFld().getText();
        String expectedResult = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        Assert.assertTrue(actualResult.contains(expectedResult));
        System.out.println("\n--- TC #4 (Login) | User failed to login Comparison: ---");
        System.out.println("** Actual Result = " + actualResult);
        System.out.println("** Expected Result = " + expectedResult);

    }
}
