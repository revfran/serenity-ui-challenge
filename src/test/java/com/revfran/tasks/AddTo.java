package com.revfran.tasks;

import com.revfran.pages.adidas.fi.ArticleDetailsPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class AddTo {
    public static Performable Bag() {
        return Task.where("{0} adds item to bag",
                Click.on(ArticleDetailsPage.ADD_TO_BAG_BUTTON)
        );
    }
}
