import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.EmailGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PracticeWebshopTest {
    WebDriver driver;

    private WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, 10);
    }

    @BeforeEach
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @Test
    public void Registration() {
        final By LOGIN = By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a");
        final By EMAIL_FIELD = By.xpath("//*[@id=\"email_create\"]");

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((LOGIN))).click();

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((EMAIL_FIELD))).click();
        driver.findElement(EMAIL_FIELD).sendKeys(EmailGenerator.getSaltString() + "@gmail.com");
        driver.findElement(EMAIL_FIELD).sendKeys(Keys.ENTER);

        final By FIRST_NAME = By.xpath("//*[@id=\"customer_firstname\"]");
        final By LAST_NAME = By.xpath("//*[@id=\"customer_lastname\"]");
        final By PASSWORD = By.xpath("//*[@id=\"passwd\"]");
        final By ADDRESS = By.id("address1");
        final By CITY = By.id("city");
        final By STATE = By.id("uniform-id_state");
        final By SELECTED_STATE = By.xpath("//*[@id=\"id_state\"]/option[46]");
        final By POSTCODE = By.id("postcode");
        final By MOBILE_PHONE = By.id("phone_mobile");

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((FIRST_NAME))).click();
        driver.findElement(FIRST_NAME).sendKeys("Auti");

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((LAST_NAME))).click();
        driver.findElement(LAST_NAME).sendKeys("Teszti");

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((PASSWORD))).click();
        driver.findElement(PASSWORD).sendKeys("Tester");

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((ADDRESS))).click();
        driver.findElement(ADDRESS).sendKeys("Hollywood boulevard");

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((CITY))).click();
        driver.findElement(CITY).sendKeys("Austin");

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((STATE))).click();
        driver.findElement(SELECTED_STATE).click();

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((POSTCODE))).click();
        driver.findElement(POSTCODE).sendKeys("10002");

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((MOBILE_PHONE))).click();
        driver.findElement(MOBILE_PHONE).sendKeys("+0111888555");
        driver.findElement(MOBILE_PHONE).sendKeys(Keys.ENTER);

        String result = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();
        String expected = "Welcome to your account. Here you can manage all of your personal information and orders.";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void RegistrationWithInvalidEmail() {
        final By LOGIN = By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a");
        final By EMAIL_FIELD = By.xpath("//*[@id=\"email_create\"]");

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((LOGIN))).click();

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((EMAIL_FIELD))).click();
        driver.findElement(EMAIL_FIELD).sendKeys("0");
        driver.findElement(EMAIL_FIELD).sendKeys(Keys.ENTER);

        String result = driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li")).getText();
        String expected = "Invalid email address.";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void RegistrationWithAlreadyCreatedEmail() {
        final By LOGIN = By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a");
        final By NEW_EMAIL = By.xpath("//*[@id=\"email_create\"]");

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((LOGIN))).click();

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((NEW_EMAIL))).click();
        driver.findElement(NEW_EMAIL).sendKeys("autiteszti@gmail.com");

        driver.findElement(NEW_EMAIL).sendKeys(Keys.ENTER);

        String result = driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li")).getText();
        String expected = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void RegistrationWithEmptyField() {
        final By LOGIN = By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a");
        final By EMAIL_FIELD = By.xpath("//*[@id=\"email_create\"]");

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((LOGIN))).click();

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((EMAIL_FIELD))).click();
        driver.findElement(EMAIL_FIELD).sendKeys("");
        driver.findElement(EMAIL_FIELD).sendKeys(Keys.ENTER);

        String result = driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li")).getText();
        String expected = "Invalid email address.";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void Login() {
        final By LOGIN = By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a");
        final By EMAIL_FIELD = By.xpath("//*[@id=\"email\"]");
        final By PASSWORD = By.xpath("//*[@id=\"passwd\"]");

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((LOGIN))).click();

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((EMAIL_FIELD))).click();
        driver.findElement(EMAIL_FIELD).sendKeys("autiteszti1@gmail.com");

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((PASSWORD))).click();
        driver.findElement(PASSWORD).sendKeys("Tester");
        driver.findElement(EMAIL_FIELD).sendKeys(Keys.ENTER);

        String result = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();
        String expected = "Welcome to your account. Here you can manage all of your personal information and orders.";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void LoginWithNotRegisteredEmail() {
        final By LOGIN = By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a");
        final By EMAIL_FIELD = By.xpath("//*[@id=\"email\"]");
        final By PASSWORD = By.xpath("//*[@id=\"passwd\"]");

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((LOGIN))).click();

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((EMAIL_FIELD))).click();
        driver.findElement(EMAIL_FIELD).sendKeys("autiteszti4@gmail.com");

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((PASSWORD))).click();
        driver.findElement(PASSWORD).sendKeys("Tester");
        driver.findElement(EMAIL_FIELD).sendKeys(Keys.ENTER);

        String result = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
        String expected = "Authentication failed.";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void LoginWithInvalidEmail() {
        final By LOGIN = By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a");
        final By EMAIL_FIELD = By.xpath("//*[@id=\"email\"]");
        final By PASSWORD = By.xpath("//*[@id=\"passwd\"]");

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((LOGIN))).click();

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((EMAIL_FIELD))).click();
        driver.findElement(EMAIL_FIELD).sendKeys("-");

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((PASSWORD))).click();
        driver.findElement(PASSWORD).sendKeys("Tester");
        driver.findElement(EMAIL_FIELD).sendKeys(Keys.ENTER);

        String result = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
        String expected = "Invalid email address.";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void LoginWithEmptyEmail() {
        final By LOGIN = By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a");
        final By EMAIL_FIELD = By.xpath("//*[@id=\"email\"]");
        final By PASSWORD = By.xpath("//*[@id=\"passwd\"]");

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((LOGIN))).click();

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((EMAIL_FIELD))).click();
        driver.findElement(EMAIL_FIELD).sendKeys("");

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((PASSWORD))).click();
        driver.findElement(PASSWORD).sendKeys("Tester");
        driver.findElement(EMAIL_FIELD).sendKeys(Keys.ENTER);

        String result = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
        String expected = "An email address required.";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void TermsAndConditions() {
        final By TERMS_CONS = By.xpath("//*[@id=\"block_various_links_footer\"]/ul/li[6]/a");

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((TERMS_CONS))).click();

        String result = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/h1")).getText();
        String expected = "TERMS AND CONDITIONS OF USE";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void Logout() {
        Login();
        final By LOGOUT = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a");

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((LOGOUT))).click();

        String result = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();
        String expected = "Sign in";
        Assertions.assertEquals(expected, result);
    }
}
