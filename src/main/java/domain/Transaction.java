package main.java.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


public class Transaction {
    private final List<Entry> entries;
    private final LocalDateTime createdAt;
    private final String description;

    public Transaction(List<Entry> entries, LocalDateTime createdAt, String description) {
        this.entries = entries;
        this.createdAt = createdAt;
        this.description = description;

        BigDecimal totalDebit = BigDecimal.ZERO;
        BigDecimal totalCredit = BigDecimal.ZERO;


        for (Entry e : entries) {
            System.out.println(totalCredit);
            System.out.println(totalDebit);

            if (e.getDirection() == Direction.CREDIT) {
                totalCredit = totalCredit.add(e.getAmount());
                System.out.println(totalCredit);
            } else {
                totalDebit = totalDebit.add(e.getAmount());
                System.out.println(totalDebit);
            }
        }

        if (totalCredit.compareTo(totalDebit) != 0) {
            throw new IllegalArgumentException("Invalid values. Transaction not completed.");
        }
    }


    public List<Entry> getEntries() {
        return entries;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }


}
