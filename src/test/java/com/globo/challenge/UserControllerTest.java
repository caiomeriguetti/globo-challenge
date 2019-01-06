package com.globo.challenge;

import com.globo.challenge.controllers.UserController;
import com.globo.challenge.models.AppUser;
import com.globo.challenge.repository.AppUserRepository;
import com.globo.challenge.services.AppUserService;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    AppUserService appUserService;

    @Test
    public void testGetUserByUsername() throws Exception {

        String username = "ControllerTestUser";
        String password = "ControllerTestPass";
        String status = "ControllerTestStatus";

        AppUser usr = new AppUser();
        usr.setUsername(username);
        usr.setPassword(password);

        appUserRepository.save(usr);

        appUserService.setUserStatus(username, status);

        ResultActions result = this.mockMvc.perform(get("/api/user/" + username)
        .header("Authorization", "Basic Y2FpbzoxMjM0"));
        MvcResult res = result.andReturn();
        String contentAsString = res.getResponse().getContentAsString();

        JSONObject obj = new JSONObject(contentAsString);

        assertThat(obj.getString("username")).isEqualTo(username);
        assertThat(obj.getString("password")).isEqualTo(password);
        assertThat(obj.getString("status")).isEqualTo(status);


    }

}
