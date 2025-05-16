package com.tarif.BookMyShow2.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BcryptConfig {
    @Bean
    public BCryptPasswordEncoder getEncoferBean() {
        return new BCryptPasswordEncoder();
    }
}
