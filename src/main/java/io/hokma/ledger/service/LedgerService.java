package io.hokma.ledger.service;


import io.hokma.ledger.domain.Account;
import io.hokma.ledger.domain.BalanceCalculator;
import io.hokma.ledger.domain.Entry;
import io.hokma.ledger.repository.LedgerRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LedgerService {

    private final LedgerRepository repository;
    private final BalanceCalculator balanceCalculator;

    public LedgerService(LedgerRepository repository, BalanceCalculator balanceCalculator) {
        this.repository = repository;
        this.balanceCalculator = balanceCalculator;
    }

    public Account createAccount(String name){
        Account account = new Account(name);
        repository.saveAccount(account);
        return account;
    }

    public Account getAccountId(String id){
        return repository.findAccountById(id);
    }

    public List<Account> getAllAccounts(){
        return repository.findAllAccounts();
    }

    public BigDecimal getBalance(String accountId){
        List<Entry> entries = repository.findTransactionsAccountId(accountId);
        return balanceCalculator.calculate(entries);
    }

}
