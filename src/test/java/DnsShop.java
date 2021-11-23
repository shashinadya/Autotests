import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;

public class DnsShop {
    @Test
    void ActionsWithSectionsOfDnsShop() {
        System.setProperty("webdriver.gecko.driver", "libs\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        driver.get("https://www.dns-shop.ru/");

        //Шаг 1. Навести на "Компьютеры"
        Actions actions = new Actions(driver);
        WebElement computers = driver.findElement(By.xpath("//a[text()='Компьютеры']"));
        actions.moveToElement(wait.until(ExpectedConditions.visibilityOf(computers))).perform();

        //Шаг 2. Выбрать "Материнские платы" в разделе "Комплектующие для ПК"
        WebElement motherBoards = driver.findElement(By.xpath("//a[text()='Материнские платы']"));
        motherBoards.click();

        //Шаг 3. Посчитать количество записей на странице
        String card = "//div[@class='catalog-product ui-button-widget']";
        List<WebElement> cardList = driver.findElements(By.xpath(card));
        int size1 = cardList.size();
        System.out.println(size1);

        //Шаг 4. Нажать на кнопку "Показать еще"
        WebElement showMoreBtn = driver.findElement(By.cssSelector(".pagination-widget__show-more-btn"));
        wait.until(ExpectedConditions.visibilityOf(showMoreBtn));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("return document.body.scrollHeight");
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        actions.moveToElement(showMoreBtn).pause(20000).moveToElement(showMoreBtn).click(showMoreBtn).perform();

        //Шаг 5. Проверить, что количество записей увеличилось в 2 раза
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(card), size1));
        List<WebElement> cardListAfterShowMore = driver.findElements(By.xpath(card));
        int size2 = cardListAfterShowMore.size();
        System.out.println(cardListAfterShowMore.size());
        assertEquals(size1 * 2, size2);

        //Шаг 6. Сгенерировать случайное число
        int randomNumber = (int) (Math.random() * 20);
        System.out.println(randomNumber);

        //Шаг 7. Нажать на кнопку "Купить" количество раз равное случайному числу из шага 6
        //( примечание: кнопку "Купить" нужно получить как дочерний элемент от записи с товаром)
        for (int i = 0; i < randomNumber; i++) {
            cardList.get(i).findElement(By.xpath("//button[text()='Купить']")).click();
            actions.pause(5000);
        }

        //Шаг 8. Нажать на "Корзина"
        driver.findElement(By.cssSelector(".cart-link__lbl")).click();

        //Шаг 9. Сравнить число записей со случайным числом
        String cartItemProduct = "//div[@class='cart-items__product']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cartItemProduct)));
        int size3 = driver.findElements(By.xpath(cartItemProduct)).size();
        System.out.println(size3);
        assertEquals(size3, randomNumber);
        driver.quit();
    }
}
