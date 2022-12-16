package com.jdbcauthentication.authentication;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity
public class SecurityManager extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    
    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     // TODO Auto-generated method stub
    //     auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema()
    //     .withUser(User.withUsername("Sayan")
    //     .password("sayan")
    //     .roles("ADMIN"))
    //     .withUser(User.withUsername("Ishita")
    //     .password("ishita")
    //     .roles("USER"));
    // }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        http.authorizeRequests()
        .antMatchers("/user")
        .hasAnyRole("USER","ADMIN")
        .antMatchers("/admin")
        .hasRole("ADMIN")
        .antMatchers("/").permitAll()
        .and().formLogin();
    }

    @Bean
    public PasswordEncoder getEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO Auto-generated method stub
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username,password,enabled "+
        "from users "+
        "where username=?")
        .authoritiesByUsernameQuery("select username,authority "
        +"from authorities "
        +"where username=?");
    }
    

}
