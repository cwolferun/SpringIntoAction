package com.company;

import com.Main;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import java.net.URI;
import java.util.Date;
import static org.hamcrest.Matchers.containsString;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TodoControllerIT {


    private static final String LOCAL_HOST = "http://localhost:";

    @LocalServerPort
    private int port;

    private TestRestTemplate template = new TestRestTemplate();

    @Test
    public void retrieveTodoIT() throws Exception{
        String expected = "{id:1,user:Jack,desc:\"Learn Spring MVC\",done:false}";
        ResponseEntity<String> response = template.getForEntity(createURL("/user/Jack.todos/1"),String.class);
        JSONAssert.assertEquals(expected,response.getBody(),false);
    }

    @Test
    public void addTodo() throws Exception{
        Todo todo = new Todo(-1, "Jill", "Learn Hibernate", new Date(), false);
        URI location = template
                .postForLocation(createURL("/users/Jill/todos"),todo);

        Assert.assertThat(location.getPath(),containsString("/users/Jill/todos/4"));
    }



    private String createURL(String uri){
        return  LOCAL_HOST+port+uri;
    }

}
