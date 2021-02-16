package stepdefs;


import ApplicatoinPages.Testpage;
import BasePage.basepage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.core.api.Scenario;

import java.net.MalformedURLException;

public class TestPageSteps extends basepage {
    private Testpage testPage;
    private String scenDesc;

    public TestPageSteps() { this.testPage = new Testpage();}
    @Before
    public void before(Scenario scenario) throws MalformedURLException {
        this.scenDesc = scenario.getName();
        setUpDriver();
    }

    @After
    public void after(Scenario scenario) {
        closeDriver(scenario);
    }

    @BeforeStep
    public void beforeStep() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Given("User navigates to URL$")
    public void aUserNavigatesToURL() throws Exception {
        this.testPage.goToURL();
    }


}