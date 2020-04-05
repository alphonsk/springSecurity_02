package com.george.springSecurity.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT USERNAME, PASSWORD, ENABLED "
                                      + "FROM user_accounts "
                                      + "WHERE USERNAME = ?")
                .authoritiesByUsernameQuery("SELECT USERNAME, ROLE "
                        + "FROM authorities "
                        + "WHERE USERNAME = ?")
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/admin", "/logged").hasRole("ADMIN")
//                .antMatchers("/logged").hasRole("USER")
                .antMatchers("/admin").hasAuthority("ADMIN")
                .antMatchers("/admin1").hasAuthority("ADMIN")
                .antMatchers("/admin2").hasAuthority("ADMIN")
                .antMatchers("/user").hasAuthority("USER")
                .antMatchers("/user1").hasAuthority("USER")
                .antMatchers("/user2").hasAuthority("USER")
                .antMatchers("/all").authenticated()
//                .antMatchers("/user/**").permitAll()
                .antMatchers("/register/**").permitAll()
                .antMatchers("/").permitAll()
//                .antMatchers("/", "/register", "/register/save", "/home", "/**").permitAll()
//                .and().formLogin().loginPage("/my-login-page");
                .and().formLogin();
// //        remove from production
//        http.csrf() .disable();
//                .authorizeRequests()
//                .anyRequest().authenticated();
    }



    //
}


//// before data
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
// //               this line for inmemory database
// //               .withDefaultSchema()
//                .withUser("user1")
//                .password("root")
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password("root")
//                .roles("ADMIN");
//    }
//    @Bean
//    public PasswordEncoder getPasswordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//
//    //
//}
