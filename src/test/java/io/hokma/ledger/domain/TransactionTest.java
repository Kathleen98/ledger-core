package io.hokma.ledger.domain;


import io.hokma.ledger.domain.exception.UnbalancedTransactionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;
import java.util.List;

import java.time.LocalDateTime;

class TransactionTest {


    @Test
    void balancedTransactionAccept(){

        Account cashier = new Account("cashier");
        Account income = new Account("income");

        Entry debit = new Entry(cashier, Direction.DEBIT, new BigDecimal("100"));
        Entry credit = new Entry(income, Direction.CREDIT, new BigDecimal("100"));

        Assertions.assertDoesNotThrow(() -> new Transaction(
                List.of(debit, credit),
                LocalDateTime.now(),
                "Balanced transaction"
        ));
    }

    @Test
    void unbalancedTransaction(){

        Account cashier = new Account("cashier");
        Account income = new Account("income");

        Entry debit = new Entry(cashier, Direction.DEBIT, new BigDecimal("100"));
        Entry credit = new Entry(income, Direction.CREDIT, new BigDecimal("50"));

        Assertions.assertThrows(UnbalancedTransactionException.class, () -> new Transaction(
                List.of(debit, credit),
                LocalDateTime.now(),
                "Unbalanced transaction"
        ));
    }
}
