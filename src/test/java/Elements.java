import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.interactions.Actions;
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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logo")));

        //Шаг 1. Нажать на лого в верхней части сайта с помощью JavascriptExecutor
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement logoLink = (WebElement) jsExecutor.executeScript("return document.querySelector('.logo')");
        logoLink.click();

        //Шаг 2. Вернуться на предыдущую вкладку
        driver.switchTo().window(firstWindowHandle);

        //Шаг 3. Убрать лого через JavascriptExecutor
        jsExecutor.executeScript("return document.querySelector('.logo').setAttribute('style', 'display:none')");

        //Шаг 4. Перевести ползунок внизу сайта слева направо
        Actions actions = new Actions(driver);
        WebElement draggerCursor = driver.findElement(By.className("dragger-cursor"));
        actions.dragAndDropBy(draggerCursor, 250, 0).perform();

        //Шаг 5. Взять координаты центра лампочки, зажать левую кнопку мыши и отвести сначала курсор немного влево, потом вправо

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gl-canvas")));
        WebElement gl_canvas = driver.findElement(By.id("gl-canvas"));
        actions.clickAndHold(gl_canvas).moveByOffset(-300, 0).moveByOffset(500, 0).build().perform();
        sleep(3000);

        //Шаг 6. Перевести ползунок внизу сайта слева направо
        actions.dragAndDropBy(draggerCursor, 250, 0).perform();

        //Шаг 7. Сделать клик левой кнопкой мыши на фотоаппарат
        actions.click(gl_canvas);
        sleep(3000);

        //Шаг 8. Перевести ползунок внизу сайта слева направо
        actions.dragAndDropBy(draggerCursor, 250, 0).perform();

        //Шаг 9. Зажать левую кнопку мыши на 7 сек
        actions.click().pause(7000).perform();
        sleep(3000);

        //Шаг 10. Перевести ползунок внизу сайта слева направо
        actions.dragAndDropBy(draggerCursor, 250, 0).perform();

        //Шаг 11. Зажать левую кнопку мыши и перенести курсор в любое место
        actions.clickAndHold().moveToElement(gl_canvas).perform();
        sleep(3000);

        //Шаг 12. Перевести ползунок внизу сайта слева направо
        actions.dragAndDropBy(draggerCursor, 250, 0).perform();

        //Шаг 13. Зажать левую кнопку мыши на 2 сек
        actions.clickAndHold().pause(2000).perform();
        sleep(3000);

        //Шаг 14. Перевести ползунок внизу сайта слева направо
        actions.dragAndDropBy(draggerCursor, 250, 0).perform();

        //Шаг 15. Закрыть сайт
        driver.quit();
    }
    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

