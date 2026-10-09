package main.java.repository;

import main.java.domain.Account;
import main.java.domain.Transaction;

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


}
