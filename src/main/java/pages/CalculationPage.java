package pages;

import cucumber.api.java.ca.Cal;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.Calculation;

import javax.lang.model.element.Element;
import java.util.List;

public class CalculationPage extends BasePage {

    @FindBy(className = "calculator__currency-field-text")
    private List<WebElement> currencyElements;

    @FindBy(className = "calculator__slide-input-label")
    private List<WebElement> inputLabelElements;

    @FindBy(className = "calculator__check-text")
    private List<WebElement> toggleLabelElement;

    @FindBy(id = "period")
    private WebElement periodSelectElement;

    @FindBy(className = "js-calc-amount")
    private WebElement amountElement;

    @FindBy(className = "js-calc-result js-calc-result-noanim")
    private WebElement resultElement;

    @FindBy(className = "js-calc-earned")
    private WebElement earnedElement;

    @FindBy(className = "js-calc-replenish")
    private WebElement replenishElement;

    @FindBy(className = "js-calc-result")
    private WebElement anotherResultElement;


    private static By inputAdditionalLocator = By.xpath("./..//input");
    private static By toggleAdditionalLocator = By.xpath("./../../../label//div[contains(@class, 'jq-checkbox calculator__check')]");


    public void setCurrency(String currency) {
        waitToBeClickable(getElementFromList(currencyElements, currency)).click();
    }

    public void input(String keywords, String value) {
        WebElement element = waitToBeVisible(getElementFromList(inputLabelElements, keywords));
        if ("Срок".equals(keywords))
            selectPeriod(value);
        else {
            element.findElement(inputAdditionalLocator).sendKeys(value);
        }
    }

    public void on(String toggleName) {
        WebElement toggle = getToggle(toggleName);
        if (isOn(toggle)) return;
        switchToggle(toggle);
    }

    public void check() {
        Calculation.setAmount(amountElement.getText());
        Calculation.setPeriod(periodSelectElement.getText());
        Calculation.setReplenishMonthly(replenishElement.getText());
        Calculation.setEarned(earnedElement.getText());
        Calculation.setReplenishTotalExpected(replenishElement.getText());
        Calculation.setResultExpected(resultElement.getText());

        Assert.assertTrue("Начисленная сумма неверна", Calculation.checkReplenishTotal());
        Assert.assertTrue("Сумма к снятию в конце срока неверна",Calculation.checkResult());
    }

    private void selectPeriod(String value) {
        new Select(waitToBeClickable(periodSelectElement)).selectByValue(value);
    }

    private boolean isOn(WebElement toggle) {
        return getClass(toggle).contains("checked");

    }

    private WebElement getToggle(String toggleLabel) {
        return waitToBeVisible(getElementFromList(toggleLabelElement, toggleLabel)).findElement(toggleAdditionalLocator);
    }

    private void switchToggle(WebElement toggle) {
        String toggleClass = getClass(toggle);
        waitToBeClickable(toggle).click();
    }

    private String getClass(WebElement element) {
        return waitToBeVisible(element).getAttribute("class");
    }
}