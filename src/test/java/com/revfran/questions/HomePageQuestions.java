package com.revfran.questions;

import com.revfran.model.HomePageInformation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class HomePageQuestions implements Question<HomePageInformation> {

    public static HomePageQuestions information() {
        return new HomePageQuestions();
    }

    @Override
    public HomePageInformation answeredBy(Actor actor) {
        String title = BrowseTheWeb.as(actor).getTitle();
        return new HomePageInformation(title);
    }
}
