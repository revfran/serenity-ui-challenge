package com.revfran.questions;

import com.revfran.model.SearchResultsInformation;
import com.revfran.pages.adidas.fi.SearchResultsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.questions.ValueOf.the;

public class SearchResultsQuestions implements Question<SearchResultsInformation> {

    public static SearchResultsQuestions information() {
        return new SearchResultsQuestions();
    }

    @Override
    public SearchResultsInformation answeredBy(Actor actor) {
        String title = BrowseTheWeb.as(actor).getTitle();
        String searchResultsTitle = the(Text.of(SearchResultsPage.SEARCH_ITEM_TITLE).viewedBy(actor));
        return new SearchResultsInformation(title, searchResultsTitle);
    }
}
