package com.SpringDeneme.SpringDemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // tanımı yapılan lokasyonlara authantication olmadan erişmeyi sağlar.
        http.authorizeRequests().antMatchers("/**/favicon.ico","/css/**","/js/**","/images/**","/webjars/**");
        // tüm istekleri otantike işlemine tani tutar.
        http.authorizeRequests().anyRequest().authenticated();
        // login sayfasının talep edilmesi sağlanır.
        http.formLogin();
    }
}
