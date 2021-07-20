package com.example.labspringboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.*;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

@RestController
/*@SpringBootApplication(exclude ={
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
})*/

@SpringBootApplication(scanBasePackages = { "com.example.labspringboot.*" })
@ComponentScan({ "com.example.labspringboot.controller","com.example.labspringboot.repository", "com.example.labspringboot.service" } )
@EntityScan("com.example.labspringboot.domain")
@EnableJpaRepositories("com.example.labspringboot.repository")
public class IntelliJApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntelliJApplication.class, args);
    }

    @GetMapping("/greet")
    //metodo de saludar, eso quiere decir greet
    public String greet(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

}
