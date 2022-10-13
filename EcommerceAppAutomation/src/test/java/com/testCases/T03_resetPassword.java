package com.testCases;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pages.P03_loginPage;
import com.pages.P02_registerPage;
import com.pages.P04_resetPasswordPage;
import org.testng.Assert;

import java.time.Duration;

public class T03_resetPassword {
    // Defining nopCommerce pages.
    P02_registerPage register = new P02_registerPage();
    P03_loginPage login = new P03_loginPage();
    P04_resetPasswordPage resetPassword = new P04_resetPasswordPage();

    @And("user navigates to forget password page.")
    public void user_navigates_to_forget_password_page() {
        T013_Hooks.driver.navigate().to(resetPassword.resetPasswordURL());
    }

    @When("user enters a valid email address.")
    public void user_enters_a_valid_email_address() {
        login.EmailField().sendKeys(register.registerEmail());
    }

    @And("user press on recover button.")
    public void user_press_on_recover_button() {
        resetPassword.recoverPasswordButton().click();
    }

    @Then("user could reset password successfully.")
    public void user_could_reset_password_successfully() {
        T013_Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        String actualResult = resetPassword.resetPasswordSuccessTxt().getText();
        String expectedResult = "Email with instructions has been sent to you.";
        Assert.assertTrue(actualResult.contains(expectedResult));
        System.out.println("\n--- TS #5 | Reset Password Valid Comparison: ---");
        System.out.println("** Actual Result = " + actualResult);
        System.out.println("** Expected Result = " + expectedResult);

    }

    @When("user enters an invalid email address.")
    public void user_enters_an_invalid_email_address() {
        login.EmailField().sendKeys(login.invalidEmail());
    }

    @Then("user should not be able to reset password.")
    public void user_should_not_be_able_to_reset_password() {
        T013_Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        String actualResult = resetPassword.emailNotFoundBarNotif().getText();
        String expectedResult = "Email not found.";
        Assert.assertTrue(actualResult.contains(expectedResult));
        System.out.println("\n--- TS #6 | Reset Password Invalid Comparison: ---");
        System.out.println("** Actual Result = " + actualResult);
        System.out.println("** Expected Result = " + expectedResult);

    }
}
