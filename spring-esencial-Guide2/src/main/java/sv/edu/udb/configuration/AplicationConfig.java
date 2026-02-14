package sv.edu.udb.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sv.edu.udb.repository.AccountRepository;
import sv.edu.udb.repository.implementation.JdbcAccountRepository;
import sv.edu.udb.service.TransferService;
import sv.edu.udb.service.implementation.TransferServiceImpl;

import javax.sql.DataSource;

class ApplicationConfig {
    @Bean
    public TransferService transferService(final AccountRepository accountRepository) {
        return new TransferServiceImpl(accountRepository);
    }

    @Bean
    public AccountRepository accountRepository(final DataSource dataSource) {
        return new JdbcAccountRepository(dataSource);
    }

}