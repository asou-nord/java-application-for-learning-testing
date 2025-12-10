package com.asking.api_produit.tests;

import com.asking.api_produit.base.BaseTest;
import com.asking.api_produit.pages.LandingPage;
import com.asking.api_produit.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ListProductsTest extends BaseTest {

    @Test
    public void listProductsTest(){
        driver.get("http://localhost:" + port + "/");

        // first starting off from the landing page:
        new LandingPage(driver).clickLogin();

        // that leads us toward the login page:
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail("ali@gmail.com");
        loginPage.setPassword("123456");
        loginPage.clickLoginButton();

        // check if we have the products listed:
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertNotNull(currentUrl);
        Assertions.assertTrue(currentUrl.contains("listeSansCon"),
                "We did not get directed to listing page" + currentUrl);

    }
}
