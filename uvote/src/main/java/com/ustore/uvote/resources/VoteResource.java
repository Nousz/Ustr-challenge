package com.ustore.uvote.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ustore.uvote.entities.Candidate;
import com.ustore.uvote.entities.Citizen;
import com.ustore.uvote.services.CandidateService;
import com.ustore.uvote.services.CitizenService;

@RestController
@RequestMapping(value = "/vote")
@CrossOrigin(origins = "http://localhost:4200")
public class VoteResource {

	@Autowired
	private CitizenService citizenService;
	
	@Autowired
	private CandidateService candidateService;
	
	@PutMapping(value = "/{citizenId}/{candidateId}")
	public ResponseEntity<Object> update(@PathVariable int candidateId, @PathVariable int citizenId ) {
		Candidate candidate = candidateService.findById(candidateId);
		Citizen citizen = citizenService.findById(citizenId);
		
		if(!citizen.getHasVoted()) {
			
			candidate.setVotes(candidate.getVotes()+1);
			candidateService.update(candidateId, candidate);
			
			citizen.setHasVoted(true);
			citizenService.update(citizenId, citizen);
			return ResponseEntity.ok().body(candidate);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(citizen);
		}
	}
}
