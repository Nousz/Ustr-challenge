package com.ustore.uvote.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ustore.uvote.entities.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer> {

}
