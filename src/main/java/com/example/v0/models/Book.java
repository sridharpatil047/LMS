package com.example.v0.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book extends BaseModel{
    String ISBN;
    String title;
    String author;
    String publication;
}
