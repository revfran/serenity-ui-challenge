package com.revfran.tasks;

import com.revfran.pages.AdidasFiPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class Search {

    public static Performable forTerm(String term) {
        return Task.where("{0} searches for term #term",
                Enter.theValue(term).into(AdidasFiPage.SEARCH_BAR).then(Click.on(AdidasFiPage.SEARCH_BAR))
        ).with("#term").of(term);
    }

    public static Performable forTermAndHitReturn(String term) {
        return Task.where("{0} searches for term #term and hits return",
                Enter.theValue(term).into(AdidasFiPage.SEARCH_BAR).thenHit(Keys.RETURN)
        );
    }
}
