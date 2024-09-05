package com.example.v0.services;

import com.example.v0.models.Fine;
import com.example.v0.models.Loan;
import com.example.v0.repositories.FineRepository;
import com.example.v0.repositories.LoanRepository;
import com.example.v0.strategies.FineCalculationStrategy;

import java.time.LocalDate;
import java.util.Optional;

public class FineService {

    FineCalculationStrategy fineCalculationStrategy;
    FineRepository fineRepository;
    LoanRepository loanRepository;


    public Fine calculateFine(long loanId){

        Optional<Loan> optionalLoan = loanRepository.findById(loanId);
        if (optionalLoan.isEmpty()){
            throw new RuntimeException();
        }
        Loan loan = optionalLoan.get();
        loan.setReturnDate(LocalDate.now());
        loanRepository.save(loan);


        double fineAmount = fineCalculationStrategy.calculateFine(loan);
        Fine fine = new Fine();
        fine.setLoan(loan);
        fine.setFineAmount(fineAmount);

        return fineRepository.save(fine);
    }
}
