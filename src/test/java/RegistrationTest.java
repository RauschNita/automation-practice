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
    }
    @Test
    public void registration() {
        LoginPage loginPage = new LoginPage(driver, getWebDriverWait());
        loginPage.clickSignIn();

        loginPage.fillOutNewEmailField(EmailGenerator.getSaltString() + "@gmail.com");
        loginPage.createAccount();

        RegistrationPage registrationPage = new RegistrationPage(driver, getWebDriverWait());
        registrationPage.setFirstName("Auti");
        registrationPage.setLastName("Teszti");
        registrationPage.setPassword("Tester");
        registrationPage.setAddress("Hollywood boulevard 187.");
        registrationPage.setCity("Austin");
        registrationPage.setState();
        registrationPage.setPostcode("10002");
        registrationPage.setPhone("+0111888555");
        registrationPage.clickRegister();

        String expected = "Welcome to your account. Here you can manage all of your personal information and orders.";
        Assertions.assertEquals(expected, registrationPage.getMessage());
    }

    @Test
    public void registrationWithInvalidEmail() {
        LoginPage loginPage = new LoginPage(driver, getWebDriverWait());
        loginPage.clickSignIn();

        loginPage.fillOutEmailField("0");
        loginPage.createAccount();

        String expected = "Invalid email address.";
        Assertions.assertEquals(expected, loginPage.getInvalidSinginMessage());
    }

    @Test
    public void registrationWithAlreadyCreatedEmail() {
        LoginPage loginPage = new LoginPage(driver, getWebDriverWait());
        loginPage.clickSignIn();

        loginPage.fillOutEmailField("autiteszti@gmail.com");
        loginPage.createAccount();

        String expected = "Invalid email address.";
        Assertions.assertEquals(expected, loginPage.getInvalidSinginMessage());
    }

    @Test
    public void registrationWithEmptyField() {
        LoginPage loginPage = new LoginPage(driver, getWebDriverWait());
        loginPage.clickSignIn();

        loginPage.createAccount();

        String expected = "Invalid email address.";
        Assertions.assertEquals(expected, loginPage.getInvalidSinginMessage());
    }

}
