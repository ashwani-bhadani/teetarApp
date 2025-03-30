package com.teetar.teetarApp;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.teetar.teetarApp.model.Role;
import com.teetar.teetarApp.model.TeetarUser;
import com.teetar.teetarApp.repository.RoleRepository;
import com.teetar.teetarApp.service.UserService;

@SpringBootApplication
public class TeetarAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeetarAppApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(RoleRepository roleRepo, UserService userService) {
		return args -> {
			long randomId = (long) (Math.random()*100) +1;
			roleRepo.save(new Role("TUSER11"));
			
			TeetarUser user = new  TeetarUser();
			user.setUserId(34L);
			user.setFirstName("Vikram" + randomId);
			user.setLastName("Sood");
			user.setEmailId("prakash"+randomId+ "@fakemail.com");
			user.setPhoneNum("3787987890");
			user.setDateOfBirth(LocalDate.now().minusYears(randomId));
			user.setUsername(randomId +"poppyPrakash"+ randomId);
			
			userService.registerUser(user);
			
		};
	}

}
