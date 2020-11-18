package com.ustore.uvote.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Long votes;
	private int candidateNumber;

	public Candidate() {
		super();
	}
	
	public Candidate(String name, Long votes, int candidateNumber) {
		super();
		this.name = name;
		this.votes = votes;
		this.candidateNumber = candidateNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getVotes() {
		return votes;
	}

	public void setVotes(Long votes) {
		this.votes = votes;
	}

	public int getCandidateNumber() {
		return candidateNumber;
	}

	public void setCandidateNumber(int candidateNumber) {
		this.candidateNumber = candidateNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidate other = (Candidate) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Citizen [id=" + id + ", name=" + name + ", votes=" + votes + ", candidateNumber=" + candidateNumber
				+ "]";
	}

}
