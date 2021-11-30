package firstTaskWithCucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MainPage {
    private WebDriver driver = new ChromeDriver();
    private String generatedFirstPassword;
    private String generatedSecondPassword;
    private String generatedThirdPassword;
    private String getPassword;

    private static final String GENERATE_PASSWORD_BTN_XPATH = "//div[@class = 'button GenerateBtn']";
    private static final String FINAL_PASS_FIELD_ID = "final_pass";
    private static final String ENABLED_SYMBOLS_CHECKBOX_ID = "Symbols";
    private static final String PASSWORD_LENGTH_SELECT_ID = "pgLength";

    public void openPasswordsGeneratorSite() {
        driver.get("https://passwordsgenerator.net/ru/");
    }

    public void pushTheButtonForGeneratePassword() {
        driver.findElement(By.xpath(GENERATE_PASSWORD_BTN_XPATH)).click();
    }

    public String getPassword() {
        this.getPassword = driver.findElement(By.id(FINAL_PASS_FIELD_ID)).getAttribute("value");
        return getPassword;
    }

    public String returnFirstPassword() {
        this.generatedFirstPassword = getPassword();
        return generatedFirstPassword;
    }

    public String returnSecondPassword() {
        this.generatedSecondPassword = getPassword();
        return generatedSecondPassword;
    }

    public void removeTheCheckboxWithSymbols() {
        driver.findElement(By.id(ENABLED_SYMBOLS_CHECKBOX_ID)).click();
    }

    public void chooseOtherPasswordLength(String len) {
        WebElement selectLength = driver.findElement(By.id(PASSWORD_LENGTH_SELECT_ID));
        Select select = new Select(selectLength);
        select.selectByVisibleText(len);
    }

    public String returnThirdPassword() {
        this.generatedThirdPassword = getPassword();
        return generatedThirdPassword;
    }

    public void closeBrowserWindowAndFinishWorkWithDriver() {
        driver.quit();
    }
}