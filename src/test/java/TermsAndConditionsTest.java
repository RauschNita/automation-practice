import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TermsAndConditionsTest extends Utils{
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        this.driver = getDriver();
        getWebDriverWait();
    }

    @Test
    public void termsAndConditions() {
        final By TERMS_CONS = By.xpath("//*[@id=\"block_various_links_footer\"]/ul/li[6]/a");

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((TERMS_CONS))).click();

        String result = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/h1")).getText();
        String expected = "TERMS AND CONDITIONS OF USE";
        Assertions.assertEquals(expected, result);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
