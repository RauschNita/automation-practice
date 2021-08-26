import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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

        String expected = "Welcome to your account. Here you can manage all of your personal information and orders.";
        Assertions.assertEquals(expected, loginPage.Login("autiteszti1@gmail.com", "Tester"));
    }

    @Test
    public void loginWithNotRegisteredEmail() {
        LoginPage loginPage = new LoginPage(getDriver(), getWebDriverWait());

        String expected = "Authentication failed.";
        Assertions.assertEquals(expected, loginPage.loginWithNotRegisteredEmail("autiteszti4@gmail.com", "Tester"));
    }

    @Test
    public void loginWithInvalidEmail() {
        LoginPage loginPage = new LoginPage(getDriver(), getWebDriverWait());

        String expected = "Invalid email address.";
        Assertions.assertEquals(expected, loginPage.loginWithInvalidEmail("-"));
    }

    @Test
    public void loginWithEmptyEmail() {
        LoginPage loginPage = new LoginPage(getDriver(), getWebDriverWait());

        String expected = "An email address required.";
        Assertions.assertEquals(expected, loginPage.loginWithEmptyEmail(""));
    }
/*
    @AfterEach
    public void tearDown() {
        driver.close();
    }*/
}
