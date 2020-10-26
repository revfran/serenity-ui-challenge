package com.revfran.tasks;

import com.revfran.pages.adidas.fi.ArticleDetailsPage;
import com.revfran.pages.adidas.fi.MainPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {

    public static Performable theAdidasFinlandHomePage() {
        return Task.where("{0} opens adidas Finland home page",
                Open.browserOn().the(MainPage.class)
        );
    }

    public static Performable theArticleDetailsPage() {
        return Task.where("{0} opens article details page",
                Open.browserOn().the(ArticleDetailsPage.class)
        );
    }
}
