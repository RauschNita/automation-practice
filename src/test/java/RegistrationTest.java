import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.EmailGenerator;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegistrationTest extends Utils {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        this.driver = getDriver();
        getWebDriverWait();
    }

    @Test
    public void registration() {
        RegistrationPage registrationPage = new RegistrationPage(getDriver(), getWebDriverWait());

        String expected = "Welcome to your account. Here you can manage all of your personal information and orders.";
        Assertions.assertEquals(expected, registrationPage.fillOutRegistrationForm("Auti", "Teszti", "Tester", "Hollywood boulevard", "Austin", "10002", "+0111888555"));

    }

    @Test
    public void registrationWithInvalidEmail() {
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
    public void registrationWithAlreadyCreatedEmail() {
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
    public void registrationWithEmptyField() {
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

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
