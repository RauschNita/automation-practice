import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.TermsAndConsPage;

import java.io.*;
import java.util.List;

public class TermsAndConditionsTest extends Utils{
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        this.driver = getDriver();
        getWebDriverWait();
    }

    @Test
    public void termsAndConditions() throws IOException {
        TermsAndConsPage tandconPage = new TermsAndConsPage(driver, getWebDriverWait());
        tandconPage.navigate();

        FileWriter writer = new FileWriter("termsandconditions.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        List<String> texts = tandconPage.getTandCList();
        for (String text : texts) {
            bufferedWriter.append(text);
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

}
