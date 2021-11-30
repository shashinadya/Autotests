package firstTaskWithCucumber;

import cucumber.api.java.ru.И;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DefsSteps {

    MainPage mainPage = new MainPage();

    @И("^настройка драйвера для браузера Chrome и инициализация драйвера$")
    public void propertiesOfDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\projects\\Autotests\\libs\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
    }

    @И("^открыть сайт генератора паролей$")
    public void openPasswordsGeneratorSite() {
        mainPage.openPasswordsGeneratorSite();
    }

    @И("^нажать на кнопку 'Генерировать пароль' для генерации пароля$")
    public void pushTheButtonForGeneratePassword() {
        mainPage.pushTheButtonForGeneratePassword();
    }

    @И("^получить значение сгенерированного пароля$")
    public void getPassword() {
        mainPage.getPassword();
    }

    @И("^проверить пароль на неравенство \"\"$")
    public void firstPasswordIsNotNullCheck() {
        assertNotEquals("", mainPage.returnFirstPassword());
    }

    @И("^проверить, что пароль не равен предыдущему паролю$")
    public void secondPasswordIsNotEqualToTheFirstPassword() {
        assertNotEquals(mainPage.returnFirstPassword(), mainPage.returnSecondPassword());
    }

    @И("^убрать галочку в чек-боксе 'Включить символы'$")
    public void removeTheCheckboxWithSymbols() {
        mainPage.removeTheCheckboxWithSymbols();
    }

    @И("^выбрать в поле 'Длина пароля' значение 8$")
    public void chooseOtherPasswordLength() {
        mainPage.chooseOtherPasswordLength("8");
    }

    @И("^проверить, что количество символов в пароле равно 8$")
    public void numberOfSymbolsInTheThirdPasswordCheck() {
        assertEquals("8", mainPage.returnThirdPassword());
    }

    @И("^закрытие окна браузера и прекращение работы драйвера$")
    public void closeBrowserWindowAndFinishWorkWithDriver() {
        mainPage.closeBrowserWindowAndFinishWorkWithDriver();
    }
}
