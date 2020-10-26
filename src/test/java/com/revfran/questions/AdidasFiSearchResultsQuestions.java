package com.revfran.questions;

import com.revfran.model.AdidasFiSearchResultsInformation;
import com.revfran.pages.AdidasFiSearchResultsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.questions.ValueOf.the;

public class AdidasFiSearchResultsQuestions implements Question<AdidasFiSearchResultsInformation> {

    @Override
    public AdidasFiSearchResultsInformation answeredBy(Actor actor) {
        String title = BrowseTheWeb.as(actor).getTitle();
        String searchResultsTitle = the(Text.of(AdidasFiSearchResultsPage.SEARCH_ITEM_TITLE).viewedBy(actor));
        return new AdidasFiSearchResultsInformation(title,searchResultsTitle);
    }

    public static AdidasFiSearchResultsQuestions information() {
        return new AdidasFiSearchResultsQuestions();
    }
}
