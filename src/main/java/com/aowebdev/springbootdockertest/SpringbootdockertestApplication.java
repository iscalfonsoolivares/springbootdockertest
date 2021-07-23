package com.aowebdev.springbootdockertest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@RestController
public class SpringbootdockertestApplication {

    @Autowired
    private DispatcherServlet servlet;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdockertestApplication.class, args);
	}

	@GetMapping("/api/v2/hello")
    public String hello() {
                 return "Hello world !!, this is awesome.";
        }

    @Bean
    public CommandLineRunner getCommandLineRunner(ApplicationContext context) {
        servlet.setThrowExceptionIfNoHandlerFound(true);
        return args -> {};
    }
}
