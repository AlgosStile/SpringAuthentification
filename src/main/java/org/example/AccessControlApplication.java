package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Главный класс приложения, отвечающий за запуск.
 */
@SpringBootApplication
public class AccessControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccessControlApplication.class, args);
    }
}
