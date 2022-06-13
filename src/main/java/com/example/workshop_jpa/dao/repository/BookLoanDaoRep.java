package com.example.workshop_jpa.dao.repository;

import com.example.workshop_jpa.dao.BookLoanDao;
import com.example.workshop_jpa.entity.BookLoan;
import com.example.workshop_jpa.exception.DataNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class BookLoanDaoRep implements BookLoanDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BookLoan save(BookLoan bookLoan) {
        if (bookLoan == null) throw new IllegalArgumentException("bookLoan was null");
        entityManager.persist(bookLoan);
        return bookLoan;
    }

    @Override
    public Optional<BookLoan> findById(int id) {
        return Optional.ofNullable(entityManager.find(BookLoan.class, id));
    }

    @Override
    public List<BookLoan> findAll() {
        
        return  entityManager.createQuery("Select bl from BookLoan  bl").getResultList();
    }

    @Override
    public BookLoan update(BookLoan bookLoan) {
        findById(bookLoan.getId()).orElseThrow(() -> new DataNotFoundException("bookLoan not found"));
        return entityManager.merge(bookLoan);
    }

    @Override
    public void delete(BookLoan bookLoan) {
        findById(bookLoan.getId()).orElseThrow(() -> new DataNotFoundException("bookLoan not found"));
        entityManager.remove(bookLoan);
    }
}
