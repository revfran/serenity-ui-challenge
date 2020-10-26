package com.revfran.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class SearchResultsInformation {

    @Getter
    private final String title;

    @Getter
    private final String searchResultsTitle;
}
