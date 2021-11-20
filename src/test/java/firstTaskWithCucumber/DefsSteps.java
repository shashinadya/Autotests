package firstTaskWithCucumber;

import cucumber.api.java.ru.И;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.*;

public class DefsSteps {
    private WebDriver driver;
    private String generatedFirstPassword;
    private WebElement generateBtn;
    private String generatedSecondPassword;
    private WebElement finalPass;
    private String generatedThirdPassword;

    @И("^настройка драйвера для браузера Chrome и инициализация драйвера$")
    public void propertiesOfDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\projects\\Autotests\\libs\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @И("^открыть сайт генератора паролей$")
    public void openPasswordsGeneratorSite() {
        driver.get("https://passwordsgenerator.net/ru/");
    }

    @И("^нажать на кнопку \"Генерировать пароль\" для получения первого пароля$")
    public void pushTheButtonForGenerateFirstPassword() {
        generateBtn = driver.findElement(By.xpath("//div[@class='button GenerateBtn']"));
        generateBtn.click();
    }

    @И("^получить значение первого сгенерированного пароля$")
    public void getFirstPassword() {
        finalPass = driver.findElement(By.id("final_pass"));
        generatedFirstPassword = finalPass.getAttribute("value");
    }

    @И("^проверить первый пароль на неравенство \"\"$")
    public void firstPasswordIsNotNullCheck() {
        assertNotEquals("", generatedFirstPassword);
    }

    @И("^нажать на кнопку \"Генерировать пароль\" для получения второго пароля$")
    public void pushTheButtonForGenerateSecondPassword() {
        generateBtn.click();
    }

    @И("^получить значение второго сгенерированного пароля$")
    public void getSecondPassword() {
        generatedSecondPassword = finalPass.getAttribute("value");
    }

    @И("^проверить, что второй пароль не равен первому паролю$")
    public void secondPasswordIsNotEqualToTheFirstPassword() {
        assertNotEquals(generatedFirstPassword, generatedSecondPassword);
    }

    @И("^убрать галочку в чек-боксе \"Включить символы\"$")
    public void removeTheCheckboxWithSymbols() {
        driver.findElement(By.id("Symbols")).click();
    }

    @И("^выбрать в поле \"Длина пароля\" значение 8$")
    public void chooseOtherPasswordLength() {
        WebElement selectLength = driver.findElement(By.id("pgLength"));
        Select select = new Select(selectLength);
        select.selectByVisibleText("8");
    }

    @И("^нажать на кнопку \"Генерировать пароль\" для получения третьего пароля$")
    public void pushTheButtonForGenerateThirdPassword() {
        generateBtn.click();
    }

    @И("^получить значение третьего сгенерированного пароля$")
    public void getThirdPassword() {
        generatedThirdPassword = finalPass.getAttribute("value");
    }

    @И("^проверить, что количество символов в третьем пароле равно 8$")
    public void numberOfSymbolsInTheThirdPasswordCheck() {
        assertEquals(8, generatedThirdPassword.length());
    }

    @И("^закрытие окна браузера и прекращение работы драйвера$")
    public void closeBrowserWindowAndFinishWorkWithDriver() {
        driver.quit();
    }
}
