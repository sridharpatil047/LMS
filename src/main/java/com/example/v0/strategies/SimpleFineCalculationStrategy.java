package com.example.v0.strategies;

import com.example.v0.models.Loan;

import java.time.Period;

public class SimpleFineCalculationStrategy implements FineCalculationStrategy{

    private static final double PER_DAY_RATE = 2.50;

    @Override
    public double calculateFine(Loan loan) {
        if (loan.getReturnDate().isAfter(loan.getDueDate())){
            Period period = Period.between(loan.getDueDate(), loan.getReturnDate());

            return period.getDays() * PER_DAY_RATE;
        }
        return 0.0;
    }
}

