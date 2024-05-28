package org.example.adoptionsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AdoptionSbApplication {

    public static void main(String[] args) {
        SpringApplication springApp = new SpringApplication(AdoptionSbApplication.class);

        springApp.run(args);
    }
}
