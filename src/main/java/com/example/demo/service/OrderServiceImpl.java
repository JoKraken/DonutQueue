package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    private static Map<String, Order> orderRepo = new HashMap<>();

    @Override
    public void createOrder(int clientID, int number){
        Order newOrder = new Order(clientID, number);
    }

    @Override
    public void deleteOrder(int id){
        orderRepo.remove(id);
    }

    @Override
    public Collection<Order> getOrders(){
        return orderRepo.values();
    }
}
