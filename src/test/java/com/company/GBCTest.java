package com.company;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GreetingBeanController.class)
public class GBCTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void greetingTest() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/greeting")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        "Hello World"));

    }

    @Test
    public void greetingObjectTest() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/greetingWithObject")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(
                        "Hello World")));

    }

    @Test
    public void greetingWithParams() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/greetingWithParameter/name/Victor")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(
                        "hello world,Victor!")));

    }

}
