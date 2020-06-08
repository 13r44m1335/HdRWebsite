package com.example.taskr0676600;

import com.example.taskr0676600.domain.model.Subtask;
import com.example.taskr0676600.domain.model.Task;

import com.example.taskr0676600.domain.model.User;
import com.example.taskr0676600.domain.model.UserRole;
import com.example.taskr0676600.repository.TaskRepository;

import com.example.taskr0676600.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.time.Month;


@SpringBootApplication
public class TaskR0676600Application {

	public static void main(String[] args) {
		SpringApplication.run(TaskR0676600Application.class, args);
	}

	@Bean
	CommandLineRunner Runner(TaskRepository repository, UserRepository userRepository){


		return args -> {
			repository.save(new Task("Ip-minor taak",
				"maken van een takenlijst",
				LocalDateTime.of(2020, Month.MAY,31,23,45), new Subtask("Story 1","As a user\n" +
					"I can retrieve all tasks\n" +
					"So that I can see what I have left to do\n")));


			repository.save(new Task("Mobiele toepassingen taak",
					"maken van een finance app",
					LocalDateTime.of(2020, Month.JUNE,2,9,30)));

			userRepository.save(new User("admin", passwordEncoder().encode("t"), UserRole.ADMIN));
			userRepository.save(new User("user", passwordEncoder().encode("t"), UserRole.USER));

		};
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}
