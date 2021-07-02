package com.example.demo.service;

import com.example.demo.model.Order;
import java.util.Collection;

public interface OrderService {
    public abstract void createOrder(int clientID, int number);
    public abstract int deleteOrder(int id);
    public abstract String getWait(int clientID);
    public abstract Collection<Order> getOrders();
    public abstract Collection<Order> getOrdersPrio();
    public abstract Collection<Order> getOrdersNormal();
    public abstract Collection<Order> getNextPickup();

}
