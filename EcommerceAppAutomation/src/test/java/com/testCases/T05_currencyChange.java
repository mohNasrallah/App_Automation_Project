package com.testCases;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import com.pages.P06_currencyChangePage;
import org.testng.Assert;

import java.time.Duration;


public class T05_currencyChange {
    P06_currencyChangePage cChange = new P06_currencyChangePage();

    @And("user press on currency list.")
    public void user_press_on_currency_list() {
        cChange.currencyChangeList();
    }

    @And("user chooses Euro currency.")
    public void user_chooses_Euro_currency() {
        T013_Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        cChange.euroCurrency().click();
    }

    @Then("item price changes to Euros.")
    public void item_price_changes_to_euros() throws InterruptedException {
        Thread.sleep(3000);
        String actualResult = cChange.dellIdeaCentre600Price().getText();
        String expectedResult = "€";
        Assert.assertTrue(actualResult.contains(expectedResult));
        System.out.println("\n--- TS #9 (Currency Change) | (Lenovo Idea Centre 600) Selecting EURO Currency Comparison: ---");
        System.out.println("** Actual Result = " + actualResult);
        System.out.println("** Expected Result = " + expectedResult);
    }

    @And("user chooses USD currency.")
    public void user_chooses_USD_currency() {
        T013_Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        cChange.lenovoIdeaCentre600USDCurrencyChange().click();
    }


    @Then("item price changes to USD.")
    public void item_price_changes_to_USD() throws InterruptedException {
        Thread.sleep(2000);
        String actualResult = cChange.dellIdeaCentre600Price().getText();
        String expectedResult = "$";
        Assert.assertTrue(actualResult.contains(expectedResult));
        System.out.println("\n--- TS #9 (Currency Change) | (Lenovo Idea Centre 600) Selecting USD Currency Comparison: ---");
        System.out.println("** Actual Result = " + actualResult);
        System.out.println("** Expected Result = " + expectedResult);
    }
}
