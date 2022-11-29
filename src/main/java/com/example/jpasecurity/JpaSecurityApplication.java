package com.example.jpasecurity;

import com.example.jpasecurity.model.Post;
import com.example.jpasecurity.model.User;
import com.example.jpasecurity.repository.PostRepository;
import com.example.jpasecurity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JpaSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaSecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PostRepository postRepository, UserRepository userRepository, PasswordEncoder passwordEncoder){
		return args -> {
			userRepository.save(new User("user", passwordEncoder.encode("pass"), "ROLE_USER"));
			userRepository.save(new User("admin", passwordEncoder.encode("pass"), "ROLE_USER,ROLE_ADMIN"));
			postRepository.save(new Post("Title", "tittle-slug", "Welcome to our blog", "Michael B Jordan"));
		};
	}
}
