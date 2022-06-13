package com.example.workshop_jpa.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class BookLoan {
    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private AppUser borrower;
    @Column(nullable = false)
    private LocalDate loanDate;
    @Column(nullable = false)
    private LocalDate dueDate;
    private boolean returned;
    @ManyToOne
    @Column(nullable = false)
    private Book book;

    public BookLoan() {
    }

    public BookLoan(AppUser borrower, LocalDate loanDate, LocalDate dueDate, boolean returned, Book book) {
        this.borrower = borrower;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returned = returned;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AppUser getBorrower() {
        return borrower;
    }

    public void setBorrower(AppUser borrower) {
        this.borrower = borrower;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookLoan bookLoan = (BookLoan) o;
        return id == bookLoan.id && returned == bookLoan.returned && borrower.equals(bookLoan.borrower) && loanDate.equals(bookLoan.loanDate) && dueDate.equals(bookLoan.dueDate) && book.equals(bookLoan.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, borrower, loanDate, dueDate, returned, book);
    }

    @Override
    public String toString() {
        return "BookLoan{" +
                "id=" + id +
                ", borrower=" + borrower +
                ", loanDate=" + loanDate +
                ", dueDate=" + dueDate +
                ", returned=" + returned +
                ", book=" + book +
                '}';
    }
}
