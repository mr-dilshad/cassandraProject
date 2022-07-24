package com.example.cassandra;

import com.example.cassandra.entity.Vet;
import com.example.cassandra.repository.VetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

@SpringBootApplication
@Slf4j
public class CassandraApplication {

	public static void main(String[] args) {
		SpringApplication.run(CassandraApplication.class, args);
	}

	@Bean
	public CommandLineRunner ctl(VetRepository vetRepository){
		return args -> {
			vetRepository.deleteAll();

			Vet john = new Vet(UUID.randomUUID(), "John", "Doe", new HashSet<String>(Arrays.asList("surgery")));
			Vet jane = new Vet(UUID.randomUUID(), "Jane", "Doe", new HashSet<String>(Arrays.asList("radiology, surgery")));

			Vet savedJohn = vetRepository.save(john);
			Vet savedJane = vetRepository.save(jane);

			vetRepository.findAll()
					.forEach(v -> log.info("Vet: {}", v.getFirstName()));

			vetRepository.findById(savedJohn.getId())
					.ifPresent(v -> log.info("Vet by id: {}", v.getFirstName()));

		};
	}
}
