package firstTaskWithCucumber;

import cucumber.api.java.ru.И;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DefsSteps {

    MainPage mainPage;
    WebDriver driver;
    String generatedFirstPassword;
    String generatedSecondPassword;
    String generatedThirdPassword;

    @И("настройка драйвера для браузера Chrome и инициализация драйвера")
    public void propertiesOfDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\projects\\Autotests\\libs\\chromedriver.exe");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
    }

    @И("открыть сайт генератора паролей")
    public void openPasswordsGeneratorSite() {
        driver.get("https://passwordsgenerator.net/ru/");
    }

    @И("нажать на кнопку 'Генерировать пароль' для генерации пароля")
    public void pushTheButtonForGeneratePassword() {
        mainPage.pushTheButtonForGeneratePassword();
    }

    @И("проверить пароль на неравенство string")
    public void firstPasswordIsNotNullCheck(String anotherPassword) {
        generatedFirstPassword = mainPage.getPassword();
        assertNotEquals(anotherPassword, generatedFirstPassword);
    }

    @И("проверить, что пароль не равен предыдущему паролю")
    public void secondPasswordIsNotEqualToTheFirstPassword() {
        generatedSecondPassword = mainPage.getPassword();
        assertNotEquals(generatedFirstPassword, generatedSecondPassword);
    }

    @И("убрать галочку в чек-боксе 'Включить символы'")
    public void removeTheCheckboxWithSymbols() {
        mainPage.removeTheCheckboxWithSymbols();
    }

    @И("выбрать в поле 'Длина пароля' значение string")
    public void chooseOtherPasswordLength(String length) {
        mainPage.chooseOtherPasswordLength(length);
    }

    @И("проверить, что длина сгенерированного пароля равна string")
    public void numberOfSymbolsInTheThirdPasswordCheck(String length) {
        generatedThirdPassword = mainPage.getPassword();
        assertEquals(length, generatedThirdPassword);
    }

    @И("закрытие окна браузера и прекращение работы драйвера")
    public void closeBrowserWindowAndFinishWorkWithDriver() {
        mainPage.closeBrowserWindowAndFinishWorkWithDriver();
    }
}
