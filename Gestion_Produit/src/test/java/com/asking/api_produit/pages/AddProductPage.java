package com.asking.api_produit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class AddProductPage {
    private final WebDriver driver;

    // LOCATORS:
    private final By productName = By.name("name");
    private final By productPrice = By.name("prix");
    private final By productPriceCurrency = By.tagName("select");
    private final By productTax = By.name("taxe");
    private final By productDatePickerButton = By.name("dateExpiration");
    private final By productSupplier = By.name("fournisseur");
    private final By productPicture = By.id("imageFile");
    private final By addProductButton = By.xpath("//button[text='Ajouter']");

    // CONSTRUCTOR:
    public AddProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // ACTIONS:

    // Set Product name:
    public void setProductName(String inputProductName){
        driver.findElement(productName).sendKeys(inputProductName);
    }

    // Set Product Price:
    public void setProductPrice(int inputProductPrice){
        driver.findElement(productPrice).sendKeys(String.valueOf(inputProductPrice)); // sendKeys katakhed ghi strings? so just cast it? I guess so.
    }

    // Set the product price currency:
    public void setProductPriceCurrency(String procductPriceCurrency){
        WebElement dropdownElement = driver.findElement(productPriceCurrency);

        Select CurrencyDropdown = new Select(dropdownElement);
        CurrencyDropdown.selectByVisibleText(procductPriceCurrency);
    }

    // Set Tax on product:
    public void setProductTax(int inputProductTax){
        driver.findElement(productTax).sendKeys(String.valueOf(inputProductTax));
    }

    // Set the date:
    public void setProductExpirationDate(String inputProductExpirationDate){
        // could we just treat it as a normal input? let's see:
        driver.findElement(productDatePickerButton).sendKeys(inputProductExpirationDate);

//      if not we would have to try the picker method:
//      WebElement datePicker = driver.findElement(productDatePickerButton);
//      datePicker.click();
    }


    // Set the Supplier:
    public void setSupplierName(String supplierName){
        driver.findElement(productSupplier).sendKeys(supplierName);
    }

    // Set the product Picture:
    public void setProductPicture(String inputProductPicturePath){
        driver.findElement(productPicture).sendKeys(inputProductPicturePath);
    }

    // Press Add product:
    public void clickAddButton(){
        driver.findElement(addProductButton).click();
    }
}
