package api.test.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"api.test.steps", "api.test.utils"},
    tags = "@create-valid-user", 
    publish = true,
    plugin = {"pretty", "html:target/cucumber-reports"}
)
public class RunnerTest {

}
