import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LoginTest extends Utils{
   /* WebDriver driver;

    @BeforeEach
    public void setUp() {
        this.driver = getDriver();
        getWebDriverWait();
    }*/

    @Test
    public void login() {
        LoginPage loginPage = new LoginPage(getDriver(), getWebDriverWait());
        loginPage.clickSignIn();

        loginPage.fillOutEmailField("autiteszti1@gmail.com");
        loginPage.fillOutPasswordField("Tester");

        String expected = "Welcome to your account. Here you can manage all of your personal information and orders.";
        Assertions.assertEquals(expected, loginPage.getSuccessSigninMessage());
    }

    @Test
    public void loginWithNotRegisteredEmail() {
        LoginPage loginPage = new LoginPage(getDriver(), getWebDriverWait());
        loginPage.clickSignIn();

        loginPage.fillOutEmailField("autiteszti4@gmail.com");
        loginPage.fillOutPasswordField("Tester");

        String expected = "Authentication failed.";
        Assertions.assertEquals(expected, loginPage.getFailedSinginMessage());
    }

    @Test
    public void loginWithInvalidEmail() {
        LoginPage loginPage = new LoginPage(getDriver(), getWebDriverWait());
        loginPage.clickSignIn();

        loginPage.fillOutEmailField("-");
        loginPage.fillOutPasswordField("Tester");

        String expected = "Invalid email address.";
        Assertions.assertEquals(expected, loginPage.getFailedSinginMessage());
    }

    @Test
    public void loginWithEmptyEmail() {
        LoginPage loginPage = new LoginPage(getDriver(), getWebDriverWait());
        loginPage.clickSignIn();

        loginPage.fillOutEmailField("");
        loginPage.fillOutPasswordField("Tester");

        String expected = "An email address required.";
        Assertions.assertEquals(expected, loginPage.getFailedSinginMessage());
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
