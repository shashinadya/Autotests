package dnsShopWithCucumberAndSelenide;

import cucumber.api.java.ru.И;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefsSteps {

    MainPage mainPage;
    WebDriver driver;
    Actions actions;
    WebDriverWait wait;
    int countOfCardsFirst;
    int countOfCardsSecond;
    int randomNumber;
    int countOfCardsInTheBasket;

    @И("настройка драйвера для браузера Firefox и инициализация драйвера")
    public void propertiesOfDriver() {
        System.setProperty("webdriver.gecko.driver", "libs\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        actions = new Actions(driver);
        mainPage = new dnsShopWithCucumberAndSelenide.MainPage(driver, actions, wait);
    }

    @И("открыть сайт магазина DNS")
    public void openDnsSite() {
        driver.get("https://www.dns-shop.ru/");
    }

    @И("навести курсор на пункт меню 'Компьютеры'")
    public void moveCursorToComputers() {
        mainPage.moveCursorToComputers();
    }

    @И("выбрать 'Материнские платы' в разделе 'Комплектующие для ПК'")
    public void clickToMotherBoards() {
        mainPage.clickToMotherBoards();
    }

    @И("посчитать количество записей на странице")
    public void calculateCountOfCardsOfMotherboards() {
        countOfCardsFirst = mainPage.calculateCountOfCardsOfMotherboards();
    }

    @И("нажать на кнопку 'Показать еще'")
    public void clickOnTheButtonShowMore() {
        mainPage.clickOnTheButtonShowMore();
    }

    @И("проверить, что количество записей увеличилось в 2 раза")
    public void countOfCardsIncreasedCheck() {
        countOfCardsSecond = mainPage.calculateCountOfCardsOfMotherboards();
        assertEquals(countOfCardsFirst * 2, countOfCardsSecond);
    }

    @И("cгенерировать случайное число")
    public int generateRandomNumber() {
        return randomNumber = (int) (Math.random() * 20);
    }

    @И("нажать на кнопку 'Купить' количество раз равное случайному сгенерированному числу")
    public void clickToTheButtonBuy() {
        mainPage.clickToTheButtonBuy(randomNumber);
    }

    @И("нажать на 'Корзина'")
    public void clickToTheBasket() {
        mainPage.clickToTheBasket();
    }

    @И("сравнить число записей со случайным сгенерированным числом")
    public void countOfCardsIsEqualRandomNumber() {
        countOfCardsInTheBasket = mainPage.calculateCountOfCardsInTheBasket();
        assertEquals(countOfCardsInTheBasket, randomNumber);
    }

    @И("закрытие окна браузера и прекращение работы драйвера")
    public void closeBrowserWindowAndFinishWorkWithDriver() {
        mainPage.closeBrowserWindowAndFinishWorkWithDriver();
    }
}