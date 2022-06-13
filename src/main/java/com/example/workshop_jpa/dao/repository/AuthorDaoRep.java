package com.example.workshop_jpa.dao.repository;

import com.example.workshop_jpa.dao.AuthorDao;
import com.example.workshop_jpa.entity.Author;
import com.example.workshop_jpa.exception.DataNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
@Repository
public class AuthorDaoRep implements AuthorDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Author save(Author author) {
        if(author==null) throw new IllegalArgumentException("author was null");
        entityManager.persist(author);
        return author;
    }

    @Override
    public Optional<Author> findBydId(int id) {
        return Optional.ofNullable(entityManager.find(Author.class, id));
    }

    @Override
    public List<Author> findAll() {
        return entityManager.createQuery("Select a from Author a").getResultList();
    }

    @Override
    public Author update(Author author) {
        findBydId(author.getId()).orElseThrow(()-> new DataNotFoundException("author not found"));
        return entityManager.merge(author);
    }

    @Override
    public void delete(Author author) {
        findBydId(author.getId()).orElseThrow(()-> new DataNotFoundException("author not found"));
        entityManager.remove(author);
    }
}
