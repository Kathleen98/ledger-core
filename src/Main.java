import main.java.domain.*;
import main.java.repository.InMemoryLedgerRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Account caixa = new Account("NovoTest");
        Account receita = new Account("ReceitaNova");

        Entry debito = new Entry(caixa, Direction.DEBIT, new BigDecimal("100"));
        Entry credito = new Entry(receita, Direction.CREDIT, new BigDecimal("100"));

        Transaction t1 = new Transaction(
                List.of(debito, credito),
                LocalDateTime.now(),
                "Transacao balanceada simples"
        );

        InMemoryLedgerRepository repository = new InMemoryLedgerRepository();

        repository.saveTransaction(t1);

        repository.calculateBalance(caixa.getId());
        repository.calculateBalance(receita.getId());

        System.out.println("Saldo caixa: " + repository.calculateBalance(caixa.getId()));
        System.out.println("Saldo receita: " + repository.calculateBalance(receita.getId()));

    }
}