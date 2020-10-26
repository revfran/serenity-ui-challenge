package com.revfran.questions;

import com.revfran.model.AdidasFiInformation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class AdidasFiQuestions  implements Question<AdidasFiInformation> {

    @Override
    public AdidasFiInformation answeredBy(Actor actor) {
        String title = BrowseTheWeb.as(actor).getTitle();
        return new AdidasFiInformation(title);
    }

    public static AdidasFiQuestions information() {
        return new AdidasFiQuestions();
    }
}
