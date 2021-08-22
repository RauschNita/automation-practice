import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogoutTest extends LoginTest {
   @Test
    public void logout() {
        this.login();

        final By LOGOUT = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a");

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((LOGOUT))).click();

        String result = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();
        String expected = "Sign in";
        Assertions.assertEquals(expected, result);
    }
}
