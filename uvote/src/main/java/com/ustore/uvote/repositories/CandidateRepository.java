package com.ustore.uvote.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ustore.uvote.entities.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

}
