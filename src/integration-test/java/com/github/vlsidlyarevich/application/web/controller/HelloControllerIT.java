package com.github.vlsidlyarevich.application.web.controller;

import com.github.vlsidlyarevich.application.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * {@link HelloController} integration test.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration
public class HelloControllerIT {

    @Value("${test.id-token}")
    private String idToken;
    @Value("${security.jwt.auth-header-name}")
    private String authHeaderName;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        this.mvc = webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void sayHello_Success_IfTokenIsValid() throws Exception {
        mvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/api/v1/hello")
                .header(authHeaderName, idToken))
                .andExpect(status().isOk())
                .andExpect(content().string("secured hello"));
    }

    @Test
    public void sayHello_AccessDenied_IfTokenIsEmpty() throws Exception {
        mvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/api/v1/hello")
                .header(authHeaderName, ""))
                .andExpect(status().isForbidden());
    }

    @Test
    public void sayHello_AccessDenied_IfTokenIsInvalid() throws Exception {
        mvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/api/v1/hello")
                .header(authHeaderName, idToken + "invalidness"))
                .andExpect(status().isForbidden());
    }
}
