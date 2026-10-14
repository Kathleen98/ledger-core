package io.hokma.ledger.repository;

import io.hokma.ledger.domain.Account;
import io.hokma.ledger.domain.Transaction;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface LedgerRepository {

    void saveAccount(Account account);

    Account findAccountById(String id);

    List<Account> findAllAccounts();

    void saveTransaction(Transaction transaction);

    List<Transaction> findAllTransactions();

    BigDecimal calculateBalance(String AccountId);


}
