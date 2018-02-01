package com.sokil.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        variant with open password storage
//       auth.userDetailsService(userDetailsService);

//        variant with password encoding
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

//        InMemory variant of userStorage
//       auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("user1").password("user").roles("USER");


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/users/**").access("hasRole('ROLE_ADMIN')")
                .and()
                .formLogin()
                .and()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

//    @Bean
//    public DaoAuthenticationProvider authProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }
}
