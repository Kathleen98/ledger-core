package io.hokma.ledger.service;

import io.hokma.ledger.domain.Account;
import io.hokma.ledger.repository.LedgerRepository;
import org.springframework.stereotype.Service;

@Service
public class LedgerService {

    private final LedgerRepository repository;

    public LedgerService(LedgerRepository repository){
        this.repository = repository;
    }

    public Account createAccount(String name){
        Account account = new Account(name);
        repository.saveAccount(account);
        return account;
    }

    public Account getAccountId(String id){
        return repository.findAccountById(id);
    }

}
