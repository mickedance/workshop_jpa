package com.example.workshop_jpa.dao;

import com.example.workshop_jpa.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    Author save(Author author);
    Optional<Author> findBydId(int id);
    List<Author> findAll();
    Author update(Author author);
    void delete(Author author);
}
