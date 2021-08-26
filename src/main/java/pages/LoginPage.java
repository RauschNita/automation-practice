package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By SIGNIN = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");

    private final By EMAIL_FIELD = By.xpath("//*[@id=\"email\"]");
    private final By PASSWORD = By.xpath("//*[@id=\"passwd\"]");
    private final By NEW_EMAIL_FIELD = By.xpath("//*[@id=\"email_create\"]");

    private final By SUCCESS = By.xpath("//*[@id=\"center_column\"]/p");
    private final By FAILED = By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li");
    private final By INVALID = By.xpath("//*[@id=\"create_account_error\"]/ol");

    private final By LOGOUT = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a");

    private final By CREATE_ACCOUNT = By.xpath("//*[@id=\"SubmitCreate\"]");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickSignIn(){
    wait.until(ExpectedConditions.elementToBeClickable((SIGNIN))).click();
    }

    public void fillOutEmailField(String email){
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }
    public void fillOutPasswordField(String pword){
        driver.findElement(PASSWORD).sendKeys(pword);
        driver.findElement(PASSWORD).sendKeys(Keys.ENTER);
    }
    public String getSuccessSigninMessage(){
        String result = driver.findElement(SUCCESS).getText();
        return result;
    }
    public String getFailedSinginMessage(){
        String result = driver.findElement(FAILED).getText();
        return result;
    }
    public String getInvalidSinginMessage(){
        String result = driver.findElement(INVALID).getText();
        return result;
    }
    public void clickLogout(){
        wait.until(ExpectedConditions.elementToBeClickable((LOGOUT))).click();
    }
    public String getSigninMessage(){
        String result = driver.findElement(SIGNIN).getText();
        return result;
    }
    public void fillOutNewEmailField(String email){
        driver.findElement(NEW_EMAIL_FIELD).sendKeys(email);
    }

    public void createAccount(){
        driver.findElement(CREATE_ACCOUNT).click();
    }
}
