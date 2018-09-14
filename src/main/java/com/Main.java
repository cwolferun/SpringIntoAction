package com;


import com.mymath.Multiplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {


    public static void main(String[] args) {

//    	ApplicationContext context =
                SpringApplication.run(Main.class,args);


//        String[] beanNames = context.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for( String s : beanNames) {
//            System.out.println(s);
//        }

    }

    @Bean
    Multiplication getmul(){
        return new Multiplication();
    }
}
