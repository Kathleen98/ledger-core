package io.hokma.ledger.config;

import io.hokma.ledger.domain.BalanceCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BalanceCalculator balanceCalculator() {
        return new  BalanceCalculator();
    }

}
