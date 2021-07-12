package com.aowebdev.springbootdockertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootdockertestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdockertestApplication.class, args);
	}

        @GetMapping("/api/v2/hello")
        public String hello() {
                 return "Hello world !!, this is awesome.";
        }

}
