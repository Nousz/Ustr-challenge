package com.ustore.uvote;

import java.util.Arrays;
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
			Candidate candidate0 = new Candidate("Ciro Gomes", 0L, 10, "Presidente");
			Candidate candidate1 = new Candidate("Fernando Haddad", 0L, 20, "Presidente");
			Candidate candidate2 = new Candidate("Henrique Meirelles", 0L, 30, "Presidente");
			Candidate candidate3 = new Candidate("Jair Bolsonaro", 0L, 40, "Presidente");
			Candidate candidate4 = new Candidate("Vera", 0L, 50, "Presidente");
			Candidate candidate5 = new Candidate("Pedro", 0L, 5050, "Senadores");
			Candidate candidate6 = new Candidate("Maria", 0L, 5030, "DeputadosFederais");
			Candidate candidate7 = new Candidate("Carlos", 0L, 5020, "Governadores");
			Candidate candidate8 = new Candidate("Gabriel", 0L, 5010, "DeputadosEstaduais");
			candidateRepository.saveAll(Arrays.asList(candidate0, candidate1, candidate2, candidate3, candidate4, candidate5, candidate6, candidate7, candidate8));
			candidateRepository.findAll().forEach(System.out::println);
		};
	}

}
