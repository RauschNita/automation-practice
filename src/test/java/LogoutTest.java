import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LogoutTest extends LoginTest {
   @Test
    public void logout() {
       LoginPage loginPage = new LoginPage(getDriver(), getWebDriverWait());
       loginPage.clickSignIn();

       loginPage.fillOutEmailField("autiteszti1@gmail.com");
       loginPage.fillOutPasswordField("Tester");
       loginPage.clickLogout();

       String expected = "Sign in";
       Assertions.assertEquals(expected, loginPage.getSigninMessage() );
    }
}
