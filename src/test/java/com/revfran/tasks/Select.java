package com.revfran.tasks;

import com.revfran.pages.adidas.fi.ArticleDetailsPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class Select {

    public static Performable FirstSizeForItem() {
        return Task.where("{0} selects first size for an item",
                Click.on(ArticleDetailsPage.SIZE_SELECTOR_BUTTON.of("1"))
        );
    }
}
