import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordsGenerator {

    @Test
    void passwordIsNotNull() {

        System.setProperty("webdriver.chrome.driver", "D:\\projects\\Autotests\\libs\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://passwordsgenerator.net/ru/");

        WebElement generateBtn = driver.findElement(By.xpath("//div[@class='button GenerateBtn']"));

        generateBtn.click();

        WebElement finalPass = driver.findElement(By.id("final_pass"));

        String generatedFirstPassword = finalPass.getAttribute("value");

        assertNotEquals("", generatedFirstPassword);

        generateBtn.click();

        String generatedSecondPassword = finalPass.getAttribute("value");

        assertNotEquals(generatedFirstPassword, generatedSecondPassword);

        driver.findElement(By.id("Symbols")).click();

        WebElement selectLength = driver.findElement(By.id("pgLength"));
        Select select = new Select(selectLength);
        select.selectByVisibleText("8");

        generateBtn.click();

        String generatedThirdPassword = finalPass.getAttribute("value");

        //System.out.println("generatedThirdPassword: " + generatedThirdPassword);

        assertEquals(8, generatedThirdPassword.length());

        driver.quit();
    }
}
