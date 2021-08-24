import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.*;
import java.util.List;

public class TermsAndConditionsTest extends Utils{
    WebDriver driver;

    private final By TERMS_CONS = By.xpath("//*[@id=\"block_various_links_footer\"]/ul/li[6]/a");
    private final By TERMS_AND_CONDITIONS_TEXT = By.cssSelector("#columns .row");

    @BeforeEach
    public void setUp() {
        this.driver = getDriver();
        getWebDriverWait();
    }

    @Test
    public void termsAndConditions() throws IOException {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable((TERMS_CONS))).click();

        FileWriter writer = new FileWriter("termsandconditions.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        List<WebElement> texts = driver.findElements(TERMS_AND_CONDITIONS_TEXT);
        for (WebElement text : texts) {
            bufferedWriter.append(text.getText());
        }
        bufferedWriter.close();

        int lines = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("termsandconditions.txt"));
            while (reader.readLine() != null) lines++;
            reader.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        Assertions.assertEquals(7, lines);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
