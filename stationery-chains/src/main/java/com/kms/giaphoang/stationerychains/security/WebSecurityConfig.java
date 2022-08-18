package com.kms.giaphoang.stationerychains.security;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

import static com.kms.giaphoang.stationerychains.model.enums.Role.*;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/12/2022, Friday
 * @project: stationery
 **/
@KeycloakConfiguration
public class WebSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

    // configureGlobal() tasks the SimpleAuthorityMapper to make sure roles are not
    // prefixed with ROLE_.
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
        auth.authenticationProvider(keycloakAuthenticationProvider);
    }


    @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    // we are permitting all here but we are gonna have method level authorization.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/categories/**").hasRole(ADMIN.name())
                .antMatchers(HttpMethod.PUT, "/api/v1/categories/**").hasRole(ADMIN.name())
                .antMatchers(HttpMethod.DELETE, "/api/v1/categories/**").hasRole(ADMIN.name())
                .antMatchers(HttpMethod.GET, "/api/v1/categories/**").hasAnyRole(ADMIN.name(), CUSTOMER.name())
                .antMatchers("/api/v1/customers/**").hasRole(CUSTOMER.name())
                .antMatchers("/api/v1/products*").hasAnyRole(ADMIN.name(), CUSTOMER.name())
                .anyRequest().permitAll();
    }
}
