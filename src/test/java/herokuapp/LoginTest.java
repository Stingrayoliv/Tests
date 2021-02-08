package herokuapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.SecureArea;



public class LoginTest {

    private ChromeDriver driver;
    LoginPage loginPage;
    SecureArea secureArea;

    @BeforeEach
    public void initPageObjects() {
        System.setProperty("webdriver.chrome.driver", "/Users/stingrey/external/chromedriver");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void rightCredentials_successfulMessage_validClickLogin() {
        loginPage.goToURl();
        loginPage.insertCredentials("tomsmith", "SuperSecretPassword!");
        Assertions.assertEquals("You logged into a secure area!\n" +
                "×", loginPage.validClickLogin().getTitleText());
    }

    @Test
    public void passwordIsNotCorrect_MessageIsNotSuccessful_validClickLogin() {
        loginPage.goToURl();
        loginPage.insertCredentials("tomsmith", "1234");
        Assertions.assertEquals("Your password is invalid!\n" +
                "×", loginPage.validClickLogin().getTitleText());
    }
}
