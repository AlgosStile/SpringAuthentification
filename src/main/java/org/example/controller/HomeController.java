package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер для управления домашними страницами.
 */
@Controller
public class HomeController {
    /**
     * Обрабатывает запросы к приватным данным.
     *
     * @return имя представления приватных данных
     */
    @GetMapping("/private-data")
    public String privateData() {
        return "private-data";
    }


    /**
     * Обрабатывает запросы к публичным данным.
     *
     * @return имя представления публичных данных
     */
    @GetMapping("/public-data")
    public String publicData() {
        return "public-data";
    }
}
