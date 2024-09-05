package com.example.v0.specifications;

import com.example.v0.models.BookItem;

import java.util.List;

public class SearchByTitle implements SearchCriteria{
    String title;

    public SearchByTitle(String title) {
        this.title = title;
    }

    @Override
    public List<BookItem> searchBooks(List<BookItem> bookItems) {
        return bookItems
                .stream()
                .filter((bookItem) -> { return bookItem.getTitle().equals(title);})
                .toList();
    }
}
