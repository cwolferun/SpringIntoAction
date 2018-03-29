package com.company;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingBeanController {

    private  static final String helloWorldTemplate = "hello world,%s!";


    @GetMapping("/greeting")
    public String welcome(){
        return "Hello World";
    }
    @GetMapping("/greetingWithParameter/name/{name}")
    public GreetingBean welcomeParam(@PathVariable String name){
        return new GreetingBean(String.format(helloWorldTemplate, name));
    }
    @GetMapping("/greetingWithObject")
    public GreetingBean welcomeWithObject(){
        return new GreetingBean("hey");
    }

}
