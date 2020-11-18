package com.ustore.uvote.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.ustore.uvote.entities.Citizen;
import com.ustore.uvote.repositories.CitizenRepository;
import com.ustore.uvote.services.exceptions.DatabaseException;
import com.ustore.uvote.services.exceptions.ResourceNotFoundException;

@Service
public class CitizenService {

	@Autowired
	CitizenRepository repository;;

	public List<Citizen> findAll() {
		return repository.findAll();
	}

	public Citizen findById(int id) {
		Optional<Citizen> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Citizen insert(Citizen obj) {
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

	public Citizen update(int id, Citizen obj) {
		try {
			Citizen entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Citizen entity, Citizen obj) {
		entity.setName(obj.getName());
		entity.setHasVoted(obj.getHasVoted());
		entity.setTituloEleitoral(obj.getTituloEleitoral());
	}
}
