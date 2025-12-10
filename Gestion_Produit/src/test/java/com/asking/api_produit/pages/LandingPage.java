package com.asking.api_produit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    // LOCATORS:
    private WebDriver driver;
    private By connectButton = By.linkText("Se connecter");

    // CONSTRUCTOR:
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    // ACTIONS:

    // Click the login button in the landing page:
    public void clickLogin(){
        driver.findElement(connectButton).click();
    }
}
