import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordsGenerator {

    @Test
    void passwordIsNotNull() {

        System.setProperty("webdriver.chrome.driver", "D:\\projects\\Autotests\\libs\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://passwordsgenerator.net/ru/");

        driver.findElement(By.xpath("//div[@class='button GenerateBtn']")).click();

        String generatedFirstPassword = driver.findElement(By.id("final_pass")).getAttribute("value");

        assertFalse(generatedFirstPassword == "");

        driver.findElement(By.xpath("//div[@class='button GenerateBtn']")).click();

        String generatedSecondPassword = driver.findElement(By.id("final_pass")).getAttribute("value");

        assertNotEquals(generatedFirstPassword, generatedSecondPassword);

        driver.findElement(By.id("Symbols")).click();

        WebElement selectLength = driver.findElement(By.id("pgLength"));
        Select select = new Select(selectLength);
        select.selectByVisibleText("8");

        driver.findElement(By.xpath("//div[@class='button GenerateBtn']")).click();

        String generatedThirdPassword = driver.findElement(By.id("final_pass")).getAttribute("value");

        //System.out.println("generatedThirdPassword: " + generatedThirdPassword);

        assertEquals(8, generatedThirdPassword.length());

    }
}
