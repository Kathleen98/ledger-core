package main.java.repository;

import main.java.domain.Account;
import main.java.domain.Transaction;
import java.util.List;


public interface LedgerRepository {

    void saveAccount(Account account);

    Account findAccountById(String id);

    List<Account> findAllAccount();

    void saveTransaction(Transaction transaction);

    List<Transaction> findAllTransaction();
}
