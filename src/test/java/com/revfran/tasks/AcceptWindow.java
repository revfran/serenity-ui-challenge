package com.revfran.tasks;

import com.revfran.pages.AdidasFiPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class AcceptWindow {
    public static Performable ofManageCookies() {
        return Task.where("{0} accepts cookies in modal window",
                Click.on(AdidasFiPage.ACCEPT_TRACKING_BUTTON)
        );
    }
}
