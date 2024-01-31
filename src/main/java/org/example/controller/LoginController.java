package org.example.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Контроллер для управления входом в систему.
 */
@Controller
public class LoginController {

    /**
     * Обрабатывает запросы после успешного входа в систему.
     *
     * @param userDetails детали аутентифицированного пользователя
     * @return перенаправление на приватные данные, если пользователь - администратор, иначе - на публичные данные
     */
    @GetMapping("/handleLogin")
    public String handleLogin(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/private-data";
        } else {
            return "redirect:/public-data";
        }
    }

}
