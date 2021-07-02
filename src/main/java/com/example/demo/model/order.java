package com.example.demo.model;

public class Order {
    private int id;
    private int clientID;
    private int number;
    private int wait;

    public Order(int id, int clientID, int number) {
        this.id = id;
        this.number = number;
        this.clientID = clientID;
    }

    public int getWait() {
        return wait;
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

    public void setWait(int wait) {
        this.wait = wait;
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
