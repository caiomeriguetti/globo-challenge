package com.globo.challenge;

import com.globo.challenge.models.AppUserInMemory;
import com.globo.challenge.repository.AppUserInMemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppUserInMemoryRepositoryTest {

    @Autowired
    AppUserInMemRepository repo;

    @Test
    public void testGetAndSetStatus() {

        AppUserInMemory usr = new AppUserInMemory();
        usr.setId("UserId");
        usr.setStatus("Blocked");

        repo.save(usr);

        Optional<AppUserInMemory> foundUser = repo.findById("UserId");

        assertThat(foundUser.isPresent()).isEqualTo(true);
        assertThat(foundUser.get().getId()).isEqualTo("UserId");
        assertThat(foundUser.get().getStatus()).isEqualTo("Blocked");

    }
}

