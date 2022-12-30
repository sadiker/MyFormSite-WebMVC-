package com.sadiker.MyFormSite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sadiker.MyFormSite.models.Issue;

@Repository
public interface IssueRepository extends JpaRepository<Issue,Long> {
    
}
