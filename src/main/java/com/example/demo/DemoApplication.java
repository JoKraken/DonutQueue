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
public class DemoApplication {

    @Autowired
    OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/ordersAll")
    public ResponseEntity<Object> getOrder() {
        return new ResponseEntity<>(orderService.getOrders(), HttpStatus.OK);
    }
    @GetMapping("/ordersPrio")
    public ResponseEntity<Object> getOrdersPrio() {
        return new ResponseEntity<>(orderService.getOrdersPrio(), HttpStatus.OK);
    }
    @GetMapping("/ordersNormal")
    public ResponseEntity<Object> getOrdersNormal() {
        return new ResponseEntity<>(orderService.getOrdersNormal(), HttpStatus.OK);
    }
    @GetMapping("/nextPickup")
    public ResponseEntity<Object> getNextPickup() {
        return new ResponseEntity<>(orderService.getNextPickup(), HttpStatus.OK);
    }
    @GetMapping("/getWait")
    public ResponseEntity<Object> getWait(@RequestParam(value = "clientID") int clientID) {
        return new ResponseEntity<>(orderService.getWait(clientID), HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity<Object> createOrder(@RequestParam(value = "clientID") int clientID, @RequestParam(value = "number") int number) {
        orderService.createOrder(clientID, number);
        return new ResponseEntity<>("Order is created successsfully", HttpStatus.OK);
    }

    @GetMapping("/deleteOrder")
    public ResponseEntity<Object> deleteOrderGet(@RequestParam(value = "clientID") int clientID) {
        if(orderService.deleteOrder(clientID) == 200){
            return new ResponseEntity<>("Order is deleted successsfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Order is deleted unsuccesssfully", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/order")
    public ResponseEntity<Object> deleteOrder(@RequestParam(value = "clientID") int clientID) {
        if(orderService.deleteOrder(clientID) == 200){
            return new ResponseEntity<>("Order is deleted successsfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Order is deleted unsuccesssfully", HttpStatus.NOT_FOUND);
        }
    }

}
