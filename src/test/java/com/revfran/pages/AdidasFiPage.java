package com.revfran.pages;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By.ByName;

@DefaultUrl("https://www.adidas.fi")
public class AdidasFiPage extends PageObject {

    // Locator Delivery Location
    public static final Target DELIVERY_LOCATION_POPUP = Target.the("Delivery location popup").locatedBy("//button[@class='gl-modal__close']");
    // Accept tracking button
    public static final Target ACCEPT_TRACKING_BUTTON = Target.the("Accept tracking button").locatedBy("//button/span[contains(text(),'Accept tracking')]/..");

    // Search bar
    public static final Target SEARCH_BAR = Target.the("Search bar").located(ByName.name("q"));

    // Overlay product suggestions
    public static final Target OVERLAY_PRODUCTS = Target.the("Overlay products").locatedBy("//span[contains(@class,'product-name')]");

    // Overlay category suggestions
    public static final Target OVERLAY_CATEGORIES = Target.the("Overlay categories").locatedBy("//li[text()='Suggestions']/following-sibling::li");

    // Overlay container
    public static final Target OVERLAY_CONTAINER = Target.the("Overlay container").locatedBy("//div[@data-auto-id='glass-search-results-container']");
}
