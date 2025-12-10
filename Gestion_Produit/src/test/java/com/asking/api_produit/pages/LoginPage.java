package com.asking.api_produit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // LOCATORS:
    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.tagName("button");


    // CONSTRUCTOR:
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // ACTIONS:

    // Set Email:
    public void setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    // Set Password:
    public void setPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    // Click Login:
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    // HELPER METHOD: combine the two actions for setting email/password into one:
    public void loginAs(String email, String password){
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }
}
