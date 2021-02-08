package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends Page {

    private static final String LOGIN_URL = BASE_URL+"/login";
    private static final By USER_NAME = By.id("username");
    private static final By PASSWORD = By.id("password");
    private static final By LOGIN_BUTTON = By.className("radius");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void insertCredentials(String userNameValue, String passwordValue) {
        driver.findElement(USER_NAME).sendKeys(userNameValue);
        driver.findElement(PASSWORD).sendKeys(passwordValue);
    }

    public void goToURl(){
        driver.navigate().to(LOGIN_URL);
    }

    public SecureArea validClickLogin(){ //when a successful scenario
        driver.findElement(LOGIN_BUTTON).click();
        return new SecureArea(driver);
    }
}
