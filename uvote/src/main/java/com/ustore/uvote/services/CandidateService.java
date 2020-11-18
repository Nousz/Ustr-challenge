package com.ustore.uvote.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ustore.uvote.entities.Candidate;
import com.ustore.uvote.repositories.CandidateRepository;
import com.ustore.uvote.services.exceptions.DatabaseException;
import com.ustore.uvote.services.exceptions.ResourceNotFoundException;

@Service
public class CandidateService {
	@Autowired
	CandidateRepository repository;;

	public List<Candidate> findAll() {
		return repository.findAll();
	}

	public Candidate findById(int id) {
		Optional<Candidate> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Candidate insert(Candidate obj) {
		return repository.save(obj);
	}

	public void delete(int id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Candidate update(int id, Candidate obj) {
		try {
			Candidate entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		} catch(ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Candidate entity, Candidate obj) {
		entity.setName(obj.getName());
		entity.setCandidateNumber(obj.getCandidateNumber());
		entity.setVotes(obj.getVotes());
	}
}
