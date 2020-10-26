package com.revfran.pages.adidas.fi;

import net.serenitybdd.screenplay.targets.Target;

public class ModalWindows {

    // Delivery Location popup
    public static final Target DELIVERY_LOCATION_POPUP = Target.the("Delivery location popup").locatedBy("//button[@class='gl-modal__close']");
    // Accept tracking button
    public static final Target ACCEPT_TRACKING_BUTTON = Target.the("Accept tracking button").locatedBy("//button/span[contains(text(),'Accept tracking')]/..");

}
