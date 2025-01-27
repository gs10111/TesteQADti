package com.Dti;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class Testes {

    private WebDriver driver;
    private static final String BASE_URL = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
    private static final String LOGIN_URL = "http://www.automationpractice.pl/index.php?controller=my-account";
    private static final String FORGOT_PASSWORD_URL = "http://www.automationpractice.pl/index.php?controller=password";
    private static final String VALID_EMAIL = "testedtiqa@gmail.com";
    private static final String VALID_PASSWORD = "vKFx797187:~";
    private static final String INVALID_EMAIL = "contaInvalida@gmail.com";
    private static final String INVALID_PASSWORD = "123456789inv";


    @BeforeEach
    public void setup() {

        System.setProperty("webdriver.msedgedriver", "drivers/msedgedriver.exe");

        driver = new ChromeDriver();

    }

    @AfterEach
    public void teardown() {

        if (driver != null) {

            driver.quit();

        }
    }

    @Test
    @DisplayName("Teste de sucesso de login da conta")
    public void testLoginAccount() {


        driver.get(BASE_URL);

        driver.findElement(By.id("email")).sendKeys(VALID_EMAIL);

        driver.findElement(By.id("passwd")).sendKeys(VALID_PASSWORD);

        driver.findElement(By.id("SubmitLogin")).click();

        assertTrue(driver.getCurrentUrl().contains(LOGIN_URL));


    }

    @Test
    @DisplayName("Teste com ambas credenciais invalidas")
    public void testLoginInvalidCredentials() {

        driver.get(BASE_URL);


        driver.findElement(By.id("email")).sendKeys(INVALID_EMAIL);

        driver.findElement(By.id("passwd")).sendKeys(INVALID_PASSWORD);


        driver.findElement(By.id("SubmitLogin")).click();


        String errorMessage = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();

        assertTrue(errorMessage.contains("There is 1 error\n" + "Authentication failed."));

    }

    @Test
    @DisplayName("teste de botão esquecimento de senha")
    public void testForgotPassword() {

        driver.get(BASE_URL);

        driver.findElement(By.linkText("Forgot your password?")).click();

        assertTrue(driver.getCurrentUrl().contains(FORGOT_PASSWORD_URL));



    }


}
