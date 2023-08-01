package com.home.andmark.firstrestapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.home.andmark.firstrestapp.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
}
