package com.example.v0.specifications;

import com.example.v0.models.BookItem;

import java.util.ArrayList;
import java.util.List;

public class OrSearch implements SearchCriteria{
    SearchCriteria searchCriteria1;
    SearchCriteria searchCriteria2;

    public OrSearch(SearchCriteria searchCriteria1, SearchCriteria searchCriteria2) {
        this.searchCriteria1 = searchCriteria1;
        this.searchCriteria2 = searchCriteria2;
    }

    @Override
    public List<BookItem> searchBooks(List<BookItem> bookItems) {

        List<BookItem> bookItemList = new ArrayList<>();

        bookItemList.addAll(searchCriteria1.searchBooks(bookItems));
        bookItemList.addAll(searchCriteria2.searchBooks(bookItems));

        return bookItemList;
    }
}
