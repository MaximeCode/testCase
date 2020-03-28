package steps;

import cucumber.api.java.ru.Тогда;
import io.qameta.allure.Step;
import pages.CalculationPage;
import pages.MainPage;

import java.util.Map;

public class CalculationSteps {

    private MainPage main = new MainPage();
    private CalculationPage calculation = new CalculationPage();


    @Step("Выбрать {currency}.")
    public void setCurrency(String currency) {
        calculation.setCurrency(currency);
    }

    @Step("Внести значения:")
    public void input(Map<String, String> values) {
        values.forEach(calculation::input);
    }

    @Step("Отметить {toggle}.")
    public void on(String toggle) {
        calculation.on(toggle);
    }

    @Step("Проверить расчёты по вкладу.")
    public void check() {
        calculation.check();
    }
}


