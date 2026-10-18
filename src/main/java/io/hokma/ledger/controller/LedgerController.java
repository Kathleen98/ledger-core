package io.hokma.ledger.controller;

import io.hokma.ledger.controller.dto.AccountResponse;
import io.hokma.ledger.controller.dto.CreateAccountRequest;
import io.hokma.ledger.domain.Account;
import io.hokma.ledger.service.LedgerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LedgerController {

    private final LedgerService ledgerService;

    public LedgerController(LedgerService ledgerService){
        this.ledgerService = ledgerService;
    }


    @GetMapping("/accounts")
    public ResponseEntity<List<AccountResponse>> getAllAccounts(){
        List<Account> accounts = ledgerService.getAllAccounts();
        List<AccountResponse> response = new ArrayList<>();
        for (Account account : accounts){
            response.add(new AccountResponse(account.getId(), account.getName()));
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<AccountResponse> findAccount(@PathVariable String id){

    Account account =  ledgerService.getAccountId(id) ;

    if(account == null){
        return ResponseEntity.notFound().build();
    }

    AccountResponse response = new AccountResponse(account.getId(), account.getName());
    return ResponseEntity.ok(response);

    }


    @PostMapping("/accounts")
    public ResponseEntity<AccountResponse> createAccount(@RequestBody CreateAccountRequest createAccountRequest) {
        Account account = ledgerService.createAccount(createAccountRequest.name());
        AccountResponse response = new AccountResponse(account.getId(), account.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
