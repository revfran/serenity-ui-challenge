package com.revfran.tasks;

import com.revfran.pages.adidas.fi.ModalWindows;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class CloseAModalWindow {
    public static Performable ofDeliverTo() {
        return Task.where("{0} closes deliver to window",
                Click.on(ModalWindows.DELIVERY_LOCATION_POPUP)
        );
    }
}
