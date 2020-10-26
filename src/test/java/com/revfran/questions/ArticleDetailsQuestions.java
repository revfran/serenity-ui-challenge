package com.revfran.questions;

import com.revfran.model.ArticleDetailsInformation;
import com.revfran.pages.adidas.fi.ArticleDetailsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.questions.ValueOf.the;

public class ArticleDetailsQuestions implements Question<ArticleDetailsInformation> {

    public static ArticleDetailsQuestions information() {
        return new ArticleDetailsQuestions();
    }

    @Override
    public ArticleDetailsInformation answeredBy(Actor actor) {
        String title = BrowseTheWeb.as(actor).getTitle();
        return new ArticleDetailsInformation(title);
    }
}
