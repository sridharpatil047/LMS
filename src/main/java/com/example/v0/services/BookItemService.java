package com.example.v0.services;


import com.example.v0.models.BookItem;
import com.example.v0.repositories.BookItemRepository;
import com.example.v0.specifications.SearchCriteria;

import java.util.List;

public class BookItemService {
    BookItemRepository bookItemRepository;

    public BookItemService(BookItemRepository bookItemRepository) {
        this.bookItemRepository = bookItemRepository;
    }

    public List<BookItem> searchBookItems(String searchString, SearchCriteria searchCriteria){
        // title=title1&op=and&author=author1


//        return bookItemRepository
        return null;
    }

}
