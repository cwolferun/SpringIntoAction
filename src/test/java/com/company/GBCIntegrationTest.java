package com.company;

import org.junit.Assert;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.Matchers.containsString;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GBCIntegrationTest {
    private static final String LOCAL_HOST = "http://localhost:";

    @LocalServerPort
    private int port;

    private TestRestTemplate template = new TestRestTemplate();

    @Test
    public void welcome() throws Exception{
        ResponseEntity<String> response = template
                .getForEntity(createURL("/greeting"),String.class);
        Assert.assertThat(response.getBody(),is(equalTo("Hello World")));
    }
    @Test
    public void welcomeWithObject() throws Exception{
        ResponseEntity<String> response = template
                .getForEntity(createURL("/greetingWithObject"),String.class);
        Assert.assertThat(response.getBody(),containsString("hey"));
    }

    @Test
    public void welcomeWithParams() throws Exception{
        ResponseEntity<String> response = template
                .getForEntity(createURL("/greetingWithParameter/name/Victor"),String.class);
        Assert.assertThat(response.getBody(),containsString("hello"));
    }

    private String createURL(String uri){
        return  LOCAL_HOST+port+uri;
    }
}
