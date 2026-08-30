package main.java.domain;

import java.math.BigDecimal;

public class Entry {

    private final  Account account;
    private final Direction direction;
    private final BigDecimal amount;

    public Entry(Account account, Direction direction, BigDecimal amount){
        if(amount.compareTo(BigDecimal.ZERO) <= 0){
           throw  new IllegalArgumentException("Invalid value. Please enter a value greater than 0");
        }

        this.account = account;
        this.direction = direction;
        this.amount = amount;
    }

    public Account getAccount(){
        return account;
    }

    public Direction getDirection(){
        return direction;
    }

    public BigDecimal getAmount(){
        return amount;
    }

}
