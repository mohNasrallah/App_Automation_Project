package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.testCases.T013_Hooks.driver;

public class P05_searchPage {

    // Defines dell Idea Centre 600 Laptop Element.
    public WebElement dellIdeaCentre600Ele() {
        By dellIdeaCentre600 = By.cssSelector("h2[class=\"product-title\"] > a[href=\"/dell-ideacentre-600-all-in-one-pc\"]");
        return driver.findElement(dellIdeaCentre600);
    }
}
