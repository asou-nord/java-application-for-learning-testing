package com.asking.api_produit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class AddProductPage {
    private final WebDriver driver;

    // LOCATORS:
    private final By productName = By.name("nom");
    private final By productPrice = By.name("prix");
    private final By productPriceCurrency = By.tagName("select");
    private final By productTax = By.name("taxe");
    private final By productDatePickerButton = By.name("dateExpiration");
    private final By productSupplier = By.name("fournisseur");
    private final By productPicture = By.id("imageFile");
    private final By addProductButton = By.xpath("//button[text()='Ajouter']");

    // CONSTRUCTOR:
    public AddProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // ACTIONS:

    // Set Product name:
    public AddProductPage setProductName(String inputProductName){
        driver.findElement(productName).sendKeys(inputProductName);
        return this;
    }

    // Set Product Price:
    public AddProductPage setProductPrice(int inputProductPrice){
        driver.findElement(productPrice).sendKeys(String.valueOf(inputProductPrice)); // sendKeys katakhed ghi strings? so just cast it? I guess so.
        return this;
    }

    // Set the product price currency:
    public AddProductPage setProductPriceCurrency(int procductPriceCurrencyIndex){
        WebElement dropdownElement = driver.findElement(productPriceCurrency);

        Select currencyDropdown = new Select(dropdownElement);
        currencyDropdown.selectByIndex(procductPriceCurrencyIndex);
        return this;
    }

    // Set Tax on product:
    public AddProductPage setProductTax(int inputProductTax){
        driver.findElement(productTax).sendKeys(String.valueOf(inputProductTax));
        return this;
    }

    // Set the date:
    public AddProductPage setProductExpirationDate(String inputProductExpirationDate){
        // could we just treat it as a normal input? let's see:
        driver.findElement(productDatePickerButton).sendKeys(inputProductExpirationDate);

//      if not we would have to try the picker method:
//      WebElement datePicker = driver.findElement(productDatePickerButton);
//      datePicker.click();
        return this;
    }


    // Set the Supplier:
    public AddProductPage setSupplierName(String supplierName){
        driver.findElement(productSupplier).sendKeys(supplierName);
        return this;
    }

    // Set the product Picture:
    public AddProductPage setProductPicture(String inputProductPicturePath){
        driver.findElement(productPicture).sendKeys(inputProductPicturePath);
        return this;
    }

    // Press Add product:
    public AddProductPage clickAddButton(){
        driver.findElement(addProductButton).click();
        return this;
    }
}
