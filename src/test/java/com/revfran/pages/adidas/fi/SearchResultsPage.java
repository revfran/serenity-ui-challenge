package com.revfran.pages.adidas.fi;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.adidas.fi/search?q=ultraboost")
public class SearchResultsPage extends PageObject {
    public static final Target SEARCH_ITEM_TITLE = Target.the("Search results title").locatedBy("//h1[@data-auto-id='plp-header-bar-search-title']");
}
