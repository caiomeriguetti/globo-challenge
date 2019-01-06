package com.globo.challenge;

import com.globo.challenge.models.AppUser;
import com.globo.challenge.repository.AppUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppUserRepositoryTest {

	@Autowired
	AppUserRepository repo;

	@Test
	public void testUserCreation() {

		AppUser usr = new AppUser();
		usr.setUsername("joao");
		usr.setPassword("1234");
		repo.save(usr);

		AppUser foundUser = repo.findByUsername("joao");

		assertThat(foundUser.getPassword()).isEqualTo("1234");
		assertThat(foundUser.getUsername()).isEqualTo("joao");

	}
}

