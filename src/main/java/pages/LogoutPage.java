package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {
    WebDriver driver;
    WebDriverWait wait;

    final By LOGOUT = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a");

    public LogoutPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public String Logout(){

        wait.until(ExpectedConditions.elementToBeClickable((LOGOUT))).click();

        String result = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();
        return result;
    }
}