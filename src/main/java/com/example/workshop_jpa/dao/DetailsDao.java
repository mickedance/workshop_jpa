package com.example.workshop_jpa.dao;

import com.example.workshop_jpa.entity.AppUser;
import com.example.workshop_jpa.entity.Details;

import java.util.List;
import java.util.Optional;

public interface DetailsDao {
    Details save(Details details);
    Optional<Details> findBydId(int id);
    List<Details> findAll();
    Details update(Details details);
    void remove(Details details);
}
