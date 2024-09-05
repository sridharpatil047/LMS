package com.example.v0.repositories;

import com.example.v0.models.BookItem;
import com.example.v0.specifications.SearchCriteria;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BookItemRepository {
    private Map<Long, BookItem> bookItemMap;
    private static long counter;

    public BookItemRepository() {
        this.bookItemMap = new HashMap<>();
    }

    public BookItem save(BookItem bookItem){
        if (bookItem.getId() == null){
            bookItem.setId(++counter);
        }
        bookItemMap.put(bookItem.getId(), bookItem);
        return bookItem;
    }
    public Optional<BookItem> findByID(long bookItemId){
        if (bookItemMap.containsKey(bookItemId)){
            return Optional.of(bookItemMap.get(bookItemId));
        }
        return Optional.empty();
    }

    public List<BookItem> findBy(SearchCriteria searchCriteria){

        return searchCriteria.searchBooks(bookItemMap.values().stream().toList());

    }

}
