package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureArea extends Page {
    private final String titleText =driver.findElement(By.id("flash")).getText();

    public SecureArea(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        return titleText;
    }
}
