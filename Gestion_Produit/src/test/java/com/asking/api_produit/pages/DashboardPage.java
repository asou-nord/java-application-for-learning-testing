package com.asking.api_produit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;

    // LOCATORS:
    private By addProductLink = By.linkText("Créer un nouveau produit");
    private By menuButton = By.className("navbar-toggler");
    private By logoutLink = By.linkText("Se déconnecter");
    private By productSearchBar = By.name("recherche");
    private By productSearchButton = By.xpath("//button[@class='btn btn-success']");


    // CONSTRUCTOR:
    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    // ACTIONS:

    // Click Add Product link:
    public void clickAddProduct(){
        driver.findElement(addProductLink).click();
    }

    // Click menu button to show option:
    public void clickMenuButton(){
        driver.findElement(menuButton).click();
    }

    // Click logout link:
    public void clickLogoutLink(){
        driver.findElement(logoutLink).click();
    }

    // Update a product requires searching for it and then clicking find then in another page you find two buttons: delete + update.
    // Searching for a product:
    public void setProductNameToFind(String productNameToFind){
        driver.findElement(productSearchBar).sendKeys(productNameToFind);
    }

    // Click search after filling the search bar:
    public void clickSearchButton(){
        driver.findElement(productSearchButton).click();
    }
}
