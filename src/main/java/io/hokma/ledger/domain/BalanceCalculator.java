package io.hokma.ledger.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

public class BalanceCalculator {

    public BigDecimal calculate(List<Entry> entries) {
        BigDecimal balance = BigDecimal.ZERO;
        for (Entry e : entries) {
            if (e.getDirection() == Direction.CREDIT) {
                balance = balance.subtract(e.getAmount());
            } else {
                balance = balance.add(e.getAmount());
            }
        }
        return balance;
    }


}
