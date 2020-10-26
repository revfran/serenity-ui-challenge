package com.revfran.questions;

import com.revfran.pages.adidas.fi.ArticleDetailsPage;
import com.revfran.pages.adidas.fi.MainPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

public class BagQuestions {

    public static Question<String> itemsAddedToBag() {
        return Text.of(ArticleDetailsPage.ITEMS_ADDED_TO_BAG_FIELD).describedAs("items added to bag").asAString();
    }

    public static Question<String> articleDetail() {
        return Text.of(ArticleDetailsPage.ARTICLE_IN_BAG_FIELD).describedAs("item details in bag").asAString();
    }
}
