package com.graphqlbooks.project;

import com.graphqlbooks.project.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }

}
