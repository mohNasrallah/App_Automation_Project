package com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static com.testCases.T013_Hooks.driver;

public class P06_currencyChangePage {

    // Defines currency change list element located in header.
    public WebElement currencyChangeList() {
        By currencyChangeList = By.cssSelector("select[id=\"customerCurrency\"]");
        return driver.findElement(currencyChangeList);
    }

    // Defines euro currency located in currency change list in header.
    public WebElement euroCurrency() {
        By euroCurrency = By.cssSelector("option[value=\"https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2Fsearch%3Fq%3Ddell\"]");
        return driver.findElement(euroCurrency);
    }

    // Defines dell Idea Centre 600 price change.
    public WebElement dellIdeaCentre600Price() {
        By dellIdeaCentre600Price = By.cssSelector("div:nth-child(1) > div > div.details > div.add-info > div.prices > span");
        return driver.findElement(dellIdeaCentre600Price);
    }

    public WebElement lenovoIdeaCentre600USDCurrencyChange() {
        By lenovoIdeaCentre600USDCurrencyChange = By.cssSelector("option[value=\"https://demo.nopcommerce.com/changecurrency/1?returnUrl=%2Fsearch%3Fq%3Ddell\"]");
        return driver.findElement(lenovoIdeaCentre600USDCurrencyChange);

    }
}
