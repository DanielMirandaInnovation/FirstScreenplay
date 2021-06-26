package com.demoqa.tests.stepdefinitions;

import com.demoqa.automation.interactions.OpenTheBrowser;
import com.demoqa.automation.tasks.FillAllFields;
import com.demoqa.automation.tasks.FillAllFieldsWithExcel;
import com.demoqa.automation.ui.TextBoxPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TextBoxStepDefinitions {

    @Managed
    private WebDriver driver;

    @Before
    public void actorSetUp(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Daniel").can(BrowseTheWeb.with(driver));
    }


    @Given("^that a web user wants to practice text box in demoqa$")
    public void thatAWebUserWantsToPracticeTextBoxInDemoqa() {
        theActorInTheSpotlight().attemptsTo(OpenTheBrowser.on(TextBoxPage.URL));
    }


    @When("^he fills all the requested fields in text box section$")
    public void heFillsAllTheRequestedFieldsInTextBoxSection() {
        theActorInTheSpotlight().attemptsTo(FillAllFields.successful());
    }

    @When("^he fills all the requested fields in text box section with data excel$")
    public void heFillsAllTheRequestedFieldsInTextBoxSectionWithDataExcel() {
        theActorInTheSpotlight().attemptsTo(FillAllFieldsWithExcel.dataInjectionSheet());
    }

    @Then("^he should see him data down\\.$")
    public void heShouldSeeHimDataDown() {
    }

}
