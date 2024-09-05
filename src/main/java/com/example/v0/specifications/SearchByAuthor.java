package com.example.v0.specifications;

import com.example.v0.models.BookItem;

import java.util.List;

public class SearchByAuthor implements SearchCriteria{
    String author;

    public SearchByAuthor(String author) {
        this.author = author;
    }

    @Override
    public List<BookItem> searchBooks(List<BookItem> bookItems) {
        return bookItems
                .stream()
                .filter((bookItem) -> { return bookItem.getAuthor().equals(author);})
                .toList();
    }
}
