package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@class='service__title-text']")
    private List<WebElement> serviceElements;


    public void goToService(String service) {
        waitToBeClickable(getElementFromList(serviceElements, service)).click();
    }
}
