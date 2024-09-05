package com.example.v0.services;

import com.example.v0.models.BookItem;
import com.example.v0.models.Loan;
import com.example.v0.models.Member;
import com.example.v0.repositories.BookItemRepository;
import com.example.v0.repositories.LoanRepository;
import com.example.v0.repositories.MemberRepository;

import java.util.Optional;
import java.time.LocalDate;

public class LoanService {

    private static final int MAX_DAYS_LIMIT = 10;
    private static final int MAX_LOAN_LIMIT = 5;

    LoanRepository loanRepository;
    MemberRepository memberRepository;
    BookItemRepository bookItemRepository;



    public Loan checkOutBook(long memberId, long bookItemId){

        Optional<Member> memberOptional = memberRepository.findById(memberId);
        if (memberOptional.isEmpty()){
            throw new RuntimeException("Member not exists");
        }
        Member member = memberOptional.get();

        Optional<BookItem> bookItemOptional = bookItemRepository.findByID(bookItemId);
        if (bookItemOptional.isEmpty()){
            throw new RuntimeException("Book not exists");
        }
        BookItem bookItem = bookItemOptional.get();

        // TODO: Check if Member not taken more than 5 loans

        if (loanRepository.findLoanByMemberId(memberId).size() >= MAX_LOAN_LIMIT){
            throw new RuntimeException("Member already loaned  " + loanRepository.findLoanByMemberId(memberId).size() + " books");
        }

        //
        Loan loan = new Loan();

        loan.setMember(member);
        loan.setBookItem(bookItem);

        LocalDate today = LocalDate.now();
        loan.setIssuedDate(today);
        loan.setDueDate(today.plusDays(MAX_DAYS_LIMIT));

        return loanRepository.save(loan);
    }

}
