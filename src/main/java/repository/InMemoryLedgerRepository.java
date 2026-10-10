package main.java.repository;

import main.java.domain.Account;
import main.java.domain.Direction;
import main.java.domain.Entry;
import main.java.domain.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryLedgerRepository implements LedgerRepository {

    private final Map<String, Account> accounts = new HashMap<String, Account>();
    private final List<Transaction> transactions = new ArrayList<Transaction>();

    @Override
    public void saveAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public List<Transaction> findAllTransactions() {
        return transactions;
    }

    @Override
    public List<Account> findAllAccounts() {
        return new ArrayList<>(accounts.values());
    }

    @Override
    public Account findAccountById(String id) {
       return accounts.get(id);
    }

    @Override
    public BigDecimal calculateBalance(String accountId){
        BigDecimal balance = BigDecimal.ZERO;

        for(Transaction t : transactions) {
            for (Entry e : t.getEntries()) {
                if (e.getAccount().getId().equals(accountId)) {
                    if (e.getDirection() == Direction.CREDIT) {
                        balance = balance.subtract(e.getAmount());
                    } else {
                        balance = balance.add(e.getAmount());
                    }
                }
            }
        }

        return balance;
    }

}
