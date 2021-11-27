package firstTaskWithCucumber;

import cucumber.api.java.ru.И;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MainPage {
    private WebDriver driver;
    private String generatedFirstPassword;
    private WebElement generateBtn;
    private String generatedSecondPassword;
    private WebElement finalPass;
    private String generatedThirdPassword;
    private int otherPasswordLengthInTheList = 8;

    private static final String GENERATE_PASSWORD_BTN_XPATH = "//div[@class = 'button GenerateBtn']";
    private static final String FINAL_PASS_FIELD_ID = "final_pass";
    private static final String ENABLED_SYMBOLS_CHECKBOX_ID = "Symbols";
    private static final String PASSWORD_LENGTH_SELECT_ID = "pgLength";

    public void propertiesOfDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\projects\\Autotests\\libs\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public void openPasswordsGeneratorSite() {
        driver.get("https://passwordsgenerator.net/ru/");
    }

    public void pushTheButtonForGeneratePassword() {
        generateBtn = driver.findElement(By.xpath(GENERATE_PASSWORD_BTN_XPATH));
        generateBtn.click();
    }

    public void getPassword() {
        finalPass = driver.findElement(By.id(FINAL_PASS_FIELD_ID));
        generatedFirstPassword = finalPass.getAttribute("value");
    }

    public void passwordIsNotNullCheck() {
        assertNotEquals("", generatedFirstPassword);
    }

    public void secondPasswordIsNotEqualToTheFirstPassword() {
        assertNotEquals(generatedFirstPassword, generatedSecondPassword);
    }

    public void removeTheCheckboxWithSymbols() {
        driver.findElement(By.id(ENABLED_SYMBOLS_CHECKBOX_ID)).click();
    }

    public void chooseOtherPasswordLength() {
        WebElement selectLength = driver.findElement(By.id(PASSWORD_LENGTH_SELECT_ID));
        Select select = new Select(selectLength);
        select.selectByVisibleText("otherPasswordLengthInTheList");
    }

    public void numberOfSymbolsInTheThirdPasswordCheck() {
        assertEquals(otherPasswordLengthInTheList, generatedThirdPassword.length());
    }

    public void closeBrowserWindowAndFinishWorkWithDriver() {
        driver.quit();
    }


}

