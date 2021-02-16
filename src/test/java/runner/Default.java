package runner;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        plugin= {"pretty","html:target/Result/cucumber-pretty","json:target/cucumber/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = {"stepdefs"}
)
public class Default extends AbstractTestNGCucumberParallelTests {

    private static long duration;

    @BeforeClass
    public static void before() {
        duration = System.currentTimeMillis();
        System.out.println("Thread Id  | Scenario Num       | Step Count");
    }

    @AfterClass
    public static void after() {
        duration = System.currentTimeMillis() - duration;
        System.out.println("DURATION - "+ duration);
    }
}