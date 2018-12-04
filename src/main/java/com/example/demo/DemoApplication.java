package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("Eray","yıldırım","(555)-55-55"));
		userRepository.save(new User("Eray1","yıldırım1","(555)-55-55"));
		userRepository.save(new User("Eray2","yıldırım1","(555)-55-55"));
		userRepository.save(new User("Eray3","yıldırım1","(555)-55-55"));
		userRepository.save(new User("Eray4","yıldırım1","(555)-55-55"));
		userRepository.save(new User("Eray5","yıldırım2","(555)-55-55"));
		userRepository.save(new User("Eray6","yıldırım3","(555)-55-55"));


	}
}
