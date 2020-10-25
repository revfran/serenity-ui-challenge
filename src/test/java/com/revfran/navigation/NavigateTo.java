package com.revfran.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {

    public static Performable theAdidasFinlandHomePage() {
        return Task.where("{0} opens adidas Finland home page",
                Open.browserOn().the(AdidasFiPage.class)
        );
    }
}
