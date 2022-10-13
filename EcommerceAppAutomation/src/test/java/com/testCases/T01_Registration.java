package com.testCases;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import com.pages.P02_registerPage;

public class T01_Registration {
P02_registerPage registration = new P02_registerPage();

    @And("user navigates to registration page.")
        public void user_navigates_to_registration_page() throws InterruptedException {
            T013_Hooks.driver.navigate().to(registration.registerPageURL());
            Thread.sleep(3000);
        }


    @And("user press on male checkbox.")
    public void user_press_on_male_checkbox() {
        registration.maleCheckBox().click();
        }


    @And("user enters valid first name.")
    public void user_enters_valid_first_name() {

        registration.firstNameFld().sendKeys("mohamed");
        }


    @And("user enters valid last name.")
    public void user_enters_valid_last_name() {
        registration.lastNameFld().sendKeys("nasrallah");
    }


    @And("user select valid date of birth.")
    public void user_select_valid_date_of_birth() {
        // Selecting Birth Day & clicking on it.
        registration.birthDay().click();
        // Selecting 14 as the Birthday day.
        registration.day14().click();
        // Selecting Birth Month.
        registration.birthMonthScrlPn().click();
        // Selecting 1 as the Birthday Month.
        registration.month1().click();
        // Selecting Birth Year & clicking on it.
        registration.birthYear().click();
        // Selecting 1995 as the Birth Year.
        registration.year1995().click();
    }


    @And ("user enters valid email address.")
    public void user_enters_valid_email_address() {
        registration.emailAddressTxtFld().sendKeys(registration.registerEmail());
    }


    @And ("user enters valid password.")
    public void user_enters_valid_password() {
        registration.passwordTxtFld().sendKeys(registration.registerPassword());
    }

    @And ("user enters invalid password.")
    public void user_enters_invalid_password() {
        registration.passwordTxtFld().sendKeys("123");
    }

    @And ("user reenter valid password.")
    public void user_reenter_valid_password() {
        registration.confirmPassTxtFld().sendKeys("Ahmed@1");
    }

    @And ("user reenter invalid password.")
    public void user_reenter_invalid_password() {
        registration.confirmPassTxtFld().sendKeys("123");
    }

    @And ("user clicks on register button.")
    public void user_clicks_on_register_button() {
        registration.registerButton().click();
    }


    @Then("user register successfully.")
    public void user_register_successfully() {
        String actualResult = registration.registrationCompletedMsg().getText();
        String expectedResult = "Your registration completed";
        Assert.assertTrue(actualResult.contains(expectedResult));
        System.out.println("\n--- TS #1 (Registration) | Text Displayed After User Registration Comparison: ---");
        System.out.println("** Actual Result = " + actualResult);
        System.out.println("** Expected Result = " + expectedResult);
    }


    @Then ("user could not register successfully.")
    public void user_could_not_register_successfully() {
        String actualResult = registration.passwordErrorMsg().getText();
        String expectedResult = "Password must meet the following rules:\n" +
                "must have at least 6 characters";
        Assert.assertTrue(actualResult.contains(expectedResult));
        System.out.println("\n--- TS #2 | Invalid Password Comparison: ---");
        System.out.println("** Actual Text Displayed Result = " + actualResult);
        System.out.println("\n** Expected Text Displayed Result = " + expectedResult);
    }


    @And("user returned to register webpage.")
    public void user_returned_to_register_webpage() {
        String actualResult = T013_Hooks.driver.getCurrentUrl();
        String expectedResult = registration.registerPageResultURL();
        Assert.assertTrue(actualResult.contains(expectedResult));
        System.out.println("\n--- TS #1 (Registration) | Redirected Website After Registration Comparison: ---");
        System.out.println("** Actual Website Redirected to = " + actualResult);
        System.out.println("** Expected Website Redirected to = " + expectedResult);
    }




}
