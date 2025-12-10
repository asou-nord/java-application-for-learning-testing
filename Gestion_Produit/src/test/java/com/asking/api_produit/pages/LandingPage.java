package com.asking.api_produit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    // LOCATORS:
    private WebDriver driver;
    private By connectButton = By.xpath("//button[text()='Se connecter']"); // lqa ay bytton li fiha text Se connecter!

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
