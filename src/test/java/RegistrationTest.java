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
    /*WebDriver driver;

    @BeforeEach
    public void setUp() {
        this.driver = getDriver();
        getWebDriverWait();
    }*/
    @Test
    public void registration() {
        RegistrationPage registrationPage = new RegistrationPage(getDriver(), getWebDriverWait());

        String expected = "Welcome to your account. Here you can manage all of your personal information and orders.";
        Assertions.assertEquals(expected, registrationPage.fillOutRegistrationForm("Auti", "Teszti", "Tester", "Hollywood boulevard", "Austin", "10002", "+0111888555"));

    }

    @Test
    public void registrationWithInvalidEmail() {
        RegistrationPage registrationPage = new RegistrationPage(getDriver(), getWebDriverWait());

        String expected = "Invalid email address.";
        Assertions.assertEquals(expected, registrationPage.rWithInvalidEmail("0"));
    }

    @Test
    public void registrationWithAlreadyCreatedEmail() {
        RegistrationPage registrationPage = new RegistrationPage(getDriver(), getWebDriverWait());

        String expected = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
        Assertions.assertEquals(expected, registrationPage.rWithAlreadyCreatedEmail("autiteszti@gmail.com"));
    }

    @Test
    public void registrationWithEmptyField() {
        RegistrationPage registrationPage = new RegistrationPage(getDriver(), getWebDriverWait());

        String expected = "Invalid email address.";
        Assertions.assertEquals(expected, registrationPage.rWithEmptyField(""));
    }

}
