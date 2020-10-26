package com.revfran.definitions;

import com.revfran.Matchers.StringContainsIgnoringCase;
import com.revfran.questions.ArticleDetailsQuestions;
import com.revfran.questions.BagQuestions;
import com.revfran.questions.HomePageQuestions;
import com.revfran.questions.OverlayQuestions;
import com.revfran.questions.SearchResultsQuestions;
import com.revfran.tasks.AcceptWindow;
import com.revfran.tasks.AddTo;
import com.revfran.tasks.CloseAModalWindow;
import com.revfran.tasks.NavigateTo;
import com.revfran.tasks.Search;
import com.revfran.tasks.Select;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.ConsequenceMatchers.displays;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;

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
        actor.wasAbleTo(NavigateTo.theAdidasFinlandHomePage(), CloseAModalWindow.ofDeliverTo(), AcceptWindow.ofManageCookies());
    }

    @Given("{actor} opens adidas Finland item detail page closing modal windows for {string}")
    public void mariaOpensAdidasFinlandItemDetailPageClosingModalWindowsFor(Actor actor, String articleNumber) {
        actor.wasAbleTo(NavigateTo.theArticleDetailsPage(), CloseAModalWindow.ofDeliverTo(), AcceptWindow.ofManageCookies());
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

    @When("{actor} selects the first size")
    public void sheSelectsTheFirstSize(Actor actor) {
        actor.attemptsTo(Select.FirstSizeForItem());
    }

    @And("{actor} adds the article to the bag")
    public void sheAddsTheArticleToTheBag(Actor actor) {
        actor.attemptsTo(AddTo.Bag());
    }

    @Then("{actor} should see that the title contains the values {string}")
    public void sheShouldSeeThatTheTitleContainsTheValues(Actor actor, String expectedTitle) {
        actor.should(seeThat(HomePageQuestions.information(), displays("title", containsString(expectedTitle))));
    }

    @Then("{actor} should see that the product suggestions should contain the word {string}")
    public void sheShouldSeeThatTheProductSuggestionsShouldContainTheWord(Actor actor, String expectedTerm) {
        // Ensure library as this is a more complex match
        Ensure.that(
                OverlayQuestions.productSuggestionsDisplayed().answeredBy(actor)).allMatch("Contain expectedTerm " + expectedTerm,
                it -> it.toUpperCase().contains(expectedTerm.toUpperCase())
        );
    }

    @Then("{actor} should see that the overlay suggestions should contain the word {string}")
    public void sheShouldSeeThatTheOverlaySuggestionsShouldContainTheWord(Actor actor, String expectedTerm) {
        // Ensure library as this is a more complex match
        Ensure.that(
                OverlayQuestions.categorySuggestionsDisplayed().answeredBy(actor)).allMatch("Contain expectedTerm " + expectedTerm,
                it -> it.toUpperCase().contains(expectedTerm.toUpperCase()));
    }

    @Then("{actor} should see that the search title contains the values {string}")
    public void sheShouldSeeThatTheSearchTitleContainsTheValues(Actor actor, String expectedTitle) {
        actor.should(eventually(seeThat(SearchResultsQuestions.information(), displays("title", containsString(expectedTitle)))));
    }

    @Then("{actor} should see that the item detail title contains the values {string}")
    public void sheShouldSeeThatTheItemDetailTitleContainsTheValues(Actor actor, String expectedTitle) {
        actor.should(eventually(seeThat(ArticleDetailsQuestions.information(), displays("title", StringContainsIgnoringCase.containsStringIgnoringCase(expectedTitle)))));
    }

    @Then("{actor} should see that the search results are related to {string}")
    public void sheShouldSeeThatTheSearchResultsAreRelatedTo(Actor actor, String expectedTerm) {
        actor.should(eventually(seeThat(SearchResultsQuestions.information(), displays("searchResultsTitle", containsString(expectedTerm.toUpperCase())))));
    }

    @Then("{actor} should see that the bag contains {string} item")
    public void sheShouldSeeThatTheBagContainsItem(Actor actor, String expectedNumberOfItems) {
        actor.should(eventually(seeThat(BagQuestions.itemsAddedToBag(), containsString(expectedNumberOfItems))));
    }

    @Then("{actor} should see that the item descriptions contains {string}")
    public void sheShouldSeeThatTheItemDescriptionsContains(Actor actor, String itemDescription) {
        actor.should(eventually(seeThat(BagQuestions.articleDetail(), containsString(itemDescription))));
    }
}
