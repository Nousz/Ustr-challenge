package com.ustore.uvote.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ustore.uvote.entities.Candidate;
import com.ustore.uvote.entities.Citizen;
import com.ustore.uvote.services.CandidateService;

@RestController
@RequestMapping(value = "/candidates")
@CrossOrigin(origins = "http://localhost:4200")
public class CandidateResource {
	@Autowired
	private CandidateService service;

	@GetMapping
	public ResponseEntity<List<Candidate>> findAll() {
		List<Candidate> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/category/{category}")
	public ResponseEntity<List<Candidate>> findAllByCategory(@PathVariable String category) {
		List<Candidate> list = service.findAll().stream().filter(person -> person.getCategory().equals(category)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Candidate> findById(@PathVariable int id) {
		Candidate obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Candidate> insert(@RequestBody Candidate obj) {
		List<Integer> candidate = service.findAll().stream().map(person -> person.getCandidateNumber()).collect(Collectors.toList());
		
		for (Integer integer : candidate) {
			if(obj.getCandidateNumber() == integer || obj.getCategory() == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(obj);
			}
		}
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Candidate> update(@PathVariable int id, @RequestBody Candidate obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}