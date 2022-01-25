package dnsShopWithCucumberAndSelenide;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private final WebDriver driver;
    private final Actions actions;
    private final WebDriverWait wait;

    private static final String COMPUTERS_XPATH = "//a[text()='Компьютеры']";
    private static final String MOTHERBOARDS_XPATH = "//a[text()='Материнские платы']\"";
    private static final String CARD_OF_MOTHERBOARD_XPATH = "//div[@class='catalog-product ui-button-widget']";
    private static final String SHOW_MORE_BUTTON_CSSSELECTOR = ".pagination-widget__show-more-btn";
    private static final String BUTTON_BUY_XPATH = "//button[text()='Купить']";
    private static final String BUTTON_BASKET_CSSSELECTOR = ".cart-link__lbl";
    private static final String CART_ITEM_PRODUCT_XPATH = "//div[@class='cart-items__product']";

    public MainPage(WebDriver driver, Actions actions, WebDriverWait wait) {
        this.driver = driver;
        this.actions = actions;
        this.wait = wait;
    }

    public void moveCursorToComputers() {
        WebElement computers = driver.findElement(By.xpath(COMPUTERS_XPATH));
        actions.moveToElement(wait.until(ExpectedConditions.visibilityOf(computers))).perform();
    }

    public void clickToMotherBoards() {
        driver.findElement(By.xpath(MOTHERBOARDS_XPATH)).click();
    }

    public int calculateCountOfCardsOfMotherboards() {
        List<WebElement> cardList = driver.findElements(By.xpath(CARD_OF_MOTHERBOARD_XPATH));
        return cardList.size();
    }

    public void clickOnTheButtonShowMore() {
        WebElement showMoreBtn = driver.findElement(By.cssSelector(SHOW_MORE_BUTTON_CSSSELECTOR));
        wait.until(ExpectedConditions.visibilityOf(showMoreBtn));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("return document.body.scrollHeight");
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        actions.moveToElement(showMoreBtn).pause(20000).moveToElement(showMoreBtn).click(showMoreBtn).perform();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(CARD_OF_MOTHERBOARD_XPATH), calculateCountOfCardsOfMotherboards()));
    }

    public void clickToTheButtonBuy(int randomNumber) {
        List<WebElement> cardList = driver.findElements(By.xpath(CARD_OF_MOTHERBOARD_XPATH));
        for (int i = 0; i < randomNumber; i++) {
            cardList.get(i).findElement(By.xpath(BUTTON_BUY_XPATH)).click();
            actions.pause(5000);
        }
    }

    public void clickToTheBasket() {
        driver.findElement(By.cssSelector(BUTTON_BASKET_CSSSELECTOR)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CART_ITEM_PRODUCT_XPATH)));
    }

    public int calculateCountOfCardsInTheBasket() {
        return driver.findElements(By.xpath(CART_ITEM_PRODUCT_XPATH)).size();
    }

    public void closeBrowserWindowAndFinishWorkWithDriver() {
        driver.quit();
    }
}
