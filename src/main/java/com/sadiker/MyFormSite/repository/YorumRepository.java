package com.sadiker.MyFormSite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sadiker.MyFormSite.models.Yorum;

@Repository
public interface YorumRepository  extends JpaRepository<Yorum,Long> {
    
}
