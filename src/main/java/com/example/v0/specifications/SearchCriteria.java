package com.example.v0.specifications;

import com.example.v0.models.BookItem;

import java.util.List;

public interface SearchCriteria {
    List<BookItem> searchBooks(List<BookItem> bookItems);
}
