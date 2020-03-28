package glue;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import utils.Init;


public class Hooks {

    static WebDriver driver = Driver.getInsance();

    @Attachment(type = "image/png")
    public static byte[] getScreenshot() {
        return  ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }


    @After
    public void shutDown(Scenario scenario) {
        if (scenario.isFailed())
            getScreenshot();
        Init.shutDown();
    }
}
