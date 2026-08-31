import main.java.domain.Account;
import main.java.domain.Direction;
import main.java.domain.Entry;
import main.java.domain.Transaction;

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


    }
}