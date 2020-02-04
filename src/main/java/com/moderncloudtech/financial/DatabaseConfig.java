package com.moderncloudtech.financial;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.moderncloudtech.repository")
@EnableTransactionManagement
public class DatabaseConfig {

}
