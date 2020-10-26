package com.revfran.pages.adidas.fi;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.adidas.fi/EH2861.html")
public class ArticleDetailsPage extends PageObject {
    // Size selector
    public static final Target SIZE_SELECTOR_BUTTON = Target.the("Size selector button").locatedBy("//button[contains(@class,'size') and not(@data-auto-id)][{0}]");

    // Add to bag
    public static final Target ADD_TO_BAG_BUTTON = Target.the("Add to cart button").locatedBy("//button[@data-auto-id='add-to-bag']");

    // Items added to bag
    public static final Target ITEMS_ADDED_TO_BAG_FIELD = Target.the("Items added field").locatedBy("//div[contains(@class,'order-summary')]/div[contains(text(),'item')]");

    // Article in bag
    public static final Target ARTICLE_IN_BAG_FIELD = Target.the("Article in bag field").locatedBy("//*[@data-auto-id='bag-modal-product-name']");
}
