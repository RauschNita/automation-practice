package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By LOGIN = By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a");
    private final By EMAIL_FIELD = By.xpath("//*[@id=\"email\"]");
    private final By PASSWORD = By.xpath("//*[@id=\"passwd\"]");

    private final By LOGOUT = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a");


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
    public String loginWithNotRegisteredEmail(String email, String pword){
        wait.until(ExpectedConditions.elementToBeClickable((LOGIN))).click();

        wait.until(ExpectedConditions.elementToBeClickable((EMAIL_FIELD))).click();
        driver.findElement(EMAIL_FIELD).sendKeys(email);

        wait.until(ExpectedConditions.elementToBeClickable((PASSWORD))).click();
        driver.findElement(PASSWORD).sendKeys(pword);
        driver.findElement(EMAIL_FIELD).sendKeys(Keys.ENTER);

        String result = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
        return result;
    }
    public String loginWithInvalidEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable((LOGIN))).click();

        wait.until(ExpectedConditions.elementToBeClickable((EMAIL_FIELD))).click();
        driver.findElement(EMAIL_FIELD).sendKeys(email);

        driver.findElement(EMAIL_FIELD).sendKeys(Keys.ENTER);

        String result = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();

        return result;
    }
    public String loginWithEmptyEmail(String email) {

        wait.until(ExpectedConditions.elementToBeClickable((LOGIN))).click();

        wait.until(ExpectedConditions.elementToBeClickable((EMAIL_FIELD))).click();
        driver.findElement(EMAIL_FIELD).sendKeys(email);

        driver.findElement(EMAIL_FIELD).sendKeys(Keys.ENTER);

        String result = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();

        return result;
    }


    public String Logout(){

        wait.until(ExpectedConditions.elementToBeClickable((LOGOUT))).click();

        String result = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();
        return result;
    }
}
