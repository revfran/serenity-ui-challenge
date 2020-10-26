package com.revfran.definitions;

import com.revfran.questions.AdidasFiQuestions;
import com.revfran.questions.AdidasFiSearchResultsQuestions;
import com.revfran.questions.Overlay;
import com.revfran.tasks.AcceptWindow;
import com.revfran.tasks.CloseAModalWindow;
import com.revfran.tasks.NavigateTo;
import com.revfran.tasks.Search;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.ConsequenceMatchers.displays;
import static org.hamcrest.Matchers.containsString;

public class BasicsDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{actor} opens adidas Finland home page")
    public void openFinlandHomePage(Actor actor) {
        actor.wasAbleTo(NavigateTo.theAdidasFinlandHomePage());
    }

    @Given("{actor} opens adidas Finland home page closing modal windows")
    public void mariaOpensAdidasFinlandHomePageClosingModalWindows(Actor actor) {
        actor.wasAbleTo(NavigateTo.theAdidasFinlandHomePage(),CloseAModalWindow.ofDeliverTo(),AcceptWindow.ofManageCookies());
    }
    @When("{actor} closes delivery modal popup")
    public void sheClosesDeliveryModalPopup(Actor actor) {
        actor.attemptsTo(CloseAModalWindow.ofDeliverTo());
    }

    @When("{actor} accepts cookies modal popup")
    public void sheAcceptsCookiesModalPopup(Actor actor) {
        actor.attemptsTo(AcceptWindow.ofManageCookies());
    }

    @When("{actor} types in search section {string}")
    public void sheTypesInSearchSection(Actor actor, String searchTerm) {
        actor.attemptsTo(Search.forTerm(searchTerm));
    }

    @When("{actor} searches for {string}")
    public void sheSearchesFor(Actor actor, String searchTerm) {
        actor.attemptsTo(Search.forTermAndHitReturn(searchTerm));
    }

    @Then("{actor} should see that the title contains the values {string}")
    public void sheShouldSeeThatTheTitleContainsTheValues(Actor actor, String expectedTitle) {
        actor.should(seeThat(AdidasFiQuestions.information(),displays("title",containsString(expectedTitle))));
    }

    @Then("{actor} should see that the product suggestions should contain the word {string}")
    public void sheShouldSeeThatTheProductSuggestionsShouldContainTheWord(Actor actor, String expectedTerm) {
        // Ensure library as this is a more complex match
        Ensure.that(
                Overlay.productSuggestionsDisplayed().answeredBy(actor)).allMatch("Contain expectedTerm " + expectedTerm,
                                                                            it -> it.toUpperCase().contains(expectedTerm.toUpperCase())
        );
    }

    @Then("{actor} should see that the overlay suggestions should contain the word {string}")
    public void sheShouldSeeThatTheOverlaySuggestionsShouldContainTheWord(Actor actor,String expectedTerm) {
        // Ensure library as this is a more complex match
        Ensure.that(
                Overlay.categorySuggestionsDisplayed().answeredBy(actor)).allMatch("Contain expectedTerm "+ expectedTerm,
                                                                            it -> it.toUpperCase().contains(expectedTerm.toUpperCase()));
    }

    @Then("{actor} should see that the search title contains the values {string}")
    public void sheShouldSeeThatTheSearchTitleContainsTheValues(Actor actor,String expectedTitle) {
        actor.should(eventually(seeThat(AdidasFiSearchResultsQuestions.information(),displays("title",containsString(expectedTitle)))));
    }

    @Then("{actor} should see that the search results are related to {string}")
    public void sheShouldSeeThatTheSearchResultsAreRelatedTo(Actor actor,String expectedTerm) {
        actor.should(eventually(seeThat(AdidasFiSearchResultsQuestions.information(),displays("searchResultsTitle",containsString(expectedTerm.toUpperCase())))));
    }
}
