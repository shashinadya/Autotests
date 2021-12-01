package firstTaskWithCucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MainPage {
    private WebDriver driver;

    private static final String GENERATE_PASSWORD_BTN_XPATH = "//div[@class = 'button GenerateBtn']";
    private static final String FINAL_PASS_FIELD_ID = "final_pass";
    private static final String ENABLED_SYMBOLS_CHECKBOX_ID = "Symbols";
    private static final String PASSWORD_LENGTH_SELECT_ID = "pgLength";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void pushTheButtonForGeneratePassword() {
        driver.findElement(By.xpath(GENERATE_PASSWORD_BTN_XPATH)).click();
    }

    public String getPassword() {
        return driver.findElement(By.id(FINAL_PASS_FIELD_ID)).getAttribute("value");
    }

    public void removeTheCheckboxWithSymbols() {
        driver.findElement(By.id(ENABLED_SYMBOLS_CHECKBOX_ID)).click();
    }

    public void chooseOtherPasswordLength(String length) {
        WebElement selectLength = driver.findElement(By.id(PASSWORD_LENGTH_SELECT_ID));
        Select select = new Select(selectLength);
        select.selectByValue(length);
    }

    public void closeBrowserWindowAndFinishWorkWithDriver() {
        driver.quit();
    }
}