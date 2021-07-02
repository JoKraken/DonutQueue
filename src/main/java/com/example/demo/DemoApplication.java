package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/ordersAll")
    public String getOrder() {
        return String.format("getOrder!");
    }

    @PostMapping("/order")
    public String createOrder(@RequestParam(value = "clientID") int clientID, @RequestParam(value = "number") int number) {
        return String.format("Hello %s! number: %s", clientID, number);
    }

}
