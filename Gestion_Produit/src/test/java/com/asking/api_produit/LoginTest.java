package com.asking.api_produit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.Duration;

// Start the real server on a random port
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginTest {

    @LocalServerPort
    private int port;

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // So I now want to hide the gui when running, because that won't help in the linxu context:
        // 1. Create Options
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        // 2. Add the "Headless" argument
        // This tells Chrome Firefox ( I changed it ): "Run without a UI"
//        firefoxOptions.addArguments("--headless");
        // Optional: Fixes common issues in Docker/Linux environments?????
        firefoxOptions.addArguments("--no-sandbox");
        firefoxOptions.addArguments("--disable-gpu");
        firefoxOptions.addArguments("--disable-extensions");

        // Selenium Manager automatically handles the driver setup
        driver = new FirefoxDriver(firefoxOptions);
        // Set a small timeout in case the page loads slowly
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testAdminCanLogin() {
        // 1. ARRANGE: Go to the login page
        // Assuming your login page is at the root "/" or "/login"
        driver.get("http://localhost:" + port + "/login");

        // 2. ACT: Find elements and type
        // Note: In your SecConfig, you set usernameParameter("email"),
        // so the HTML input likely has name="email"
        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement passwordInput = driver.findElement(By.name("password"));

        // Use a valid user from your database (Charbel/Charbel based on previous chats?)
        emailInput.sendKeys("ali@gmail.com"); // Replace with a VALID email from your DB
        passwordInput.sendKeys("123456");    // Replace with the VALID password

        // Find the submit button.
        // If it doesn't have an ID, we can find it by its tag or text.
        // Option A: If it's the only button
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        // 3. ASSERT: Did we get redirected?
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertNotNull(currentUrl);
        Assertions.assertTrue(currentUrl.contains("/listeSansCon"),
                "User should be redirected to product list after login. Current URL: " + currentUrl);
    }

    @Test
    public void testAdminCanLogout() {
        driver.get("http://localhost:" + port + "/login");

        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement passwordInput = driver.findElement(By.name("password"));

        emailInput.sendKeys("ali@gmail.com");
        passwordInput.sendKeys("123456");

        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        WebElement navbarButton = driver.findElement(By.className("navbar-toggler"));
        navbarButton.click();

        WebElement logoutLink = driver.findElement(By.linkText("Se déconnecter"));
        logoutLink.click();

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertNotNull(currentUrl);
        Assertions.assertTrue(currentUrl.contains("logout"),
                "Logout link did not direct us toward logout page!");

        WebElement logOutButton = driver.findElement(By.tagName("button"));
        logOutButton.click();

        currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        boolean isBackAtLogin = currentUrl.equals("http://localhost:" + port + "/");
        Assertions.assertTrue(isBackAtLogin,
                "We are not in the landing page!");
    }
}