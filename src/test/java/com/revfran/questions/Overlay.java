package com.revfran.questions;

import com.revfran.pages.AdidasFiPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

public class Overlay {
    public static Question<List<String>> categorySuggestionsDisplayed(){
        return Text.of(AdidasFiPage.OVERLAY_CATEGORIES).describedAs("category suggestion displayed").asAList();
    }

    public static Question<List<String>> productSuggestionsDisplayed(){
        return Text.of(AdidasFiPage.OVERLAY_PRODUCTS).describedAs("product suggestion displayed").asAList();
    }
/*
    public static Question<ElementAvailability> categorySuggestionsVisible(){
        return ElementAvailability.AdidasFiPage.OVERLAY_CONTAINER.).describedAs("category suggestion displayed").asAList();
    }*/
}
