package com.revfran.questions;

import com.revfran.pages.adidas.fi.MainPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

public class OverlayQuestions {
    public static Question<List<String>> categorySuggestionsDisplayed() {
        return Text.of(MainPage.OVERLAY_CATEGORIES).describedAs("category suggestion displayed").asAList();
    }

    public static Question<List<String>> productSuggestionsDisplayed() {
        return Text.of(MainPage.OVERLAY_PRODUCTS).describedAs("product suggestion displayed").asAList();
    }
}
