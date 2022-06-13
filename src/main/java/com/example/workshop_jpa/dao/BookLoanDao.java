package com.example.workshop_jpa.dao;

import com.example.workshop_jpa.entity.BookLoan;

import java.util.List;
import java.util.Optional;

public interface BookLoanDao {
    BookLoan save(BookLoan bookLoan);
    Optional<BookLoan> findById(int id);
    List<BookLoan> findAll();
    BookLoan update(BookLoan bookLoan);
    void delete(BookLoan bookLoan);
}
