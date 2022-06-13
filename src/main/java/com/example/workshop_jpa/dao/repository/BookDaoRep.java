package com.example.workshop_jpa.dao.repository;

import com.example.workshop_jpa.dao.BookDao;
import com.example.workshop_jpa.entity.Book;
import com.example.workshop_jpa.exception.DataNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class BookDaoRep implements BookDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Book save(Book book) {
        if (book == null) throw new IllegalArgumentException("book was null");
        entityManager.persist(book);
        return book;
    }

    @Override
    public Optional<Book> findById(int id) {
        return Optional.ofNullable(entityManager.find(Book.class, id));
    }

    @Override
    public List<Book> findAll() {
        return entityManager.createQuery("Select b from Book b").getResultList();
    }

    @Override
    public Book update(Book book) {
        findById(book.getId()).orElseThrow(() -> new DataNotFoundException("book not found"));
        return entityManager.merge(book);
    }

    @Override
    public void remove(Book book) {
        findById(book.getId()).orElseThrow(() -> new DataNotFoundException("book not found"));
        entityManager.remove(book);
    }
}
