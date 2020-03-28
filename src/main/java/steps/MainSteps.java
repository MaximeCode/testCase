package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps {

    private MainPage main = new MainPage();

    @Step("Перейти в меню {service}.")
    public void goToService(String service) {
        main.goToService(service);
    }
}
