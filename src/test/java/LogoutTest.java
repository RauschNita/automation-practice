import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LoginPage;
import pages.LogoutPage;

public class LogoutTest extends LoginTest {
   @Test
    public void logout() {
       this.login();

       LogoutPage logoutPage = new LogoutPage(getDriver(), getWebDriverWait());

       String expected = "Sign in";
       Assertions.assertEquals(expected, logoutPage.Logout());
    }
}
