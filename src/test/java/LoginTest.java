import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginTest extends Utils{
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        this.driver = getDriver();
        getWebDriverWait();
    }

    @Test
    public void login() {
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
    public void loginWithNotRegisteredEmail() {
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
    public void loginWithInvalidEmail() {
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
    public void loginWithEmptyEmail() {
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

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
