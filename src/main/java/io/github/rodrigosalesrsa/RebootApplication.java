package io.github.rodrigosalesrsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RebootApplication {
    @GetMapping("/hello")
    public String helloWold(){
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(RebootApplication.class, args);
    }
}
