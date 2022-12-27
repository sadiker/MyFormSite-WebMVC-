package com.sadiker.MyFormSite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sadiker.MyFormSite.models.Konu;

@Repository
public interface KonuRepository extends JpaRepository<Konu,Long> {
    
}
