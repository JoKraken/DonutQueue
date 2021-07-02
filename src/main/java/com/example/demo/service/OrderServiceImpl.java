package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class OrderServiceImpl implements OrderService {
    private static Map<Integer, Order> orderRepoNormal = new HashMap<>();
    private static Map<Integer, Order> orderRepoPrio = new HashMap<>();
    private static Integer lastId = 0;

    @Override
    public void createOrder(int clientID, int number){
        Order newOrder;
        if(clientID >= 1000){
            newOrder = new Order(lastId, clientID, number);
            newOrder.setWait(getWaitTime());
            orderRepoNormal.put(newOrder.getId(), newOrder);
        } else {
            newOrder = new Order(lastId, clientID, number);
            newOrder.setWait(getWaitTime());
            orderRepoPrio.put(newOrder.getId(), newOrder);
        }
        lastId = lastId +1;
    }

    public Integer getWaitTime(){
        int time = 1;
        int count = 0;
        for(Order value : orderRepoPrio.values()){
            System.out.println(value.getNumber());
            if(count + value.getNumber() <= 50) {
                count = count + value.getNumber();
            } else {
                time++;
                count = value.getNumber();
            }
        }
        for(Order value : orderRepoNormal.values()){
            System.out.println(value.getNumber());
            if(count + value.getNumber() <= 50) {
                count = count + value.getNumber();
            } else {
                time++;
                count = value.getNumber();
            }
        }
        return time*5;
    }

    @Override
    public String getWait(int clientID){
        int count = 0;
        for(Order value : orderRepoPrio.values()){
            count++;
            if(value.getClientID() == clientID) {
                return "place: "+ count + ", wait " + value.getWait() + " min";
            }
        }
        for(Order value : orderRepoNormal.values()){
            count++;
            if(value.getClientID() == clientID) {
                return "place: "+ count + ", wait " + value.getWait() + " min";
            }
        }
        return "Order can not be found";
    }

    @Override
    public int deleteOrder(int id){
        AtomicReference<Integer> key = new AtomicReference<>(0);
        orderRepoPrio.forEach((k, v) -> {
            System.out.println(v.getClientID());
            if(v.getClientID() == id) key.set(k);
        });
        if(key.get() != 0) {
            orderRepoPrio.remove(key.get());
            return 200;
        }
        orderRepoNormal.forEach((k, v) -> {
            System.out.println(v.getClientID());
            if(v.getClientID() == id) key.set(k);
        });
        if(key.get() != 0) {
            orderRepoNormal.remove(key.get());
            return 200;
        }
        System.out.println(key.get());
        return 404;
    }

    @Override
    public Collection<Order> getOrders(){
        Map<Integer, Order> all = new HashMap<>();
        all.putAll(orderRepoNormal);
        all.putAll(orderRepoPrio);
        return all.values();
    }

    @Override
    public Collection<Order> getOrdersPrio(){
        return orderRepoPrio.values();
    }

    @Override
    public Collection<Order> getOrdersNormal(){
        return orderRepoNormal.values();
    }

    @Override
    public Collection<Order> getNextPickup(){
        Map<Integer, Order> nextPickup = new HashMap<>();
        int id = 1;

        for(Order value : orderRepoPrio.values()){
            System.out.println(value.getNumber());
            if(value.getWait() == 5) {
                nextPickup.put(id, value);
                id++;
            }
            value.setWait(value.getWait()-5);
        }
        orderRepoPrio.values().removeIf(val -> val.getWait() == 0);
        for(Order value : orderRepoNormal.values()){
            System.out.println(value.getNumber());
            if(value.getWait() == 5) {
                nextPickup.put(id, value);
                id++;
            }
            value.setWait(value.getWait()-5);
        }
        orderRepoNormal.values().removeIf(val -> val.getWait() == 0);
        return nextPickup.values();
    }
}
