package com.example.demo.service;

import java.util.Collection;
import java.util.Map;
import com.example.demo.model.Order;

public interface OrderService {

    public void addOrder(int clientID, int number);
    public void deleteOrder(int id);
    public Collection<Order> getOrders();

}
