package glue;

import cucumber.api.java.Before;
import cucumber.api.java.ru.Тогда;
import io.qameta.allure.Step;
import pages.CalculationPage;
import pages.MainPage;
import steps.CalculationSteps;
import steps.MainSteps;
import utils.Init;

import java.util.Map;

public class StepDefinitions {

    private MainSteps main = new MainSteps();
    private CalculationSteps calculation = new CalculationSteps();

    @Тогда("Перейти на {string}.")
    public void перейти_на(String string) {
        Init.gettingStarted(string);
    }

    @Тогда("Перейти в меню {string}.")
    public void перейти_в_меню(String string) {
        main.goToService(string);
    }

    @Тогда("Выбрать {string}.")
    public void выбрать(String string) {
        calculation.setCurrency(string);
    }

    @Тогда("Внести значения:")
    public void внести_значения(Map<String, String> values) {
        calculation.input(values);
    }

    @Тогда("Отметить {string}.")
    public void отметить(String string) {
        calculation.on(string);
    }

    @Тогда("Проверить расчёты по вкладу.")
    public void проверить_расчёты_по_вкладу() {
        calculation.check();
    }
}
