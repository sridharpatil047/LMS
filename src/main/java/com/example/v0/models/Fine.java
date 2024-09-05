package com.example.v0.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fine extends BaseModel{
    Loan loan;
    double fineAmount;
}
