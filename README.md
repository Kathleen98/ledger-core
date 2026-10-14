# Ledger - Um Livro de Registro de Movimentações em Software

## Status / Roadmap

| Fase | Descrição | Situação |
|------|-----------|----------|
| 1 | Domínio em memória | ✅ Concluída |
| 2 | Persistência com JDBC e SQL puro | ⏸️ Adiada/planejada, adiada em favor da Fase 3 para priorizar a experiência com Spring Boot |
| 3 | API REST com Spring Boot | 🚧 Em andamento |

## Invariantes do Domínio

- Toda transação tem seus lados equilibrados (débito = crédito).
- O saldo é sempre derivado dos lançamentos, nunca guardado como um campo editável.
- Lançamentos nunca são alterados; correções são novos lançamentos.

## Tecnologias

**Em uso**
- Java 21
- Spring Boot
- JUnit
- Maven

**Futuro**
- SQL
- PostgreSQL

## Arquitetura

O código está organizado em camadas:

- **controller** : requisições HTTP
- **service** : lógica da aplicação
- **domain** : conceitos e regras de negócio
- **repository** : persistência dos dados

As camadas se conectam pela **DI (Injeção de Dependência)** e **IoC (Inversão de Controle)**: o Spring cria e gerencia os beans (IoC) e injeta eles onde são declarados como dependência (DI).

Todo o código está sendo escrito seguindo o **DIP** (última sigla do acrônimo SOLID - Princípio da Inversão de Dependência) e o **SRP** (primeira sigla do acrônimo SOLID - Princípio da Responsabilidade Única). Essa abordagem faz com que o código dependa de abstrações e não de implementações (DIP) e tenha responsabilidades organizadas em camadas (SRP), trazendo um ganho significativo na manutenibilidade. Por exemplo: se em algum momento for necessário trocar alguma lib do projeto, como a dependência está de forma abstrata e não acoplada, posso fazer a alteração sem que toda a aplicação desmorone.

Também há ganhos na parte de testes: com essa estrutura, consigo testar sem sujar o banco de dados, mantendo a consistência dos dados e tornando a aplicação mais segura e testável.

### Proteção do domínio

A camada de negócio foi construída e protegida com invariantes definidas antes de iniciar o projeto:

- **Transaction** : não nasce desbalanceada, a validação acontece no construtor, então a recusa de um lançamento desbalanceado ocorre antes de o objeto ser criado.
- **Entry** : mesma lógica da Transaction, se o valor enviado estiver fora do padrão, o objeto não é criado.

O objetivo de consistência e imutabilidade dos dados levou ao uso dos modificadores `final` e `private` nos campos:

- **final** : não permite que o valor seja reatribuído.
- **private** : restringe a visibilidade; o acesso se dá apenas pelos métodos criados conforme a necessidade.

A proteção do domínio também é feita com **DTO (Data Transfer Object)**, que funciona como uma casca de proteção: o mundo externo não fala com as entidades diretamente.

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
    ├── main/java/io/hokma/ledger/
    │   ├── controller/
    │   │   ├── dto/
    │   │   │   ├── AccountResponse.java
    │   │   │   └── CreateAccountRequest.java
    │   │   └── LedgerController.java
    │   ├── domain/
    │   │   ├── Account.java
    │   │   ├── Entry.java
    │   │   ├── Transaction.java
    │   │   ├── Direction.java
    │   │   └── exception/
    │   │       └── UnbalancedTransactionException.java
    │   ├── repository/
    │   │   ├── LedgerRepository.java
    │   │   └── InMemoryLedgerRepository.java
    │   ├── service/
    │   │   └── LedgerService.java
    │   └── LedgerApplication.java
    └── test/java/io/hokma/ledger/
        └── domain/
            └── TransactionTest.java
```
