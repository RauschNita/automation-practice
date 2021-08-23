package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    private final By LOGIN = By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a");
    final By EMAIL_FIELD = By.xpath("//*[@id=\"email\"]");
    final By PASSWORD = By.xpath("//*[@id=\"passwd\"]");


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String Login(String email, String pword){

        wait.until(ExpectedConditions.elementToBeClickable((LOGIN))).click();

        wait.until(ExpectedConditions.elementToBeClickable((EMAIL_FIELD))).click();
        driver.findElement(EMAIL_FIELD).sendKeys(email);

        wait.until(ExpectedConditions.elementToBeClickable((PASSWORD))).click();
        driver.findElement(PASSWORD).sendKeys(pword);
        driver.findElement(EMAIL_FIELD).sendKeys(Keys.ENTER);

        String result = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();

        return result;

    }
}
