# Ledger - Um Livro de Registro de Movimentações em Software

> Este projeto tem como objetivo aprofundar meus conhecimentos em Java, SQL e integridade financeira.

## Status

Em construção

## Invariantes do Domínio

- Toda transação tem seus lados equilibrados (débito = crédito).
- O saldo é sempre derivado dos lançamentos, nunca guardado como um campo editável.
- Lançamentos nunca são alterados nem apagado, correções são novos lançamentos.

## Tecnologias

- Java
- SQL
- Postgres

## Estrutura de pastas

```
ledger-core/
├── README.md
├── LICENSE
├── .gitignore
├── docs/
│   ├── ADR/
│   │   ├── README.md
│   │   └── 0001-....md
│   └── estudos/
└── src/
    └── main/java/<seu/pacote>/ledger/
        ├── domain/
        │   ├── Account.java
        │   ├── Entry.java
        │   ├── Transaction.java
        │   ├── Direction.java
        │   ├── Money.java
        │   └── exception/
        │       └── UnbalancedTransactionException.java
        ├── repository/
        │   ├── LedgerRepository.java
        │   └── InMemoryLedgerRepository.java
        └── Main.java
```