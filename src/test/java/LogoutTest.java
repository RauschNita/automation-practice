import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;


public class LogoutTest extends LoginTest {
   @Test
    public void logout() {
       LoginPage loginPage = new LoginPage(getDriver(), getWebDriverWait());
       loginPage.Login("autiteszti1@gmail.com", "Tester");

       String expected = "Sign in";
       Assertions.assertEquals(expected, loginPage.Logout() );
    }
}
