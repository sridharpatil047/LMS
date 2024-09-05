package com.example.v0.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class Loan extends BaseModel{
    Member member;
    BookItem bookItem;
    LocalDate issuedDate;
    LocalDate dueDate;
    LocalDate returnDate;
}
