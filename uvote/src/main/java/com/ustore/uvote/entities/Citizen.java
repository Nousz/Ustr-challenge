package com.ustore.uvote.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Citizen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Long tituloEleitoral;
	private Boolean hasVoted;

	public Citizen() {
		super();
	}

	public Citizen(String name, Long tituloEleitoral, Boolean hasVoted) {
		super();
		this.name = name;
		this.tituloEleitoral = tituloEleitoral;
		this.hasVoted = hasVoted;
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

	public Long getTituloEleitoral() {
		return tituloEleitoral;
	}

	public void setTituloEleitoral(Long tituloEleitoral) {
		this.tituloEleitoral = tituloEleitoral;
	}

	public Boolean getHasVoted() {
		return hasVoted;
	}

	public void setHasVoted(Boolean hasVoted) {
		this.hasVoted = hasVoted;
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
		Citizen other = (Citizen) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", tituloEleitoral=" + tituloEleitoral + ", hasVoted="
				+ hasVoted + "]";
	}

}
