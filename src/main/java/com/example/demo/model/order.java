package com.example.demo.model;

public class Order {
    private int id;
    private int clientID;
    private int number;

    public Order(int clientID, int number) {
        this. number = number;
        this.clientID = clientID;
    }

    public int getId() {
        return id;
    }

    public int getClientID() {
        return clientID;
    }

    public int getNumber() {
        return number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
