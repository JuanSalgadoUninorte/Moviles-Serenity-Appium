package co.com.choucair.stepdefinitions;

import co.com.choucair.model.DataModel;
import co.com.choucair.questions.LastResponse;
import co.com.choucair.tasks.LoginProcess;
import co.com.choucair.tasks.OpenApp;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EriBankStepDefinitions {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("Juan access to the app")
    public void juanAccessToTheApp() {
        theActorCalled("Juan");
        theActorInTheSpotlight().attemptsTo(OpenApp.openApplication());
    }

    @When("He accesses to my account with my credentials")
    public void heAccessesToMyAccountWithMyCredentials(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(LoginProcess.appLoginProcess(DataModel.setData(dataTable).get(0)));
    }

    @Then("He is able to check my actual balance")
    public void heIsAbleToCheckMyActualBalance(DataTable dataTable) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(LastResponse.lastResponseConfirmation(DataModel.setData(dataTable).get(0))));

    }
}