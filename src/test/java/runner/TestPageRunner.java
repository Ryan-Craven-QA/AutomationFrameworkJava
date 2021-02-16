package runner;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        plugin= {"pretty","html:target/Result/cucumber-pretty","json:target/cucumber/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = {"stepdefs"},
        tags = "@test_page"
)

public class TestPageRunner extends AbstractTestNGCucumberParallelTests {

    @BeforeClass
    public static void before() {
        System.out.println("Before - " +System.currentTimeMillis());
    }

    @AfterClass
    public static void after() {
        System.out.println("After - " +System.currentTimeMillis());
    }
}
