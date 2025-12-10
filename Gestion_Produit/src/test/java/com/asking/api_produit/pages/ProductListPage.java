package com.asking.api_produit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListPage {
    private WebDriver driver;

    // LOCATORS:
    private By updateProductButton = By.xpath("//link[text()='Update Product']");


    // CONSTRUCTOR:
    public ProductListPage(WebDriver driver){
        this.driver = driver;
    }

    // ACTIONS:

    // click update button
    public void clickUpdateProductButton(){
        driver.findElement(updateProductButton).click();
    }
}
