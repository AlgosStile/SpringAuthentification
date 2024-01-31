package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * Конфигурация безопасности веб-приложения.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * Создает кодировщик паролей.
     *
     * @return BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Конфигурирует аутентификацию пользователей.
     *
     * @param auth объект для построения аутентификации
     * @throws Exception если возникает ошибка при конфигурации аутентификации
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("user").password(passwordEncoder().encode("password")).roles("USER").and().withUser("admin").password(passwordEncoder().encode("password")).roles("ADMIN");
    }

    /**
     * Конфигурирует безопасность HTTP.
     *
     * @param http объект для построения безопасности HTTP
     * @throws Exception если возникает ошибка при конфигурации безопасности HTTP
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login", "/handleLogin").permitAll().antMatchers("/private-data").hasRole("ADMIN").antMatchers("/public-data").authenticated().and().formLogin().loginPage("/login").defaultSuccessUrl("/handleLogin", true).and().logout().logoutSuccessUrl("/login").and().exceptionHandling().accessDeniedPage("/login?denied=true").and().csrf().disable();
    }

}
