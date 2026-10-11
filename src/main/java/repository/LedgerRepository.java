package repository;

import io.hokma.ledger.domain.Account;
import io.hokma.ledger.domain.Transaction;

import java.math.BigDecimal;
import java.util.List;


public interface LedgerRepository {

    void saveAccount(Account account);

    Account findAccountById(String id);

    List<Account> findAllAccounts();

    void saveTransaction(Transaction transaction);

    List<Transaction> findAllTransactions();

    BigDecimal calculateBalance(String AccountId);


}
