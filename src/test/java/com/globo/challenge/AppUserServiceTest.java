package com.globo.challenge;

import com.globo.challenge.models.AppUser;
import com.globo.challenge.repository.AppUserInMemRepository;
import com.globo.challenge.repository.AppUserRepository;
import com.globo.challenge.services.AppUserService;
import com.globo.challenge.services.impl.AppUserServiceImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppUserServiceTest {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private AppUserRepository appUserRepository;

    private static AppUser testUsr;

    private static boolean setUpIsDone = false;

    @Before
    public void setup(){
        if (!setUpIsDone) {
            String username = "ServiceTestUser";

            testUsr = new AppUser();
            testUsr.setUsername(username);
            testUsr.setPassword("1234");

            appUserRepository.save(testUsr);

            setUpIsDone = true;
        }

    }

    @Test
    public void testGetUserByUsername() {

        AppUser usr = appUserService.getUserByUsername(testUsr.getUsername());

        assertThat(usr.getPassword()).isEqualTo(testUsr.getPassword());
        assertThat(usr.getUsername()).isEqualTo(testUsr.getUsername());

    }

    @Test
    public void testSetStatus() {

        String status = "TestStatus";

        appUserService.setUserStatus(testUsr.getUsername(), status);


        AppUser usr = appUserService.getUserByUsername(testUsr.getUsername());

        assertThat(usr.getStatus()).isEqualTo(status);

    }





}