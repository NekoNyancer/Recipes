package com.myownproject.myownproject.users;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UsersConfig {


    @Bean
    CommandLineRunner commandLineRunnerSaveDefaultUser( UsersRepository repository){
        return args -> {
            Users admin = new Users(
                    "admin",
                    "admin"
            );
            Users balazs = new Users(
                    "balazs",
                    "balazs"
            );

            repository.saveAll( List.of( admin, balazs ) );
        };
    }
}
