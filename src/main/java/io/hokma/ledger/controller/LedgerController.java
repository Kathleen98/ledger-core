package io.hokma.ledger.controller;

import io.hokma.ledger.controller.dto.AccountResponse;
import io.hokma.ledger.controller.dto.CreateAccountRequest;
import io.hokma.ledger.domain.Account;
import io.hokma.ledger.service.LedgerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class LedgerController {

    private final LedgerService ledgerService;

    public LedgerController(LedgerService ledgerService){
        this.ledgerService = ledgerService;
    }

    @PostMapping("/accounts")
    public ResponseEntity<AccountResponse> createAccount(@RequestBody CreateAccountRequest createAccountRequest) {
        Account account = ledgerService.createAccount(createAccountRequest.name());
        AccountResponse response = new AccountResponse(account.getId(), account.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
