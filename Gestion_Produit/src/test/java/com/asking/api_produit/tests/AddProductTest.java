package com.asking.api_produit.tests;

import com.asking.api_produit.base.BaseTest;
import com.asking.api_produit.pages.AddProductPage;
import com.asking.api_produit.pages.DashboardPage;
import com.asking.api_produit.pages.LandingPage;
import com.asking.api_produit.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddProductTest extends BaseTest {

    @Test
    public void addProductTest() {
        driver.get("http://localhost:" + port + "/");

        new LandingPage(driver).clickLogin();

        new LoginPage(driver).loginAs("ali@gmail.com", "123456");

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickMenuButton();
        dashboardPage.clickAddProduct();

        AddProductPage addProductPage = new AddProductPage(driver);

        // Creating a name for our product that will be different (avoid false positive):
        String uniqueName = "Product_" + System.currentTimeMillis();

        // add the product details:
        addProductPage
                .setProductName(uniqueName)
                .setProductPrice(100)
                .setProductPriceCurrency(0)
                .setProductTax(10)
                .setProductExpirationDate("10/10/2026")
                .setSupplierName("supplier1");

        // let's sleep a moment to see if the data are correctly inserted:
        takeABreak();

        // add the product:
        addProductPage.clickAddButton();

        // this will direct us toward the page of products:
        DashboardPage dashboardPage1 = new DashboardPage(driver);

        // check if the product was added successfully:
        String currentUrl = driver.getCurrentUrl();
        String urlContent = driver.getPageSource();

        Assertions.assertNotNull(currentUrl);
        Assertions.assertNotNull(urlContent);

        boolean isProductListPage = currentUrl.equals("http://localhost:" + port + "/creation/");
        boolean isProductAdded = urlContent.contains("Le produit a bien été créé!!!");

        Assertions.assertTrue(isProductListPage,
                "We did not get directed toward the listing of products " + currentUrl);
        Assertions.assertTrue(isProductAdded,
                "The product was not added");
    }
}
