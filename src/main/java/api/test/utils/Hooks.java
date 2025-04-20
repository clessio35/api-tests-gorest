package api.test.utils;

import org.junit.Before;

import io.cucumber.java.Scenario;

public class Hooks {

    private static Scenario scenario;

    @Before
    public void beforeScenario(Scenario scenario) {
        Hooks.scenario = scenario;
    }

    public static String getScenarioName() {
        return scenario != null ? scenario.getName() : "unknown_scenario";
    }
}
