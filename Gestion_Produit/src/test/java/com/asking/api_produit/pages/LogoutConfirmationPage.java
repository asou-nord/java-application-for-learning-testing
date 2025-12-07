package com.asking.api_produit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutConfirmationPage {
    private WebDriver driver;

    // LOCATORS:
    private By logOutButton = By.tagName("button");


    // CONSTRUCTOR:
    public LogoutConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    // ACTIONS:

    // Click logout:
    public void clickLogoutButton(){
        driver.findElement(logOutButton).click();
    }
}
