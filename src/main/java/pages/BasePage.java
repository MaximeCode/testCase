package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.util.List;

public abstract class BasePage {

    static WebDriver driver = Driver.getInsance();
    static WebDriverWait wait = new WebDriverWait(driver, 1);


    public BasePage() {
        PageFactory.initElements(driver, this);
    }


    public WebElement getElementFromList(List<WebElement> elements, String keywords) {
        return elements
                .stream()
                .filter(item -> item.getText().contains(keywords))
                .findFirst()
                .orElse(null);
    }



    void waitPresence(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    WebElement waitToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    WebElement waitToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    List<WebElement> waitElementsToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    WebElement waitToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    WebElement waitToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


}
