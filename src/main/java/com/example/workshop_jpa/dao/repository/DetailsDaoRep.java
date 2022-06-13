package com.example.workshop_jpa.dao.repository;

import com.example.workshop_jpa.dao.DetailsDao;
import com.example.workshop_jpa.entity.AppUser;
import com.example.workshop_jpa.entity.Details;
import com.example.workshop_jpa.exception.DataNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class DetailsDaoRep implements DetailsDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Details save(Details details) {
        if(details==null) throw new IllegalArgumentException("details is null");
        entityManager.persist(details);
        return details;
    }

    @Override
    public Optional<Details> findBydId(int id) {
        return Optional.ofNullable(entityManager.find(Details.class,id));
    }

    @Override
    public List<Details> findAll() {
        return entityManager.createQuery("Select d from Details  d").getResultList();
    }

    @Override
    public Details update(Details details) {
        findBydId(details.getId()).orElseThrow(()-> new DataNotFoundException("Details not found"));
        return entityManager.merge(details);
    }

    @Override
    public void remove(Details details) {
        findBydId(details.getId()).orElseThrow(()-> new DataNotFoundException("Details not found"));
        entityManager.remove(details);
    }
}
