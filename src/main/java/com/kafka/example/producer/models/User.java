package com.kafka.example.producer.models;

public class User {

    String name;
    int id;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }





}