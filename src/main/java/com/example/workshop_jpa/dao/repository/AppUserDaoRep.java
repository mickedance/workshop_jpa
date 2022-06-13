package com.example.workshop_jpa.dao.repository;

import com.example.workshop_jpa.dao.AppUserDao;
import com.example.workshop_jpa.entity.AppUser;
import com.example.workshop_jpa.exception.DataNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class AppUserDaoRep implements AppUserDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public AppUser save(AppUser appUser) {
        if(appUser==null) throw new IllegalArgumentException("appUser was null");
        entityManager.persist(appUser);
        return appUser;
    }

    @Override
    public Optional<AppUser> findById(int id) {
        return Optional.ofNullable(entityManager.find(AppUser.class, id));
    }

    @Override
    public List<AppUser> findAll() {
        return entityManager.createQuery("Select a from AppUser a").getResultList();
    }

    @Override
    public AppUser update(AppUser appUser) {
        findById(appUser.getId()).orElseThrow(()-> new DataNotFoundException("AppUser not found"));
        return entityManager.merge(appUser);
    }

    @Override
    public void remove(AppUser appUser) {
        findById(appUser.getId()).orElseThrow(()-> new DataNotFoundException("AppUser not found"));
        entityManager.remove(appUser);
    }
}
