package com.ustore.uvote;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ustore.uvote.entities.Candidate;
import com.ustore.uvote.repositories.CandidateRepository;
import com.ustore.uvote.repositories.CitizenRepository;

@SpringBootApplication
public class UvoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(UvoteApplication.class, args);
	}

	@Bean
	CommandLineRunner init(CandidateRepository candidateRepository, CitizenRepository citizenRepository) {
		return args -> {
			Stream.of("Ciro Gomes", "Fernando Haddad", "Henrique Meirelles", "Vera", "Jair Bolsonaro").forEach(name -> {
				Candidate candidate = new Candidate(name, 30L, 0);
				candidateRepository.save(candidate);
			});
			candidateRepository.findAll().forEach(System.out::println);
		};
	}

}
