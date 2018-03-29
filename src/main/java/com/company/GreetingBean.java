package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class GreetingBean {

    private String message;

    GreetingBean(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
