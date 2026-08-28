package main.java.domain;

import java.util.UUID;

public class Account{
    private final String id = UUID.randomUUID().toString();
    private final String name;

    public Account(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }
}