package com.example.v0.repositories;

import com.example.v0.models.Loan;

import java.util.*;

public class LoanRepository {

    private Map<Long, Loan> loanMap;
    private static long counter;
    public LoanRepository() {
        this.loanMap = new HashMap<>();
    }

    public Loan save(Loan loan){
        if (loan.getId() == null){
            loan.setId(++counter);
        }
        loanMap.put(loan.getId(), loan);
        return loan;
    }

    public Optional<Loan> findById(long loanId){
        if (loanMap.containsKey(loanId)){
            return Optional.of(loanMap.get(loanId));
        }
        return Optional.empty();
    }

    public List<Loan> findLoanByMemberId(long memberId){

        return loanMap.values().stream()
                .filter((loan)->{return  loan.getId() == memberId;}).toList();

    }

}
