package it.thomasiommi.mongocktest;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableMongock
@SpringBootApplication
public class MongockTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongockTestApplication.class, args);
    }

}
