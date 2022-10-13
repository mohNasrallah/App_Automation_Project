package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static com.testCases.T013_Hooks.driver;

public class P02_registerPage {

    public String registerPageURL() {
        return "https://demo.nopcommerce.com/register?returnUrl=%2F";
    }

    public String registerPageResultURL() {
        return "https://demo.nopcommerce.com/registerresult/1?returnUrl=/";
    }

    public WebElement maleCheckBox() {
        By maleCheckBox = By.id("gender-male");
        return driver.findElement(maleCheckBox);
    }

    public WebElement firstNameFld() {
        By firstNameFld = By.id("FirstName");
        return driver.findElement(firstNameFld);
    }

    public WebElement lastNameFld() {
        By lastNameFld = By.id("LastName");
        return driver.findElement(lastNameFld);
    }

    public WebElement birthDay() {
        By birthDay = By.name("DateOfBirthDay");
        return driver.findElement(birthDay);
    }

    public WebElement day14() {
        By day14 = By.cssSelector("select[name=\"DateOfBirthDay\"] > option[value=\"1\"]");
        return driver.findElement(day14);
    }

    public WebElement birthMonthScrlPn() {
        By birthMonthScrlPn = By.name("DateOfBirthMonth");
        return driver.findElement(birthMonthScrlPn);
    }

    public WebElement month1() {
        By month1 = By.cssSelector("select[name=\"DateOfBirthMonth\"] > option[value=\"1\"]");
        return driver.findElement(month1);
    }

    public WebElement birthYear() {
        By birthYear = By.name("DateOfBirthYear");
        return driver.findElement(birthYear);
    }

    public WebElement year1995() {
        By year1995 = By.cssSelector("option[value=\"1995\"]");
        return driver.findElement(year1995);
    }

    public WebElement emailAddressTxtFld() {
        By emailAddressTxtFld = By.cssSelector("div[class=\"inputs\"] > input[type=\"email\"]");
        return driver.findElement(emailAddressTxtFld);
    }

    public String registerEmail() {
        return "fortestingpurpose@udacity.com";
    }

    public WebElement passwordTxtFld() {
        By passwordTxtFld = By.id("Password");
        return driver.findElement(passwordTxtFld);
    }

    public String registerPassword() {
        return "Ahmed@1";
    }

    public WebElement confirmPassTxtFld() {
        By confirmPassTxtFld = By.id("ConfirmPassword");
        return driver.findElement(confirmPassTxtFld);
    }

    public WebElement registerButton() {
        By registerButton = By.cssSelector("button[name=\"register-button\"]");
        return driver.findElement(registerButton);
    }

    public WebElement registrationCompletedMsg() {
        By registrationCompletedMsg = By.cssSelector("div[class=\"result\"]");
        return driver.findElement(registrationCompletedMsg);
    }

    public WebElement passwordErrorMsg() {
        By passwordErrorMsg = By.id("Password-error");
        return driver.findElement(passwordErrorMsg);
    }


}
