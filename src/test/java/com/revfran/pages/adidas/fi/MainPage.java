package com.revfran.pages.adidas.fi;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By.ByName;

@DefaultUrl("https://www.adidas.fi")
public class MainPage extends PageObject {
    // Search bar
    public static final Target SEARCH_BAR = Target.the("Search bar").located(ByName.name("q"));

    // OverlayQuestions product suggestions
    public static final Target OVERLAY_PRODUCTS = Target.the("OverlayQuestions products").locatedBy("//span[contains(@class,'product-name')]");

    // OverlayQuestions category suggestions
    public static final Target OVERLAY_CATEGORIES = Target.the("OverlayQuestions categories").locatedBy("//li[text()='Suggestions']/following-sibling::li");
}
