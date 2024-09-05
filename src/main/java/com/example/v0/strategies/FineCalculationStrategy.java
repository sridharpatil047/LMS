package com.example.v0.strategies;

import com.example.v0.models.Fine;
import com.example.v0.models.Loan;

public interface FineCalculationStrategy {
    double calculateFine(Loan loan);
}
