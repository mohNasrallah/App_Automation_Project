package com.testCases;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import com.pages.P01_homePage;
import com.pages.P05_searchPage;
import org.testng.Assert;

public class T04_search {
    P01_homePage home = new P01_homePage();
    P05_searchPage search = new P05_searchPage();

    @And("user search text field with key dell.")
    public void user_search_text_field_with_key_dell() {
        home.searchTxtFld().sendKeys("dell");
    }

    @Then("user clicks on the search button.")
    public void user_clicks_on_the_search_button() {
        home.searchButton().click();
    }


    @And("user redirected to a search result.")
    public void user_redirected_to_a_search_result() {
        String actualURL = T013_Hooks.driver.getCurrentUrl();
        String expectedURL = "https://demo.nopcommerce.com/search?q=dell";
        Assert.assertTrue(actualURL.contains(expectedURL));
        System.out.println("\n--- TS #7 (Search) | Keyword Searching URL Comparison: ---");
        System.out.println("** Actual URL = " + actualURL);
        System.out.println("** Expected URL = " + expectedURL);
        String actualDisplayedOption = search.dellIdeaCentre600Ele().getText();
        String expectedDisplayedOption = "dell";
        Assert.assertTrue(actualDisplayedOption.contains(expectedDisplayedOption));
        System.out.println("\n--- TS #7 (Search) | Displayed Option Comparison: ---");
        System.out.println("** Actual Displayed Option = " + actualDisplayedOption);
        System.out.println("** Expected Displayed Option = " + expectedDisplayedOption);
    }
}
