package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;

@SpringBootApplication
@RestController
public class DemoApplication<OrderService> {
    @Autowired
    OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/ordersAll")
    public ResponseEntity<Object> getOrder() {
        return new ResponseEntity<>(orderService.getOrders(), HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity<Object>  createOrder(@RequestParam(value = "clientID") int clientID, @RequestParam(value = "number") int number) {
        orderService.createOrder(clientID, number);
        return new ResponseEntity<>("Order is created successsfully", HttpStatus.OK);
    }

    @DeleteMapping("/order")
    public ResponseEntity<Object>  deleteOrder(@RequestParam(value = "dountID") int dountID) {
        orderService.deleteOrder(dountID);
        return new ResponseEntity<>("Order is created successsfully", HttpStatus.OK);
    }

}
