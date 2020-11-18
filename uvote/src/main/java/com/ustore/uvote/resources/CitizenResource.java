package com.ustore.uvote.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ustore.uvote.entities.Citizen;
import com.ustore.uvote.services.CitizenService;

@RestController
@RequestMapping(value = "/citizens")
public class CitizenResource {

	@Autowired
	private CitizenService service;
	
	@GetMapping
	public ResponseEntity<List<Citizen>> findAll() {
		List<Citizen> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Citizen> findById(@PathVariable int id) {
		Citizen obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Citizen> insert(@RequestBody Citizen obj) {
		List<Long> citizens = service.findAll().stream().map(person -> person.getTituloEleitoral()).collect(Collectors.toList());
		
		for (Long tituloEleitoral : citizens) {
			if(obj.getTituloEleitoral().equals(tituloEleitoral)) {
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
	public ResponseEntity<Citizen> update(@PathVariable int id, @RequestBody Citizen obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
