import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.Select;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Elements {

    @Test
    void WorkWithElements() {
        System.setProperty("webdriver.chrome.driver", "libs\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://2017.makemepulse.com/");

        //Запомнить хендл первого окна
        String firstWindowHandle = driver.getWindowHandles().iterator().next();

        //Ожидание появления элемента logo
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Шаг 1. Нажать на лого в верхней части сайта с помощью JavascriptExecutor
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement logoLink = (WebElement) jsExecutor.executeScript("return document.querySelector('.logo')");
        logoLink.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Шаг 2. Вернуться на предыдущую вкладку
        driver.switchTo().window(firstWindowHandle);
    }
}
