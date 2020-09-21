package com.eureka.user.controller;

import com.eureka.user.entities.User;
import com.eureka.user.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RideControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Autowired
    UserRepository userRepository;

    private User user;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);

        user = new User();
        user.setId(0L);
        user.setAddress("test");
        user.setEmailAddress("test");
        user.setMerchantName("test");
        user.setMerchantType("test");
        user.setOwnerName("test");
        user.setPassword("test");
        user.setPhoneNumber("test");
    }

    @Test
    public void testPersonShouldBeRegistered() throws Exception {
        HttpEntity<Object> user = getHttpEntity(
                "{\"merchantType\": \"test\", \"merchantName\": \"test\"," +
                        " \"ownerName\": \"test\", \"address\": \"test\"," +
                        " \"phoneNumber\": \"test\", \"emailAddress\": \"test\"," +
                        " \"password\": \"test\"}");
        ResponseEntity<User> response = template.postForEntity("/api/user", user, User.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    private HttpEntity<Object> getHttpEntity(Object body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<Object>(body, headers);
    }

}
