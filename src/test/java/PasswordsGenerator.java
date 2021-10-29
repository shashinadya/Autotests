import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordsGenerator {

    @Test
    void passwordIsNotNull() {

        System.setProperty("webdriver.chrome.driver", "D:\\projects\\Autotests\\libs\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://passwordsgenerator.net/ru/");

        driver.findElement(By.xpath("//div[@class='button GenerateBtn']")).click();

        String generatePassword = driver.findElement(By.id("final_pass")).getText();

        assertNotNull(generatePassword);

    }
}
