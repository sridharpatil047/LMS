package com.example.v0.specifications;

import com.example.v0.models.BookItem;

import java.util.List;

public class AndSearch implements SearchCriteria{
    SearchCriteria searchCriteria1;
    SearchCriteria searchCriteria2;

    public AndSearch(SearchCriteria searchCriteria1, SearchCriteria searchCriteria2) {
        this.searchCriteria1 = searchCriteria1;
        this.searchCriteria2 = searchCriteria2;
    }

    @Override
    public List<BookItem> searchBooks(List<BookItem> bookItems) {
        return searchCriteria2.searchBooks(
                searchCriteria1.searchBooks(bookItems));
    }
}
